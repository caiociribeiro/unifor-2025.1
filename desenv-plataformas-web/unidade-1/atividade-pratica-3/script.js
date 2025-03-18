document.addEventListener("DOMContentLoaded", () => {
    const openAddModalBtn = document.getElementById("openAddModal");
    const addModal = document.getElementById("addModal");
    const cancelAddBtn = document.getElementById("cancelAdd");
    const confirmAddBtn = document.getElementById("confirmAdd");
    const reviewList = document.getElementById("reviewList");
    const movieNameInput = document.getElementById("movieName");
    const movieRatingSelect = document.getElementById("movieRating");
    const movieReviewText = document.getElementById("movieReview");
    const movieLikeBtn = document.getElementById("movieLike");

    const confirmModal = document.getElementById("confirmModal");
    const cancelDeleteBtn = document.getElementById("cancelDelete");
    const confirmDeleteBtn = document.getElementById("confirmDelete");

    let reviews = JSON.parse(localStorage.getItem("reviews")) || [];
    let reviewToDeleteId = null;

    function saveReviews() {
        localStorage.setItem("reviews", JSON.stringify(reviews));
    }

    function renderReviews() {
        reviewList.innerHTML = "";
        reviews.forEach((review) => {
            const item = document.createElement("div");
            item.classList.add("review-item");
            item.setAttribute("data-id", review.id);
            item.innerHTML = `
          <h3>${review.movieName}</h3>
          <div>
            <span class="review-rating"><strong>Avaliação:</strong> ${
                review.movieRating
            } estrela(s)</span>
            ${
                review.liked
                    ? `<span class="liked"><i class="fa-solid fa-heart"></i></span>`
                    : ""
            }
          </div>
          <p>${review.movieReview}</p>
          <button class="btn-delete">Excluir</button>
        `;
            item.querySelector(".btn-delete").addEventListener("click", () => {
                reviewToDeleteId = review.id;
                openModal(confirmModal);
            });
            reviewList.appendChild(item);
        });
    }

    function openModal(modal) {
        modal.style.display = "flex";
    }
    function closeModal(modal) {
        modal.style.display = "none";
    }

    renderReviews();

    openAddModalBtn.addEventListener("click", () => {
        movieNameInput.value = "";
        movieRatingSelect.value = "0.5";
        movieReviewText.value = "";
        movieLikeBtn.classList.remove("liked");
        openModal(addModal);
    });

    cancelAddBtn.addEventListener("click", () => {
        closeModal(addModal);
    });

    movieLikeBtn.addEventListener("click", () => {
        movieLikeBtn.classList.toggle("liked");
    });

    confirmAddBtn.addEventListener("click", () => {
        const movieName = movieNameInput.value.trim();
        const movieRating = movieRatingSelect.value;
        const movieReview = movieReviewText.value.trim();
        const liked = movieLikeBtn.classList.contains("liked");

        if (movieName === "" || movieReview === "") {
            alert("Preencha o nome do filme e a review.");
            return;
        }

        const review = {
            id: Date.now(),
            movieName,
            movieRating,
            movieReview,
            liked,
        };

        reviews.push(review);
        saveReviews();
        renderReviews();
        closeModal(addModal);
    });

    cancelDeleteBtn.addEventListener("click", () => {
        reviewToDeleteId = null;
        closeModal(confirmModal);
    });

    confirmDeleteBtn.addEventListener("click", () => {
        if (reviewToDeleteId !== null) {
            reviews = reviews.filter(
                (review) => review.id !== reviewToDeleteId
            );
            saveReviews();
            renderReviews();
        }
        reviewToDeleteId = null;
        closeModal(confirmModal);
    });

    window.addEventListener("click", (e) => {
        if (e.target === addModal) {
            closeModal(addModal);
        }
        if (e.target === confirmModal) {
            closeModal(confirmModal);
        }
    });
});
