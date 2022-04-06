var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
});

var CompleteList = document.querySelectorAll("#iscomplete");

console.log(CompleteList);

for(let i = 0; i < CompleteList.length; i++)
{
    console.dir(CompleteList[i]);

    if(CompleteList[i].textContent == "false"){
        CompleteList[i].textContent= "아직 진행중입니다."
        let tr =  CompleteList[i].parentNode;
        tr.className = "table-danger"

    }
    if(CompleteList[i].textContent == "true"){
        CompleteList[i].textContent = "완료되었습니다."
        console.log(CompleteList[i].parentNode);
        let tr =  CompleteList[i].parentNode;
        tr.className = "table-success"
    }
}

let Modal = document.querySelector("#Modal");
var list = new Array();

Modal.addEventListener('show.bs.modal', function(event){
    let btn = event.relatedTarget;
    list = btn.dataset.rol.split(",");
    console.log(list);
    let _No = btn.getAttribute('data-bs-whatever');
    console.log(_No);
    let NoInput = Modal.querySelector('.modal-body #No');
    NoInput.value = _No;
    let TitleInput = Modal.querySelector('.modal-body #title');
    TitleInput.value = list[0];
    let WTDInput = Modal.querySelector('.modal-body #whatToDo');
    WTDInput.value = list[1];
    let whentodo = Modal.querySelector('.modal-body #whenToDo');
    whentodo.value = list[2];
    let select = Modal.querySelector(".modal-body #howLongToDo");
    for (let i = 1; i < Number(list[3]); i++) {
        let option = document.createElement("option");
        option.textContent = i;
        select.appendChild(option);
    }
    let selectedoption = document.createElement("option");
    selectedoption.setAttribute("selected", true);
    selectedoption.setAttribute("disabled", true);
    selectedoption.textContent = list[3];
    select.appendChild(selectedoption);
    for (let i = (Number(list[3]) + 1); i <= 24; i++) {
        let option = document.createElement("option");
        option.textContent = i;
        select.appendChild(option);
    }

    let btn_update = document.querySelector(".modal-footer #update-btn");

    btn_update.addEventListener('click', function (event) {
        let No = _No;
        let _title =  Modal.querySelector('.modal-body #title');
        let _whatToDo = Modal.querySelector('.modal-body #whatToDo');
        let _whenToDo = Modal.querySelector('.modal-body #whenToDo');
        let _howLongTodo = Modal.querySelector(".modal-body #howLongToDo");



        data = {
            title: _title.value,
            whatToDo: _whatToDo.value,
            whenToDo: _whenToDo.value,
            howLongToDo: parseInt(_howLongTodo.value)
        }
        console.log(data.title);
        console.log(data.whatToDo);
        console.log(data.whenToDo);
        console.log(data.howLongToDo);
        console.log(No);

        var xhr = new XMLHttpRequest();
        /* Post 방식으로 요청 */
        let url = '/api/put/' + No;
        console.log(url);
        xhr.open('PUT', url , true);
        /* Response Type을 Json으로 사전 정의 */
        xhr.responseType = "json";

        xhr.setRequestHeader('Content-type', 'application/json');

        xhr.send(JSON.stringify(data));
        console.log(JSON.stringify(data));


        xhr.onload = function () { //통신 성공
            if (xhr.DONE) {
                console.log(xhr.response);
                console.log("통신 성공");
                alert('수정되었습니다.');
                window.location.href = '/todolist';
            } else { //통신 실패
                alert("수정에 실패했습니다.")
                console.log(" 수정 실패");
            }
        }

    });
    Modal.removeEventListener("show.bs.modal", arguments.callee);
});







