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
table.encycs {
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
	padding: 11px 16px;
	background-color: blue;
	color: white;
	border-radius: 5px;
}

div.btn_box a:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.7);
}
</style>

<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/encyc.js?ver=2022-07-25-001"></script>

</head>
<body>

	<table class="w3-table-all encycs">
		<colgroup>
			<col width="100px">
			<col width="100px">
			<col width="300px">
			<col width="200px">
		</colgroup>

		<thead>
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${ENCYCS}" var="ENCYC" varStatus="INDEX">
				<tr data-seq="${ENCYC.e_seq}">
					<td>${INDEX.count}</td>
					<td>${ENCYC.title}</td>
					<td>${ENCYC.description}</td>
					<td>${ENCYC.e_username}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<div class="btn_box">
		<a href="${rootPath}/encyc/encyc_insert">추가</a>
	</div>

</body>

</html>