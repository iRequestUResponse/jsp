<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 선언부 : 메서드나 변수를 선언 -->
<%!
	private long factorial(int x) {
		long result = 1;
		for (; x > 0; x--) {
			result *= x;
		}
		return result;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for (int i = 0; i < 11; i++) { %>
	factorial(<%= i %>) : <%= factorial(i) %> <br>
	<% } %>
</body>
</html>