package kr.or.ddit.post.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/fileDownload")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IPostService service;

	@Override
	public void init() throws ServletException {
		service = PostService.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String atfNum = request.getParameter("atfNum");
		
		AttachedfileVo avo = service.selectAtf(Integer.parseInt(atfNum));
		
		ServletOutputStream sos = response.getOutputStream();
		
		File file = new File(avo.getAtfPath());
		
		FileInputStream fis = new FileInputStream(file);
		
		byte[] buff =new byte[512];
		int len = 0;
		
		while((len = fis.read(buff, 0, 512)) != -1) {
			sos.write(buff,0,len);
		}
		
		fis.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
