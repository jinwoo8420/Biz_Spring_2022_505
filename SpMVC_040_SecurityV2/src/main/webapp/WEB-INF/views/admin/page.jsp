<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>

</head>

<body>
	<h1>Admin PAGE</h1>

	<table class="w3-table w3-table-all">
		<tr>
			<th>USERNAME</th>
			<th>NAME</th>
			<th>NICKNAME</th>
			<th>EMAIL</th>
			<th>TEL</th>
		</tr>
		<c:forEach items="${USERS}" var="USER">
			<tr>
				<td onclick="location.href = '${rootPath}/admin/update?username=${USER.username}';">${USER.username}</td>
				<td>${USER.realname}</td>
				<td>${USER.nickname}</td>
				<td>${USER.email}</td>
				<td>${USER.tel}</td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>