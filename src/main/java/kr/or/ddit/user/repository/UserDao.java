package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDao implements IUserDao {

	/**
	* Method : getUserList
	* 작성자 : PC-17
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<User> getUserList() {
		/*
		 * // db에서 조회가 되었다고 가정하고 가짜 객체를 리턴 List<UserVo> userList = new ArrayList<>();
		 * for (String str : "brown, cony, sally, moon, james".split(", *")) {
		 * userList.add(new UserVo(str)); }
		 */
		
		SqlSession sqlSession = MybatisUtil.getSession();
		List<User> userList = sqlSession.selectList("user.getUserList");
		sqlSession.close();
		
		return userList;
	}

	/**
	* Method : getUser
	* 작성자 : PC-17
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :userId를 갖는 사용자 정보 조회
	*/
	@Override
	public User getUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		User userVo = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();
		
		return userVo;
	}

	/**
	* Method : getUserListOnlyHalf
	* 작성자 : PC-17
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 50명 조회
	*/
	@Override
	public List<User> getUserListOnlyHalf() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<User> userList = sqlSession.selectList("user.getUserListOnlyHalf");
		sqlSession.close();
		
		return userList;
	}

}
