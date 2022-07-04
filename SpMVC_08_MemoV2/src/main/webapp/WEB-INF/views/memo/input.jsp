<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #b8d7fd;
}

a {
	color: inherit;
}

form {
	width: 50%;
	text-align: center;
}

input {
	padding: 1rem;
	width: 100%;
}

.list {
	text-decoration: none;
	padding: 15px 16px;
	border-radius: 5px;
	color: white;
	margin-left: 20px;
	width: 110px;
	height: 40.5px;
}

.list:hover {
	background-color: white;
	color: black;
}

.input-file_btn:hover {
	background-color: white;
	color: black;
}

.input-file_btn {
	padding: 10px 20px;
	border-radius: 4px;
	color: white;
	cursor: pointer;
	width: 30px;
	height: 30px;
}

button {
	padding: 10px 20px;
	background-color: #001841;
	border-radius: 4px;
	color: white;
	cursor: pointer;
	right: 0px;
	position: absolute;
}

button:hover {
	background-color: white;
	color: black;
	border: 1px solid black
}
</style>

</head>
<body>
	<form method="POST" enctype="multipart/form-data" style="position: relative;">
		<button>메모기록</button>
		<input name="m_seq" type="hidden" value='<c:out value="${MEMO.m_seq}" default ="0"/>'>
		<input name="m_memo" placeholder="메모 입력 (20자 이내)" value="${MEMO.m_memo}" maxlength='20'
			style="width: 30%; margin-bottom: 20px;">
		<br> <label class="input-file_btn" for="file_btn"> 파일선택 </label>
		<input id="file_btn" type="file" name="file" accept="images/*" style="display: none;" />

		<a href="${rootPath}/" class="list">HOME</a>
	</form>
</body>
</html>