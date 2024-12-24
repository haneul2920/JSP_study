// 자원 관리 페이지 관련 기능

// 자원 데이터를 담을 배열
let resources = [
    { id: 1, name: "자원 1", quantity: 50, location: "창고 A" },
    { id: 2, name: "자원 2", quantity: 120, location: "창고 B" },
    // 다른 자원들도 여기에 추가 가능
];

// 홈으로 이동
function goHome() {
    window.location.href = "index.html"; // index.html로 이동
}

// 자원 삭제 기능
function deleteResource(resourceId) {
    resources = resources.filter(resource => resource.id !== resourceId); // 배열에서 해당 자원 삭제
    renderResourceList(); // 삭제 후 자원 목록 재렌더링
}

// 자원 수정 시작
function editResource(resourceId) {
    const resource = resources.find(r => r.id === resourceId);
    if (resource) {
        document.getElementById('editName').value = resource.name;
        document.getElementById('editQuantity').value = resource.quantity;
        document.getElementById('editLocation').value = resource.location;

        // 수정 완료 버튼에서 처리할 자원 ID를 기억
        document.getElementById('editResourceDetails').onsubmit = function(event) {
            event.preventDefault();
            saveResourceChanges(resourceId);
        };

        // 수정 폼 표시 및 자원 목록 숨김
        document.getElementById('editResourceForm').style.display = 'block';
        document.querySelector('.resource-container').style.display = 'none';
    }
}

// 자원 수정 사항 저장
function saveResourceChanges(resourceId) {
    const name = document.getElementById('editName').value;
    const quantity = document.getElementById('editQuantity').value;
    const location = document.getElementById('editLocation').value;

    const resource = resources.find(r => r.id === resourceId);
    if (resource) {
        resource.name = name;
        resource.quantity = quantity;
        resource.location = location;
    }

    // 수정 폼 숨기고 자원 목록 다시 표시
    document.getElementById('editResourceForm').style.display = 'none';
    document.querySelector('.resource-container').style.display = 'block';

    renderResourceList(); // 자원 목록 재렌더링
}

// 수정 취소
function cancelEdit() {
    document.getElementById('editResourceForm').style.display = 'none';
    document.querySelector('.resource-container').style.display = 'block';
}

// 자원 수량 늘리기
function increaseQuantity(resourceId) {
    const resource = resources.find(r => r.id === resourceId);
    if (resource) {
        resource.quantity += 10; // 수량을 10 증가시킴
        renderResourceList(); // 수량 변경 후 자원 목록 재렌더링
    }
}

// 자원 추가
document.getElementById('addResourceForm').onsubmit = function(event) {
    event.preventDefault();

    const name = document.getElementById('resourceName').value;
    const quantity = parseInt(document.getElementById('resourceQuantity').value);
    const location = document.getElementById('resourceLocation').value;

    // 새로운 자원 객체 추가
    const newResource = {
        id: resources.length + 1, // ID는 자동 증가
        name,
        quantity,
        location
    };
    resources.push(newResource);

    renderResourceList(); // 자원 목록 재렌더링

    // 폼 초기화
    document.getElementById('addResourceForm').reset();
};

// 자원 목록 렌더링
function renderResourceList() {
    const resourceList = document.getElementById('resourceList');
    resourceList.innerHTML = ''; // 기존 목록을 지우고

    resources.forEach(resource => {
        const resourceItem = document.createElement('div');
        resourceItem.classList.add('resource-item');
        resourceItem.setAttribute('data-id', resource.id);

        resourceItem.innerHTML = `
            <h3>${resource.name}</h3>
            <p>수량: <span class="quantity">${resource.quantity}</span></p>
            <p>위치: ${resource.location}</p>
            <button class="delete-button" onclick="deleteResource(${resource.id})">삭제</button>
            <button class="edit-button" onclick="editResource(${resource.id})">수정</button>
            <button class="increase-quantity-button" onclick="increaseQuantity(${resource.id})">수량 늘리기</button>
        `;

        resourceList.appendChild(resourceItem); // 자원 항목 추가
    });
}

// 초기 자원 목록 렌더링
renderResourceList();
