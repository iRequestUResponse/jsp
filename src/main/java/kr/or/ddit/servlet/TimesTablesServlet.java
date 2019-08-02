package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimesTablesServlet extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(TimesTablesServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("TimesTablesServlet doGet()"); // 이걸 쓰면 안 좋다
		logger.debug("TimesTablesServlet doGet()");
		String method = req.getMethod();
		
//		logger.trace("trace");
//		logger.debug("debug {} {}", method, method+"test");
//		logger.info("info");
//		logger.warn("warn");
//		logger.error("error");
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("	<table border=1>");
		for (int j = 1; j <= 9; j++) {
			pw.println("		<tr>");
			for (int i = 2; i <= 9; i++) {
				pw.println("			<td>" + i + " * " + j + " = " + (i * j) + "</td>");
			}
			pw.println("		</tr>");
		}
		pw.println("	</table>");
		pw.println("<body>");
		pw.println("</html>");
	}

}
