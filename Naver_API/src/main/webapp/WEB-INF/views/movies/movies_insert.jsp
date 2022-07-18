<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST" class="w3-container">
	<div>
		<input name="title" id="m_title" class="w3-input" placeholder="제목" value="${MOVIE.title}" 
			<c:if test = "${not empty MOVIE.title}">
				readonly = "readonly"
			</c:if>
		>
		<input name="subtitle" class="w3-input" placeholder="영제목" value="${MOVIE.subtitle}">		
	</div>
	<div>
		<input name="director" class="w3-input" placeholder="감독" value="${MOVIE.director}">
		<input name="actor" class="w3-input" placeholder="주연" value="${MOVIE.actor}">
		<input name="pubDate" class="w3-input" placeholder="제작년도" value="${MOVIE.pubDate}">
	</div>
	<div>
	<input name="userRating" class="w3-input" placeholder="평점" value="${MOVIE.userRating}"type="hidden">
		<input name="link" class="w3-input" placeholder="자세히보기" value="${MOVIE.link}" type="hidden">
		<input name="image" class="w3-input" placeholder="이미지경로" value="${MOVIE.image}" type="hidden">
		<input name="m_code" class="w3-input" placeholder="CODE" value="${MOVIE.m_code}" >
		<input name="m_usename" class="w3-input" placeholder="작성자" value="${M_USER}" readonly="readonly" type="hidden">
	</div>

	<button type="button" class="w3-button w3-indigo movies-save">저장</button>
</form>