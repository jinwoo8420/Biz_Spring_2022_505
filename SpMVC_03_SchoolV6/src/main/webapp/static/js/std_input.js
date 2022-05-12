const std_num_check_cb = () => {
  const st_num = document.querySelector("input[name='st_num']");
  if (st_num.value === "") {
    alert("중복검사를 하려면 학번 입력");
    st_num.focus();

    return false;
  }

  // alert("입력한 학번 : " + st_num.value);
  fetch(`${rootPath}/student/st_num_check?st_num=${st_num.value}`)
    .then((res) => res.text())
    .then((result) => {
      if (result === "USE") {
        alert("이미 등록된 학번\n 다시 입력");
      } else {
        alert("사용 가능한 학번");
      }
    });
};

document.addEventListener("DOMContentLoaded", () => {
  const std_num_check = document.querySelector("button.std_num_check");

  /*
  std_num_check click event handler를
  std_num_check_cb 함수로 별도 선언하고 handler
  */

  if (std_num_check) {
    std_num_check.addEventListener("click", std_num_check_cb); // end callback

    const std_save = document.querySelector("button.std_save"); // 현재 html 화면에 있는 클래스가 std_save인 버튼을 챙겨서 핸들링 준비 요청

    // std_save가 정상적으로 준비 되었는지 확인
    if (std_save) {
      std_save.addEventListener("click", save_cb);
    }
  }
});
