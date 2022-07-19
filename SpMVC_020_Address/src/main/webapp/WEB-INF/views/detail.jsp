<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
a {
	text-decoration: none;
	color: inherit;
}

body {
	width: 50vw;
	margin: 10px auto;
	background-color: #b8d7fd;
}

table {
	border-collapse: collapse;
	margin: 10px auto;
	width: 70%;
}

.btn {
	margin: 10px auto;
	line-height: 100%;
	float: right;
}

.btn a {
	text-decoration: none;
	display: inline-block;
	padding: 12px 16px;
	border-radius: 5px;
	background-color: #001841;
	color: white;
}

.btn a:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.7);
	background-color: white;
	color: black;
	border: 1px solid white;
}
</style>

</head>

<body>
	<h3>${DETAIL.a_name} DETAIL PAGE</h3>

	<table>
		<thead>
			<tr>
				<th>SEQ</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
		</thead>

		<tbody>
			<tr style="text-align: center">
				<td>${DETAIL.a_seq}</td>
				<td>${DETAIL.a_name}</td>
				<td>${DETAIL.a_tel}</td>
				<td>${DETAIL.a_address}</td>
			</tr>
		</tbody>

	</table>

	<div class="btn">
		<a href="${rootPath}/update?seq=${DETAIL.a_seq}">수정</a>
		<a href="${rootPath}/delete?seq=${DETAIL.a_seq}">삭제</a>
		<a href="${rootPath}/">Home</a>
	</div>

</body>

</html>