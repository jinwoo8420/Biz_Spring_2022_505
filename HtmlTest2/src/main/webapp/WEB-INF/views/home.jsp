<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <script type="text/javascript" src="logo_event.js"></script>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Season + ing</title>
    <link rel="stylesheet" href="${rootPath}/static/css/main.css" />
    <link rel="stylesheet" href="${rootPath}/static/css/ball.css" />
    <link rel="stylesheet" href="${rootPath}/static/css/logo.css" />

    <style></style>
  </head>
  <body>
    <div class="main"></div>

    <div class="main_button">
      <img id="logo_img" src="\images\로고1.png" />
      <!-- <img id="logo_img" src="\images\시즌 잉.png" /> -->

      <button id="football" onclick="location.href = 'soccer-seoul.html'; ">
        <img id="button_img" src="\images\football_text.png" /><br />
        <p class="m_b_text">K-리그</p>
        <p id="button_text">
          정보보러가기 <b id="button_text_arrow"> &#10095;</b>
        </p>
      </button>
      <img id="football_img" src="\images\football.png" />

      <button id="baseball" onclick="location.href = 'baseball-kia.html'; ">
        <img id="button_img" src="\images\baseball_text.png" /><br />
        <p class="m_b_text">KBO-리그</p>
        <p id="button_text">
          정보보러가기 <b id="button_text_arrow"> &#10095;</b>
        </p>
      </button>
      <img id="baseball_img" src="\images\baseball.png" />

      <button id="volleyball" onclick="location.href = '../html/nav.html'; ">
        <img id="button_img" src="\images\volleyball_text.png" /><br />
        <p class="m_b_text">V-리그</p>
        <p id="button_text">
          정보보러가기 <b id="button_text_arrow"> &#10095;</b>
        </p>
      </button>
      <img id="volleyball_img" src="\images\volleyball.png" />
    </div>

    <footer>사용한 오픈소스들 카카오~관광지~어쩌고</footer>
  </body>
</html>
