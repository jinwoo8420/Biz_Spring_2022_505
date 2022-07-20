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

.tbl_adr {
	border-collapse: collapse;
	margin: 10px auto;
}

.tbl_adr td {
	line-height: 30px;
}
</style>

</head>
<body>
	<button onclick="location.href = '${rootPath}/insert';">주소록 추가</button>

	<!-- 
	form에 한개의 input box만 있을 경우 input box text를 입력 후 Enter를 누르면 input box에 담긴 문자열을
	서버로 전송하는 기능이 활성화 된다
	 -->
	<c:if test="${empty UPDATE.a_seq}">
		<form>
			<input name="search" placeholder="검색어 입력">
		</form>
	</c:if>

	<table class="tbl_adr">
		<colgroup>
			<col width="100px">
			<col width="100px">
			<col width="300px">
			<col width="500px">
			<col width="1000px">
		</colgroup>

		<thead>
			<tr>
				<th>NO</th>
				<th>SEQ</th>
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
					<td>${address.a_seq}</td>
					<td>${address.a_name}</td>
					<td>${address.a_tel}</td>
					<td>${address.a_address}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<%@ include file="/WEB-INF/views/pagenation.jsp"%>

</body>
</html>
