
var btn_update = document.querySelector("#update");

btn_update.addEventListener('click', function (event) {
    event.preventDefault();
    let _No = document.querySelector("#No");
    let _title = document.querySelector("#title");
    let _whatToDo = document.querySelector("#whatToDo");
    let _whenToDo = document.querySelector("#whenToDo");
    let _howLongTodo = document.querySelector("#howLongToDo");


    data = {
        title: _title.value,
        whatToDo: _whatToDo.value,
        whenToDo: _whenToDo.value,
        howLongToDo: parseInt(_howLongTodo.value)
    }
    console.log(_title.value);
    console.log(_whatToDo.value);
    console.log(_whenToDo.value);
    console.log(typeof (data.howLongToDo));
    console.log(_No.value);

    var xhr = new XMLHttpRequest();
    /* Post 방식으로 요청 */
    let url = '/api/put/' + _No.value;
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