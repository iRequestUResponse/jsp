<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>
	<!-- 파라미터를 받는다
		input tag의 name 속성이 파라미터 이름
		userId, pwssword
		String userId = request.getParameter("userId");	
		String password = request.getParameter("password");	
	 -->
	 <%
	 	String userId = request.getParameter("userId");	
		String password = request.getParameter("password");
	 %>
	 
	 <h2>request.getParameter()</h2>
	 parameter userId = <%= userId %> <br>
	 parameter password = <%= password %> <br>
	 
	 <%
		String[] userIds = request.getParameterValues("userId");
	 %>
	 <h2>request.getParameterValues()</h2>
	 <% for (String str : userIds) { %>
	 parameter userId = <%= str %> <br>
	 <% } %>
	 
	 <%
	 	Map<String, String[]> requestMap = request.getParameterMap();
	 	Set<String> keySet = requestMap.keySet();
	 %>
	 <h2>request.getParameterMap()</h2>
	 <% for (String key : keySet) { %>
	 <%= key %> = <%= Arrays.toString(requestMap.get(key)) %> <br>
	 <% } %>
	 
	 <%
	 	Enumeration<String> parameterNames = request.getParameterNames();
	 %>
	 <h2>request.getParameterNames()</h2>
	 <% while (parameterNames.hasMoreElements()) { %>
	 <%= parameterNames.nextElement() %> <br>
	 <% } %>
</body>
</html>