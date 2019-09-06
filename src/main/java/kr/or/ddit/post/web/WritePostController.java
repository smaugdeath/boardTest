package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.FileuploadUtil;

/**
 * Servlet implementation class WritePostController
 */
@WebServlet("/writePost")

@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)

public class WritePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IPostService service;   
		
	@Override
	public void init() throws ServletException {
		service = PostService.getInstance();
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = request.getParameter("boardNum");
		
		request.setAttribute("postNum", "");
		request.setAttribute("boardNum", boardNum);
		
		request.getRequestDispatcher("post/writePost.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("S_USERVO");
		PostVo pvo = new PostVo();
		int seq = service.getPostSeq();
		
		String boardNum = request.getParameter("boardNum");
		String parentPostNum = request.getParameter("parentPostNum");	
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(parentPostNum.equals("")) {
			pvo.setPostNum(seq);
			pvo.setPostTitle(request.getParameter("postTitle"));	
			pvo.setPostContent(request.getParameter("smarteditor"));
			pvo.setUserId(user.getUserId());
			pvo.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));	
			
			map.put("pvo", pvo);
			
			service.insertPost(map);
			
		}else {
			pvo.setPostNum(seq);
			pvo.setPostTitle(request.getParameter("postTitle"));	
			pvo.setPostContent(request.getParameter("smarteditor"));
			pvo.setUserId(user.getUserId());
			pvo.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));	
			pvo.setParentPostNum(Integer.parseInt(parentPostNum));
			pvo.setGn(Integer.parseInt(request.getParameter("gn")));	
			
			map.put("pvo", pvo);
			
			service.insertPost2(map);
			
		}
		
		Collection<Part> parts = request.getParts();
		String filename = "";
		String path = "";
		
		for(Part p : parts) {
			if("attachedFile".equals(p.getName())){
				if(p.getSize()>0) {
					filename = FileuploadUtil.getFilename(p.getHeader("Content-Disposition"));	//사용자가 업로드한 파일명
					String realFilename = UUID.randomUUID().toString();
					String ext = FileuploadUtil.getFileExtension(p.getHeader("Content-Disposition"));
					path = FileuploadUtil.getPath() + realFilename + ext;
					
					p.write(path);
					AttachedfileVo avo = new AttachedfileVo();
					
					avo.setPostNum(seq);
					avo.setAtfPath(path);
					avo.setAtfNm(filename);
					
					service.insertAtf(avo);
					
					String res = "저장 성공";
					
					request.setAttribute("boardNum", boardNum);
					request.setAttribute("res", res);
				}
			}
		} 
		
		request.setAttribute("postNum", seq);
		request.setAttribute("boardNum", boardNum);
		
		request.getRequestDispatcher("/selectPost").forward(request, response);
		
	}

}
