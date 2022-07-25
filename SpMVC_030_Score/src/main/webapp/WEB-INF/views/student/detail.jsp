<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<div class="student detail_body">
	<div>학번 :</div>
	<div class="student detail">${DETAIL.st_num}</div>
</div>

<div class="student detail_body">
	<div>이름 :</div>
	<div class="student detail">${DETAIL.st_name}</div>
</div>

<div class="student detail_body">
	<div>학과 :</div>
	<div class="student detail">${DETAIL.st_dept}</div>
</div>

<div class="student detail_body">
	<div>학년 :</div>
	<div class="student detail">${DETAIL.st_grade}</div>
</div>

<div class="student detail_body">
	<div>전화번호 :</div>
	<div class="student detail">${DETAIL.st_tel}</div>
</div>

<div class="student detail_body">
	<div>주소 :</div>
	<div class="student detail">${DETAIL.st_addr}</div>
</div>

<div>
	<c:forEach items="${DETAIL.scoreList}" var="SCORE">
		<div>${SCORE.sb_name}(${SCORE.sc_sbcode}) : ${SCORE.sc_score}</div>
	</c:forEach>
</div>

<a href="${rootPath}/student">리스트</a>
<a href="${rootPath}/student/update?st_num=${DETAIL.st_num}">수정</a>

<%-- <c:forEach items="${SCORE}" var="SCORES">
	<div class="student detail_body">
		<div>${SCORES.sb_name}:</div>
		<div class="student detail">${SCORES.sc_score}</div>
	</div>
</c:forEach> --%>