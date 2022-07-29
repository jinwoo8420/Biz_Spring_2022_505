<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<div class="w3-container">

	<table class="w3-table-all search-result">
		<colgroup>
			<col width="100px">
			<col width="300px">
			<col width="500px">
			<col width="300px">
		</colgroup>

		<thead>
			<tr>
				<th>제목</th>
				<th>자세히 보기</th>
				<th>내용</th>
				<th>이미지</th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${empty ENCYCS}">
				<tr>
					<td colspan="4">검색결과 없음</td>
				</tr>
			</c:if>

			<c:forEach items="${ENCYCS}" var="ENCYC">
				<tr data-title="${ENCYC.title}">
					<td>${ENCYC.title}</td>
					<td>${ENCYC.link}</td>
					<td>${ENCYC.description}</td>
					<td>${ENCYC.thumbnail}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</div>
