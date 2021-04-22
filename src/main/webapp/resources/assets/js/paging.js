var page = 1;   //  현재 페이지
var pageRows = 10;  // 페이지당 글의 개수

function loadPage(page){
    $.ajax({
        url : "http://localhost:8033/stuckyi/board/" + page + "/" + pageRows,
        type : "GET",
        cache : false,
        success : function(data, status){
            if(status == "success"){
                parseJSON(data);
                updateList(data);
            }
        }
    });  // end $.ajax()
} // end loadPage()

function parseJSON(jsonObj){
    var row = jsonObj.list;
    var i;
    
    var table="<tr><th>아이디</th><th>종류</th><th>제목</th><th>조회수</th></tr>";
    for (i = 0; i < row.length; i++) { 
        table += "<tr>";
        
        table += "<td>" + row[i].userId + "</td>";
        table += "<td>" + row[i].brdType + "</td>";
        table += "<td><a href='view?uid=" + row[i].brdUid + "'>" + row[i].brdTitle + "</a></td>";
        table += "<td>" + row[i].brdViewcnt + "</td>";
        table += "</tr>";
    }
    $("#boardJSON").html(table);
}


$(document).ready(function(){
    loadPage(page);
});

// 한페이징에 표시될 페이지수 --> writePages
// 총 페이지수 --> totalPage
// 현재 페이지 --> curPage

function updateList(jsonObj){

    if(jsonObj.boardStatus == "OK"){
        var count = jsonObj.boardCount;

        window.page = jsonObj.page;
        window.pageRows = jsonObj.pageRows; 

        // [페이징 정보 업데이트]
        var pagination = buildPagination(jsonObj.writePages, jsonObj.totalPage, jsonObj.page, jsonObj.pageRows);
        $("#pagination").html(pagination);

        return true;  // 목록 업데이트 성공하면 true 리턴
    } else {
        alert("내용이 없습니다.");
        return false;
    }


} // end updateList()

function buildPagination(writePages, totalPage, curPage, pageRows){
	var str = "";   // 최종적으로 페이징에 나타날 HTML 문자열 <li> 태그로 구성
	
	// 페이징에 보여질 숫자들 (시작숫자 start_page ~ 끝숫자 end_page)
    var start_page = ( (parseInt( (curPage - 1 ) / writePages ) ) * writePages ) + 1;
    var end_page = start_page + writePages - 1;

    if (end_page >= totalPage){
    	end_page = totalPage;
    }
    
  //■ << 표시 여부
	if(curPage > 1){
		str += "<li><a onclick='loadPage(" + 1 + ")' class='tooltip-top' title='처음'><i class='fas fa-angle-double-left'></i></a></li>\n";
	}
	
  	//■  < 표시 여부
    if (start_page > 1) 
    	str += "<li><a onclick='loadPage(" + (start_page - 1) + ")' class='tooltip-top' title='이전'><i class='fas fa-angle-left'></i></a></li>\n";
    
    //■  페이징 안의 '숫자' 표시	
	if (totalPage >= 1) {
	    for (var k = start_page; k <= end_page; k++) {
	        if (curPage != k)
	            str += "<li><a onclick='loadPage(" + k + ")'>" + k + "</a></li>\n";
	        else
	            str += "<li><a class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
	    }
	}
	
	//■ > 표시
    if (totalPage > end_page){
    	str += "<li><a onclick='loadPage(" + (end_page + 1) + ")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
    }

	//■ >> 표시
    if (curPage < totalPage) {
        str += "<li><a onclick='loadPage(" + totalPage + ")' class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
    }

    return str;
} // end buildPagination();

