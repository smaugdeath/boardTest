package kr.or.ddit.post.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostVo {
	
	private static final Logger logger = LoggerFactory.getLogger(PostVo.class);

	private int postNum;
	private int boardNum;
	private String postTitle;
	private String postContent;
	private String userId;
	private Date postDate;
	private String delStatus;
	private int parentPostNum;
	private int gn;
	private int level;
	
	public PostVo() {
		
	}
	
	public PostVo(int postNum, String postTitle, String postContent, Date postDate, String delStatus, String userId,
				  int boardNum, int parentPostNum, int gn) {
		this.postNum = postNum;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
		this.delStatus = delStatus;
		this.userId = userId;
		this.boardNum = boardNum;
		this.parentPostNum = parentPostNum;
		this.gn = gn;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}

	public int getParentPostNum() {
		return parentPostNum;
	}

	public void setParentPostNum(int parentPostNum) {
		this.parentPostNum = parentPostNum;
	}

	public int getGn() {
		return gn;
	}

	public void setGn(int gn) {
		this.gn = gn;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	
	
	
	
}
