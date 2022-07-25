<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST">
	<input name="st_name" value="${UPDATE.st_name}" />
	<input name="st_dept" value="${UPDATE.st_dept}" />
	<input name="st_grade" value="${UPDATE.st_grade}" />
	<input name="st_tel" value="${UPDATE.st_tel}" />
	<input name="st_addr" value="${UPDATE.st_addr}" />
	<button>저장</button>
</form>