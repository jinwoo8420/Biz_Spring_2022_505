document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-result");
  const modal_content = modal_box.querySelector("div.search-content");

  const inputs = document.querySelectorAll("input");
  const desc = document.querySelector("textarea");

  const input_index = {
    isbn: 0,
    title: 1,
    author: 2,
    publisher: 3,
    pubdate: 4,
    link: 5,
    image: 6,
  };

  const extractTextPattern = /(<([^>]+)>)/gi;

  const book_isbn = document.querySelector("input#isbn");
  const book_title = document.querySelector("input#title");

  const btn_save = document.querySelector("button.book-save");

  book_isbn?.addEventListener("input", (e) => {
    const isbn = e.target.value;
    if (isbn.length >= 13) {
      alert(isbn);
    }
  });

  book_title?.addEventListener("keypress", (e) => {
    if (e.keyCode === 13) {
      fetch(`${rootPath}/naver/books?title=${e.target.value}`)
        .then((res) => res.text())
        .then((result) => {
          modal_box.style.display = "block";
          modal_content.innerHTML = result;
        });
    }
  }); // end book_title

  modal_box?.addEventListener("click", (e) => {
    const td = e.target;

    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const codes = tr.dataset.isbn?.split(" ");

      console.log(codes.length);

      fetch(`${rootPath}/naver/${codes}/book`)
        .then((res) => res.json())
        .then((result) => {
          inputs[input_index.isbn].value = result.isbn.replace(
            extractTextPattern,
            ""
          );
          inputs[input_index.title].value = result.title;
          inputs[input_index.author].value = result.author;
          inputs[input_index.publisher].value = result.publisher;
          inputs[input_index.pubdate].value = result.pubdate;
          inputs[input_index.link].value = result.link;
          inputs[input_index.image].value = result.image;
          desc.value = result.description.replace(extractTextPattern, "");
          modal_box.style.display = "none";
        });

      alert(codes);
    }
  });

  btn_save?.addEventListener("click", (btn) => {
    const isbn = inputs[input_index.isbn];
    const title = inputs[input_index.title];
    const author = inputs[input_index.author];
    const publisher = inputs[input_index.publisher];

    if (isbn?.value === "") {
      alert("ISBN 입력");
      isbn.focus();
      return false;
    }

    if (title?.value === "") {
      alert("도서명 입력");
      title.focus();
      return false;
    }

    if (author?.value === "") {
      alert("저자 입력");
      author.focus();
      return false;
    }

    if (publisher?.value === "") {
      alert("출판사 입력");
      publisher.focus();
      return false;
    }

    const form = btn.currentTarget.closest("FORM");
    form.submit();
  });
}); // end ContentLoaded
