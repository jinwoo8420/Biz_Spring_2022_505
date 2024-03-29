document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-shopping_result");
  const modal_content = modal_box.querySelector("div.shopping_search-content");

  const inputs = document.querySelectorAll("input");

  const input_index = {
    // productId: 0,
    title: 0,
    mallName: 1,
    maker: 2,
    brand: 3,
    lprice: 4,
    hprice: 5,
    link: 6,
    image: 7,
  };

  const extractTextPattern = /(<([^>]+)>)/gi;

  const shopping_title = document.querySelector("input#s_title");

  const btn_save = document.querySelector("button.shopping-save");

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
      const codes = tr.dataset.title.replace(extractTextPattern, "");
      console.log(codes);

      fetch(`${rootPath}/naver/${codes}/shopping`)
        .then((res) => res.json())
        .then((result) => {
          // inputs[input_index.productId].value = result.productId;
          inputs[input_index.title].value = result.title.replace(
            extractTextPattern,
            ""
          );
          inputs[input_index.mallName].value = result.mallName;
          inputs[input_index.maker].value = result.maker;
          inputs[input_index.brand].value = result.brand;

          if (result.lprice === "") {
            inputs[input_index.lprice].value = 0;
          } else if (!(result.lprice === "")) {
            inputs[input_index.lprice].value = result.lprice;
          }

          if (result.hprice === "") {
            inputs[input_index.hprice].value = 0;
          } else if (!(result.hprice === "")) {
            inputs[input_index.hprice].value = result.hprice;
          }

          inputs[input_index.link].value = result.link;
          inputs[input_index.image].value = result.image;
          modal_box.style.display = "none";
        });
    }
  });

  btn_save?.addEventListener("click", (btn) => {
    const title = inputs[input_index.title];

    if (title?.value === "") {
      alert("상품명 입력");
      title.focus();
      return false;
    }

    const form = btn.currentTarget.closest("FORM");
    form.submit();
  });
}); // end ContentLoaded
