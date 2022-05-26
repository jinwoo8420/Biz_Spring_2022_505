document.addEventListener("DOMContentLoaded", () => {
  const id_check = document.querySelector("button.id_check");
  const join_btn = document.querySelector("button.join");

  const index = {
    username: 0,
    password: 1,
    re_password: 2,
    name: 3,
    email: 4,
  };

  // form.join 내부에 있는 모든 input box
  // querySelectorAll을 사용하면 tag 요소들을 배열로 가져온다
  const inputList = document.querySelectorAll("form.join input");

  /* 
  inputList에는 0번 요소부터 4번 요소까지 form tag에 작성된 순서대로 담겨있다
  index 객체에서 각 요소의 첨자를 가져오고 첨자를 사용하여 input tag를 각 순서대로 변수에 담겠다
  */
  const username = inputList[index.username];
  const password = inputList[index.password];
  const re_password = inputList[index.re_password];
  const name = inputList[index.name];
  const email = inputList[index.email];

  const username_msg = document.querySelector("div.username");

  if (id_check) {
    id_check.addEventListener("click", () => {
      if (username.value === "") {
        username_msg.innerText = " * USER NAME 입력";

        /*
        JS코드를 사용하여 여러가지 style을 변경하고자 할 때
        미리 본문의 style 항목에 사용하지 않는 class 하나 만들어 두고
        속성을 미리 작성해놓는다
        그리고 해당 항목에 classList.add("class 이름")와 같이
        사용하면 여러가지 
        */

        username_msg.classList.remove("ok");
        // div.username 항목에 warn 이라는 class를 붙히기
        username_msg.classList.add("warn");
        username.focus();
        return false;
      } // end if

      fetch(`${rootPath}/user/idcheck/${username.value}`)
        .then((res) => res.text())
        .then((result) => {
          if (result === "OK") {
            username_msg.classList.remove("warn");
            username_msg.classList.add("ok");
            username_msg.innerText = "사용가능";
          } else {
            username_msg.classList.remove("ok");
            username_msg.classList.add("warn");
            username_msg.innerText = " * 이미 가입 된 USER NAME";
          }
        });
    });
  }
});
