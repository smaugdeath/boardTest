package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.IBoardDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardService implements IBoardService {
	
	private static IBoardService service;
	
	private IBoardDao boardDao;

	private BoardService() { 
		boardDao = BoardDao.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service==null) service = new BoardService();
		return service;
	}
	
	@Override
	public List<BoardVo> getBoardList() {
		SqlSession sqlSession = MybatisUtil.getSession();
	    List<BoardVo> boardList = boardDao.getBoardList(sqlSession);
	    sqlSession.close();
	    return boardList;
	}

	@Override
	public int insertBoard(BoardVo bvo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = boardDao.insertBoard(sqlSession, bvo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo bvo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int cnt = boardDao.updateBoard(sqlSession, bvo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	

	

}
