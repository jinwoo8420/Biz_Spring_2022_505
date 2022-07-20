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
section.w3-container {
	display: flex;
	flex-direction: column;
	width: 80%;
	margin: 10px auto;
}

div.detail-flex {
	display: flex;
	justify-content: space-around;
}

div.detail, div.btn_box {
	width: 80%;
	margin: 10px auto;
}

div.btn_box {
	text-align: right;
}

div.btn_box a {
	text-decoration: none;
	color: white;
	display: inline-block;
	padding: 12px 16px;
	border-radius: 5px;
}

div.btn_box a:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.7);
}

a.list {
	background-color: green;
}

a.update {
	background-color: blue;
}

a.delete {
	background-color: red;
}
</style>

</head>
<body>
	<section class="w3-container">

		<div class="w3-container shopping_detail-flex">
			<div>
				<img src="${SHOPPING.image}">
			</div>

			<div class="shopping_detail">
				<h2>
					상품명 : <a href="${SHOPPING.link}" target=_Blank>${SHOPPING.title}</a>
				</h2>
				<p>쇼핑몰 : ${SHOPPING.mallName}</p>
				<p>제조사 : ${SHOPPING.maker}</p>
				<p>브랜드 : ${SHOPPING.brand}</p>
				<p>최저가 : ${SHOPPING.lprice}</p>
				<p>최고가 : ${SHOPPING.hprice}</p>
			</div>

		</div>

		<div class="btn_box">
			<a href="${rootPath}/shopping/shopping_list" class="list">리스트</a> <a
				href="${rootPath}/shopping/${SHOPPING.s_seq}/shopping_update" class="update">수정</a>
			<a href="javascript:void(0)" class="delete">삭제</a>
		</div>
	</section>
</body>

<script>
	document.querySelector("a.delete")?.addEventListener("click",()=>{
		if(confirm("삭제?")) {
			document.location.replace("${rootPath}/shopping/${SHOPPING.s_seq}/shopping_delete")
		}
	})
</script>

</html>
