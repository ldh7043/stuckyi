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
            }
        }
    });  // end $.ajax()
} // end loadPage()

function parseJSON(jsonObj){
    var row = jsonObj.list;
    var i;
    var totalCnt = jsonObj.totalCnt;
    var length = 6;
    if(totalCnt < length){
        length = totalCnt;
    }
    
    var table="";
    for (i = 0; i < length; i++) { 
        table += "<div class='col-lg-4 col-md-6 content-item' data-aos='fade-up'>";
        table += "<a href='http://localhost:8033/stuckyi/board/view?uid=" + row[i].brdUid +"'><span>";
        table += (i+1) + "</span>";
        table += "<h4>" + row[i].brdTitle + "</h4>";
        table += "<p>" + row[i].brdType + "</p>";
        table += "</a></div>";
    }
    $("#homeBoard").html(table);
}


$(document).ready(function(){
    loadPage(page);
});


