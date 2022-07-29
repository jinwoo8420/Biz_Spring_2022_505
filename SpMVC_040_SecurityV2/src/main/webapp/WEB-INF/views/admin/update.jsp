<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<div class="w3-container w3-card-4">
	<form:form class="w3-container">

		<c:if test="${error=='ADMIN_PASS'}">
			<div class="w3-text-red">
				<strong>관리자 비밀번호 오류</strong>
			</div>
		</c:if>

		<label class="w3-text-blue">ADMIN PASSWORD</label>
		<div class="w3-text-red">* 관리자 비밀번호 입력</div>
		<input name="password" class="w3-input w3-border">

		<label class="w3-text-blue">USERNAME</label>
		<input class="w3-input w3-border" value="${UPDATE.username}" readonly="readonly">

		<label class="w3-text-blue">EMAIL</label>
		<input name="email" class="w3-input w3-border" value="${UPDATE.email}">

		<label class="w3-text-blue">NAME</label>
		<input name="realname" class="w3-input w3-border" value="${UPDATE.realname}">

		<label class="w3-text-blue">NICKNAME</label>
		<input name="nickname" class="w3-input w3-border" value="${UPDATE.nickname}">

		<label class="w3-text-blue">TEL</label>
		<input name="tel" class="w3-input w3-border" value="${UPDATE.tel}">

		<button class="w3-button w3-blue">수정</button>
	</form:form>
</div>