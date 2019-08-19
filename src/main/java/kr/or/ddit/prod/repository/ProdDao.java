package kr.or.ddit.prod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.prod.model.Prod;
import kr.or.ddit.util.MybatisUtil;

public class ProdDao implements IProdDao {

	@Override
	public List<Prod> selectListByLGU(String lprod_gu) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Prod> list = sqlSession.selectList("prod.selectListByLGU", lprod_gu);
		sqlSession.close();
		return list;
	}

}
