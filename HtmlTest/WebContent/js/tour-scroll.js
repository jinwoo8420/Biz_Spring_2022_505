const bob = document.querySelector("a.btn-bob");

bob.addEventListener("click", () => {
  document.querySelector("div.first-list").style.opacity = 0;
  document.querySelector("div.list-position").style.opacity = 1;
});

const all = document.querySelector("a.btn-all");

all.addEventListener("click", () => {
  document.querySelector("div.first-list").style.opacity = 1;
  document.querySelector("div.list-position").style.opacity = 0;
});
