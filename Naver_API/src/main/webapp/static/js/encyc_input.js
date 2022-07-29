document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-encyc_result");
  const modal_content = modal_box.querySelector("div.search-encyc_content");

  const inputs = document.querySelectorAll("input");
  const desc = document.querySelector("textarea");

  const input_index = {
    title: 0,
    link: 1,
    thumbnail: 2,
  };

  const extractTextPattern = /(<([^>]+)>)/gi;

  const encyc_title = document.querySelector("input#e_title");

  const btn_save = document.querySelector("button.encyc-save");

  encyc_title?.addEventListener("keypress", (e) => {
    if (e.keyCode === 13) {
      fetch(`${rootPath}/naver/encyc?title=${e.target.value}`)
        .then((res) => res.text())
        .then((result) => {
          modal_box.style.display = "block";
          modal_content.innerHTML = result;
        });
    }
  }); // end encyc_title

  modal_box?.addEventListener("click", (e) => {
    const td = e.target;

    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const codes = tr.dataset.title
        .replace(extractTextPattern, "")
        .replace(/(\s*)/g, "");

      fetch(`${rootPath}/naver/${codes}/encyc`)
        .then((res) => res.json())
        .then((result) => {
          inputs[input_index.title].value = result.title.replace(
            extractTextPattern,
            ""
          );
          inputs[input_index.link].value = result.link;
          inputs[input_index.thumbnail].value = result.thumbnail;
          desc.value = result.description.replace(extractTextPattern, "");
          modal_box.style.display = "none";
        });
      alert(codes);
    }
  });

  btn_save?.addEventListener("click", (btn) => {
    const title = inputs[input_index.title];

    if (title?.value === "") {
      alert("제목 입력");
      title.focus();
      return false;
    }
    const form = btn.currentTarget.closest("FORM");
    form.submit();
  });
}); // end ContentLoaded
