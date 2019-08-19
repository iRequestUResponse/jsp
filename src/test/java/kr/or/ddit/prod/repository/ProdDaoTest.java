package kr.or.ddit.prod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.prod.model.Prod;

public class ProdDaoTest {

	@Test
	public void test() {
		/***Given***/
		IProdDao dao = new ProdDao();

		/***When***/
		List<Prod> list = dao.selectListByLGU("P101");

		/***Then***/
		assertEquals(6, list.size());
	}

}
