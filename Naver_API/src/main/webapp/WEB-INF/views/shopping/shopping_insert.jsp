<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST" class="w3-container">
	<div>
		<input name="title" id="s_title" class="w3-input" placeholder="상품명" value="${SHOPPING.title}">
	</div>
	<div>
		<input name="mallName" class="w3-input" placeholder="쇼핑몰" value="${SHOPPING.mallName}">
		<input name="maker" class="w3-input" placeholder="제조사" value="${SHOPPING.maker}">
		<input name="brand" class="w3-input" placeholder="브랜드" value="${SHOPPING.brand}">
		<input name="lprice" class="w3-input" placeholder="최저가" type="number" value='<c:out value="${SHOPPING.lprice}" default ="0"/>'>
		<input name="hprice" class="w3-input" placeholder="최고가" type="number" value='<c:out value="${SHOPPING.hprice}" default ="0"/>'>
	</div>
	<div>
		<input name="link" class="w3-input" placeholder="자세히보기" value="${SHOPPING.link}" type="hidden">
		<input name="image" class="w3-input" placeholder="이미지경로" value="${SHOPPING.image}" type="hidden">
		<input name="s_usename" class="w3-input" placeholder="작성자" value="${S_USER}" readonly="readonly" type="hidden">
	</div>

	<button type="button" class="w3-button w3-indigo shopping-save">저장</button>
</form>