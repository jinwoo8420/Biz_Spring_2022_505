document.addEventListener("DOMContentLoaded", () => {
  const inputs = document.querySelectorAll("input");

  const input_index = {
    a_name: 1,
    a_tel: 2,
    a_address: 3,
  };

  const btn_save = document.querySelector("button.btn_save");

  btn_save?.addEventListener("click", (btn) => {
    const a_name = inputs[input_index.a_name];
    const a_tel = inputs[input_index.a_tel];
    const a_address = inputs[input_index.a_address];

    if (a_name?.value === "") {
      alert("이름 입력");
      a_name.focus();
      return false;
    }

    if (a_tel?.value === "") {
      alert("전화번호 입력");
      a_tel.focus();
      return false;
    }

    if (a_address?.value === "") {
      alert("주소 입력");
      a_address.focus();
      return false;
    }

    const form = btn.currentTarget.closest("FORM");
    form.submit();
  });
});
