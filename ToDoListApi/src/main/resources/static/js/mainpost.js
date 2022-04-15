
let isTitleValid = false;
let isWhatToDoValid=false;
let isWhenToDoValid =false;
let isHowLongToDoValid = false;

document.querySelector("#title").addEventListener("input", function(){

    let inputtitle=this.value;

    if(inputtitle.length == 0){
        isTitleValid = false;
    }
    else if(inputtitle.length > 10 ){
        isTitleValid = false;
    }
    else{
        isTitleValid = true;
    }

    if(isTitleValid == true){
        this.classList.remove("is-invalid");
        this.classList.add("is-valid");
    }else{
        this.classList.remove("is-valid");
        this.classList.add("is-invalid");
    }
});

document.querySelector("#whatToDo").addEventListener("input", function(){

    let inputwhattodo=this.value;
    console.log(inputwhattodo);

    if(inputwhattodo.length == 0){
        isWhatToDoValid = false;
    }
    else{
        isWhatToDoValid = true;
    }
    if(isWhatToDoValid == true){
        this.classList.remove("is-invalid");
        this.classList.add("is-valid");
    }else{
        this.classList.remove("is-valid");
        this.classList.add("is-invalid");
    }
});

document.querySelector("#whenToDo").addEventListener("input", function(){

    let inputwhentodo=this.value;

    if(inputwhentodo.length == 0){
        isWhenToDoValid = false;
    }
    else{
        isWhenToDoValid = true;
    }

    if(isWhenToDoValid == true){
        this.classList.remove("is-invalid");
        this.classList.add("is-valid");
    }else{
        this.classList.remove("is-valid");
        this.classList.add("is-invalid");
    }
});

document.querySelector("#howLongToDo").addEventListener("input", function(){

    let inputhowlong=this.value;

    if(inputhowlong.value == 0){
        isHowLongToDoValid = false;
    }
    else{
        isHowLongToDoValid = true;
    }

    if(isHowLongToDoValid == true){
        this.classList.remove("is-invalid");
        this.classList.add("is-valid");
    }else{
        this.classList.remove("is-valid");
        this.classList.add("is-invalid");
    }
});





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
            if(!isTitleValid){
                _title.classList.remove("is-valid");
                _title.classList.add("is-invalid");
            }
            if(!isWhatToDoValid){
                _whatToDo.classList.remove("is-valid");
                _whatToDo.classList.add("is-invalid");
            }
            if(!isWhenToDoValid){
                _whenToDo.classList.remove("is-valid");
                _whenToDo.classList.add("is-invalid");
            }
            if(!isHowLongToDoValid){
                _howLongTodo.classList.remove("is-valid");
                _howLongTodo.classList.add("is-invalid");
            }
            alert("누락된 요소가 있습니다.")
            console.log("통신 실패");
        }
    }

});

