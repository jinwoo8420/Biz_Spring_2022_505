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
.detail_btn {
	cursor: pointer;
}

.detail_btn:hover {
	border-bottom: solid 2px white;
}

body {
	width: 50vw;
	margin: 10px auto;
	background-color: #b8d7fd;
}

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

.tbl_adr {
	border-collapse: collapse;
	margin: 10px auto;
	width: 70%;
}

.tbl_adr td {
	line-height: 30px;
}
</style>

</head>
<body>
	<c:if test="${not empty UPDATE.a_seq}">
		<h3>${UPDATE.a_name} UPDATE PAGE</h3>
	</c:if>

	<form method="POST">
		<input name="a_seq" type="hidden"
			value='<c:out value="${UPDATE.a_seq}" default ="0"/>'>
		<input name="a_name" value="${UPDATE.a_name}" placeholder="이름">
		<input name="a_tel" value="${UPDATE.a_tel}" placeholder="전화번호">
		<input name="a_address" value="${UPDATE.a_address}" placeholder="주소">

		<div class="btn_box">
			<button>저장</button>

			<c:if test="${not empty UPDATE.a_seq}">
				<button
					onclick="location.href = '${rootPath}/detail?seq=${UPDATE.a_seq}';">뒤로가기</button>
			</c:if>
		</div>
	</form>

	<table class="tbl_adr">
		<colgroup>
			<col width="100px">
			<col width="300px">
			<col width="300px">
			<col width="1000px">
		</colgroup>

		<thead>
			<tr>
				<th>NO</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${HOME}" var="address" varStatus="INDEX">
				<tr style="text-align: center" class="detail_btn"
					onclick="location.href = '${rootPath}/detail?seq=${address.a_seq}';">
					<td>${INDEX.count}</td>
					<td>${address.a_name}</td>
					<td>${address.a_tel}</td>
					<td>${address.a_address}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
