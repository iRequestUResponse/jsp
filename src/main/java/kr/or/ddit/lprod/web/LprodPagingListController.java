package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;

@WebServlet("/lprodPagingList")
public class LprodPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILprodService lprodService = new LprodService();
		
		String pageStr = request.getParameter("page");
		String sizeStr = request.getParameter("size");
		int pageInt = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int sizeInt = sizeStr == null ? 5 : Integer.parseInt(sizeStr);
		
		Page page = new Page();
		page.setPage(pageInt);
		page.setSize(sizeInt);
		request.setAttribute("pageVo", page);
		Map<String, Object> map = lprodService.getLprodPagingList(page);
		
		List<Lprod> lprodList = (List<Lprod>) map.get("lprodList");
		int paginationSize = (Integer) map.get("paginationSize");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
	}
}
