<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<link rel="stylesheet"
	href="${rootPath}/static/css/home_book.css?ver=2022-06-3-004">
<link rel="stylesheet"
	href="${rootPath}/static/css/main.css?ver=2022-06-2-002">
<link rel="stylesheet"
	href="${rootPath}/static/css/input_book.css?ver=2022-06-3-001">

<script>
	const rootPath = "${rootPath}"
</script>

<script src="${rootPath}/static/js/save.js?ver2022-06-03-008"></script>
<body>
	<header>
		<h1>API APP</h1>
	</header>

	<nav>
		<ul>
			<li><a href="${rootPath}/">Home</a></li>
			<li><a href="${rootPath}/books/list">도서정보</a></li>
			<li><a href="${rootPath}/news/news_list">오늘의 뉴스</a></li>
			<li><a href="${rootPath}/movies">영화정보</a></li>
			<li><a href="${rootPath}/naver">네이버 체험</a></li>

			<%
			// 로그인 하지 않았을 때
			%>
			<c:if test="${empty MEMBER}">
				<li><a href="${rootPath}/member/login">로그인</a></li>
				<li><a href="${rootPath}/member/join">회원가입</a></li>
			</c:if>

			<%
			// 로그인 했을 때는 MEMBER 객체에 로그인한 사용자 정보가 담겨 있다
			%>
			<c:if test="${not empty MEMBER}">
				<li><a href="${rootPath}/member/mypage">My Page</a></li>
				<li><a href="${rootPath}/member/logout">로그아웃</a></li>
			</c:if>
		</ul>
	</nav>

	<form class="save" method="POST">
		<div>
			<input name="isbn" id="isbn" placeholder="ISBN"> <input
				name="title" id="title" placeholder="도서명">
		</div>

		<div>
			<input name="author" placeholder="저자"> <input
				name="publisher" placeholder="출판사"> <input name="pubdate"
				placeholder="출판일"> <input name="price" placeholder="가격"
				type="number">
		</div>

		<textarea rows="5" cols="140" placeholder="내용 입력"></textarea>

		<div class="btn">
			<button class="btn_save" type="button">저장</button>
			<button id="btn_new" type="button">새로작성</button>
			<button id="btn_list" type="button">리스트보기</button>
		</div>
	</form>

</body>