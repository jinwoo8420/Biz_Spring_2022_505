<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
	margin: 10px auto;
	width: 80%;
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
</style>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script>
	const rootPath = '${rootPath}'
</script>
<script src="${rootPath}/static/js/memo.js?ver=2022-06-24-001"></script>

</head>
<body>
	<table class="w3-table-all memo">
		<colgroup>
			<col width="100px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
		<thead>
			<tr>
				<th>NO</th>
				<th>내용</th>
				<th>작성일자</th>
				<th>작성시각</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
				<tr data-m_seq="${MEMO.m_seq}">
					<td>${INDEX.count}</td>
					<td>${MEMO.m_memo}</td>
					<td>${MEMO.m_date}</td>
					<td>${MEMO.m_time}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="btn_box">
		<a href="${rootPath}/memo/insert">추가</a>
	</div>

</body>
</html>