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
section.container {
	display: flex;
	flex-direction: column;
	width: 80%;
	margin: 10px auto;
}

div.detail-flex {
	display: flex;
	justify-content: space-around;
}

div.detail {
	width: 50%;
	margin: 10px auto;
	line-height: 300%;
}

div.btn-box {
	margin: 10px auto;
	margin-right: 10px;
	position: absolute;
	right: 0px;
	bottom: 0px;
	line-height: 100%;
	position: absolute;
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
	background-color: #001841;
}

a.update {
	background-color: #001841;
}

a.delete {
	background-color: #001841;
}

img {
	width: 300px;
	margin: 30px 30px;
}

body {
	background-color: #b8d7fd;
}

.detail {
	background-color: white;
	color: black;
	text-align: center;
	margin: 50px 20px;
	display: flex;
	flex-direction: column;
	height: 300px;
	font-size: 20px;
	box-shadow: 3px 3px 3px black;
	padding: 20px;
	justify-content: center;
	align-items: center;
	height: 300px;
	position: relative;
}
</style>

</head>
<body>
	<section class="container">
		<div class="detail-flex">
			<div>
				<img src="${rootPath}/upload/${MEMO.m_up_image}" alt="${MEMO.m_image}" width="100px">
			</div>

			<div class="detail">
				<div>작성자 : ${MEMO.m_author}</div>
				<div>작성일자 : ${MEMO.m_date}</div>
				<div>작성시각 : ${MEMO.m_time}</div>
				<div>메모 : ${MEMO.m_memo}</div>

				<div class="btn-box">
					<a href="${rootPath}/memo/${MEMO.m_seq}/update" class="update">수정</a>
					<a href="${rootPath}/memo/${MEMO.m_seq}/delete" class="delete">삭제</a>
					<a href="${rootPath}/" class="list">리스트</a>
				</div>

			</div>


		</div>


	</section>
</body>
</html>