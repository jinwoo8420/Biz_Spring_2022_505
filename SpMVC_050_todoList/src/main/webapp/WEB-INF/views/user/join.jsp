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
	<form:form>
		<input name="username" placeholder="USERNAME">
		<input name="password" type="password" placeholder="PASSWORD">
		<input name="re_password" type="password" placeholder="RE_PASSWORD">
		<input name="realname" placeholder="NAME">
		<input name="nickname" placeholder="NICKNAME">
		<input name="email" placeholder="EMAIL">
		<button>회원가입</button>
	</form:form>
</body>

</html>