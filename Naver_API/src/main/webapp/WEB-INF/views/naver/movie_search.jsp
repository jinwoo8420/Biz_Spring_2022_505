<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<div class="w3-container">

	<table class="w3-table-all search-result">
		<colgroup>
			<col width="300px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
		</colgroup>

		<thead>
			<tr>
				<th>제목</th>
				<th>감독</th>
				<th>주연</th>
				<th>평점</th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${empty MOVIES}">
				<tr>
					<td colspan="4">검색결과 없음</td>
				</tr>
			</c:if>

			<c:forEach items="${MOVIES}" var="MOVIE">
				<tr data-title="${MOVIE.title}">
					<td>${MOVIE.title}</td>
					<td>${MOVIE.director}</td>
					<td>${MOVIE.actor}</td>
					<td>${MOVIE.userRating}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</div>
