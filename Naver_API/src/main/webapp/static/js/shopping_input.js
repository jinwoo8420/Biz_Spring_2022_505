document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-shopping_result");
  const modal_content = modal_box.querySelector("div.shopping_search-content");

  const inputs = document.querySelectorAll("input");

  const input_index = {
    s_productId: 0,
    s_title: 1,
    s_mallName: 2,
    s_maker: 3,
    s_brand: 4,
    s_lprice: 5,
    s_hprice: 6,
    s_link: 7,
    s_image: 8,
  };

  const extractTextPattern = /(<([^>]+)>)/gi;

  const shopping_id = document.querySelector("input#s_productId");
  const shopping_title = document.querySelector("input#s_title");

  const btn_save = document.querySelector("button.shopping-save");

  shopping_id?.addEventListener("input", (e) => {
    const id = e.target.value;
    alert(id);
  });

  shopping_title?.addEventListener("keypress", (e) => {
    if (e.keyCode === 13) {
      fetch(`${rootPath}/naver/shopping?title=${e.target.value}`)
        .then((res) => res.text())
        .then((result) => {
          modal_box.style.display = "block";
          modal_content.innerHTML = result;
        });
    }
  }); // end shopping_title

  modal_box?.addEventListener("click", (e) => {
    const td = e.target;

    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const codes = tr.dataset.id?.split(" ");

      if (codes.length > 1) {
        fetch(`${rootPath}/naver/${codes[1]}/shopping`)
          .then((res) => res.json())
          .then((result) => {
            inputs[input_index.s_productId].value = result.s_productId
              .replace(extractTextPattern, "")
              .split(" ")[1];
            inputs[input_index.s_title].value = result.s_title;
            inputs[input_index.s_mallName].value = result.s_mallName;
            inputs[input_index.s_maker].value = result.s_maker;
            inputs[input_index.s_brand].value = result.s_brand;
            inputs[input_index.s_lprice].value = result.s_lprice;
            inputs[input_index.s_hprice].value = result.s_hprice;
            inputs[input_index.s_link].value = result.s_link;
            inputs[input_index.s_image].value = result.s_image;
            modal_box.style.display = "none";
          });
      } else {
        alert("ID 코드 찾을 수 없음");
      }

      alert(codes);
    }
  });

  btn_save?.addEventListener("click", (btn) => {
    const title = inputs[input_index.s_title];

    if (title?.value === "") {
      alert("상품명 입력");
      title.focus();
      return false;
    }

    const form = btn.currentTarget.closest("FORM");
    form.submit();
  });
}); // end ContentLoaded
