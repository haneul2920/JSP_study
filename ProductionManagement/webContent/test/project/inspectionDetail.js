document.addEventListener('DOMContentLoaded', function() {
    const params = new URLSearchParams(window.location.search);
    const machineId = params.get('machine'); // URL 파라미터에서 기계 ID 가져오기

    // 기계 정보와 점검 이력 업데이트 (예시)
    const machineName = document.getElementById('machineName');
    const inspectionDate = document.getElementById('inspectionDate');
    const inspectionStatus = document.getElementById('inspectionStatus');
    const inspectionOfficer = document.getElementById('inspectionOfficer');
    const inspectionHistory = document.getElementById('inspectionHistory');

    // 기계 정보 예시 (실제로는 서버에서 가져오거나 로컬 스토리지에서 불러올 수 있습니다)
    machineName.textContent = `기계 ${machineId}`;
    inspectionDate.textContent = '2024-12-01';
    inspectionStatus.textContent = '양호';
    inspectionOfficer.textContent = '홍길동';

    // 점검 이력 추가 예시
    const historyItem = document.createElement('li');
    historyItem.textContent = '2024-12-01: 점검 완료 - 담당자: 홍길동';
    inspectionHistory.appendChild(historyItem);

    // 점검 이력 추가 폼
    document.getElementById('addInspectionRecordForm').addEventListener('submit', function(e) {
        e.preventDefault();
        
        const recordDate = e.target[0].value;
        const recordContent = e.target[1].value;
        const recordOfficer = e.target[2].value;

        const newHistoryItem = document.createElement('li');
        newHistoryItem.textContent = `${recordDate}: ${recordContent} - 담당자: ${recordOfficer}`;
        inspectionHistory.appendChild(newHistoryItem);

        // 폼 초기화
        e.target.reset();
    });
});

function goHome() {
    window.location.href = "index.html"; // index.html로 이동
}
