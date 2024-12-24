// report.js
function goHome() {
    window.location.href = "index.html"; // 홈 페이지로 이동
}

// 생산 보고서 삭제
function deleteReport(reportId) {
    const report = document.getElementById(reportId);
    report.remove(); // 해당 보고서 항목을 삭제
}

// 생산 보고서 상세보기
function viewReport(reportId) {
    alert(`${reportId}의 상세 정보를 보려면 다른 페이지로 이동해야 합니다.`);
    // 여기서는 간단한 알림을 출력했지만, 실제로는 상세보기 페이지로 이동하는 로직이 필요합니다.
}

// 생산 보고서 추가
function addReport(event) {
    event.preventDefault(); // 폼 제출 시 새로고침 방지

    const title = document.getElementById("reportTitle").value;
    const startTime = document.getElementById("startTime").value;
    const endTime = document.getElementById("endTime").value;
    const productionAmount = document.getElementById("productionAmount").value;

    const reportList = document.querySelector(".report-list");

    const newReport = document.createElement("div");
    newReport.classList.add("report-item");

    newReport.innerHTML = `
        <h3>${title}</h3>
        <p>작업 시작: ${startTime}</p>
        <p>작업 종료: ${endTime}</p>
        <p>생산량: ${productionAmount}개</p>
        <button class="view-button" onclick="viewReport('newReport')">상세보기</button>
        <button class="delete-button" onclick="deleteReport('newReport')">삭제</button>
    `;
    reportList.appendChild(newReport);

    // 폼 초기화
    document.getElementById("addReportForm").reset();
}
