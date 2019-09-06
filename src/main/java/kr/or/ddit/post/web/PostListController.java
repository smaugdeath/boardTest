package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/postList")
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = PostService.getInstance();
	}
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardNum = request.getParameter("boardNum");
		String pageStr = request.getParameter("page");
		String pagesizeStr = request.getParameter("pagesize");
		
		if(boardNum==null) {
			boardNum = (String) request.getAttribute("boardNum");
		}
		
		List<PostVo> pageLists = postService.allPostList(Integer.parseInt(boardNum));
		
		int page = pageStr==null ? 1 : Integer.parseInt(pageStr);
		int pagesize = pagesizeStr==null ? 10 : Integer.parseInt(pagesizeStr);

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardNum", Integer.parseInt(boardNum));
		map.put("page", page);
		map.put("pagesize", pagesize);
		
		List<PostVo> list = postService.getPostList(map);
		int paginationSize = (int)Math.ceil((double)pageLists.size()/pagesize);
		
		request.setAttribute("boardNum", boardNum);
		request.setAttribute("postList", list);
		request.setAttribute("boardNm", request.getParameter("boardNm"));
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("post/postList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = (String) request.getAttribute("boardNum");
		
		request.setAttribute("boardNum", boardNum);
		
		doGet(request, response);
	}

	

}
