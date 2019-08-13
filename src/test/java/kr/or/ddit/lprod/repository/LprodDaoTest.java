package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.lprod.model.Lprod;

public class LprodDaoTest {

	@Test
	public void test() {
		/***Given***/
		ILprodDao lprodDao = new LprodDao(); 

		/***When***/
		List<Lprod> list = lprodDao.selectAll();

		/***Then***/
		assertEquals(10, list.size());
	}

}
