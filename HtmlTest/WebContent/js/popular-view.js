document.addEventListener("DOMContentLoaded", () => {
  const SLIDE_WIDTH = 1200;
  const prevBtn = document.querySelector("div.prev");
  const nextBtn = document.querySelector("div.next");
  const slides = document.querySelector("div.slides");
  const sldCount = document.querySelectorAll("div.slides div").length;

  let position = 0;
  let curPosition = 0;

  if (prevBtn) {
    prevBtn.addEventListener("click", () => {
      if (curPosition > 0) {
        position += SLIDE_WIDTH;
        slides.style.transform = `translateX(${position}px)`;
        slides.style.transition = `${0.8}s ease-out`;
        curPosition--;
      }
    });
  }

  if (nextBtn) {
    nextBtn.addEventListener("click", () => {
      if (curPosition <= sldCount - 16) {
        position -= SLIDE_WIDTH;
        slides.style.transform = `translateX(${position}px)`;
        slides.style.transition = `${0.8}s ease-out`;
        curPosition++;
      }
    });
  }

  const prevBtn_food = document.querySelector("div.prev_food");
  const nextBtn_food = document.querySelector("div.next_food");
  const slides_food = document.querySelector("div.slides_food");
  const sldCount_food = document.querySelectorAll("div.slides_food div").length;

  let position_food = 0;
  let curPosition_food = 0;

  if (prevBtn_food) {
    prevBtn_food.addEventListener("click", () => {
      if (curPosition_food > 0) {
        position_food += SLIDE_WIDTH;
        slides_food.style.transform = `translateX(${position_food}px)`;
        slides_food.style.transition = `${0.8}s ease-out`;
        curPosition_food--;
      }
    });
  }

  if (nextBtn_food) {
    nextBtn_food.addEventListener("click", () => {
      if (curPosition_food <= sldCount_food - 16) {
        position_food -= SLIDE_WIDTH;
        slides_food.style.transform = `translateX(${position_food}px)`;
        slides_food.style.transition = `${0.8}s ease-out`;
        curPosition_food++;
      }
    });
  }

  const prevBtn_stay = document.querySelector("div.prev_stay");
  const nextBtn_stay = document.querySelector("div.next_stay");
  const slides_stay = document.querySelector("div.slides_stay");
  const sldCount_stay = document.querySelectorAll("div.slides_stay div").length;

  let position_stay = 0;
  let curPosition_stay = 0;

  if (prevBtn_stay) {
    prevBtn_stay.addEventListener("click", () => {
      if (curPosition_stay > 0) {
        position_stay += SLIDE_WIDTH;
        slides_stay.style.transform = `translateX(${position_stay}px)`;
        slides_stay.style.transition = `${0.8}s ease-out`;
        curPosition_stay--;
      }
    });
  }

  if (nextBtn_stay) {
    nextBtn_stay.addEventListener("click", () => {
      if (curPosition_stay <= sldCount_stay - 16) {
        position_stay -= SLIDE_WIDTH;
        slides_stay.style.transform = `translateX(${position_stay}px)`;
        slides_stay.style.transition = `${0.8}s ease-out`;
        curPosition_stay++;
      }
    });
  }
});
