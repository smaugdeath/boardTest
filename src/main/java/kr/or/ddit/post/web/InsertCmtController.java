package kr.or.ddit.post.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.user.model.User;

/**
 * Servlet implementation class InsertCmtController
 */
@WebServlet("/insertCmt")
public class InsertCmtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IPostService service;
    
    @Override
    public void init() throws ServletException {
    	service = PostService.getInstance();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("S_USERVO");
		
		String postNum = request.getParameter("cmtPostNum");
		String cmtContent = request.getParameter("cmtContent");
		String userId = user.getUserId();
		
		CommentsVo cvo = new CommentsVo(0, cmtContent, null, Integer.parseInt(postNum), userId);
		
		service.insertCmt(cvo);
		
		request.setAttribute("postNum", postNum);
		
		request.getRequestDispatcher("/selectPost").forward(request, response);;
	}
}
