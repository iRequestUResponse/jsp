package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;

public class LprodServiceTest {
	private ILprodService lprodService;
	
	@Before
	public void setup() {
		lprodService = new LprodService();
	}

	@Test
	public void getLprodListTest() {
		/***Given***/

		/***When***/
		List<Lprod> list = lprodService.getLprodList();

		/***Then***/
		assertEquals(10, list.size());
	}
	
	@Test
	public void getLprodPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setSize(5);

		/***When***/
		Map<String, Object> map = lprodService.getLprodPagingList(page);
		List<Lprod> list = (List<Lprod>) map.get("lprodList");
		int paginationSize = (Integer) map.get("paginationSize");

		/***Then***/
		assertEquals(5, list.size());
		assertEquals(2, paginationSize);
	}

}
