//답글 (대댓글)
$("#btnReply").click(function(){
    var cmtContent=$("#cmtContent").val(); //댓글 내용
    var brdUid =  $("#brdUid").val();//게시물 번호
    var userid=$("#userid").val(); // 아이디

    var param={ "cmtContent": cmtContent, "brdUid": brdUid, "userid":userid, };
    var csrfName = $("#csrfName").val();
    var csrfValue = $("#csrfValue").val();
    param[csrfName] = csrfValue;
    $.ajax({
        type: "post", //데이터를 보낼 방식
        url: "http://localhost:8033/stuckyi/comment/writeOk", //데이터를 보낼 url
        data: param, //보낼 데이터

        success: function(){ //데이터를 보내는것이 성공했을시 출력되는 메시지
            alert("댓글이 등록되었습니다.");
            location.href = "http://localhost:8033/stuckyi/board/view?uid=" + brdUid;
        }
    });
});

var page = 1;   //  현재 페이지
var pageRows = 10;  // 페이지당 글의 개수
var brdUid =  $("#brdUid").val();//게시물 번호

$(function(){
    $.ajax({
    url: "http://localhost:8033/stuckyi/comment/"+ brdUid + "/" + page + "/" + pageRows,
    type: "GET",
    cache: false,
    success: function(data, status){
        if(status == "success") {
            commentJSON(data);
            updateList(data);
        }
    }
    })
});

function commentJSON(jsonObj){
    var row = jsonObj.commentList;
    var i;
    var str="";
    var userid=$("#userid").val(); // 아이디
    var table="";
    for (i = 0; i < row.length; i++) { 
            table += "<tr style='width: 100%;'>";
            table += "<td style='width: 70%;'>" + row[i].userid + "</td>";
            table += "<td style='width: 30%;'>" + row[i].cmtRegDate + "</td></tr><tr>";
            table += "<td>" + row[i].cmtContent + "</td>";
            if(row[i].userid == userid){
                table += "<td><button type='button' id='deleteCmt' value='"+row[i].cmtUid + "'>삭제</button></td>";
            }
            table += "</tr><hr>";
    }
    $("#commentJSON").html(table);
    $("#deleteCmt").click(function(){
        var brdUid =  $("#brdUid").val();
        var cmtUid = $("#deleteCmt").val();
        var param={ "cmtUid": cmtUid};
        var csrfName = $("#csrfName").val();
        var csrfValue = $("#csrfValue").val();
        param[csrfName] = csrfValue;
        $.ajax({
            type: "delete", //데이터를 보낼 방식
            url: "http://localhost:8033/stuckyi/comment/deleteOk", //데이터를 보낼 url
            data: param, //보낼 데이터
    
            success: function(){ //데이터를 보내는것이 성공했을시 출력되는 메시지
                alert("댓글이 삭제되었습니다.");
                location.href = "http://localhost:8033/stuckyi/board/view?uid=" + brdUid;
            }
        });
    });

}



function updateList(jsonObj){

    if(jsonObj.commentStatus == "OK"){
        var count = jsonObj.commentCount;

        window.page = jsonObj.commentpage;
        window.pageRows = jsonObj.commentPageRows; 

        // [페이징 정보 업데이트]
        var pagination = buildPagination(jsonObj.commentWritePages, jsonObj.commentTotalPage, jsonObj.commentpage, jsonObj.commentPageRows);
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
	if (totalPage > 1) {
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