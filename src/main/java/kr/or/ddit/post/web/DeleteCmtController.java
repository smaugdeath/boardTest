package kr.or.ddit.post.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

/**
 * Servlet implementation class DeleteCmtController
 */
@WebServlet("/deleteCmt")
public class DeleteCmtController extends HttpServlet {
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
		
		String boardNum = request.getParameter("boardNum");
		String postNum = request.getParameter("postNum");
		String cmtNum = request.getParameter("cmtNum");
		
		int cnt = service.deleteCmt(Integer.parseInt(cmtNum));
		
		request.setAttribute("postNum", postNum);
		request.setAttribute("boardNum", request.getAttribute("boardNum"));
		
		request.getRequestDispatcher("/selectPost").forward(request, response);;
	}

}
