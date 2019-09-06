package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

/**
 * Servlet implementation class DeletAtfController
 */
@WebServlet("/deleteAtf")
public class DeleteAtfController extends HttpServlet {
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
		
		PostVo pvo = new PostVo();
		String atfNum = request.getParameter("atfNum");
		String boardNum = request.getParameter("boardNum");
		String parentPostNum = request.getParameter("parentPostNum");
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		String userId = request.getParameter("userId");
		
		pvo.setPostTitle(postTitle);
		pvo.setPostContent(postContent);
		pvo.setUserId(userId);
		
		int cnt = service.deleteAtf(Integer.parseInt(atfNum));
		List<AttachedfileVo> atfList = service.getAttachedFile(Integer.parseInt(parentPostNum));
		
		request.setAttribute("parentPostNum", parentPostNum);
		request.setAttribute("pvo", pvo);
		request.setAttribute("atfList", atfList);
		request.setAttribute("boardNum", boardNum);
		
		request.getRequestDispatcher("post/modifyPost.jsp").forward(request, response);
	}
}
