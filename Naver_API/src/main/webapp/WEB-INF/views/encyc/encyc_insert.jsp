<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST" class="w3-container">
	<div>
		<input name="title" id="e_title" class="w3-input" placeholder="제목" value="${ENCYC.title}">
	</div>
	<div>
		<input name="link" class="w3-input" placeholder="자세히보기" value="${ENCYC.link}" type="hidden">
		<input name="thumbnail" class="w3-input" placeholder="이미지경로" value="${ENCYC.thumbnail}" type="hidden">
		<input name="e_seq" type="hidden" value='<c:out value="${ENCYC.e_seq}" default ="0"/>'>
		<input name="e_usename" class="w3-input" placeholder="작성자" value="${E_USER}" readonly="readonly" type="hidden">
	</div>
	
	<textarea rows="5" cols="205" name="description">${ENCYC.description}</textarea>

	<button type="button" class="w3-button w3-indigo encyc-save">저장</button>
</form>