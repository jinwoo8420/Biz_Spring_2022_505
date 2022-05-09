document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav"); // 어딘가에 있을 nav tag를 객체 변수에 담아오기

  // nav tag를 가져왔을때 (없을 시 작동 X)
  if (nav) {
    nav.addEventListener("click", (e) => {
      /*
      e.target
      현재 nav > ul > li 형태로 layout 구성
      이 layout의 제일 바깥쪽인 nav tag에 click event 설정
      마우스로 nav tag의 어느 곳을 클릭하면 event가 nav > ul > li로 점점 전파 : event Bubbling
      event Bubbling은 상당히 불편한 존재이나 이 현상을 역으로 이용하여 실제 li tag에 click이 되었음을 감지

      nav > li tag를 click하면 li tag에 대한 정보가 e.target에 담김
      결국 js 코드에서 다수의 li tag에 일일이 event를 설정한 것처럼 사용 가능
       */

      const target = e.target;
      const navText = target.innerText;

      let url = `${rootPath}`;

      if (navText === "학생정보") {
        url += "/student";
      } else if (navText === "성적정보") {
        alert("성적정보 입력");
      } else if (navText === "로그인") {
        alert("로그인 창");
      } else if (navText === "회원가입") {
        alert("회원가입 불가");
      }

      document.location.href = url;
    });
  }
});
