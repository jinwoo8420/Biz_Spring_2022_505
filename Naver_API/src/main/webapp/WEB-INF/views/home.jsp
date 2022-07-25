<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>API APP</title>

<style>
</style>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${rootPath}/static/css/home.css?ver=2022-07-25-001">
<link rel="stylesheet" href="${rootPath}/static/css/main.css?ver=2022-06-08-001">
<link rel="stylesheet" href="${rootPath}/static/css/table.css?ver=2022-07-14-001">

<script>
	const rootPath = "${rootPath}"
</script>

<script src="${rootPath}/static/js/input.js?ver=2022-07-15-002"></script>
<script src="${rootPath}/static/js/shopping_input.js?ver=2022-07-20-003"></script>
<script src="${rootPath}/static/js/movie_input.js?ver=2022-07-19-001"></script>
<script src="${rootPath}/static/js/encyc_input.js?ver=2022-07-25-003"></script>

</head>

<body>
	<header>
		<h1>API APP</h1>
		<p>Naver API를 활용한 도서, 쇼핑, 영화 정보, 백과사전 서비스</p>
	</header>

	<nav>
		<ul>
			<li><a href="${rootPath}/">Home</a></li>
			<li><a href="${rootPath}/books/list">도서정보</a></li>
			<li><a href="${rootPath}/shopping/shopping_list">쇼핑</a></li>
			<li><a href="${rootPath}/movies/movies_list">영화정보</a></li>
			<li><a href="${rootPath}/encyc/encyc_list">백과사전</a></li>
			<li><a href="${rootPath}/naver">네이버 체험</a></li>

			<c:if test="${empty USER}">
				<li><a href="${rootPath}/user/login">로그인</a></li>
				<li><a href="${rootPath}/user/join">회원가입</a></li>
			</c:if>

			<c:if test="${not empty USER}">
				<li><a href="${rootPath}/user/mypage">My Page(${USER.nickname})</a></li>
				<li><a href="${rootPath}/user/logout">로그아웃</a></li>
			</c:if>
		</ul>
	</nav>

	<section class="main">
		<c:choose>
			<c:when test="${LAYOUT=='BOOK-INPUT'}">
				<%@ include file="/WEB-INF/views/books/insert.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='BOOK-LIST'}">
				<%@ include file="/WEB-INF/views/books/list.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='BOOK-DETAIL'}">
				<%@ include file="/WEB-INF/views/books/detail.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='SHOPPING-INPUT'}">
				<%@ include file="/WEB-INF/views/shopping/shopping_insert.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='SHOPPING-LIST'}">
				<%@ include file="/WEB-INF/views/shopping/shopping_list.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='SHOPPING-DETAIL'}">
				<%@ include file="/WEB-INF/views/shopping/shopping_detail.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='MOVIE-INPUT'}">
				<%@ include file="/WEB-INF/views/movies/movies_insert.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='MOVIE-LIST'}">
				<%@ include file="/WEB-INF/views/movies/movies_list.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='MOVIE-DETAIL'}">
				<%@ include file="/WEB-INF/views/movies/movies_detail.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='ENCYC-INPUT'}">
				<%@ include file="/WEB-INF/views/encyc/encyc_insert.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='ENCYC-LIST'}">
				<%@ include file="/WEB-INF/views/encyc/encyc_list.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='ENCYC-DETAIL'}">
				<%@ include file="/WEB-INF/views/encyc/encyc_detail.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='JOIN'}">
				<%@ include file="/WEB-INF/views/user/join.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='LOGIN'}">
				<%@ include file="/WEB-INF/views/user/login.jsp"%>
			</c:when>

			<c:when test="${LAYOUT=='MYPAGE'}">
				<%@ include file="/WEB-INF/views/user/mypage.jsp"%>
			</c:when>

			<c:otherwise>
				<%@ include file="/WEB-INF/views/main_view.jsp"%>
			</c:otherwise>
		</c:choose>
	</section>

	<footer class="main">
		<address>CopyRight &copy; 1223wlsdn@naver.com</address>
	</footer>

	<div class="w3-modal modal-result">
		<div class="w3-modal-content w3-card-4">

			<header class="w3-container w3-teal">
				<span class="w3-button w3-display-topright modal-close">&times;</span>
				<h2>도서 검색 정보</h2>
			</header>

			<div class="w3-container search-content">
				<p>검색 결과 보여지는 곳</p>
			</div>

			<footer class="w3-container w3-teal">
				<address>CopyRight &copy; 1223wlsdn@naver.com</address>
			</footer>

		</div>

		<script>
		document.querySelector("span.modal-close")?.addEventListener("click",()=>{
			document.querySelector("div.w3-modal.modal-result").style.display="none"
		})
		</script>

	</div>

	<div class="w3-modal modal-shopping_result">
		<div class="w3-modal-content w3-card-4">

			<header class="w3-container w3-teal">
				<span class="w3-button w3-display-topright modal-shopping_close">&times;</span>
				<h2>쇼핑 검색 정보</h2>
			</header>

			<div class="w3-container shopping_search-content">
				<p>검색 결과 보여지는 곳</p>
			</div>

			<footer class="w3-container w3-teal">
				<address>CopyRight &copy; 1223wlsdn@naver.com</address>
			</footer>

		</div>

		<script>
		document.querySelector("span.modal-shopping_close")?.addEventListener("click",()=>{
			document.querySelector("div.w3-modal.modal-shopping_result").style.display="none"
		})
		</script>

	</div>

	<div class="w3-modal modal-movie_result">
		<div class="w3-modal-content w3-card-4">

			<header class="w3-container w3-teal">
				<span class="w3-button w3-display-topright modal-movie_close">&times;</span>
				<h2>영화 검색 정보</h2>
			</header>

			<div class="w3-container search-movie_content">
				<p>검색 결과 보여지는 곳</p>
			</div>

			<footer class="w3-container w3-teal">
				<address>CopyRight &copy; 1223wlsdn@naver.com</address>
			</footer>

		</div>

		<script>
		document.querySelector("span.modal-movie_close")?.addEventListener("click",()=>{
			document.querySelector("div.w3-modal.modal-movie_result").style.display="none"
		})
		</script>

	</div>

	<div class="w3-modal modal-encyc_result">
		<div class="w3-modal-content w3-card-4">

			<header class="w3-container w3-teal">
				<span class="w3-button w3-display-topright modal-encyc_close">&times;</span>
				<h2>백과사전 정보</h2>
			</header>

			<div class="w3-container search-encyc_content">
				<p>검색 결과 보여지는 곳</p>
			</div>

			<footer class="w3-container w3-teal">
				<address>CopyRight &copy; 1223wlsdn@naver.com</address>
			</footer>

		</div>

		<script>
		document.querySelector("span.modal-encyc_close")?.addEventListener("click",()=>{
			document.querySelector("div.w3-modal.modal-encyc_result").style.display="none"
		})
		</script>

	</div>

</body>
</html>