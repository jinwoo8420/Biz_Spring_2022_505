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
	<table>
		<thead>
			<tr>
				<th>SEQ</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>${DETAIL.a_seq}</td>
				<td>${DETAIL.a_name}</td>
				<td>${DETAIL.a_tel}</td>
				<td>${DETAIL.a_address}</td>
			</tr>
		</tbody>

	</table>

	<div>
		<a href="${rootPath}/update?seq=${DETAIL.a_seq}">수정</a>
		<a href="${rootPath}/delete?seq=${DETAIL.a_seq}">삭제</a>
		<a href="${roorPath}/">Home</a>
	</div>
</body>
</html>