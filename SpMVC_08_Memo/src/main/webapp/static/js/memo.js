document.addEventListener("DOMContentLoaded", () => {
  const memo_table = document.querySelector("table.memo");

  memo_table?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const m_seq = tr.dataset.m_seq;
      document.location.href = `${rootPath}/memo/${m_seq}/detail`;
    }
  });
});
