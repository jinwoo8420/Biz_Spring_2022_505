document.addEventListener("DOMContentLoaded", () => {
  const book_table = document.querySelector("table.books");

  book_table?.addEventListener("click", (e) => {
    const target = e.target;
    const tr = target?.closest("TR");
    const isbn = tr?.dataset.isbn;

    document.location.href = `${rootPath}/books/${isbn}/detail`;
  });
});
