document.addEventListener('DOMContentLoaded', () => {
    const llegados = document.querySelectorAll('.llegado');
    const prevButton = document.querySelector('.nav-button.prev');
    const nextButton = document.querySelector('.nav-button.next');
    let currentIndex = 0;

    function updateSelected() {
        llegados.forEach((llegado, index) => {
            llegado.classList.toggle('selected', index === currentIndex);
        });
    }

    function showPrevious() {
        if (currentIndex > 0) {
            currentIndex--;
            updateSelected();
        }
    }

    function showNext() {
        if (currentIndex < llegados.length - 1) {
            currentIndex++;
            updateSelected();
        }
    }

    prevButton.addEventListener('click', showPrevious);
    nextButton.addEventListener('click', showNext);

    updateSelected();
});
