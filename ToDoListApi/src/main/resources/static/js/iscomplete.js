var btn_complete = document.querySelector("#iscompletebtn");

btn_complete.addEventListener('click', function (event) {
    let _No = this.dataset.rol;
    data = {
        No : _No,
        isComplete : true
    }

    console.log(_No);

    var xhr = new XMLHttpRequest();
    /* Post 방식으로 요청 */
    let url = '/api/put/complete/' + _No;
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
            alert('Mission Complete!');
            window.location.href = '/todolist';
        } else { //통신 실패
            alert("수정에 실패했습니다.")
            console.log(" 수정 실패");
        }
    }

});