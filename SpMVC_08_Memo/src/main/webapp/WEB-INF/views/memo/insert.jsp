<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form:form modelAttribute="memoVO" enctype="multipart/form-data">
	<div>
		<form:input path="m_author" />
		<form:input path="m_date" />
		<form:input path="m_time" />
	</div>
	<div>
		<input name="img" type="file" />
		<!-- <input type="file" name="m_image" multiple="multiple" accept="images/*"/> -->
	</div>
	<form:textarea rows="10" path="m_memo" />
	<button>저장</button>
</form:form>