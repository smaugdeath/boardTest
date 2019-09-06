package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;

public class BoardDao implements IBoardDao {
	private static IBoardDao boardDao;
	
	private BoardDao() { }
	
	public static IBoardDao getInstance() {
		if(boardDao==null) boardDao = new BoardDao();
		
		return boardDao;
	}
	

	@Override
	public List<BoardVo> getBoardList(SqlSession sqlSession) {
		
		List<BoardVo> boardList = sqlSession.selectList("board.getBoardList");		
		
		return boardList;
	}

	@Override
	public int insertBoard(SqlSession sqlSession, BoardVo bvo) {
		return sqlSession.insert("board.insertBoard", bvo);
	}

	@Override
	public int updateBoard(SqlSession sqlSession, BoardVo bvo) {
		return sqlSession.update("board.updateBoard", bvo);
	}

	

	

	

}
