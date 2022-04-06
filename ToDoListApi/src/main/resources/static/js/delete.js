var btn_delete = document.querySelector("#deletebtn");
var _No = btn_delete.dataset.rol;

btn_delete.addEventListener('click', function (event) {

    var xhr = new XMLHttpRequest();
    console.log(_No);
    /* Post 방식으로 요청 */
    let url = '/api/delete/' + _No;
    console.log(url);
    xhr.open('DELETE', url, true);
    /* Response Type을 Json으로 사전 정의 */
    xhr.responseType = "json";

    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send();
    xhr.onload = function () { //통신 성공
        if (xhr.DONE) {
            console.log(xhr.response);
            console.log("통신 성공");
            alert('삭제되었습니다.');
            window.location.href = '/todolist';
        } else { //통신 실패
            alert("수정에 실패했습니다.")
            console.log(" 수정 실패");
        }
    }

});