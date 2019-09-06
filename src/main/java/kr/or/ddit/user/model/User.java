package kr.or.ddit.user.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

public class User {
	
	private static final Logger logger = LoggerFactory.getLogger(User.class);

	private String userId;		//사용자 아이디
	private String pass;		//사용자 비밀번호
	private String userNm;		//사용자 이름
	
	public User() {
		
	}
	
	public User(String userName) {
		this.userNm = userName;
	}
	
	public User(String userId, String userNm, String pass) {
		this.userId = userId;
		this.userNm = userNm;
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", pass=" + pass + ", userNm=" + userNm + "]";
	}

	public boolean checkLoginValidate(String userId, String pass) {
		// 암호화 문장끼리 비교
		return userId.equals(this.getUserId()) && KISA_SHA256.encrypt(pass).equals(this.getPass());
	}
	

}
