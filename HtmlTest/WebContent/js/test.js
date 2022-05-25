const incheon = document.querySelector("a.cl");

incheon.addEventListener("click", () => {
  document.querySelector("div.view").style.zIndex = 100000;
});

const seoul = document.querySelector("a.cl2");

seoul.addEventListener("click", () => {
  document.querySelector("div.view").style.zIndex = 0;
});

// function getShow() {
//   document.getElementById("incheon_view").style.visibility = "visible";
//   document.getElementById("seoul_view").style.visibility = "hidden";
// }

// 인기 관광지 - 지역 버튼 눌렀을 때 효과 주기
var menuLinks = document.querySelectorAll(".menu-link");
function clickMenuHandler() {
  for (var i = 0; i < menuLinks.length; i++) {
    menuLinks[i].classList.remove("menu-active");
  }
  this.classList.add("menu-active");
}
for (var i = 0; i < menuLinks.length; i++) {
  menuLinks[i].addEventListener("click", clickMenuHandler);
}
