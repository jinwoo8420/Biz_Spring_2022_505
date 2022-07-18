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

<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/shopping.js?ver=2022-07-16-001"></script>

</head>
<body>

	<table class="w3-table-all shopping">
		<colgroup>
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
		</colgroup>

		<thead>
			<tr>
				<th>No.</th>
				<th>상품명</th>
				<th>쇼핑몰</th>
				<th>제조사</th>
				<th>브랜드</th>
				<th>최저가</th>
				<th>최고가</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${SHOPPINGS}" var="SHOPPING" varStatus="INDEX">
				<tr data-id="${SHOPPING.productId}">
					<td>${INDEX.count}</td>
					<td>${SHOPPING.title}</td>
					<td>${SHOPPING.mallName}</td>
					<td>${SHOPPING.maker}</td>
					<td>${SHOPPING.brand}</td>
					<td>${SHOPPING.lprice}</td>
					<td>${SHOPPING.hprice}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<div class="btn_box">
		<a href="${rootPath}/shopping/shopping_insert">상품정보추가</a>
	</div>

</body>
</html>