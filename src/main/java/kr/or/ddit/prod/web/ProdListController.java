package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.Prod;
import kr.or.ddit.prod.repository.IProdDao;
import kr.or.ddit.prod.repository.ProdDao;

@WebServlet("/prodList")
public class ProdListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lprod_gu = request.getParameter("lprod_gu");
		IProdDao prodDao = new ProdDao();
		List<Prod> list = prodDao.selectListByLGU(lprod_gu);
		
		request.setAttribute("prodList", list);
		request.getRequestDispatcher("/prod/prodList.jsp").forward(request, response);
	}
}
