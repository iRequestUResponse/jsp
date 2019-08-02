<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String number = request.getParameter("number"), number2 = request.getParameter("number2");
		if (number == null) number = "";
		if (number2 == null) number2 = "";
		
		int begin, end;
		try {
			begin = Integer.parseInt(number);
			end = Integer.parseInt(number2);
		} catch (NumberFormatException e) {
			begin = 0;
			end = 0;
		}
		int result = begin * end;
	%>
	<form action="<%= request.getContextPath() %>/jsp/mul.jsp" method="get">
		number : <input type="text" name="number" value="<%= number %>"> <br>
		number2 : <input type="text" name="number2" value="<%= number2 %>"> <br>
		<input type="submit">	
	</form>
	
	result = <%= result %>
</body>
</html>