package kr.or.ddit.post.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentsVo {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentsVo.class);
	
	private int cmtNum;
	private String cmtContent;
	private Date cmtDate;
	private int postNum;
	private String userId;
	private String delStatus;
	
	public CommentsVo() {
		
	}
	
	public CommentsVo(int cmtNum, String cmtContent, Date cmtDate, int postNum, String userId) {
		this.cmtNum = cmtNum;
		this.cmtContent = cmtContent;
		this.cmtDate = cmtDate;
		this.postNum = postNum;
		this.userId = userId;
		
	}

	public int getCmtNum() {
		return cmtNum;
	}

	public void setCmtNum(int cmtNum) {
		this.cmtNum = cmtNum;
	}

	public String getCmtContent() {
		return cmtContent;
	}

	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}

	public Date getCmtDate() {
		return cmtDate;
	}

	public void setCmtDate(Date cmtDate) {
		this.cmtDate = cmtDate;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}
	
	
	

}
