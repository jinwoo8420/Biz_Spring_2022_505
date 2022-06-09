document.addEventListener("DOMContentLoaded", () => {
  const login_form = document.querySelector("form.login");
  const username = login_form?.querySelector("input[name=username]");
  const password = login_form?.querySelector("input[name=password]");
  const btn_login = login_form?.querySelector("button.btn-login");

  btn_login?.addEventListener("click", () => {
    if (username.value === "") {
      alert("User Name 입력");
      username.focus();
      return false;
    }

    if (password.value === "") {
      alert("PassWord 입력");
      password.focus();
      return false;
    }

    login_form.submit();
  });
});
