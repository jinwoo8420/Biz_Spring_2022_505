document.addEventListener("DOMContentLoaded", () => {
  const IMAGE_WIDTH = 600;
  const prevBtn = document.querySelector("button.prev");
  const nextBtn = document.querySelector("button.next");
  const images = document.querySelector("div.images");
  const imgCount = document.querySelectorAll("div.images img").length;

  let position = 0;
  let curPosition = 0;
  if (prevBtn) {
    prevBtn.addEventListener("click", () => {
      if (curPosition > 0) {
        position += IMAGE_WIDTH;
        images.style.transform = `translateX(${position}px)`;
        curPosition--;
      }
    });
  }
  if (nextBtn) {
    nextBtn.addEventListener("click", () => {
      if (curPosition < imgCount - 1) {
        position -= IMAGE_WIDTH;
        images.style.transform = `translateX(${position}px)`;
        curPosition++;
      }
    });
  }
});
