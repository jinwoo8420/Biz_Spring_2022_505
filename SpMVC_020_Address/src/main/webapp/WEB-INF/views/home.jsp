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
</head>
<body>
	<h1>hello</h1>
	<form method="POST">
		<input name="a_seq" type="hidden">
		<input name="a_name" placeholder="이름">
		<input name="a_tel" placeholder="전화번호">
		<input name="a_address" placeholder="주소">
		<button>저장</button>
	</form>
</body>
</html>
