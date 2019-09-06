package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDaoTest {

	   private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	   
	   private IUserDao dao;
	   private SqlSession sqlSession;
	   private String userId = "cony";
	   
	   //junit 테스트 메소드 실행 순서
	   // @Before -> @Test -> @After
	   // @Test 테스트 메소드가 실행되기 전에 @Before이 적용된 메소드를 먼저 실행하고, @Test 메소드 실행수
	   // @After이 적용된 메소드를 실행한다.
	   // @Test 메소드는 실행순서가 보장되지 않음
	   
	   //테스트에 공통적으로 필요한 자원을 생성 / 초기화
	   @Before
	   public void setup() {
	      logger.debug("before");
	      dao = UserDao.getInstance();
	      sqlSession = MybatisUtil.getSession();
	      
	   }
	   
	   //테스트에 공통적으로 사용한 자원을 해제
	   @After
	   public void tearDown() {
	      logger.debug("after");
	      sqlSession.close();
	   }
	   
	   /**
	   * Method : getUserTest
	   * 작성자 : PC-13
	   * 변경이력 :
	   * Method 설명 : 사용자 정보 조회 테스트
	    */
	   @Test
	   public void getUserTest() {
			/***Given***/

			/***When***/
			User uvo = dao.getUser(sqlSession, userId);
			
			/***Then***/
			assertEquals("cony", uvo.getUserId());
	   }

}
