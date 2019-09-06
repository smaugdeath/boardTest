package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.util.FileuploadUtil;

/**
 * Servlet implementation class ModifyPostController
 */
@WebServlet("/modifyPost")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class ModifyPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IPostService service;
	private String res;
	
	@Override
	public void init() throws ServletException {
		service = PostService.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNum = request.getParameter("boardNum");
		String parentPostNum = request.getParameter("parentPostNum");
		String gn = request.getParameter("gn");
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		String btnValue = request.getParameter("btnValue");
		String userId = request.getParameter("userId");
		PostVo pvo = new PostVo();
		
	Map<String, Object> map =service.selectPost(Integer.parseInt(parentPostNum));
	
	PostVo pvo1 =(PostVo) map.get("pvo");
		
		if(btnValue.equals("답글")) {
			request.setAttribute("boardNum", boardNum);
			request.setAttribute("parentPostNum", parentPostNum);
			request.setAttribute("gn", gn);
			
			request.getRequestDispatcher("/post/writePost.jsp").forward(request, response);
		}else if(btnValue.equals("삭제")) {
			pvo.setDelStatus("Y");
			pvo.setPostNum(Integer.parseInt(parentPostNum));
			
			int cnt = service.deletePost(pvo);
			
			if(cnt>0) {
				res = "삭제 성공";
			}else {
				res = "삭제 실패";
			}
			
			request.setAttribute("res", res);
			request.setAttribute("boardNum", boardNum);
			
			request.getRequestDispatcher("/postList").forward(request, response);;
			
		}else if(btnValue.equals("수정")) {
			pvo.setPostTitle(postTitle);
			pvo.setPostContent(pvo1.getPostContent());
			pvo.setUserId(userId);
			
			
			List<AttachedfileVo> atfList = service.getAttachedFile(Integer.parseInt(parentPostNum));
			
			request.setAttribute("parentPostNum", parentPostNum);
			request.setAttribute("pvo", pvo);
			request.setAttribute("atfList", atfList);
			request.setAttribute("boardNum", boardNum);
			
			request.getRequestDispatcher("post/modifyPost.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String boardNum = request.getParameter("boardNum");
		String parentPostNum = request.getParameter("parentPostNum");
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("smarteditor");
		
		Collection<Part> parts = request.getParts();
		String filename = "";
		String path = "";
		
		PostVo pvo = new PostVo();
		
		pvo.setPostNum(Integer.parseInt(parentPostNum));
		pvo.setPostTitle(postTitle);
		pvo.setPostContent(postContent);
		
		service.updatePost(pvo);
		
		for(Part p : parts) {
			if("attachedFile".equals(p.getName())){
				if(p.getSize()>0) {
					filename = FileuploadUtil.getFilename(p.getHeader("Content-Disposition"));	//사용자가 업로드한 파일명
					String realFilename = UUID.randomUUID().toString();
					String ext = FileuploadUtil.getFileExtension(p.getHeader("Content-Disposition"));
					path = FileuploadUtil.getPath() + realFilename + ext;
					
					p.write(path);
					AttachedfileVo avo = new AttachedfileVo();
					
					avo.setPostNum(Integer.parseInt(parentPostNum));
					avo.setAtfPath(path);
					avo.setAtfNm(filename);
					
					service.insertAtf(avo);
				}
			}
		} 
		
		request.setAttribute("boardNum", boardNum);
		request.setAttribute("postNum", parentPostNum);
		
		request.getRequestDispatcher("/selectPost").forward(request, response);
		
	}

}
