// submit
function formPaging(){
	document.getElementById("formPaging").submit();
}

// index 리스트 처리
function pageIndex(index){
	document.getElementById("index").value = index-1;
	formPaging(); // 익명함수가 아니어서 이걸 써준다고 진숙이가 말했다ㅋ....
}

// 리스트 출력개수
function listCnt(){
	document.getElementById("index").value = 0;
	document.getElementById("pageStartNum").value = 1;
	document.getElementById("listCnt").value = document.getElementById("listCount").value;
	formPaging();
}

// 이전 페이지 
function pagePre(index, pageCnt){
	if((index-pageCnt)>0){
		index -= pageCnt;
		document.getElementById("pageStartNum").value = index;
		document.getElementById("index").value = index-1;
	}
	formPaging();
}

// 다음 페이지 (여러개의 값을 받아서 처리해 주어야 함)
// index 필요할 것. total값도 필요하고, listCnt도 필요, pageCnt도 필요
function pageNext(index, total, listCnt, pageCnt){
	var totalPage = Math.ceil(total/listCnt);
	var max = Math.ceil(totalPage/pageCnt);
	if(max*pageCnt > index+pageCnt){
		index += pageCnt;
		document.getElementById("pageStartNum").value = index;
		document.getElementById("index").value = index-1;
	}
	formPaging();
}

function pageLast(index, total, listCnt, pageCnt){
	var totalPage = Math.ceil(total/listCnt);
	var max = Math.ceil(totalPage/pageCnt);
	while(max*pageCnt > index+pageCnt){
		index += pageCnt;
	}
		document.getElementById("pageStartNum").value = index;
		document.getElementById("index").value = totalPage-1;
	formPaging();
	
}





