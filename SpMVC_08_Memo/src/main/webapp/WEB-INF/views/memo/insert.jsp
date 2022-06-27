<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<style>
body {
	background-color: skyblue;
}

textarea {
	width: 70%;
	height: 10em;
	border: 2px solid black;
	resize: none;
	margin: 20px;
	justify-content: center;
}

h1 {
	text-align: center;
	margin-top: 50px;
}

input {
	padding: 10px;
	text-align: center;
}

.f {
	padding: 10px;
}

div {
	margin: 20px auto;
	text-align: center;
}

button {
	font-size: 15px;
}
</style>

<form:form modelAttribute="memoVO" enctype="multipart/form-data">
	<div>
		<form:input path="m_author" />
		<form:input path="m_date" />
		<form:input path="m_time" />
	</div>
	<div>
		<input name="img" type="file" />
	</div>
	<form:textarea rows="10" path="m_memo" />
	<button>저장</button>
</form:form>