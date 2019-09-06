package kr.or.ddit.post.repository;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

public class PostServiceTest {

	private IPostService postService;
	   
	private int postNum = 1;
	
	@Before
	public void setup() {
	   postService = new PostService();
	   
	}

	@Test
	public void getPostListTest() {
		/***Given***/
		int boardNum = 1;
		int page = 1;
		int pagesize = 10;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardNum", boardNum);
		map.put("page", page);
		map.put("pagesize", pagesize);

		/***When***/
		List<PostVo> list = postService.getPostList(map);
		
		/***Then***/
		assertEquals(10, list.size());
	}

	@Test
	public void selectPost() {
		/***Given***/
		int postNum = 101;

		/***When***/
		Map<String, Object> map = postService.selectPost(postNum);
		PostVo pvo = (PostVo) map.get("pvo");
		List<CommentsVo> cmtList = (List<CommentsVo>) map.get("cmtList");
		
		/***Then***/
		assertEquals("adfadf", pvo.getPostTitle());
		assertEquals(2, cmtList.size());
	}
	
	@Test
	public void insertCmt() {
		/***Given***/
		CommentsVo cvo = new CommentsVo(0, "안녕", null, 105, "sally");

		/***When***/
		int cnt = postService.insertCmt(cvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getPostSeq() {
		/***Given***/

		/***When***/
		int seq = postService.getPostSeq();

		/***Then***/
		assertEquals(108, seq);
	}
	
	@Test
	public void insertPost() {
		/***Given***/
		PostVo pvo = new PostVo();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pvo", pvo);
		pvo.setPostTitle("테스트");	
		pvo.setPostContent("테스트입니다.테스트");
		pvo.setUserId("cony");
		pvo.setBoardNum(1);	
		pvo.setPostNum(107);
		/***When***/
		int cnt = postService.insertPost(map);
		
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void insertPost2() {
		/***Given***/
		PostVo pvo = new PostVo();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pvo", pvo);
		pvo.setPostTitle("테스트");	
		pvo.setPostContent("테스트입니다. 테스트");
		pvo.setUserId("cony");
		pvo.setBoardNum(1);	
		pvo.setParentPostNum(105);
		pvo.setGn(32);
		pvo.setPostNum(109);
		/***When***/
		int cnt = postService.insertPost2(map);
		
		
		/***Then***/
		assertEquals(0, cnt);
	}
	
	@Test
	public void insertAtf() {
		/***Given***/
		AttachedfileVo avo = new AttachedfileVo();
		avo.setAtfNm("테스트");
		avo.setAtfPath("테스트용");
		avo.setPostNum(105);
		
		/***When***/
		int cnt = postService.insertAtf(avo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void deletePost() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setDelStatus("Y");
		pvo.setPostNum(59);
		
		/***When***/
		int cnt = postService.deletePost(pvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updatePost() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setPostTitle("게시글 수정테스트");
		pvo.setPostContent("게시글 수정테스트입니다.");
		pvo.setPostNum(58);
		
		/***When***/
		int cnt = postService.updatePost(pvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getAttachedFile() {
		/***Given***/
		int postNum = 105;

		/***When***/
		List<AttachedfileVo> list = postService.getAttachedFile(postNum);
		
		/***Then***/
		assertEquals(1, list.size());
	}
	
	@Test
	public void deleteAtf() {
		/***Given***/
		int atfNum = 25;

		/***When***/
		int cnt = postService.deleteAtf(atfNum);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void deleteCmt() {
		/***Given***/
		int cmtNum=15;

		/***When***/
		int cnt = postService.deleteCmt(cmtNum);
				
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void seleteAtf() {
		/***Given***/
		int atfNum=14;

		/***When***/
		AttachedfileVo avo = postService.selectAtf(atfNum);

		/***Then***/
		assertEquals(14, avo.getAtfNum());
	}


}
