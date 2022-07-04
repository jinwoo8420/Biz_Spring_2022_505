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
	width: 50vw;
	margin: 10px auto;
	background-color: #b8d7fd;
	/* display: flex;
	flex-direction: column; */
}

div.container {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 50vh;
}

table {
	border-collapse: collapse;
	margin: 10px auto;
	width: 70%;
}

div.btn_box {
	width: 80%;
	margin: 10px auto;
	text-align: right;
}

div.btn_box a {
	text-decoration: none;
	display: inline-block;
	padding: 12px 16px;
	background-color: blue;
	color: white;
	border-radius: 6px;
}

div.btn_box a:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.7);
}

h1 {
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
}

div.btn-box {
	float: right;
	margin: 10px auto;
}

div.btn-box a {
	text-decoration: none;
	color: black;
	display: inline-block;
	padding: 12px 16px;
	border-radius: 5px;
	text-decoration: none;
	background-color: white;
}

div.btn-box a:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.7);
}
</style>

<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/memo.js?ver=2022-06-27-001"></script>

</head>
<body>

	<div class="container">
		<h1>${USERNAME}</h1>
		<table class="memo">
			<tr>
				<th>NO</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>메모</th>
			</tr>
			<c:if test="${empty MEMOS}">
				<tr>
					<td colspan="4" style="text-align: center">메모 X</td>
				</tr>
			</c:if>
			<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
				<tr data-seq="${MEMO.m_seq}" style="text-align: center">
					<td>${INDEX.count}</td>
					<td>${MEMO.m_date}</td>
					<td>${MEMO.m_time}</td>
					<td>${MEMO.m_memo}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="btn-box">
		<a href="${rootPath}/memo/insert">메모작성하기</a>
		<c:if test="${empty USERNAME}">
			<a href="${rootPath}/user/login">로그인</a>
		</c:if>
		<c:if test="${not empty USERNAME}">
			<a href="${rootPath}/user/logout">로그아웃</a>
		</c:if>
	</div>

</body>
</html>