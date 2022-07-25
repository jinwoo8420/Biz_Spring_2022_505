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
	<h1>${DETAIL.st_name} PAGE</h1>

	<h4>학번 : ${DETAIL.st_num}</h4>
	<h4>학과 : ${DETAIL.st_dept}</h4>
	<h4>학년 : ${DETAIL.st_grade}</h4>
	<h4>전화번호 : ${DETAIL.st_tel}</h4>
	<h4>주소 : ${DETAIL.st_addr}</h4>
</body>

</html>