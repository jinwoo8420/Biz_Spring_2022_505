document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-shopping_result");
  const modal_content = modal_box.querySelector("div.shopping_search-content");

  const inputs = document.querySelectorAll("input");

  const input_index = {
    productId: 0,
    title: 1,
    mallName: 2,
    maker: 3,
    brand: 4,
    lprice: 5,
    hprice: 6,
    link: 7,
    image: 8,
  };

  const extractTextPattern = /(<([^>]+)>)/gi;

  const shopping_id = document.querySelector("input#s_productId");
  const shopping_title = document.querySelector("input#s_title");

  const btn_save = document.querySelector("button.shopping-save");

  // shopping_id?.addEventListener("input", (e) => {
  //   const id = e.target.value;
  //   alert(id);
  // });

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
      const codes = tr.dataset.id;
      console.log(codes);

      if (codes != 0) {
        fetch(`${rootPath}/naver/${codes}/shopping`, {
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
          },
        })
          .then((res) => {
            res.json();
            console.log(res);
          })
          .then((result) => {
            inputs[input_index.productId].value = result.productId;
            inputs[input_index.title].value = result.title;
            inputs[input_index.mallName].value = result.mallName;
            inputs[input_index.maker].value = result.maker;
            inputs[input_index.brand].value = result.brand;
            inputs[input_index.lprice].value = result.lprice;
            inputs[input_index.hprice].value = result.hprice;
            inputs[input_index.link].value = result.link;
            inputs[input_index.image].value = result.image;
            modal_box.style.display = "none";
          });
      } else {
        alert("ID 코드 찾을 수 없음");
      }

      alert(codes);
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
