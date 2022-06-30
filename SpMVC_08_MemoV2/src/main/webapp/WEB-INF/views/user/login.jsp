<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>

<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #b8d7fd;
}

form {
	width: 50%;
	text-align: center;
}

input {
	padding: 1rem;
	border-radius: 5px;
	margin-right: 100px;
}

a {
	color: inherit;
}

.list {
	text-decoration: none;
	padding: 15px 16px;
	border-radius: 5px;
	position: absolute;
	background-color: #001841;
	color: white;
}
</style>

</head>
<body>
	<form method="POST">
		<input name="username" placeholder="USERNAME 입력 후 Enter">
		<a href="${rootPath}/" class="list">HOME</a>
	</form>
</body>
</html>