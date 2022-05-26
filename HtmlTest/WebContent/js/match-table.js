const lbtn = document.querySelector("a.match-rbtn");

lbtn.addEventListener("click", () => {
  document.querySelector("div.table-front").style.opacity = 0;
});

const btn = document.querySelector("a.match-lbtn");

btn.addEventListener("click", () => {
  document.querySelector("div.table-front").style.opacity = 1;
});
