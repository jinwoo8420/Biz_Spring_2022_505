document.addEventListener("DOMContentLoaded", () => {
  const save_btn = document.querySelector("button.btn_save");
  const save_form = document.querySelector("form.save");

  const index = {
    isbn: 0,
    title: 1,
    author: 2,
    publisher: 3,
    pubdate: 4,
    price: 5,
  };

  const inputList = document.querySelectorAll("form.save input");

  const isbn = inputList[index.isbn];
  const title = inputList[index.title];
  const author = inputList[index.author];
  const publisher = inputList[index.publisher];
  const pubdate = inputList[index.pubdate];
  const price = inputList[index.price];

  if (save_btn) {
    save_btn.addEventListener("click", () => {
      if (isbn.value === "") {
        alert("isbn 입력");
        isbn.focus();
        return false;
      }

      if (title.value === "") {
        alert("title 입력");
        title.focus();
        return false;
      }

      if (author.value === "") {
        alert("author 입력");
        author.focus();
        return false;
      }

      if (publisher.value === "") {
        alert("publisher 입력");
        publisher.focus();
        return false;
      }

      if (pubdate.value === "") {
        alert("pubdate 입력");
        pubdate.focus();
        return false;
      }

      if (price.value === "") {
        alert("price 입력");
        price.focus();
        return false;
      }

      save_form.submit();
    });
  }
});
