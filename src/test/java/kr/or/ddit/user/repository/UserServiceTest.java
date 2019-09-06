package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

public class UserServiceTest {

	   
	   private IUserService userService;
	   
	   private String userId = "brown";
	   
	   @Before
	   public void setup() {
	      userService = UserService.getInstance();
	      
	   }
	   
	   /**
	   * Method : getUserTest
	   * 작성자 : PC-17
	   * 변경이력 :
	   * Method 설명 : 사용자 정보 조회 테스트
	   */
	   @Test
	   public void getUserTest() {
	      /***Given***/
	      String userId = "cony";
	      
	      /***When***/
	      User userVo = userService.getUser(userId);

	      /***Then***/
	      assertEquals("코니", userVo.getUserNm());
	      assertEquals("cony1234", userVo.getPass());
	   }

}
