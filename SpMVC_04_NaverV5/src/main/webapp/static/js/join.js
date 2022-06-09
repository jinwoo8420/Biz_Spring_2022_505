document.addEventListener("DOMContentLoaded", () => {
  const username = document.querySelector("#username");
  const password = document.querySelector("#password");
  const re_password = document.querySelector("#re_password");
  const email = document.querySelector("#email");
  const name = document.querySelector("#name");
  const nickname = document.querySelector("#nickname");
  const btn_join = document.querySelector("#btn-join");

  btn_join?.addEventListener("click", () => {
    if (username.value === "") {
      alert("username 입력");
      username.focus();
      return false;
    }

    if (username.value.length > 20) {
      alert("username 20자 이내로 입력");
      username.focus();
      return false;
    }

    if (username.value.toUpperCase() === password.value.toUpperCase()) {
      alert("username과 password 같으면 안됨");
      username.value = "";
      password.value = "";
      username.focus();
      return false;
    }

    // 숫자와 문자를 포함하는 6 ~ 12자리 문자열 검사 패턴
    const passRule = /^[A-Za-z0-9]{6,12}$/;

    // 문자, 숫자, 특수문자가 포함된 8 ~ 15자리 문자열 검사 패턴
    const passRule2 =
      /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

    // password.value의 값이 패턴에 일치하지 않을시
    if (passRule.test(password.value) === false) {
      alert("password 문자, 숫자 포함 6 ~ 12자리");
      password.focus();
      return false;
    }

    if (re_password.value === "") {
      alert("password 확인 입력");
      re_password.focus();
      return false;
    }

    if (password.value !== re_password.value) {
      alert("password와 password 확인 값이 일치하지 않음");
      password.value = "";
      re_password.value = "";
      password.focus();
      return false;
    }

    const emailRule =
      /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

    if (email.value === "") {
      alert("email 입력");
      email.focus();
      return false;
    }

    if (emailRule.test(email.value) === false) {
      alert("email 형식 잘못됨");
      email.focus();
      return false;
    }

    document.querySelector("form.join")?.submit();
  });
});
