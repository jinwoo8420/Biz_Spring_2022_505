document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-result");
  // div.modal-result에 포함된 요소중에서 div.search-content 가져오기
  const modal_content = modal_box.querySelector("div.search-content");
  const modal_content_table = document.querySelector("table.search-result");
  const inputs = document.querySelectorAll("input");
  const desc = document.querySelector("textarea");
  const book_isbn = document.querySelector("input#isbn");
  const book_title = document.querySelector("input#title");

  /*
      input event
      input tag에 키보드로 문자를 입력 할 때마다 발생하는 event
      */

  /*
      if(book_isbn)을 실행하여 book_isbn이 있으면 addEventListener를 부착하고 
      만약 book_isbn 객체가 없으면 오류를 발생시키지 말고 실행 중단
      */
  book_isbn?.addEventListener("input", (e) => {
    const isbn = e.target.value;
    if (isbn.length >= 13) {
      alert(isbn);
    }
  });

  book_title?.addEventListener("keypress", (e) => {
    if (e.keyCode === 13) {
      //   alert(e.target.value);
      fetch(`${rootPath}/naver/books?title=${e.target.value}`)
        .then((res) => res.text())
        .then((result) => {
          modal_box.style.display = "block";
          modal_content.innerHTML = result;
        });
    }
  }); // end book_title

  modal_content_table?.addEventListener("click", (e) => {});
});
