document.addEventListener("DOMContentLoaded", () => {
  const id_check = document.querySelector("button.id_check");
  const join_btn = document.querySelector("button.join");
  const join_form = document.querySelector("form.join");

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

  const username_isBlank = () => {
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
    username_msg.innerText = " * USER NAME 입력";
    username.focus();
    return false;
  };

  // join button 클릭
  if (join_btn) {
    join_btn.addEventListener("click", () => {
      if (username.value === "") {
        username_isBlank();
        return false;
      }

      if (password.value === "") {
        alert("비밀번호 입력");
        password.focus();
        return false;
      }

      if (re_password.value === "") {
        alert("비밀번호 확인 입력");
        re_password.focus();
        return false;
      }

      if (password.value !== re_password.value) {
        alert("비밀번호와 비밀번호 확인 다름");
        password.value = "";
        re_password.value = "";
        password.focus();
        return false;
      }

      /* 
      유효성 검사 종료
      form에 담긴 데이터를 서버로 전송한다
      */

      join_form.submit();
    });
  }

  if (id_check) {
    id_check.addEventListener("click", () => {
      if (username.value === "") {
        username_isBlank();
        return false;
      } // end if

      /*
      queryString 방식으로 요청
      localhost:8080/school/user/idcheck?username=callor
      URL(주소창)에 서버보내는 변수이름(username)이 노출되는 문제가 있다
      보내는 데이터의 길이 제한이 있다

      URL, PathVarriable 방식으로 데이터(검사하고자 하는 username) 를 전송하기
      REST Ful 방식이라고 한다
      localhost:8080/school/user/idcheck/callor 로 요청하기
      */
      fetch(
        `${rootPath}/user/idcheck/${username.value}?username=${username.value}`
      )
        .then((res) => {
          console.table(index);
          console.table(res);
          return res.text();
        })
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
