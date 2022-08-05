<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<h1>TodoList</h1>

	<form:form class="logout" action="${rootPath}/logout">
		<button>LOGOUT</button>
	</form:form>

	<a href="${rootPath}/user/mypage">MYPAGE</a>
	<a href="${rootPath}/admin">ADMIN HOME</a>
</body>

</html>