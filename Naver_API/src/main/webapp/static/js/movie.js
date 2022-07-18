document.addEventListener("DOMContentLoaded", () => {
  const movie_table = document.querySelector("table.movies");

  movie_table?.addEventListener("click", (e) => {
    const target = e.target;
    const tr = target?.closest("TR");
    const title = tr?.dataset.title;

    document.location.href = `${rootPath}/movies/${title}/movies_detail`;
  });
});
