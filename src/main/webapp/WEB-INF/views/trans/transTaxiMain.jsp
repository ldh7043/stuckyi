<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="descriptison">
<meta content="" name="keywords">
<!-- Favicons -->
<link href="<%=request.getContextPath()%>/resources/assets/img/favicon.png" rel="icon">
<link href="<%=request.getContextPath()%>/resources/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i,900" rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="<%=request.getContextPath()%>/resources/assets/img/favicon.png" rel="icon">
<link href="<%=request.getContextPath()%>/resources/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/assets/vendor/venobox/venobox.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/assets/vendor/aos/aos.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<%=request.getContextPath()%>/resources/assets/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/assets/css/board.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/bb29575d31.js"></script>
<title>장애인편의시설알리미</title>
</head>
 <style>
.container #title {
   text-align: center;
   padding: 10px;
}
#taxiMain{
    padding-top:40px;
	padding-bottom:20px;
  	box-shadow: 0 5px 25px 0 rgba(214, 215, 216, 0.6);
	padding-left: 60px;
}
.container #map {
   margin: 0 auto;
   width: 90%;
   height: 500px;
}


.container #hosname:hover {
   color: blue;
}

#hosname {
   float: right;
   padding: 0 0 5px 0;
   height: 38px;
}

#btn_search {
   margin: 0 50px;
}

#subXML {
   width: 100%;
}

#loadbutton {
   text-align: center;
}

#subXML {
   text-align: center;
}

#btn1{
   float:left;
   margin: 30px 5px 30px 150px;
   position: static; 
}
#box1{
   float:right;
   margin: -75px 120px 0px 10px;
   position: relative;
   text-align : center;
}

#callXML{
   text-align: center;
}

#texiapi {
   text-align: center;
}

#article{
	padding-left: 150px;
}
</style>

<body>
   <!-- ======= Header ======= -->
   <header id="header">
      <div class="container">

         <div class="logo float-left">
            <h1 class="text-light">
               <a href="http://localhost:8033/stuckyi/main/home"><span>STUCKYI</span></a>
            </h1>
         </div>

          <nav class="nav-menu float-right d-none d-lg-block">
            <ul>
               <li><a href="#quick">바로가기버튼</a></li>
               <li><a href="http://localhost:8033/stuckyi/main/welfareMain">복지시설</a></li>
               <li class="drop-down"><a href="http://localhost:8033/stuckyi/trans/transmain">교통시설</a>
                  <ul>
                     <li><a href="http://localhost:8033/stuckyi/trans/submain">지하철</a></li>
                     <li class="drop-down"><a href="http://localhost:8033/stuckyi/trans/taxireserve">콜택시</a>
                        <ul>
                           <li><a href="http://localhost:8033/stuckyi/trans/transmain">콜택시 정보</a></li>
                           <li><a href="http://localhost:8033/stuckyi/trans/taxireserve">콜택시 예약</a></li>
                        </ul></li>
                  </ul></li>
               <li><a href="http://localhost:8033/stuckyi/tour/tourmain">관광시설</a></li>
               <li class="drop-down"><a href="http://localhost:8033/stuckyi/clinic/clinicmain">병원시설</a>
                  <ul>
                     <li><a href="http://localhost:8033/stuckyi/clinic/clinicmain">병원 편의시설 찾기</a></li>
                     <li><a href="http://localhost:8033/stuckyi/clinic/clinicreserve">병원 예약하기</a></li>
                  </ul></li>
               <li>
                     <sec:authorize access="isAuthenticated()">
                                <div class="login-register-cart-button d-flex align-items-center">
                                    <div class="login-register-btn mr-50">
                                       <sec:authentication property="principal.username" var="user_id" />
                                       <a href="http://localhost:8033/stuckyi/main/mypage">${user_id } 님</a>
                              
                                    </div>
                                </div>
                                </sec:authorize>
                                           
                </li>
               <li class="logoutBtn">
                     <sec:authorize access="isAuthenticated()">
                                <div class="login-register-cart-button d-flex align-items-center">
                                    <div class="login-register-btn mr-50">
                                       <sec:authentication property="principal.username" var="user_id" />
                                       
                              <form action="${pageContext.request.contextPath }/main/logout" method='post'>
                                 <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                                 <button id="zzzz" class="btn btn-outline-info" type="submit" >로그아웃</button>
                                    </form>
                                    </div>
                                </div>
                                </sec:authorize>
                        
                                           
                        <sec:authorize access="isAnonymous()">
                            <!-- Login/Register & Cart Button -->
                            <div class="login-register-cart-button d-flex align-items-center">
                                <!-- Login/Register -->
                                <div class="login-register-btn mr-50">
                                    <a href="<%=request.getContextPath() %>/main/login" id="loginBtn" class="btn btn-outline-info custom" type="button">로그인</a>
                                </div>
                            </div>
                        </sec:authorize>
                </li>
                
               
            </ul>
         </nav>
         <!-- .nav-menu -->

    </div>
  </header><!-- End Header -->
