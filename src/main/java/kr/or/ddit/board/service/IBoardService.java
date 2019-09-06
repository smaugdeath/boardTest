package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;

public interface IBoardService {
	
	/**
	* Method : getBoardList
	* 작성자 : PC-24
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 리스트 불러오기
	*/
	List<BoardVo> getBoardList();
	
	/**
	* Method : insertBoard
	* 작성자 : PC-24
	* 변경이력 :
	* @param bvo
	* @return
	* Method 설명 : 게시판 등록
	*/
	int insertBoard(BoardVo bvo);
	
	/**
	* Method : updateBoard
	* 작성자 : PC-24
	* 변경이력 :
	* @param bvo
	* @return
	* Method 설명 : 게시판 수정
	*/
	int updateBoard(BoardVo bvo);
}
