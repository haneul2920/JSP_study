// 설비 상태 리스트
const equipmentList = [
    { name: "설비 1", status: "작동 중" },
    { name: "설비 2", status: "점검 중" },
    { name: "설비 3", status: "대기 중" },
];

// 설비 상태 리스트를 HTML로 표시
function renderEquipmentList() {
    const listElement = document.getElementById('equipmentStatusList');
    listElement.innerHTML = ''; // 기존 리스트 비우기

    equipmentList.forEach((equipment, index) => {
        const listItem = document.createElement('li');
        listItem.innerHTML = `
            <div>
                <span>${equipment.name}</span>
                <span>상태: ${equipment.status}</span>
            </div>
            <button onclick="removeEquipment(${index})">삭제</button>
        `;
        listElement.appendChild(listItem);
    });
}

// 설비 추가
const addEquipmentForm = document.getElementById('addEquipmentForm');
addEquipmentForm.addEventListener('submit', function(e) {
    e.preventDefault(); // 폼 제출 시 페이지 리로드 방지

    const equipmentName = document.getElementById('equipmentName').value;
    if (equipmentName) {
        equipmentList.push({ name: equipmentName, status: "대기 중" });
        renderEquipmentList(); // 새 설비 추가 후 리스트 갱신
        document.getElementById('equipmentName').value = ''; // 입력 필드 초기화
    }
});

// 설비 삭제
function removeEquipment(index) {
    equipmentList.splice(index, 1);
    renderEquipmentList(); // 리스트 갱신
}

// 설비 현황 페이지 닫기
function closePage() {
    window.history.back(); // 이전 페이지로 돌아가기
}

// 초기 화면 렌더링
renderEquipmentList();
