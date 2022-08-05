<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>

<style>
a {
	text-decoration: none;
	color: inherit;
}
</style>

</head>

<body>
	<h1>TodoList</h1>

	<sec:authorize access="isAnonymous()">
		<h3>
			<a href="${rootPath}/login">LOGIN</a>
		</h3>

		<h3>
			<a href="${rootPath}/user/join">JOIN</a>
		</h3>
	</sec:authorize>


	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="isAuthenticated() AND hasRole('ROLE_ADMIN')">
			<h3>
				<a href="${rootPath}/admin">ADMIN HOME</a>
			</h3>
		</sec:authorize>

		<sec:authorize access="isAuthenticated() AND hasRole('ROLE_USER')">
			<h3>
				<a href="${rootPath}/user/mypage">MYPAGE</a>
			</h3>
		</sec:authorize>

		<form:form class="logout" action="${rootPath}/logout">
			<button>LOGOUT</button>
		</form:form>

	</sec:authorize>
</body>

</html>