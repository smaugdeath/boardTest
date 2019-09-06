package kr.or.ddit.board.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;

public interface IBoardDao {
	
	/**
	* Method : getBoardList
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 리스트 불러오기
	*/
	List<BoardVo> getBoardList(SqlSession sqlSession);
	
	/**
	* Method : insertBoard
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param bvo
	* @return
	* Method 설명 : 게시판 등록
	*/
	int insertBoard(SqlSession sqlSession, BoardVo bvo);
	
	/**
	* Method : updateBoard
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param bvo
	* @return
	* Method 설명 : 게시판 수정
	*/
	int updateBoard(SqlSession sqlSession, BoardVo bvo);

}
