package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.repository.LprodDao;
import kr.or.ddit.util.MybatisUtil;

public class LprodService implements ILprodService {
	private ILprodDao lprodDao;
	public LprodService() {
		lprodDao = new LprodDao();
	}
	
	/**
	* Method : getLprodList
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품그룹 리스트
	*/
	@Override
	public List<Lprod> getLprodList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Lprod> list = lprodDao.getLprodList(sqlSession);
		sqlSession.close();
		return list;
	}
	
	/**
	* Method : getLprodPagingList
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 제품그룹 리스트 페이징
	*/
	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		Map<String, Object> map = new HashMap<>();
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<Lprod> lprodList = lprodDao.getLprodPagingList(sqlSession, page);
		int totalCnt = lprodDao.getLprodTotalCnt(sqlSession);
		
		sqlSession.close();
		
		// lprodList, paginationSize
		map.put("lprodList", lprodList);
		map.put("paginationSize", (totalCnt + page.getSize() - 1) / page.getSize());
		return map;
	}
}
