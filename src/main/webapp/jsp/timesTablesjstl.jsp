<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 스크립틀릿, 표현식 --> jstl, el --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<table border=1>
	<c:forEach var="j" begin="1" end="9">
		<tr>
		<c:forEach var="i" begin="2" end="9">
			<td>${ i } * ${ j } = ${ i * j }</td>
		</c:forEach>
		</tr>
	</c:forEach>
	</table>
</body>
</html>