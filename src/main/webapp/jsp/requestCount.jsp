<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>uri 통계자료</h2>
	<table>
		<thead>
			<tr>
				<th>uri</th>
				<th>method</th>
				<th>count</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ applicationScope.requestCountMap }" var="reqCount">
			<tr>
				<td>${ reqCount.key.split(";")[0] }</td>
				<td>${ reqCount.key.split(";")[1] }</td>
				<td>${ reqCount.value }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>