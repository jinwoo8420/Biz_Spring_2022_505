<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>
<link rel="stylesheet"
	href="${rootPath}/static/css/home_book.css?ver=2022-06-3-001">
<link rel="stylesheet"
	href="${rootPath}/static/css/main.css?ver=2022-06-2-002">
<link rel="stylesheet"
	href="${rootPath}/static/css/table_book.css?ver=2022-06-3-005">

</head>
<body>
	<header>
		<h1>도서정보 리스트</h1>
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

	<article class="ch-container">
		<table class="ch-table">

			<thead>
				<tr>
					<th>No.</th>
					<th>ISBN</th>
					<th>도서명</th>
					<th>출판사</th>
					<th>저자</th>
					<th>출판일자</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${BOOKS}" var="BOOK">
					<tr>
						<td>${BOOK.isbn}</td>
						<td>${BOOK.isbn}</td>
						<td>${BOOK.title}</td>
						<td>${BOOK.publisher}</td>
						<td>${BOOK.author}</td>
						<td>${BOOK.pubdate}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</article>


	<button onclick="location.href = '${rootPath}/books/insert'">도서정보
		추가</button>
</body>
</html>