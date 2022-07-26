document.addEventListener("DOMContentLoaded", () => {
  const list_body = document.querySelector("tbody.student.body");

  list_body?.addEventListener("click", (e) => {
    const tr = e.target;
    const ul = tr.closest("TR");
    const st_num = ul.dataset.stnum;

    document.location.href = `${rootPath}/student/detail?st_num=${st_num}`;
  });
});
