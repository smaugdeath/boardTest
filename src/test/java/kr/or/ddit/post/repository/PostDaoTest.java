package kr.or.ddit.post.repository;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.AttachedfileVo;
import kr.or.ddit.post.model.CommentsVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);

	private IPostDao postDao;
	private SqlSession sqlSession;
	
	//테스트에 공통적으로 필요한 자원을 생성 / 초기화
	@Before
	public void setup() {
	   logger.debug("before");
	   postDao = new PostDao();
	   sqlSession = MybatisUtil.getSession();
	}
	
	//테스트에 공통적으로 사용한 자원을 해제
	@After
	public void tearDown() {
	   logger.debug("after");
	   sqlSession.close();
	}
	
	@Test
	public void getAllPostList() {
		/***Given***/
		

		/***When***/

		/***Then***/

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
		List<PostVo> list = postDao.getPostList(sqlSession, map);
		
		/***Then***/
		assertEquals(10, list.size());
	}
	
	@Test
	public void selectPost() {
		/***Given***/
		int postNum = 4;

		/***When***/
		PostVo pvo = postDao.selectPost(sqlSession, postNum);
		
		/***Then***/
		assertEquals("네번째 글입니다", pvo.getPostTitle());
	}
	
	@Test
	public void getCmtList() {
		/***Given***/
		int postNum = 101;

		/***When***/
		List<CommentsVo> list = postDao.getCmtList(sqlSession, postNum);
		
		/***Then***/
		assertEquals(1, list.size());
	}
	
	@Test
	public void insertCmt() {
		/***Given***/
		CommentsVo cvo = new CommentsVo(0, "테스트2", null, 101, "cony");

		/***When***/
		int cnt = postDao.insertCmt(sqlSession, cvo);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getPostSeq() {
		/***Given***/

		/***When***/
		int seq = postDao.getPostSeq(sqlSession);

		/***Then***/
		assertEquals(105, seq);
	}
	
	@Test
	public void insertPost() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setPostTitle("테스트");	
		pvo.setPostContent("테스트입니다.테스트");
		pvo.setUserId("cony");
		pvo.setBoardNum(1);	
		pvo.setPostNum(105);
		/***When***/
		int cnt = postDao.insertPost(sqlSession, pvo);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void insertPost2() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setPostTitle("테스트");	
		pvo.setPostContent("테스트입니다. 테스트");
		pvo.setUserId("cony");
		pvo.setBoardNum(1);	
		pvo.setParentPostNum(105);
		pvo.setGn(32);
		pvo.setPostNum(106);
		
		/***When***/
		int cnt = postDao.insertPost2(sqlSession, pvo);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void insertAtf() {
		/***Given***/
		AttachedfileVo avo = new AttachedfileVo();
		avo.setAtfNm("테스트");
		avo.setAtfPath("테스트용");
		avo.setPostNum(105);
		
		/***When***/
		int cnt = postDao.insertAtf(sqlSession, avo);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void deletePost() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setDelStatus("Y");
		pvo.setPostNum(106);
		
		/***When***/
		int cnt = postDao.deletePost(sqlSession, pvo);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updatePost() {
		/***Given***/
		PostVo pvo = new PostVo();
		pvo.setPostTitle("게시글 수정테스트");
		pvo.setPostContent("게시글 수정테스트입니다.");
		pvo.setPostNum(105);
		
		/***When***/
		int cnt = postDao.updatePost(sqlSession, pvo);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void getAttachedFile() {
		/***Given***/
		int postNum = 105;

		/***When***/
		List<AttachedfileVo> list = postDao.getAttachedFile(sqlSession, postNum);
		
		/***Then***/
		assertEquals(1, list.size());
	}
	
	@Test
	public void deleteAtf() {
		/***Given***/
		int atfNum = 28;

		/***When***/
		int cnt = postDao.deleteAtf(sqlSession, atfNum);
		
		/***Then***/
		assertEquals(1, cnt);
		
	}
	
	@Test
	public void deleteCmt() {
		/***Given***/
		int cmtNum=14;

		/***When***/
		int cnt = postDao.deleteCmt(sqlSession, cmtNum);
				
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void seleteAtf() {
		/***Given***/
		int atfNum=28;

		/***When***/
		AttachedfileVo avo = postDao.selectAtf(sqlSession, atfNum);
		
		/***Then***/
		assertEquals(28, avo.getAtfNum());
	}
	
}
