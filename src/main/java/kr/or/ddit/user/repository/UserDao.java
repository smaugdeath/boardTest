package kr.or.ddit.user.repository;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;

public class UserDao implements IUserDao {

	private static IUserDao dao;
	
	private UserDao() { }
	
	public static IUserDao getInstance() {
		if(dao==null) dao = new UserDao();
		return dao;
	}

	/**
	* Method : getUser
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param userId
	* @return
	* Method 설명 : userId를 갖는 사용자 정보 조회
	*/
	public User getUser(SqlSession sqlSession, String userId) {
		
		User userVo = sqlSession.selectOne("user.getUser", userId);
		
		return userVo;
	}

}
