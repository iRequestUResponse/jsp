<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body, select {
	font-size: 2rem;
}
</style>
</head>
<body>
	<form action="" id="frm" action="${ cp }/selectLocale" method="GET">
		<select name="locale">
			<option value="ko">한국어</option>
			<option value="en">English</option>
			<option value="zh">中国话</option>
		</select>
	</form>
	
	<fmt:setLocale value="${ param.locale }"/>
	<fmt:setBundle basename="kr.or.ddit.msg.message" var="msg"/>
	<fmt:message key="GREETING" bundle="${ msg }" /> <br>
	
	<script>
	if ("${ param.locale }") frm.locale.value = "${ param.locale }";
	
	frm.locale.oninput = function() {
		frm.submit();
	}
	</script>
</body>
</html>