document.addEventListener("DOMContentLoaded", () => {
  /*
    nav의 li tag를 클릭했을 때 할 일을 지정하는 것
    화면에 li tag가 여러개가 있다
    여러개의 li tag에 click 이벤트를 설정하려면
    document.querySelectorAll() 함수를 사용하여 전체 tag list를 배열로 받고
    for() 반복문을 사용하여 각각의 요소에 event를 부여하는 코드가 필요하다

    지금은 li tag를 감싸고 있는 nav tag 한개만 click 이벤트를 적용하여
    이벤트 버블링을 역으로 활용하여 사용한다
    nav.main_nav에 click 이벤트를 설정했지만
    e 매개변수의 target 속성을 사용하면 가장 안쪽의 li tag에 접근이 가능하다
    li tag가 click 되면 tagName을 조회해보고 실제로 li tag가 click 되면
    li tag의 text를 가져와서 location을 변경하는 용도로 활용한다

    e.target.tagName을 참조 할 때는 tag 이름을 대문자로 확인해야 한다
    */
  const main_nav = document.querySelector("nav.main_nav");

  if (main_nav) {
    main_nav.addEventListener("click", (e) => {
      const li = e.target; // 가장 안쪽에서 실제 click 된 tag, li tag

      if (li.tagName === "LI") {
        const text = li.innerText;

        let url = `${rootPath}`;

        if (text === "로그인") {
          url += "/user/login";
        } else if (text === "회원가입") {
          url += "/user/join";
        } else if (text === "로그아웃") {
          url += "/user/logout";
        }

        document.location.href = url;
      }
    });
  }
});
