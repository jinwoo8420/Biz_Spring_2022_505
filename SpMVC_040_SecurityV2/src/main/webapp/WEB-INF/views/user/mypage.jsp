<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<div class="w3-container w3-card-4">
	<h1>MY PAGE</h1>

	<ul class="w3-text-blue">
		<li><strong>USERNAME : <sec:authentication property="principal.username" /></strong></li>

		<li><strong>EMAIL : <sec:authentication property="principal.email" /></strong></li>

		<li><strong>NAME : <sec:authentication property="principal.realname" /></strong></li>

		<li><strong>NICKNAME : <sec:authentication property="principal.nickname" /></strong></li>

		<li><strong>TEL : <sec:authentication property="principal.tel" /></strong></li>
	</ul>

	<a href="${rootPath}/user/update?username=<sec:authentication
					property="principal.username" />">수정</a>

</div>