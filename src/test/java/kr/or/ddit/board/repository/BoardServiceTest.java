package kr.or.ddit.board.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.repository.UserDaoTest;

public class BoardServiceTest {

	
	
	private IBoardService service;
	
	
	@Before
	public void setup() {
		service = BoardService.getInstance();
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void getBoardListTest() {
		/***Given***/

		/***When***/
		List<BoardVo> list = service.getBoardList();
		
		/***Then***/
		assertEquals(22, list.size());
	}
	
	@Test
	public void insertBoardTest() throws ParseException {
		/***Given***/
		Date date = new SimpleDateFormat("yyyyMMdd").parse("20190603");
		
		BoardVo bvo = new BoardVo(21, "테스트", "N", date, "cony");
		
		/***When***/
		int cnt = service.insertBoard(bvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updateBoardTest() throws ParseException {
		/***Given***/
		Date date = new SimpleDateFormat("yyyyMMdd").parse("20190603");
		
		BoardVo bvo = new BoardVo(1, "자유게시판", "Y", null, null);
		
		/***When***/
		int cnt = service.updateBoard(bvo);
		
		/***Then***/
		assertEquals(1, cnt);
	}

}
