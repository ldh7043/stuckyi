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
<c:if test = "${not empty errors}">
<script>
alert("${errors}");
</script>
</c:if>
<body>
   <!-- ======= Header ======= -->
   <header id="header">
      <div class="joinContainer">

         <div class="logo float-left">
            <h1 class="text-light">
               <a href="http://localhost:8033/stuckyi/main/home"><span>STUCKYI</span></a>
            </h1>
            <!-- Uncomment below if you prefer to use an image logo -->
            <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
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
                        
                                           
                        <sec:authorize access="isAnonymous()">
                                <!-- Login/Register & Cart Button -->
                                <div class="login-register-cart-button d-flex align-items-center">
                                    <!-- Login/Register -->
                                    <div class="login-register-btn mr-50">
                                        <a href="<%=request.getContextPath() %>/main/login" id="loginBtn" class="btn btn-outline-info" type="button">로그인</a>
                                    </div>
                                </div>
                                </sec:authorize>
                </li>
            
                
               
            </ul>
         </nav>
         <!-- .nav-menu -->

      </div>
   </header>
   <!-- End Header -->
      <!-- ======= About Us Section ======= -->
 <section id="about" class="about">
    <div class="container">
       <div id="joinStuckyiTitle">
       <div style="padding-bottom: 10%;"><h2 style="font-weight: bold;">회원가입</h2></div>
        </div>
      
           <form action="http://localhost:8033/stuckyi/join/joinOk" method="post" name="fr" id="joinForm" onsubmit="return check()">
             <div style="text-align:center; padding-left:5%"><textarea class="checkJoin" id="textbox" style="width:400px; height: 100px;">
약관동의: 수집하는 개인정보의 항목첫째, 회사는 회원가 입, 원활한 고객상담, 각종 서비스의 제공을 위해 최초 회원가입 당시 아래와 같은 최소한의 개인정보를 필수항목으로 수집하고 있습니다. 

나. 개인정보 수집방법회사는 다음과 같은 방법으로 개인정보를 수집합니다. 
   - 홈페이지, 서면양식, 팩스, 전화, 상담 게시판, 이메일, 이벤트 응모, 배송요청 
   - 협력회사로부터의 제공            
   - 생성정보 수집 툴을 통한 수집    
                   </textarea></div>
                   <br>
      <div id="joinStuckyi">
               
                <div style="margin-top:-20%;">      
              <input type="checkbox" checked="checked" name="remember" style="float:right;">
                </div>
                <div style="width:110px; float:right;">동의합니다.</div>
                  
               <br><br>
               
               <table id="joinTable">
               		<tr>
               			<td class="data">아이디</td>
               			<td><input type="text" class="btn btn-outline-info" placeholder="아이디를 입력하세요" name="id" value="${j.id }" required></td><td>
               <button type="button" class="btn btn-outline-info" onclick="confirmId()">중복확인</button></td>
               		</tr>
               		<tr>
               			<td class="data">비밀번호</td>
               			<td><input type="password" class="btn btn-outline-info" placeholder="비밀번호를 입력하세요" style="font-family:sans-serif" name="pw" value="${j.pw }" required></td>
               		</tr>
               		<tr>
               			<td class="data">비밀번호 확인</td>
               			<td><input type="password" class="btn btn-outline-info" placeholder="비밀번호를 입력하세요" style="font-family:sans-serif" name="pw2"  required></td>
               		</tr>
               		<tr>
               			<td class="data">이름</td>
               			<td><input type="text" class="btn btn-outline-info" placeholder="이름을 입력하세요" name="name" value="${j.name }" required></td>
               		</tr>
               		<tr>
               			<td class="data">이메일</td>
               			<td><input type="text" class="btn btn-outline-info" placeholder="이메을 입력하세요" name="email" value="${j.email }"required></td>
               		</tr>
               		<tr>
               			<td class="data">전화번호</td>
               			<td><input type="text" class="btn btn-outline-info" placeholder="전화번호를 입력하세요" name="ph" value="${j.ph }" required></td>
               		</tr>
               		<tr>
               			<td class="data">성별</td>
               			<td><input type="radio" class="btn btn-outline-info" id="male" name="gender" value="male" >
				               <label for="male">남성</label><br>
				               <input type="radio" id="female" name="gender" value="female" >
				               <label for="female">여성</label></td>
               		</tr>
               		<tr>
               			<td><input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/></td>
               		</tr>
               		
               </table>
                
               <div id="button-join">
                  <button class="btn btn-outline-info" type="submit" formmethod="post" class="makeUser">
                  회원가입
                  </button>
               </div>
               </form>
          
        </div>

<script>
   function check(){
      if(document.fr.pw.value != document.fr.pw2.value){
         alert("Password가 서로 다릅니다.")
         return false;
      }
   }
   
   
   function confirmId(){ 
      if(document.fr.id.value == "" || document.fr.id.value.length < 0){
         alert("아이디를 입력해주세요");
         return;
      }
      
      // 회원정보 체크위해 DB에 접근
      url = "confirmId?id=" + document.fr.id.value;
      window.open(url, "confirmId", "width=300, height=200");
      
   }
</script>
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