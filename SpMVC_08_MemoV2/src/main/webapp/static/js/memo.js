document.addEventListener("DOMContentLoaded", () => {
  const memo_table = document.querySelector("table.memo");

  memo_table?.addEventListener("click", (e) => {
    const target = e.target;
    const tr = target?.closest("TR");
    const seq = tr?.dataset.seq;

    if (seq) {
      document.location.href = `${rootPath}/memo/${seq}/detail`;
    }
  });
});
