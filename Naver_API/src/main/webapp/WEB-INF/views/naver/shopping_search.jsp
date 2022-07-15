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
				<th>상품명</th>
				<th>쇼핑몰</th>
				<th>제조사</th>
				<th>브랜드</th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${empty SHOPPINGS}">
				<tr>
					<td colspan="4">검색결과 없음</td>
				</tr>
			</c:if>

			<c:forEach items="${SHOPPINGS}" var="SHOPPING">
				<tr data-id="${SHOPPING.productId}">
					<td>${SHOPPING.title}</td>
					<td>${SHOPPING.mallName}</td>
					<td>${SHOPPING.maker}</td>
					<td>${SHOPPING.brand}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</div>
