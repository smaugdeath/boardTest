package kr.or.ddit.board.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardVo {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardVo.class);
	
	private int boardNum;
	private String boardNm;
	private String useStatus;
	private String userId;
	private Date boardDate;
	
	public BoardVo() {
		
	}
	
	public BoardVo(int boardNum, String boardNm, String useStatus, Date boardDate, String userId) {
		this.boardNum = boardNum;
		this.boardNm = boardNm;
		this.useStatus = useStatus;
		this.boardDate = boardDate;
		this.userId = userId;
	}


	public BoardVo(String boardNm, String useStatus, String userId) {
		this.boardNm = boardNm;
		this.useStatus = useStatus;
		this.userId = userId;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardNm() {
		return boardNm;
	}

	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	
	
}
