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

div.detail, div.btn-box {
	width: 80%;
	margin: 10px auto;
}

div.btn-box {
	text-align: right;
}

div.btn-box a {
	text-decoration: none;
	color: white;
	display: inline-block;
	padding: 12px 16px;
	border-radius: 5px;
}

div.btn-box a:hover {
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
		<div class="w3-container detail-flex">
			<div>
				<img src="${rootPath}/upload/${MEMO.m_image}">
			</div>
			<div class="detail">
				<p>SEQ : ${MEMO.m_seq}
				<p>작성자 : ${MEMO.m_author}
				<p>작성일자 : ${MEMO.m_date}
				<p>작성시각 : ${MEMO.m_time}
				<p>내용 : ${MEMO.m_memo}
			</div>
		</div>
		<div class="btn-box">
			<a href="${rootPath}/" class="list">리스트</a>
			<a href="${rootPath}/memo/${MEMO.m_seq}/update" class="update">수정</a>
			<a href="javascript:void(0)" class="delete">삭제</a>
		</div>
	</section>
</body>
<script>
		document.querySelector("a.delete")?.addEventListener("click",()=>{
			if(confirm("정말 삭제할까요?")) {
				document.location.replace("${rootPath}/memo/${MEMO.m_seq}/delete")
			}
		})
	</script>





</html>