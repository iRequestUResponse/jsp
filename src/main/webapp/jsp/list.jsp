<%@ page import="kr.or.ddit.user.repository.UserDao"%>
<%@ page import="kr.or.ddit.user.repository.IUserDao"%>
<%@ page import="kr.or.ddit.user.model.UserVo"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	private IUserDao userDao = new UserDao();
	private List<UserVo> userList = userDao.getUserList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 1. userdao 선언
		 2. getUserList() 호출
		 3. 호출 결과(List<UserVo>)를 for loop를 통해 tr 태그를 반복 생성
	 --%>
	<table>
		<tr>
			<th>이름</th>
		</tr>
		<% for (UserVo user : userList) { %>
		<tr>
			<td><%= user.getUserNm() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>