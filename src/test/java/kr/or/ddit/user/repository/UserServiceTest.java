package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

public class UserServiceTest {
	
	private IUserService userService;
	private String userId = "brownTest";
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Before
	public void setup() {
		userService = new UserService();
		
		userService.deleteUser(userId);
	}

	/**
	* Method : getuserListTest
	* 작성자 : PC-17
	* 변경이력 :
	* Method 설명 : getUserList 테스트
	*/
	@Test
	public void getUserListTest() {
		/***Given***/
		

		/***When***/
		List<User> userList = userService.getUserList();

		/***Then***/
		assertEquals(105, userList.size());
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
		String userId = "brown";
		
		/***When***/
		User userVo = userService.getUser(userId);
		logger.debug("getUser Test {}", userVo);

		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		assertEquals("brown1234", userVo.getPass());
	}
	
	/**
	* Method : getUserListTest
	* 작성자 : PC-17
	* 변경이력 :
	* Method 설명 : getUserListOnlyHalf 테스트
	*/
	@Test
	public void getUserListOnlyHalfTest() {
		/***Given***/
		
		
		/***When***/
		List<User> userList = userService.getUserListOnlyHalf();
		
		/***Then***/
		assertEquals(50, userList.size());
	}
	
	/**
	* Method : getUserPagingListTest
	* 작성자 : PC-17
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	*/
	@Test
	public void getUserPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setSize(10);

		/***When***/
		Map<String, Object> resultMap = userService.getUserPagingList(page); 
		List<User> userList = (List<User>) resultMap.get("userList");
		int paginationSize = (Integer) resultMap.get("paginationSize");

		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid22", userList.get(0).getUserId());
		assertEquals(11, paginationSize);
	}
	
	/**
	* Method : insertUser
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param user
	* @return
	* Method 설명 : 사용자 등록
	 * @throws ParseException 
	*/
	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		user.setUserId(userId );	
		user.setUserNm("브라운테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");

		/***When***/
		int insertCnt = userService.insertUser(user);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateUserTest() {
		/***Given***/
		User user = userService.getUser(userId);

		/***When***/
		user.setUserNm("asdf");
		userService.updateUser(user);
		User user2 = userService.getUser(userId);

		/***Then***/
		assertEquals("asdf", user2.getUserNm());
	}
}
