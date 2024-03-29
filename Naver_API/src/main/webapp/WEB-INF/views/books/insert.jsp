<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST" class="w3-container">
	<div>
		<input name="isbn" id="isbn" class="w3-input" placeholder="ISBN" value="${BOOK.isbn}" <c:if test = "${not empty BOOK.isbn}">
				readonly = "readonly"
			</c:if>>
		<input name="title" id="title" class="w3-input" placeholder="도서명" value="${BOOK.title}">
	</div>
	<div>
		<input name="author" class="w3-input" placeholder="저자" value="${BOOK.author}">
		<input name="publisher" class="w3-input" placeholder="출판사" value="${BOOK.publisher}">
		<input name="pubdate" class="w3-input" placeholder="출판일" value="${BOOK.pubdate}">
	</div>
	<div>
		<input name="link" class="w3-input" placeholder="자세히보기" value="${BOOK.link}" type="hidden">
		<input name="image" class="w3-input" placeholder="이미지경로" value="${BOOK.image}" type="hidden">
		<input name="b_usename" class="w3-input" placeholder="작성자" value="${B_USER}" readonly="readonly" type="hidden">
	</div>
	<textarea rows="5" cols="205" name="description">${BOOK.description}</textarea>

	<button type="button" class="w3-button w3-indigo book-save">저장</button>
</form>