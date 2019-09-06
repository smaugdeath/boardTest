package kr.or.ddit.user.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.util.MybatisUtil;

public class UserService implements IUserService {
	
	private static IUserService service;
	private IUserDao dao;
	private UserService() { 
		dao = UserDao.getInstance();
	}
	
	public static IUserService getInstance() {
		if(service==null) service = new UserService();
		
		return service;
	}

	/**
	* Method : getUser
	* 작성자 : PC-24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 상세 조회
	*/
	public User getUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
	    User user = dao.getUser(sqlSession, userId);
	    sqlSession.close();
	    return user;
	}

}