<body>
   <main id="main">



<!-- body 영역 -->
<div id="taxiMain" class="container">
   <div  class="container" id="article">
   <div  class="ct_explain" id="taxi_info1">
   <h2 style="color:#5c768d; padding-left: 180px;">시설공단 콜택시 안내</h2><br>
      <p>서울시 장애인 콜택시는 중증장애인에게 이동 편의를 제공하여 사회참여 확대를 위하여 노력하고 있습니다.</p>
   <h4>콜택시 운영체제</h4>
   <ol>
      <li>콜접수 : 이용시민이 전화/문자, 인터넷 또는 앱을 통해 차량 신청</li>
      <li>배차 : 접수순에 따라 가장 근접한 차량 연결</li>
      <li>서비스(운행) : 차량이 이용시민 출발지로 이동 → 탑승 → 목적지까지 운행</li>
   </ol>
   </div>
   <div  class="ct_explain" id="text_info2"> 
   <h4>콜택시 이용현황 안내</h4>
   <p>서울시 시설공단에서 운영중인 장애인 콜택시 운행 일별 운행차량대수, 콜건수, 대기시간 등을<br> 
       검색하여 콜접수 시간대가 몰리는 시간을 피해 원할한 접수를
      할 수 있도록 검색이 가능합니다.</p>
   </div></div>

   
   <div class="container">
   <div class="row">
   <div id="btn1">
   <div class="btn btn-outline-info"><a href="https://www.sisul.or.kr/open_content/calltaxi/guidance/internet.jsp" role="button"><b>시설공단 인터넷<br>콜접수 바로가기</b></a></div>
   </div></div>
   <div id="box1" style= "text-align:center"><b>시설공단 콜접수 전화번호</b><br>02-1234-5678</div>
   </div>

   <br>
   
   
   <br>

   <!--call api-->
   <div id="texiapi">
   <form name="callday">
      날짜: <input type="date" id="REG_DATE" value="2021-01-01" placeholder="yyyy-mm-dd"/>
      <input type="number" id="START_INDEX" value="1" hidden>
      <input type="number" id="END_INDEX" value="5" hidden>
      
      <button id="btn_load" type="button" class="btn btn-outline-info">정보 가져오기</button>
      <button id="btn_remove" class="btn btn-outline-info">지우기</button><br>
      
      
   </form></div>

   <table class="table" id="callXML"></table>
