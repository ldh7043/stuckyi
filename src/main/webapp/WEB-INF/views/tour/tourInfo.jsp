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
#tourshow {
   font-size: 17px;
   margin: 0px auto;
   line-height: 40px;
   width: 450px;
}

#tourimage{
    width: 300px;
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


      
      <!-- ======= About Us Section ======= -->
      <section id="about" class="about">
         <div class="tourContainer">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<div id="row">
   <div><p id="tourshow"></p></div>
</div>
<script>
   var api_key = "52665a66483130323733486a667346";

    $(document).ready(function(){
       // XML
        var url = "http://openapi.seoul.go.kr:8088/" + api_key + "/xml/touristSpotInfo/1/100/" + <%=(String)request.getParameter("SEQ") %>;
        console.log(url);

        $.ajax({
            url : url,
            type : "GET",
            cache : false,
            success : function(data, status){
                if(status == "success") parseXML(data);
            }
        });        
    });
    
    function parseXML(xmlDOM) {
        var cnt = 0;
        $(xmlDOM).find("row").each(function(){
            document.getElementById("tourshow").innerHTML = 
               "<img src=" + $(this).find("IMAGES").text() + " id=" + "tourimage>" +
               "<br> 관광지이름 : " + $(this).find("SISULNAME").text() +
               "<br> 주소 : " + $(this).find("ADDR").text() + 
               "<br> 연락처 : " + $(this).find("TEL").text() + 
               "<br> 홈페이지 : " + "<a href=" + $(this).find("HOMEPAGE").text() + ">" + $(this).find("HOMEPAGE").text() + "</a>" + 
               "<hr>" +
               " 주출입구 접근로 여부 : " + $(this).find("ST1").text() + 
               "<br> 장애인 전용 주차구역 여부: " + $(this).find("ST2").text() + 
               "<br> 주출입구 높이차이 제거 여부: " + $(this).find("ST3").text() + 
               "<br> 장애인용 승강기 여부: " + $(this).find("ST4").text() + 
               "<br> 장애인 화장실 여부: " + $(this).find("ST5").text() + 
               "<br> 장애인용 객실 이용가능 여부: " + $(this).find("ST6").text() + 
               "<br> 장애인용 관람석 이용가능 여부: " + $(this).find("ST7").text() + 
               "<br> 장애인 매표소 여부: " + $(this).find("ST8").text() + 
               "<br> 시각장애인 편의서비스 여부: " + $(this).find("ST9").text() + 
               "<br> 청각장애인 편의서비스 여부: " + $(this).find("ST10").text() + 
               "<br> 안내 서비스 여부: " + $(this).find("ST11").text() + 
               "<br> 휠체어 대여 여부: " + $(this).find("ST12").text()
               ;
               
        });
        $("#tourXML").html(table);
    }   
    
</script>
  </div>
      </section>
      <!-- End About Us Section -->
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
  <script src="<%= request.getContextPath() %>/resources/assets/js/homeBoard.js"></script>

</body>

</html>