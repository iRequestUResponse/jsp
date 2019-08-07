<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	// /css/blog.css --> 물리적인 경로를 구해주는 메서드
	String blogCssPath = application.getRealPath("/css/blog.css");
	
	File file = new File(blogCssPath);
	FileInputStream fis = new FileInputStream(file);
	byte[] buffer = new byte[512];
	int len = 0;
	while ((len = fis.read(buffer)) != -1) {
		out.write(new String(Arrays.copyOfRange(buffer, 0, len)));
	}
	out.write("<br><br>");
	fis.close();
%>

blogCssPath : <%= blogCssPath %> <br>