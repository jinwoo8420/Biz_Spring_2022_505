<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<div class="w3-container w3-card-4">
	<form:form class="w3-container">
		<c:if test="${error=='PASS_FALE'}">
			<div class="w3-text-red">* 비밀번호가 일치하지 않아 수정불가</div>
		</c:if>

		<label class="w3-text-blue">USERNAME</label>
		<input class="w3-input w3-border" value='<sec:authentication property="principal.username"/>' readonly="readonly">

		<label class="w3-text-blue">PASSWORD</label>
		<div class="w3-text-red">* 확인 용도이며 변경 X</div>
		<input name="password" class="w3-input w3-border">

		<label class="w3-text-blue">EMAIL</label>
		<input name="email" class="w3-input w3-border" value='<sec:authentication property="principal.email"/>'>

		<label class="w3-text-blue">NAME</label>
		<input name="realname" class="w3-input w3-border" value='<sec:authentication property="principal.realname"/>'>

		<label class="w3-text-blue">NICKNAME</label>
		<input name="nickname" class="w3-input w3-border" value='<sec:authentication property="principal.nickname"/>'>

		<label class="w3-text-blue">TEL</label>
		<input name="tel" class="w3-input w3-border" value='<sec:authentication property="principal.tel"/>'>

		<button class="w3-button w3-blue">수정</button>
	</form:form>
</div>