package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoTest {
	private SqlSession sqlSession;
	private ILprodDao lprodDao;
	
	@Before
	public void setup() {
		sqlSession = MybatisUtil.getSession();
		lprodDao = new LprodDao();
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}

	@Test
	public void getLprodListTest() {
		/***Given***/

		/***When***/
		List<Lprod> list = lprodDao.getLprodList(sqlSession);

		/***Then***/
		assertEquals(10, list.size());
	}
	
	@Test
	public void getLprodPagingListTest() {
		/***Given***/

		/***When***/
		Page page = new Page();
		page.setPage(1);
		page.setSize(5);
		List<Lprod> list = lprodDao.getLprodPagingList(sqlSession, page);

		/***Then***/
		assertEquals(5, list.size());
		assertEquals("P101", list.get(0).getLprod_gu());
	}

}
