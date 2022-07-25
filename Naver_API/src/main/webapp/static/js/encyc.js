document.addEventListener("DOMContentLoaded", () => {
  const encyc_table = document.querySelector("table.encycs");

  encyc_table?.addEventListener("click", (e) => {
    const target = e.target;
    const tr = target?.closest("TR");
    const seq = tr?.dataset.seq;

    document.location.href = `${rootPath}/encyc/${seq}/encyc_detail`;
  });
});
