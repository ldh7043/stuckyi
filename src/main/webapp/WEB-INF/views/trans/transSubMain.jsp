 <%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
   prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="descriptison">
<meta content="" name="keywords">
<!-- Favicons -->
<link
   href="<%=request.getContextPath()%>/resources/assets/img/favicon.png"
   rel="icon">
<link
   href="<%=request.getContextPath()%>/resources/assets/img/apple-touch-icon.png"
   rel="apple-touch-icon">

<!-- Google Fonts -->
<link
   href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i,900"
   rel="stylesheet">

<!-- Vendor CSS Files -->
<link
   href="<%=request.getContextPath()%>/resources/assets/img/favicon.png"
   rel="icon">
<link
   href="<%=request.getContextPath()%>/resources/assets/vendor/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
<link
   href="<%=request.getContextPath()%>/resources/assets/vendor/icofont/icofont.min.css"
   rel="stylesheet">
<link
   href="<%=request.getContextPath()%>/resources/assets/vendor/boxicons/css/boxicons.min.css"
   rel="stylesheet">
<link
   href="<%=request.getContextPath()%>/resources/assets/vendor/animate.css/animate.min.css"
   rel="stylesheet">
<link
   href="<%=request.getContextPath()%>/resources/assets/vendor/venobox/venobox.css"
   rel="stylesheet">
<link
   href="<%=request.getContextPath()%>/resources/assets/vendor/aos/aos.css"
   rel="stylesheet">

<!-- Template Main CSS File -->
<link
   href="<%=request.getContextPath()%>/resources/assets/css/style.css"
   rel="stylesheet">
<link
   href="<%=request.getContextPath()%>/resources/assets/css/board.css"
   rel="stylesheet">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/bb29575d31.js"></script>
<title>장애인편의시설알리미</title>
</head>
<style>
.container #title {
   text-align: center;
   padding: 10px;
}

.container #map {
   margin: 0 auto;
   width: 90%;
   height: 500px;
}

.container #buttons {
   padding: 10px 60px;
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
               <li class="drop-down"><a
                  href="http://localhost:8033/stuckyi/trans/transmain">교통시설</a>
                  <ul>
                     <li><a href="http://localhost:8033/stuckyi/trans/submain">지하철</a></li>
                     <li class="drop-down"><a
                        href="http://localhost:8033/stuckyi/trans/taxireserve">콜택시</a>
                        <ul>
                           <li><a
                              href="http://localhost:8033/stuckyi/trans/transmain">콜택시
                                 정보</a></li>
                           <li><a
                              href="http://localhost:8033/stuckyi/trans/taxireserve">콜택시
                                 예약</a></li>
                        </ul></li>
                  </ul></li>
               <li><a href="http://localhost:8033/stuckyi/tour/tourmain">관광시설</a></li>
               <li class="drop-down"><a
                  href="http://localhost:8033/stuckyi/clinic/clinicmain">병원시설</a>
                  <ul>
                     <li><a
                        href="http://localhost:8033/stuckyi/clinic/clinicmain">병원
                           편의시설 찾기</a></li>
                     <li><a
                        href="http://localhost:8033/stuckyi/clinic/clinicreserve">병원
                           예약하기</a></li>
                  </ul></li>
               <li><sec:authorize access="isAuthenticated()">
                     <div class="login-register-cart-button d-flex align-items-center">
                        <div class="login-register-btn mr-50">
                           <sec:authentication property="principal.username" var="user_id" />
                           <a href="http://localhost:8033/stuckyi/main/mypage">${user_id }
                              님</a>

                        </div>
                     </div>
                  </sec:authorize></li>
               <li class="logoutBtn"><sec:authorize
                     access="isAuthenticated()">
                     <div class="login-register-cart-button d-flex align-items-center">
                        <div class="login-register-btn mr-50">
                           <sec:authentication property="principal.username" var="user_id" />

                           <form action="${pageContext.request.contextPath }/main/logout"
                              method='post'>
                              <input type="hidden" name="${_csrf.parameterName }"
                                 value="${_csrf.token }" />
                              <button id="zzzz" class="btn btn-outline-info" type="submit">로그아웃</button>
                           </form>
                        </div>
                     </div>
                  </sec:authorize> <sec:authorize access="isAnonymous()">
                     <!-- Login/Register & Cart Button -->
                     <div class="login-register-cart-button d-flex align-items-center">
                        <!-- Login/Register -->
                        <div class="login-register-btn mr-50">
                           <a href="<%=request.getContextPath()%>/main/login"
                              id="loginBtn" class="btn btn-outline-info custom"
                              type="button">로그인</a>
                        </div>
                     </div>
                  </sec:authorize></li>


            </ul>
         </nav>
         <!-- .nav-menu -->

      </div>
   </header>
   <!-- End Header -->

   <main id="main">


      <!-- ======= About Us Section ======= -->
      <section id="about" class="about">
         <div class="container">

            <h2 id="title">역 편의시설 찾기</h2>
            <script
               src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

            <div id="map" style="width: 50%; height: 350px;"></div>

            <script type="text/javascript"
               src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c391516a386c40148a51ae48a3479f77&libraries=services"></script>
            <div id="buttons" style="padding-bottom: 30px;">
               <input class="btn btn-outline-info" class="form-label" type="text"
                  id="STATION" style="margin: 0px 0px 0px 275px;"
                  placeholder="예) 개포동">
               <button class="btn btn-outline-info" type="button" id="btn_search">역
                  명 검색</button>
               <br> <br>
               <button class="btn btn-outline-info" type="button" id="btn_load"
                  style="margin: 0px 0px 0px 275px;">역 목록 가져오기</button>
               <button class="btn btn-outline-info" type="button" id="btn_remove"
                  style="margin: 0 50px;">지우기</button>
               <br>


               <!-- 테이블 생성 -->
               <br> <br>
               <div>
                  <table id="subXML"></table>
               </div>

               <!-- 테이블 생성 -->

               <div id="loadbutton">
                  <button type="button" id="load" class='btn btn-outline-info'>더보기</button>
               </div>
            </div>
            <script>
