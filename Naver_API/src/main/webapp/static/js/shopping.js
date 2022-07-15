document.addEventListener("DOMContentLoaded", () => {
  const shopping_table = document.querySelector("table.shopping");

  shopping_table?.addEventListener("click", (e) => {
    const target = e.target;
    const tr = target?.closest("TR");
    const id = tr?.dataset.id;

    if (id) {
      document.location.href = `${rootPath}/shopping/${productId}/detail`;
    }
  });
});
