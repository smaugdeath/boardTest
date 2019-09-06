package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.User;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = BoardService.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardVo> boardList = boardService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("res", request.getAttribute("res"));
		
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("S_USERVO");
		String boardNum = request.getParameter("boardNum");
		String btnValue = request.getParameter("btnValue");
		String boardNm = request.getParameter("boardNm");
		String useStatus = request.getParameter("useStatus");
		
		
		String res = "";
		
		if(useStatus.equals("사용")) {
			useStatus = "Y";
		}else {
			useStatus = "N";
		}
		
		if(btnValue.equals("생성")) {
			
			BoardVo bvo = new BoardVo(0, boardNm, useStatus, null, user.getUserId());
			
			int cnt = boardService.insertBoard(bvo);
			
			if(cnt == 1) {
				res = "생성 성공";
			}else {
				res = "생성 실패";
			}
			
		}else if(btnValue.equals("수정")) {
			
			BoardVo bvo = new BoardVo(Integer.parseInt(boardNum), boardNm, useStatus, null, null);
			
			int cnt = boardService.updateBoard(bvo);
			
			if(cnt == 1) {
				res = "수정 성공";
			}else {
				res = "수정 실패";
			}
		}
		
		request.setAttribute("res", res);
		
		doGet(request, response);
	}
	

}
