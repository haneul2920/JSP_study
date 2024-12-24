// 페이지가 로드되면 페이지를 부드럽게 표시하는 함수
document.addEventListener('DOMContentLoaded', function() {
    const page = document.querySelector('.page');
    if (page) page.classList.add('show');  // 페이지가 부드럽게 나타나도록 클래스 추가
});

// 페이지 이동 시 부드럽게 전환하는 함수
function smoothPageTransition(href) {
    const transition = document.querySelector('.page-transition');
    if (transition) {
        transition.classList.add('active');  // 화면이 어두워지기 시작
        setTimeout(() => {
            window.location.href = href; // 실제 페이지 이동
        }, 500);  // 0.5초 후 이동
    }
}

// 링크와 버튼 클릭 시 전환 애니메이션 적용
document.querySelectorAll('a, button').forEach(element => {
    element.addEventListener('click', function(event) {
        const href = element.getAttribute('href') || element.dataset.href;
        if (href) {
            event.preventDefault();  // 기본 클릭 이벤트 막기
            smoothPageTransition(href);  // 부드럽게 페이지 전환
        }
    });
});

// 새 페이지가 로드될 때 천천히 표시되도록
window.addEventListener('load', function() {
    const page = document.querySelector('.page');
    if (page) page.classList.add('fade-in'); // 새 페이지가 부드럽게 나타나도록 클래스 추가
});

function goHome() {
    document.body.classList.add("fade-out");
    setTimeout(() => {
        window.location.href = "index.html";
    }, 500);
}
