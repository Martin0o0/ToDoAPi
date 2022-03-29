var btn_save = document.querySelector("#button_save");

btn_save.addEventListener('click', function (event) {
    event.preventDefault();
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

    var xhr = new XMLHttpRequest();
    /* Post 방식으로 요청 */
    xhr.open('POST', '/api/post', true);
    /* Response Type을 Json으로 사전 정의 */
    xhr.responseType = "json";

    xhr.setRequestHeader('Content-type', 'application/json');

    xhr.send(JSON.stringify(data));
    console.log(JSON.stringify(data));


    xhr.onload = function () { //통신 성공
        if (xhr.status == 200) {
            console.log(xhr.response);
            console.log("통신 성공");
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        } else { //통신 실패
            alert("등록에 실패했습니다.")
            console.log("통신 실패");
        }
    }

});

