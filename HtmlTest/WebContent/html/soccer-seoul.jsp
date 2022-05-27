<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Season + ing ㅣ soccer-seoul</title>
<link rel="stylesheet" href="css/nav.css" />
<link rel="stylesheet" href="css/k-league-box.css" />
<link rel="stylesheet" href="css/popular-view.css" />
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b801ddbd49c9b14fef4051c9f7807b4f"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<script
	scr="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/js/all.min.js"></script>
<script src="js/popular-view.js"></script>
<script src="js/soccer-seoul.js"></script>

</head>
<body>
	<header>
		<nav id="nav-menu">
			<ul id="login">
				<!--이거 자리만 미리 잡아놓을려고 만든거임 신경 ㄴㄴ-->
				<li><a href="#">회원가입</a></li>
				<li><a href="#">로그인</a></li>
			</ul>
			<div id="drop">
				<ul id="menu">
					<li id="logo"><a href="../html/main.html"><img
							src="../images/logo.png"></a></a></li>
					<li id="soccer"><a href="../html/soccer-seoul.html">축구</a>
						<ul class="drop-menu drop-soccer">
							<li><a href="#">김천 상무</a></li>
							<li><a href="../html/soccer-incheon.html">인천 UNT</a></li>
							<li><a href="#">전북 현대</a></li>
							<li><a href="#">수원 삼성</a></li>
							<li><a href="#">성남 FC</a></li>
							<li><a href="../html/soccer-seoul.html">FC 서울</a></li>
							<li><a href="#">제주 UNT</a></li>
							<li><a href="#">대구 FC</a></li>
							<li><a href="#">강원 FC</a></li>
							<li><a href="#">수원 FC</a></li>
							<li><a href="#">울산 현대</a></li>
							<li><a href="#">포항 스틸러스</a></li>
						</ul></li>
					<li id="baseball"><a href="baseball-kia.html">야구</a>
						<ul class="drop-menu drop-baseball">
							<li><a href="#">KT 위즈</a></li>
							<li><a href="#">두산 베어스</a></li>
							<li><a href="#">삼성 라이온즈</a></li>
							<li><a href="#">LG 트윈스</a></li>
							<li><a href="#">키움 히어로즈</a></li>
							<li><a href="#">SSG 랜더스</a></li>
							<li><a href="#">NC 다이노스</a></li>
							<li><a href="#">롯데 자이언츠</a></li>
							<li><a href="../html/baseball-kia.html">KIA 타이거즈</a></li>
							<li><a href="#">한화 이글스</a></li>
						</ul></li>
					<li id="volleyball"><a href="#">배구</a>
						<ul class="drop-volleyball">
							<li>
								<ul id="volleyman">
									<li>남자부</li>
									<li><a href="#">대한항공 점보스</a></li>
									<li><a href="#">KB손해보험 스타즈</a></li>
									<li><a href="#">한국전력 빅스톰</a></li>
									<li><a href="#">삼성화재 블루팡스</a></li>
									<li><a href="#">우리카드 우리WON</a></li>
									<li><a href="#">OK금융그룹 읏맨</a></li>
									<li><a href="#">현대캐피탈 스카이워커스</a></li>
								</ul>
							</li>
							<li>
								<ul id="volleywoman">
									<li>여자부</li>
									<li><a href="#">GS 칼텍스 KIXX</a></li>
									<li><a href="#">IBK 기업은행 알토스</a></li>
									<li><a href="#">KGC인삼공사 프로배구단</a></li>
									<li><a href="#">페퍼저축은행 AI 페퍼스</a></li>
									<li><a href="#">흥국생명 핑크스파이더스</a></li>
									<li><a href="#">한국도로공사 하이패스</a></li>
									<li><a href="#">현대건설 힐스테이트</a></li>
								</ul>
							</li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</header>
	<section>
		<article>
			<h1>케이리그</h1>
			<div id="k-league-box">
				<div id="korea-map">
					<img src="../img/korea-map.png" />
				</div>
				<div id="ticket-book">
					<p>
						FC서울 홈구장: <span>서울 월드컵 경기장</span>
					</p>
					<img src="../img/seoul.jpg" />
					<div id="match-text">
						<a href="#"><i class="fa-solid fa-chevron-left"></i></a>
						<p>5월 경기 일정</p>
						<a href="#"><i class="fa-solid fa-chevron-right"></i></a>
					</div>
					<table>
						<tr>
							<td>경기</td>
							<td>날짜</td>
							<td>시간</td>
							<td>매치업</td>
						</tr>
						<tr>
							<td>R11 K리그1</td>
							<td>05.08(일)</td>
							<td>16:30</td>
							<td>FC서울 &nbsp; VS &nbsp; 수원FC</td>
						</tr>
						<tr>
							<td>R12 K리그1</td>
							<td>05.15(일)</td>
							<td>19:30</td>
							<td>FC서울 &nbsp; VS &nbsp; 포항 스틸러스</td>
						</tr>
						<tr>
							<td>R14 K리그1</td>
							<td>05.21(토)</td>
							<td>16:30</td>
							<td>FC서울 &nbsp; VS &nbsp; 성남FC</td>
						</tr>
						<tr>
							<td>4라운드 FA컵</td>
							<td>05.25(수)</td>
							<td>19:30</td>
							<td>FC서울 &nbsp; VS &nbsp; 제주UNT</td>
						</tr>
						<tr>
							<td>R15 K리그1</td>
							<td>05.28(토)</td>
							<td>16:30</td>
							<td>FC서울 &nbsp; VS &nbsp; 김천 상무</td>
						</tr>
					</table>
					<a href="https://www.fcseoul.com/tickets/reserveSingleTicket"><div
							id="ticket-link">티켓 예매하러 가기</div></a>
				</div>
			</div>
			<a href="#"><div class="map-point seoul"
					style="font-size: 18px; background-color: rgb(0, 24, 65);">FC
					서울</div></a> <a href="#"><div class="map-point gangwon1">강원 FC</div></a> <a
				href="#"><div class="map-point gangwon2">강원 FC</div></a> <a href="#"><div
					class="map-point gimcheon">김천 상무</div></a> <a href="#"><div
					class="map-point deagu">대구 FC</div></a> <a href="#"><div
					class="map-point seongnam">성남 FC</div></a> <a href="#"><div
					class="map-point suwon1">수원 삼성</div></a> <a href="#"><div
					class="map-point suwon2">수원 FC</div></a> <a href="#"><div
					class="map-point ulsan">울산 현대</div></a> <a
				href="html/soccer-incheon.jsp"><div class="map-point incheon">인천
					UNT</div></a> <a href="#"><div class="map-point jeonbuk">전북 현대</div></a> <a
				href="#"><div class="map-point jeju">제주 UNT</div></a> <a href="#"><div
					class="map-point pohang">포항 스틸러스</div></a>
		</article>
		<article>
			<h1 id="around-tour-text">주변 관광지</h1>
			<div id="around-tour-box">
				<div id="map" style="width: 780px; height: 700px"></div>
				<script>
					var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
					var options = {
						//지도를 생성할 때 필요한 기본 옵션
						center : new kakao.maps.LatLng(37.5682320566392,
								126.89728895889323), //지도의 중심좌표.
						level : 5, //지도의 레벨(확대, 축소 정도)
					};

					var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
					kakao.maps.event.addListener(map, "dragend", function() {
						// 지도 중심좌표를 얻어옵니다
						var latlng = map.getCenter();
					});
					// 마커가 표시될 위치입니다
					var markerPosition = new kakao.maps.LatLng(
							37.5682320566392, 126.89728895889323);

					// 마커를 생성합니다
					var marker = new kakao.maps.Marker({
						position : markerPosition,
					});

					// 마커가 지도 위에 표시되도록 설정합니다
					marker.setMap(map);

					// 마커를 표시할 위치와 title 객체 배열입니다
					var positions = [
							{
								title : "임시",
								latlng : new kakao.maps.LatLng(
										37.5685697835858, 126.90242746486415),
							},
							{
								title : "임시",
								latlng : new kakao.maps.LatLng(
										37.566363091949704, 126.90333586185338),
							},
							{
								title : "임시",
								latlng : new kakao.maps.LatLng(
										37.57434922130049, 126.89661266669978),
							},
							{
								title : "임시",
								latlng : new kakao.maps.LatLng(
										37.5617679245245, 126.90322861617548),
							},
							{
								title : "임시",
								latlng : new kakao.maps.LatLng(
										37.56337720514317, 126.91019875000214),
							},
							{
								title : "임시",
								latlng : new kakao.maps.LatLng(
										37.56013222991391, 126.90839175819526),
							},
							{
								title : "임시",
								latlng : new kakao.maps.LatLng(
										37.55974568332285, 126.89845504341308),
							},
							{
								title : "임시",
								latlng : new kakao.maps.LatLng(
										37.579308336813504, 126.89066231573184),
							}, ];

					// 마커 이미지의 이미지 주소입니다
					var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

					for (var i = 0; i < positions.length; i++) {
						// 마커 이미지의 이미지 크기 입니다
						var imageSize = new kakao.maps.Size(24, 35);

						// 마커 이미지를 생성합니다
						var markerImage = new kakao.maps.MarkerImage(imageSrc,
								imageSize);

						// 마커를 생성합니다
						var marker = new kakao.maps.Marker({
							map : map, // 마커를 표시할 지도
							position : positions[i].latlng, // 마커를 표시할 위치
							title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
							image : markerImage, // 마커 이미지
						});
					}
					// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
					var mapTypeControl = new kakao.maps.MapTypeControl();
					map.addControl(mapTypeControl,
							kakao.maps.ControlPosition.TORIGHT);

					// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
					var zoomControl = new kakao.maps.ZoomControl();
					// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
					// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
					map.addControl(zoomControl,
							kakao.maps.ControlPosition.BOTTOMRIGHT);

					// 마커를 표시할 위치입니다
					var position = new kakao.maps.LatLng(37.5685697835858,
							126.90242746486415);

					// 마커를 생성합니다
					var marker = new kakao.maps.Marker({
						position : position,
					});

					// 마커를 지도에 표시합니다.
					marker.setMap(map);

					// 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
					var iwContent = '<div style="padding:5px;">Hello World!</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

					// 인포윈도우를 생성합니다
					var infowindow = new kakao.maps.InfoWindow({
						content : iwContent,
					});

					// 마커에 마우스오버 이벤트를 등록합니다
					kakao.maps.event.addListener(marker, "mouseover",
							function() {
								// 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
								infowindow.open(map, marker);
							});

					// 마커에 마우스아웃 이벤트를 등록합니다
					kakao.maps.event.addListener(marker, "mouseout",
							function() {
								// 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
								infowindow.close();
							});
				</script>
				<div id="tour-list">
					<div id="choice-tour-menu">
						<a href="#"><div id="choice-all">전체</div></a> <a href="#"><div>식당</div></a>
						<a href="#"><div>숙박</div></a>
					</div>
					<p>
						총 <span>100</span>개의 결과가 있습니다
					</p>
					<div id="list-detail">
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (1).jpg" />
							</div>
							<div>
								<p>[숙박]럭셔리한 호텔</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 숙소 너무 멋졍
								</p>
								<a href="../html/tour-detail.html"><div class="detail-watch">
										</href>
										자세히 보러가기
									</div></a>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (3).jpg" />
							</div>
							<div>
								<p>[식당]아주 맛난집</p>
								<p>
									아주 맛나게 가고싶은 <br /> 식당 너무 멋졍
								</p>
								<a href="../html/tour-detail.html"><div class="detail-watch">자세히
										보러가기</div></a>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (2).jpg" />
							</div>
							<div>
								<p>[숙박]럭셔리한 호텔</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 숙소 너무 멋졍
								</p>
								<a href="../html/tour-detail.html"><div class="detail-watch">자세히
										보러가기</div></a>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (4).jpg" />
							</div>
							<div>
								<p>[식당]아주나이스</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 식당 너무 멋졍
								</p>
								<a href="../html/tour-detail.html"><div class="detail-watch">자세히
										보러가기</div></a>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (1).jpg" />
							</div>
							<div>
								<p>[숙박]럭셔리한 호텔</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 숙소 너무 멋졍
								</p>
								<a href="../html/tour-detail.html"><div class="detail-watch">자세히
										보러가기</div></a>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (3).jpg" />
							</div>
							<div>
								<p>[식당]아주 맛난집</p>
								<p>
									아주 맛나게 가고싶은 <br /> 식당 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (2).jpg" />
							</div>
							<div>
								<p>[숙박]럭셔리한 호텔</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 숙소 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (4).jpg" />
							</div>
							<div>
								<p>[식당]아주나이스</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 식당 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (1).jpg" />
							</div>
							<div>
								<p>[숙박]럭셔리한 호텔</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 숙소 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (3).jpg" />
							</div>
							<div>
								<p>[식당]아주 맛난집</p>
								<p>
									아주 맛나게 가고싶은 <br /> 식당 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (2).jpg" />
							</div>
							<div>
								<p>[숙박]럭셔리한 호텔</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 숙소 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (4).jpg" />
							</div>
							<div>
								<p>[식당]아주나이스</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 식당 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (1).jpg" />
							</div>
							<div>
								<p>[숙박]럭셔리한 호텔</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 숙소 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (3).jpg" />
							</div>
							<div>
								<p>[식당]아주 맛난집</p>
								<p>
									아주 맛나게 가고싶은 <br /> 식당 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (2).jpg" />
							</div>
							<div>
								<p>[숙박]럭셔리한 호텔</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 숙소 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
						<div class="tour-detail">
							<div class="detail-img">
								<img src="../img/tour (4).jpg" />
							</div>
							<div>
								<p>[식당]아주나이스</p>
								<p>
									아주 으리으리하게 가고싶은 <br /> 식당 너무 멋졍
								</p>
								<div class="detail-watch">자세히 보러가기</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
		<div class="popular_view">
			<h4 class="view_title">인기 관광지</h4>
			<div id="area_container">
				<ul class="menu">
					<li><a class="cl2 menu-link" data-menu="1">서울</a></li>
					<li><a class="cl menu-link" data-menu="2">인천</a></li>
					<li><a>대전</a></li>
					<li><a>대구</a></li>
					<li><a>광주</a></li>
					<li><a>부산</a></li>
					<li><a>울산</a></li>
					<li><a>세종</a></li>
					<li><a>경기</a></li>
					<li><a>강원</a></li>
					<li><a>충북</a></li>
					<li><a>충남</a></li>
					<li><a>경북</a></li>
					<li><a>경남</a></li>
					<li><a>전북</a></li>
					<li><a>전남</a></li>
					<li><a>제주</a></li>
				</ul>
			</div>
		</div>
		<div class="change">
			<div class="seoul_view view2">
				<div class="attraction_view">
					<h4 class="attraction">명소 관광지</h4>
					<div class="out">
						<div class="window">
							<div class="btn prev">
								<button class="">&#10094;</button>
							</div>
							<div class="slides">
								<div class="attr_container">
									<span class="img"> <img
										src="/images/seoul/이랜드크루즈 (한강유람선)1.JPG" /> <!-- <div class="img_p">
                        <p>자세히 보기+</p>
                      </div> -->
									</span> <span>[명소]&nbsp; <b>이랜드크루즈(한강유람선)</b></span> <span
										id="content">한강 유람선은 1986년 10월 26일, 서울특별시의 중심부를 동서로
										가로지르는 유람선을 첫 취항하여 운항을 개시하였다.현재 ㈜이랜드크루즈에서 여의도, 잠실을 중심으로 2개의
										터미널을 운영하고 있다. </span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/seoul/경복궁1.jpg" />
									</span> <span>[명소]&nbsp; <b>경복궁</b></span> <span id="content">경복궁은
										1395년 태조 이성계에 의해서 새로운 조선왕조의 법궁으로 지어졌다. 경복궁은 동궐(창덕궁)이나 서궐(경희궁)에
										비해 위치가 북쪽에 있어 '북궐'이라 불리기도 했다. 경복궁은 5대 궁궐 가운데 으뜸의 규모와 건축미를
										자랑한다. </span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/seoul/청계산1.jpg" />
									</span> <span>[명소]&nbsp; <b>청계산</b></span> <span id="content">"서울대공원과
										서울랜드, 국립현대미술관을 둘러싼 푸른 산자락이 바로 청계산이다. 서울 양재동과 과천시, 성남시,의왕시의 경계를
										이루고 있는 청계산은 관악산 산자락이 과천 시내를 에둘러 남쪽으로 뻗어내린 것이다. 산맥은 여기서 멈추지 않고
										서남쪽으로 뻗어나가 의왕시의 백운산, 모락산, 오봉산으로 이어진다. </span>
								</div>
								<div class="attr_container">
									<span class="img"> <img
										src="/images/seoul/신사동 가로수길1.jpg" />
									</span> <span>[명소]&nbsp; <b>신사동 가로수길</b></span> <span id="content">3호선
										신사역에서 압구정 현대고등학교 앞으로 통하는 은행나무길.‘예술가의 거리’ 라 불리는 신사동 가로수길 주위로는
										아기자기한 커피숍과 맛집, 디자이너들의 옷 매장들이 즐비해 있어 이국적인 분위기를 연출한다. 이러한 신사동
										가로수길만의 독특한 분위기 덕분에 평일에도 카메라를 들고 여기저기서 사진을 촬영하는 사람들의 모습을 종종 볼 수
										있다. 특히 가을에는 낙엽지는 거리를 보러 많은 사람들이 찾아오며, 젊은이들의 입소문을 타고 유명세를 탄 이후
										많은 영화의 배경지로 나오기도 했다. </span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/seoul/남산골한옥마을1.jpg" />
									</span> <span>[명소]&nbsp; <b>남산골한옥마을</b></span> <span id="content">"1998년
										조성된 남산골한옥마을은 남산 북측 옛 수도방위사령부 부지 총 79,934m²(24,180평)에 한옥 5동,
										전통공예관, 천우각, 전통정원, 서울남산국악당, 새천년타임캡슐 광장으로 구성되어 시민과 관광객을 맞이하고 있다.
										번화한 도심 한 가운데에서 한국 전통문화를 소재로 한 다양한 체험거리를 만나볼 수 있으며, 남산 자락을 따라
										전통조경 양식으로 조성된 계곡과 정자, 각종 화초가 만들어내는 아름다운 풍경을 만날 수 있다. 전통정원 가장
										높은 곳에는 서울정도 600년을 기념하고 400년 후 서울정도 천년을 기대하며 1994년 당대의 기억을 매설한
										서울천년타입캡슐 광장이 조성되어 있다. 옛 가옥을 복원해 놓은 남산골한옥마을 남산골한옥마을 안으로 들어서면 연못
										청학지와 그 곁으로 천우각이 있다. </span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/seoul/홍릉수목원1.jpg" />
									</span> <span>[명소]&nbsp; <b>홍릉수목원</b></span> <span id="content">홍릉수목원은
										1922년 서울 홍릉에 임업 시험장이 설립되면서 조성된 우리나라 최초의 제1세대 수목원이다. 이곳은 조선왕조
										고종의 왕비인 명성황후의 능(1897년)인 「홍릉」이 있었던 곳으로 「홍릉수목원」이라 이름 붙여졌으며 지금은
										이장되어 터만 표시되어 있다. </span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/seoul/광화문1.jpg" />
									</span> <span>[명소]&nbsp; <b>광화문</b></span> <span id="content">광화문은
										경복궁의 남문이며, 궁성의 정문이다. 광화문은 국왕이 드나드는 정문이기도 했지만, 조선의 법궁인 경복궁의
										정문이었기 때문에 다른 궁궐의 정문에 비해 그 규모와 격식 면에서도 매우 웅장하고 화려했다. 또한 광화문은 담장
										끝 동쪽과 서쪽에 각각 동십자각과 서십자각을 두어 조선의 5대 궁궐 가운데 유일하게 궐문형식을 갖추고 있기도
										했다. 광화문은 중층으로 된 문루를 받치는 기단석축에 세 개의 홍예로 이루어져 있는데, 중앙의 홍예로는 왕이,
										좌우의 홍예로는 왕세자와 신하들이 출입하도록 하였다. </span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/seoul/남산서울타워1.jpg" />
									</span> <span>[명소]&nbsp; <b>남산서울타워</b></span> <span id="content">"'남산서울타워'는
										효율적인 방송전파 송수신과 한국의 전통미를 살린 관광 전망시설의 기능을 겸비한 국내 최초의 종합전파탑으로
										방송문화와 관광산업의 미래를 위해 건립되었다. 세계 유명한 종합 탑들이 그 나라 또는 그 도시의 상징적인 존재가
										된 것 처럼 '남산서울타워' 역시 지난 40여 년간 대한민국의 대표적인 관광지이자 서울의 상징물 역할을
										해왔다.'남산서울타워'는 서울 시내 전 지역에서 바라보이는 탑의 높이와 독특한 구조, 형태 등으로 인하여 시민의
										관심과 사랑의 대상이 되었고, 내외국인들이 즐겨 찾는 제1의 관광 명소로서의 위치를 확고히 하고 있다. 최근에는
										한류 바람을 몰고 온 각종 예능, 드라마의 촬영지로 이름이 높아지면서 내외국인 관광객들이 발길이 끊이지 않는
										곳이다. </span>
								</div>
							</div>
						</div>
						<div class="btn next">
							<button class="">&#10095;</button>
						</div>
					</div>
				</div>

				<div class="food_view">
					<h4 class="food">식당 관광지</h4>
					<div class="out">
						<div class="window">
							<div class="btn prev_food">
								<button class="">&#10094;</button>
							</div>
							<div class="slides_food">
								<div class="food_container">
									<span class="img"> <img src="/images/seoul/진미식당.webp" />
									</span> <span>[식당] &nbsp; <b>진미식당</b></span> <span id="content">간장게장
										한 가지만을 자신 있게 선보이는 게장 전문점으로, 이곳에선 최상급의 서해안 꽃게만을 사용한다. 진미식당이 10년
										넘게 꾸준한 사랑을 받을 수 있었던 비법은 바로 재료의 품질과 변함없는 맛에 대한 고집이다. .</span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/seoul/알라 프리마.webp" />
									</span> <span>[식당] &nbsp; <b>알라 프리마</b></span> <span id="content">늘
										과감하고 창의적인 요리로 미식가들의 발길을 유혹하는 알라 프리마. 오픈된 주방이 한눈에 들어오는 넓은 카운터
										테이블과 쾌적한 다이닝 홀, 그리고 프라이빗 다이닝 공간이 모던하게 펼쳐진다. </span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/seoul/도우룸.webp" />
									</span> <span>[식당] &nbsp; <b>도우룸</b></span> <span id="content">100%
										수제 파스타 면을 전문으로 하는 이탤리언 레스토랑. 영어로 ‘반죽’이라는 의미의 ‘도우’에서 이름을 딴 이곳에서
										가장 주목해야 하는 곳은 파스타를 만드는 도우룸이다. </span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/seoul/버드나무집.webp" />
									</span> <span>[식당] &nbsp; <b>버드나무집</b></span> <span id="content">버드나무집은
										1977년부터 명맥을 이어온 한우 구이 전문점이다. 초창기엔 주물럭만을 판매했지만, 지금은 소갈비와 특수 부위도
										제공한다. </span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/seoul/미토우.webp" />
									</span> <span>[식당] &nbsp; <b>미토우</b></span> <span id="content">입구에
										들어서는 순간부터 일본의 전통 요리집 분위기가 물씬 풍기는 ‘미토우’. 레스토랑의 단아한 인테리어가 권영운,
										김보미 셰프의 정갈한 일본 요리와 조화를 이룬다. </span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/seoul/진미 평양냉면.webp" />
									</span> <span>[식당] &nbsp; <b>진미 평양냉면</b></span> <span id="content">“유명
										평양냉면 식당에서 쌓은 20년의 경험과 노력의 결과물이 바로 진미 평양냉면”이라 말하는 임세권 셰프. 고객이
										만족할 만큼 맛있는 냉면을 만드는 것이 그의 첫 번째 목표이고, 언제 찾아도 한결같은 맛을 즐길 수 있게
										일관성을 유지하는 것이 두 번째 목표라고 한다. </span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/seoul/구복만두.webp" />
									</span> <span>[식당] &nbsp; <b>구복만두</b></span> <span id="content">한국인
										남편과 중국인 아내가 운영하는 구복만두는 좋은 재료로 정성껏 빚은 맛있는 만두를 저렴한 가격에 즐길 수 있는,
										가격 만족도가 훌륭한 식당이다.</span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/seoul/고려 삼계탕.webp" />
									</span> <span>[식당] &nbsp; <b>고려 삼계탕</b></span> <span id="content">1960년에
										대한민국 최초로 문을 연 삼계탕 전문점으로 현재 2대째 이어오고 있다. 전통과 현대적인 감각이 조화를 이룬
										인테리어로 깔끔함 인상을 주는 이곳은 일반 삼계탕 외에 오골계를 이용한 삼계탕 역시 대표 메뉴로 꼽힌다. </span>
								</div>
							</div>
						</div>
						<div class="btn next_food">
							<button class="">&#10095;</button>
						</div>
					</div>
				</div>

				<div class="stay_view">
					<h4 class="stay">숙박 관광지</h4>
					<div class="out">
						<div class="window">
							<div class="btn prev_stay">
								<button class="">&#10094;</button>
							</div>
							<div class="slides_stay">
								<a href="tour-detail.html" style="color: inherit">
									<div class="stay_container">
										<span class="img"> <img
											src="/images/seoul/나인트리 프리미어 호텔 인사동.jpg" />
										</span> <span>[숙박] &nbsp; <b>나인트리 프리미어 호텔 인사동</b></span> <span
											id="content">나인트리 프리미어 호텔 인사동은 3호선 안국역 6번출구에서 걸어서 약
											2분, 1호선 종각역 3-1번 출구에서 도보 약 10분 거리에 있습니다. 경복궁, 광화문 등 한국의 대표
											관광지까지 걸어서 약 15분이면 갈 수 있습니다. </span>
									</div>
								</a>
								<div class="stay_container">
									<span class="img"> <img src="/images/seoul/파라스파라 서울.jpg" />
									</span> <span>[숙박] &nbsp; <b>파라스파라 서울</b></span> <span id="content">파라스파라
										서울 오퍼레이티드 바이 조선 호텔 & 리조트는 북한산 국립공원 내 위치한 서울 최초의 단지형 리조트입니다.
										가까운 지하철역은 북한산 우이역이며, 도보로 약 3분 거리에 있습니다. </span>
								</div>
								<div class="stay_container">
									<span class="img"> <img
										src="/images/seoul/글래드 강남 코엑스센터.jpg" />
									</span> <span>[숙박] &nbsp; <b>글래드 강남 코엑스센터</b></span> <span
										id="content">글래드 강남 코엑스센터는 지하철 2호선 삼성역 1번 출구에서 도보 1분
										거리에 위치해 있습니다. 주변 관광지로는 쇼핑하기 좋은 코엑스몰이 도보 약 5분, 롯데월드가 차로 약 10분,
										신사동 가로수길이 차로 약 20분 정도 소요됩니다.호텔에서는 편리하게 업무를 볼 수 있는 비즈니스 라운지와
										피트니스 센터는 물론, 와인스토어와 세탁실까지 이용하실 수 있습니다. </span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/seoul/롯데 호텔 월드.jpg" />
									</span> <span>[숙박] &nbsp; <b>롯데 호텔 월드</b></span> <span id="content">2022년
										5월 새롭게 오픈한 롯데 호텔 월드는 세계 최대 규모의 실내 놀이공원인 롯데월드 어드벤쳐와 롯데월드몰과 바로
										연결되어 있습니다. 석촌호수가 도보로 약 5분 거리에 있으며 지하철 2, 8호선 잠실역까지는 지하 통로를 통해
										도보로 약 3분 거리에 있습니다. </span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/seoul/서울 신라 호텔.jpg" />
									</span> <span>[숙박] &nbsp; <b>서울 신라 호텔</b></span> <span id="content">서울
										신라 호텔은 3호선 동대입구역 5번 출구에서 도보로 5분 거리에 있으며 명동과 동대문 방면으로 무료 셔틀버스를
										운행하고 있습니다. 호텔에서 명동 쇼핑 거리까지는 차로 15분, 강남역까지는 차로 약 20분이 소요됩니다.</span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/seoul/신라스테이 역삼.jpg" />
									</span> <span>[숙박] &nbsp; <b>신라스테이 역삼</b></span> <span id="content">신라스테이
										역삼은 2호선 역삼역과 선릉역에서 도보 10분 거리에 있습니다. 역삼역에서 단 한 정거장이면 강남으로 가실 수
										있고, 선릉역에서 한 정거장이면 코엑스 몰까지 가실 수 있습니다. </span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/seoul/글래드 여의도.jpg" />
									</span> <span>[숙박] &nbsp; <b>글래드 여의도</b></span> <span id="content">글래드
										호텔 여의도는 9호선 국회의사당역 4번 출구에서 도보 1분 거리에 있습니다. 여의도 공원이 도보로 5분 거리에
										있으며, 'IFC 몰'과 '더 현대 서울'까지는 약 15분 정도 소요됩니다. </span>
								</div>
								<div class="stay_container">
									<span class="img"> <img
										src="/images/seoul/페어필드 바이 메리어트 서울.jpg" />
									</span> <span>[숙박] &nbsp; <b>페어필드 바이 메리어트 서울</b></span> <span
										id="content">페어필드 바이 메리어트는 1호선 영등포역 3번 출구에서 도보 약 5분 거리에
										있으며, 여의도 한강공원까지 차로 약 10분, 영등포 타임스퀘어까지 도보 5분, 문래창작촌까지 도보로 약 20분
										거리에 위치해 있습니다.</span>
								</div>
							</div>
						</div>
						<div class="btn next_stay">
							<button class="">&#10095;</button>
						</div>
					</div>
				</div>
			</div>

			<div class="incheon_view view">
				<div class="attraction_view">
					<h4 class="attraction">명소 관광지</h4>
					<div class="out">
						<div class="window">
							<div class="btn prev">
								<button class="">&#10094;</button>
							</div>
							<div class="slides">
								<div class="attr_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[명소] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[명소] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[명소] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[명소] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[명소] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[명소] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[명소] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="attr_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[명소] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
							</div>
						</div>
						<div class="btn next">
							<button class="">&#10095;</button>
						</div>
					</div>
				</div>

				<div class="food_view">
					<h4 class="food">식당 관광지</h4>
					<div class="out">
						<div class="window">
							<div class="btn prev_food">
								<button class="">&#10094;</button>
							</div>
							<div class="slides_food">
								<div class="food_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[식당] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[식당] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[식당] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[식당] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[식당] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[식당] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[식당] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="food_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[식당] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
							</div>
						</div>
						<div class="btn next_food">
							<button class="">&#10095;</button>
						</div>
					</div>
				</div>

				<div class="stay_view">
					<h4 class="stay">숙박 관광지</h4>
					<div class="out">
						<div class="window">
							<div class="btn prev_stay">
								<button class="">&#10094;</button>
							</div>
							<div class="slides_stay">
								<div class="stay_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[숙박] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[숙박] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[숙박] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/img1.jpg" />
									</span> <span>[숙박] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[숙박] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[숙박] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[숙박] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
								<div class="stay_container">
									<span class="img"> <img src="/images/img2.jpg" />
									</span> <span>[숙박] &nbsp; <b>관광지 이름</b></span> <span id="content">관광지
										소개입니다. 소개는 간략하게 하는게 좋죠. 왜냐면 잘 안읽거든요.</span>
								</div>
							</div>
						</div>
						<div class="btn next_stay">
							<button class="">&#10095;</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<footer></footer>
</body>
<script src="../js/test.js"></script>
</html>
