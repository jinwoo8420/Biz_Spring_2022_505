<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<style>
form {
	margin: 50px auto;
	width: 80%;
}

input {
	padding: 0.5rem;
	border: none;
	border-radius: 10px;
}

button {
	padding: 10px 20px;
	background-color: #001841;
	border-radius: 4px;
	color: white;
	cursor: pointer;
}

button:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.7);
	background-color: white;
	color: black;
	border: 1px solid white;
}

.btn_box {
	display: inline-block;
	float: right;
}
</style>

<script src="${rootPath}/static/js/insert.js?ver=2022-07-20-003"></script>

<c:if test="${not empty UPDATE.a_seq}">
	<h3>${UPDATE.a_name} UPDATE PAGE</h3>
</c:if>

<form method="POST">
	<input name="a_seq" type="hidden"
		value='<c:out value="${UPDATE.a_seq}" default ="0"/>' />
	<input name="a_name" value="${UPDATE.a_name}" placeholder="이름" />
	<input name="a_tel" value="${UPDATE.a_tel}" placeholder="전화번호" />
	<input name="a_address" value="${UPDATE.a_address}" placeholder="주소" />

	<div class="btn_box">
		<button class="btn_save" type="button">저장</button>

		<c:if test="${empty UPDATE.a_seq}">
			<button onclick="location.href = '${rootPath}/';" type="button">HOME</button>
		</c:if>

		<c:if test="${not empty UPDATE.a_seq}">
			<button onclick="location.href = '${rootPath}/detail?seq=${UPDATE.a_seq}';"
				type="button">뒤로가기</button>
		</c:if>
	</div>
</form>