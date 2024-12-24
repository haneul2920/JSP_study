// 일정 추가 함수
function addSchedule(event) {
    event.preventDefault(); // 기본 폼 제출 동작 방지

    const machineName = document.getElementById("machineName").value;
    const startTime = document.getElementById("startTime").value;
    const endTime = document.getElementById("endTime").value;
    const task = document.getElementById("task").value;

    const scheduleContainer = document.querySelector(".schedule-container");

    // 새로운 일정 항목 HTML 생성
    const scheduleItem = document.createElement("div");
    scheduleItem.classList.add("schedule-item");

    scheduleItem.innerHTML = `
        <h3>${machineName}</h3>
        <p>작업 시작: ${startTime}</p>
        <p>작업 종료: ${endTime}</p>
        <p>상태: 정상</p>
        <p>작업: ${task}</p>
        <button class="delete-btn" onclick="deleteSchedule(this)">삭제</button>
    `;

    // 새로운 일정 항목을 컨테이너에 추가
    scheduleContainer.appendChild(scheduleItem);

    // 폼 리셋
    document.getElementById("addScheduleForm").reset();
}

// 일정 삭제 함수
function deleteSchedule(button) {
    const scheduleItem = button.closest(".schedule-item");
    scheduleItem.remove(); // 해당 일정 항목 삭제
}