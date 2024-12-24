function updateTime() {
    const timeElement = document.getElementById('time');
    const now = new Date();
    
    // 시간, 분, 초를 2자리로 포맷팅
    const hours = String(now.getHours()).padStart(2, '0');
    const minutes = String(now.getMinutes()).padStart(2, '0');
    const seconds = String(now.getSeconds()).padStart(2, '0');
    
    // 시간을 화면에 표시
    timeElement.textContent = `${hours}:${minutes}:${seconds}`;
}

// 1초마다 시간을 업데이트
setInterval(updateTime, 1000);

// 페이지가 로드될 때 시간 설정
updateTime();
