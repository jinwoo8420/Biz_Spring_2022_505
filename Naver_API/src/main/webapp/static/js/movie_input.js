document.addEventListener("DOMContentLoaded", () => {
  const modal_box = document.querySelector("div.modal-movie_result");
  const modal_content = modal_box.querySelector("div.search-movie_content");

  const inputs = document.querySelectorAll("input");

  const input_index = {
    title: 0,
    subtitle: 1,
    director: 2,
    actor: 3,
    pubDate: 4,
    userRating: 5,
    link: 6,
    image: 7,
  };

  const extractTextPattern = /(<([^>]+)>)/gi;

  const movie_title = document.querySelector("input#m_title");

  const btn_save = document.querySelector("button.movies-save");

  movie_title?.addEventListener("keypress", (e) => {
    if (e.keyCode === 13) {
      fetch(`${rootPath}/naver/movies?title=${e.target.value}`)
        .then((res) => res.text())
        .then((result) => {
          modal_box.style.display = "block";
          modal_content.innerHTML = result;
        });
    }
  }); // end movie_title

  modal_box?.addEventListener("click", (e) => {
    const td = e.target;

    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const codes = tr.dataset.title
        .replace(extractTextPattern, "")
        .replace(/(\s*)/g, "");

      fetch(`${rootPath}/naver/${codes}/movies`)
        .then((res) => res.json())
        .then((result) => {
          inputs[input_index.title].value = result.title.replace(
            extractTextPattern,
            ""
          );
          inputs[input_index.subtitle].value = result.subtitle;
          inputs[input_index.director].value = result.director;
          inputs[input_index.actor].value = result.actor;
          inputs[input_index.pubDate].value = result.pubDate;
          inputs[input_index.userRating].value = result.userRating;
          inputs[input_index.link].value = result.link;
          inputs[input_index.image].value = result.image;
          modal_box.style.display = "none";
        });
      alert(codes);
    }
  });

  btn_save?.addEventListener("click", (btn) => {
    const title = inputs[input_index.title];

    if (title?.value === "") {
      alert("제목 입력");
      title.focus();
      return false;
    }
    const form = btn.currentTarget.closest("FORM");
    form.submit();
  });
}); // end ContentLoaded
