package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.util.MybatisUtil;

public class LprodDao implements ILprodDao {

	/**
	* Method : selectAll
	* 작성자 : PC-17
	* 변경이력 :
	* @return
	* Method 설명 : LPROD의 모든 목록 가져오기
	*/
	@Override
	public List<Lprod> selectAll() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Lprod> list = sqlSession.selectList("lprod.selectAll");
		sqlSession.close();
		return list;
	}

}