var sublist = [];
var trID = [];

// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
      mapOption = {
         center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
         level: 6 // 지도의 확대 레벨
      };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 
var api_key = "6b6766505531303233327a4c434e43";

   $(document).ready(function(){
      $("#load").hide();
      $("#btn_search").click(function() {
      $("tr").hide();
            for (var i = 0; i < sublist.length; i++) {
            if (sublist[i].indexOf($("#STATION").val()) != -1) {
               $("#a" + trID[i]).show();
               $("#thead").show();
            }
         }
          mapSearch();
   });

     $("#btn_load").click(function() {
        // XML 
      var req_url = "http://openapi.seoul.go.kr:8088/" + api_key + "/xml/subwayTourInfo/1/50";
 
         $("#load").show();
         $.ajax({
            url : req_url,
            type : "GET",
            cache : false,
            success : function(data, status) {
               if (status == "success") parseXML(data);
           }
         });
      });

            $("#btn_remove").click(function() {
             $("#subXML").html("");
         });
   });
        
   
function parseXML(xmlDOM) {
   var cnt =0;
   var table = "<tr id='thead'><th style='width:20%;'>노선명칭</th><th style='width:30%'>역명칭</th><th style='width:50%'>전화번호</th></tr>";
   $(xmlDOM).find("row").each(function(){
     table += "<tr style='display: none;' id='a"+ cnt + "'>";
      table += "<td><div id='subname' onclick=\"location.href='subinfo?NO=" + $(this).find('NO').text() + "'\">" + $(this).find('STATION').text() + "</div></td>";
      table += "<td>" + $(this).find("LINE_NAME").text() + "</td>";
      table += "<td>" + $(this).find("TELNO_INFO").text() + "</td>";
      table += "</tr>";
      sublist.push($(this).find("STATION").text());
      trID.push(cnt);
      cnt++;
      });
      $("#subXML").html(table);
      $("tr:hidden").slice(0,10).show();
   } 
   
//더보기 버튼
$(function() {
   $("#load").click(function(e) {
      e.preventDefault();
      $("tr:hidden").slice(0, 10).show();
      if ($("tr:hidden").length == 0) {
         alert("불러올데이터가없습니다.");
      }
   });
});
   

   function mapSearch(){
      var ps = new kakao.maps.services.Places(); 

      var keyword_place = document.getElementsByTagName('input')[0].value;

      // 키워드로 장소를 검색합니다
      ps.keywordSearch(keyword_place, placesSearchCB); 
   }
   
   // 키워드 검색 완료 시 호출되는 콜백함수 입니다
   function placesSearchCB (data, status, pagination) {
      if (status === kakao.maps.services.Status.OK) {

         // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
         // LatLngBounds 객체에 좌표를 추가합니다
         var bounds = new kakao.maps.LatLngBounds();

         for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
         }       

         // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
         map.setBounds(bounds);
      } 
   }
   
