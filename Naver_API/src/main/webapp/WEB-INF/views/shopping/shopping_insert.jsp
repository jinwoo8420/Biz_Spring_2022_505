<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST" class="w3-container">
	<div>
		<input name="s_productId" id="s_productId" class="w3-input" placeholder="ID" value="${SHOPPING.s_productId}" type="hidden"
			<c:if test = "${not empty SHOPPING.productId}">
				readonly = "readonly"
			</c:if>
		>
		<input name="s_title" id="s_title" class="w3-input" placeholder="상품명" value="${SHOPPING.s_title}">
	</div>
	<div>
		<input name="s_mallName" class="w3-input" placeholder="쇼핑몰" value="${SHOPPING.s_mallName}">
		<input name="s_maker" class="w3-input" placeholder="제조사" value="${SHOPPING.s_maker}">
		<input name="s_brand" class="w3-input" placeholder="브랜드" value="${SHOPPING.s_brand}">
		<input name="s_lprice" class="w3-input" placeholder="최저가" type="number" value="${SHOPPING.s_lprice}">
		<input name="s_hprice" class="w3-input" placeholder="최고가" type="number" value="${SHOPPING.s_hprice}">
	</div>
	<div>
		<input name="s_link" class="w3-input" placeholder="자세히보기" value="${SHOPPING.s_link}" type="hidden">
		<input name="s_image" class="w3-input" placeholder="이미지경로" value="${SHOPPING.s_image}" type="hidden">
		<input name="s_usename" class="w3-input" placeholder="작성자" value="${S_USER}" readonly="readonly" type="hidden">
	</div>

	<button type="button" class="w3-button w3-indigo shopping-save">저장</button>
</form>