<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// jsp에 내장되어있는 기본 객체가 존재 : request, response
%>
<body>
	request.getLocalAddr() local IP = <%= request.getLocalAddr() %> <br>
	request.getRemoteAddr() 클라이언트 IP = <%= request.getRemoteAddr() %> <br>
	request.getContentLgneth() 요청 정보 길이 = <%= request.getContentLength() %> <br>
	request.getCharacterEncoding() 요청 정보 인코딩 = <%= request.getCharacterEncoding() %> <br>
	request.getContentType() 요청정보 컨텐트 타입 = <%= request.getContentType() %> <br>
	request.getProtocol() 요청 프로토콜 = <%= request.getProtocol() %> <br>
	request.getMethod() 요청 메서드 = <%= request.getMethod() %> <br>
	request.getRequestURI() 요청 RUI = <%= request.getRequestURI() %> <br>
	request.getContextPath() context path = <%= request.getContextPath() %> <br> <!-- 어플 이름이라고 보면 된다 (경로명 : ex : /home -->
	request.getServername() 서버이름 = <%= request.getServerName() %> <br>
	request.getServerPort() 서버포트 = <%= request.getServerPort() %> <br>
	
</body>
</html> 