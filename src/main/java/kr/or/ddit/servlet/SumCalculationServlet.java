package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sumCalculation")
public class SumCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		int startNum = Integer.parseInt(start);
		int endNum = Integer.parseInt(end);
		int result = 0;
		
		for (int i = startNum; i <= endNum; i++) result += i;
		
		request.getSession().setAttribute("sumResult", result);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}

}
