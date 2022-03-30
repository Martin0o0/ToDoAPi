var CompleteList = document.querySelectorAll("#iscomplete");

console.log(CompleteList);

for(let i = 0; i < CompleteList.length; i++)
{
    console.dir(CompleteList[i]);

    if(CompleteList[i].textContent == "false"){
        CompleteList[i].textContent= "아직 진행중입니다."
        let tr =  CompleteList[i].parentNode;
        tr.className = "danger"

    }
    if(CompleteList[i].textContent == "true"){
        CompleteList[i].textContent = "완료되었습니다."
        console.log(CompleteList[i].parentNode);
        let tr =  CompleteList[i].parentNode;
        tr.className = "success"
    }
}