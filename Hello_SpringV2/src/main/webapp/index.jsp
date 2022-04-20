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
	String strName = "홍길동";
	int intNum1 = 30, intNum2 = 40;
	int intSum = intNum1 + intNum2;
	%>
	<h1>
		Hello
		<%=strName%>
	</h1>
	<h3><%=intNum1%>
		+
		<%=intNum2%>
		=
		<%=intSum%></h3>
</body>
</html>