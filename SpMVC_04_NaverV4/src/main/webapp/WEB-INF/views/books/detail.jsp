<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>

<style>
div.detail, div.btn_box {
	width: 80%;
	margin: 10px auto;
}

div.btn_box {
	text-align: right;
}

div.btn_box a {
	text-decoration: none;
	color: white;
	display: inline-block;
	padding: 12px 16px;
	border-radius: 5px;
}

div.btn_box a:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.7);
}

a.list {
	background-color: green;
}

a.update {
	background-color: blue;
}

a.delete {
	background-color: red;
}
</style>

</head>
<body>
	<div class="detail">
		<p>ISBN : ${BOOK.isbn}</p>
		<p>도서명 : ${BOOK.title}</p>
		<p>저자 : ${BOOK.author}</p>
		<p>출판사 : ${BOOK.publisher}</p>
		<p>가격 : ${BOOK.price}</p>
		<p>출판일자 : ${BOOK.pubdate}</p>
	</div>

	<div class="btn_box">
		<a href="${rootPath}/books/list" class="list">리스트</a>
		<a href="${rootPath}/books/${BOOK.isbn}/update" class="update">수정</a>
		<%
		//href="javascript:void(0)" : a tag의 link 연결 기능 완전 무력화
		%>
		<a href="javascript:void(0)" class="delete">삭제</a>
	</div>
</body>

<script>
document.querySelector("a.delete")?.addEventListener("click",()=>{
	if(confirm("삭제?")) {
		document.location.replace("${rootPath}/books/${BOOK.isbn}/delete")
	}
})

/*
  location.href = URL / location.replace(URL) 차이점
  
  .href는 브라우저 화면이 전환될때 history를 계속 간직하고 있다
  어떤 page에서 계속 뒤로가기를 클릭하면 연속으로 뒤로 복귀가 된다
  
  .replace()는 현재 화면의 history를 제거해 버리고 새로운 page로 덮어쓰기가 된다
  뒤로가기를 눌렀을 때 현재 보고있는 페이지를 열 수 없다는 것이다
  
  detail에서 삭제를 선택했을 때
  삭제하고 난 후 뒤로가기를 눌러 이미 삭제된 데이터를 보는 것을 방지하기 위함이다
 */

</script>

</html>
