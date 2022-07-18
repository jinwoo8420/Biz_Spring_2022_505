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
table.books {
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

<script src="${rootPath}/static/js/movie.js?ver=2022-07-16-007"></script>

</head>
<body>

	<table class="w3-table-all movies">
		<colgroup>
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
		</colgroup>

		<thead>
			<tr>
				<th>No.</th>				
				<th>제목</th>
				<th>감독</th>
				<th>주연</th>
				<th>평점</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${MOVIES}" var="MOVIE" varStatus="INDEX">
				<tr data-title="${MOVIE.m_code}">
					<td>${INDEX.count}</td>
					<td>${MOVIE.title}</td>
					<td>${MOVIE.director}</td>
					<td>${MOVIE.actor}</td>
					<td>${MOVIE.userRating}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<div class="btn_box">
		<a href="${rootPath}/movies/movies_insert">영화정보추가</a>
	</div>

</body>
</html>