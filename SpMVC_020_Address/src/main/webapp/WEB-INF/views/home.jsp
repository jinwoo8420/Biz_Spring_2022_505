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
</head>
<body>
	<h1>hello</h1>
	<form method="POST">
		<input name="a_seq" type="hidden"
			value='<c:out value="${UPDATE.a_seq}" default ="0"/>'>
		<input name="a_name" value="${UPDATE.a_name}" placeholder="이름">
		<input name="a_tel" value="${UPDATE.a_tel}" placeholder="전화번호">
		<input name="a_address" value="${UPDATE.a_address}" placeholder="주소">
		<button>저장</button>
	</form>

	<table class="tbl_adr">
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
				<tr>
					<td>${INDEX.count}</td>
					<td><a href="${rootPath}/detail?seq=${address.a_seq}">${address.a_name}</a></td>
					<td>${address.a_tel}</td>
					<td>${address.a_address}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