<!-- 테이블 생성 -->
       <div id="loadbutton"><button class="btn btn-outline-info" type="button" id="load">더보기</button></div>
       
  </div>
   <script>
      var api_key = "525a697446646c633131344b4b594468";

      $(document).ready(function(){
        $("#load").hide();
         $("#btn_load").click(function(){
            $("#load").show();
            var START_INDEX = $("#START_INDEX").val();
            var END_INDEX = $("#END_INDEX").val();
            var REG_DATE = $("#REG_DATE").val();
            //REG_DATE = REG_DATE.replace(/-/g, '');

      // XML
         var req_url = "http://openapi.seoul.go.kr:8088/" + api_key + "/xml/disabledCalltaxi/" + START_INDEX  + "/" + END_INDEX + "/" + REG_DATE;
      
         $.ajax({
            url : req_url,
            type : "GET",
            cache : false,
            success : function(data, status){
               if(status == "success") parseXML(data);
               }
            });   
         });

         $("#btn_remove").click(function(){
         $("#demoXML").html("");
         });
      });


   function parseXML(xmlDOM) {
      var table = "<tr><th style='width:20%'>차량타입</th><th style='width:20%'>배차일시</th><th style='width:20%'>승차일시</th><th style='width:20%'>출발지</th><th style='width:20%'>목적지</th></tr>";
      $(xmlDOM).find("ROW > list > item").each(function(){
         table += "<tr style='display: none;'>";
         table += "<td>" + $(this).find("cartype").text() + "</td>";
         table += "<td>" + $(this).find("settime").text() + "</td>";
         table += "<td>" + $(this).find("ridetime").text() + "</td>";
         table += "<td>" + $(this).find("startpos1").text() + "</td>";
         table += "<td>" + $(this).find("endpos1").text() + "</td>";
         table += "</tr>";
      });
      $("#callXML").html(table);
      $("tr:hidden").slice(0, 10).show();
   }
   
   $(function() {
         $("#load").click(function(e) {
            e.preventDefault();
            $("tr:hidden").slice(0, 10).show();
            if ($("tr:hidden").length == 0) {
               alert("불러올데이터가없습니다.");
            }
         });
      });
   </script>





    <!-- ======= Counts Section ======= -->
    <section id="quick" class="counts section-bg">
      <div class="container">

        <div class="row">

          <div class="col-lg-3 col-md-6 text-center" data-aos="fade-up">
            <div class="count-box">
            <a href="http://localhost:8033/stuckyi/board/list">
              <img src="https://img.icons8.com/dusk/64/000000/welfare.png"/>
              <p>건의사항 바로가기</p>
              </a>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 text-center" data-aos="fade-up" data-aos-delay="200">
            <div class="count-box">
             <a href="http://localhost:8033/stuckyi/trans/transmain">
              <img src="https://img.icons8.com/clouds/64/000000/subway.png"/>
              <p>교통 바로가기</p>
               </a>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 text-center" data-aos="fade-up" data-aos-delay="400">
            <div class="count-box">
             <a href="http://localhost:8033/stuckyi/tour/tourmain">
              <img src="https://img.icons8.com/color/64/000000/tour-guide.png"/>
              <p>관광지 바로가기</p>
              </a>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 text-center" data-aos="fade-up" data-aos-delay="600">
            <div class="count-box">
             <a href="http://localhost:8033/stuckyi/clinic/clinicmain">
              <img src="https://img.icons8.com/clouds/64/000000/ambulance.png"/>
              <p>병원 바로가기</p>
               </a>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Counts Section -->
<!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-5 col-md-6 footer-info">
            <div class="social-links mt-3">
              <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
              <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
              <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
              <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
              <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
            </div>
          </div>

          <div class="col-lg-2 col-md-6 footer-links">
            <h4>Useful Links</h4>
            <ul>
              <li><i class="bx bx-chevron-right"></i> <a href="http://localhost:8033/stuckyi/board/list">건의사항</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="http://localhost:8033/stuckyi/main/welfareMain">복지시설</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="http://localhost:8033/stuckyi/trans/transmain">교통시설</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="http://localhost:8033/stuckyi/tour/tourmain">관광시설</a></li>
              <li><i class="bx bx-chevron-right"></i> <a href="http://localhost:8033/stuckyi/clinic/clinicmain">병원시설</a></li>
            </ul>
          </div>


          <div class="col-lg-5 col-md-6 footer-info">
            <h3>장애인편의시설</h3>
            <p>
              서울특별시 강남구 역삼동 736-7 <br>
              서비스업신고 : 2020-서울강남-0082호
              <strong>Phone:</strong> 02-111-2222<br>
              <strong>Email:</strong> abcd123@naver.com<br>
            </p>
          </div>

        </div>
      </div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>STUCKYI</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/mamba-one-page-bootstrap-template-free/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/jquery/jquery.min.js"></script>
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/php-email-form/validate.js"></script>
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/jquery-sticky/jquery.sticky.js"></script>
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/venobox/venobox.min.js"></script>
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/counterup/counterup.min.js"></script>
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="<%= request.getContextPath() %>/resources/assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="<%= request.getContextPath() %>/resources/assets/js/main.js"></script>

</body>

</html>