// 지도에 마커를 표시하는 함수입니다
   function displayMarker(place) {
      
      // 마커를 생성하고 지도에 표시합니다
      var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(place.y, place.x) 
      });

      // 마커에 클릭이벤트를 등록합니다
      kakao.maps.event.addListener(marker, 'click', function() {
            // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
      infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
      infowindow.open(map, marker);
      });
   }
      </script>
   </div>
   
   <script>
   function delSession(){
      session.invalidate();
      response.sendRedirect("http://localhost:8033/stuckyi/main/home");
      </script>
      </section>
      <div class="clear"></div>


      <!-- ======= Counts Section ======= -->
      <section id="quick" class="counts section-bg">
         <div class="container">

            <div class="row">

               <div class="col-lg-3 col-md-6 text-center" data-aos="fade-up">
                  <div class="count-box">
                     <a href="http://localhost:8033/stuckyi/main/welfareMain"> <img
                        src="https://img.icons8.com/dusk/64/000000/welfare.png" />
                        <p>복지시설 바로가기</p>
                     </a>
                  </div>
               </div>

               <div class="col-lg-3 col-md-6 text-center" data-aos="fade-up"
                  data-aos-delay="200">
                  <div class="count-box">
                     <a href="#"> <img
                        src="https://img.icons8.com/clouds/64/000000/subway.png" />
                        <p>교통 바로가기</p>
                     </a>
                  </div>
               </div>

               <div class="col-lg-3 col-md-6 text-center" data-aos="fade-up"
                  data-aos-delay="400">
                  <div class="count-box">
                     <a href="#"> <img
                        src="https://img.icons8.com/color/64/000000/tour-guide.png" />
                        <p>관광지 바로가기</p>
                     </a>
                  </div>
               </div>

               <div class="col-lg-3 col-md-6 text-center" data-aos="fade-up"
                  data-aos-delay="600">
                  <div class="count-box">
                     <a href="#"> <img
                        src="https://img.icons8.com/clouds/64/000000/ambulance.png" />
                        <p>병원 바로가기</p>
                     </a>
                  </div>
               </div>

            </div>

         </div>
      </section>
      <!-- End Counts Section -->

      <!-- ======= Footer ======= -->
      <footer id="footer">
         <div class="footer-top">
            <div class="container">
               <div class="row">

                  <div class="col-lg-5 col-md-6 footer-info">
                     <div class="social-links mt-3">
                        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a> <a
                           href="#" class="facebook"><i class="bx bxl-facebook"></i></a> <a
                           href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
                        <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
                        <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
                     </div>
                  </div>

                  <div class="col-lg-2 col-md-6 footer-links">
                     <h4>Useful Links</h4>
                     <ul>
                        <li><i class="bx bx-chevron-right"></i> <a
                           href="http://localhost:8033/stuckyi/board/list">건의사항</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a
                           href="http://localhost:8033/stuckyi/main/welfareMain">복지시설</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a
                           href="http://localhost:8033/stuckyi/trans/transmain">교통시설</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a
                           href="http://localhost:8033/stuckyi/tour/tourmain">관광시설</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a
                           href="http://localhost:8033/stuckyi/clinic/clinicmain">병원시설</a></li>
                     </ul>
                  </div>


                  <div class="col-lg-5 col-md-6 footer-info">
                     <h3>장애인편의시설</h3>
                     <p>
                        서울특별시 강남구 역삼동 736-7 <br> 서비스업신고 : 2020-서울강남-0082호 <strong>Phone:</strong>
                        02-111-2222<br> <strong>Email:</strong> abcd123@naver.com<br>
                     </p>
                  </div>

               </div>
            </div>
         </div>

         <div class="container">
            <div class="copyright">
               &copy; Copyright <strong><span>STUCKYI</span></strong>. All Rights
               Reserved
            </div>
            <div class="credits">
               <!-- All the links in the footer should remain intact. -->
               <!-- You can delete the links only if you purchased the pro version. -->
               <!-- Licensing information: https://bootstrapmade.com/license/ -->
               <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/mamba-one-page-bootstrap-template-free/ -->
               Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
            </div>
         </div>
      </footer>
      <!-- End Footer -->

      <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

      <!-- Vendor JS Files -->
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/jquery/jquery.min.js"></script>
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/php-email-form/validate.js"></script>
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/jquery-sticky/jquery.sticky.js"></script>
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/venobox/venobox.min.js"></script>
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/waypoints/jquery.waypoints.min.js"></script>
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/counterup/counterup.min.js"></script>
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
      <script
         src="<%=request.getContextPath()%>/resources/assets/vendor/aos/aos.js"></script>

      <!-- Template Main JS File -->
      <script
         src="<%=request.getContextPath()%>/resources/assets/js/main.js"></script>
</body>

</html>