<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<header>
		<!-- 상단 로그인바 -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<c:choose>
		<c:when test="${sessionScope.sessionId == null}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Login <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="Login.jsp">Login</a></li>
					</ul>
				</li>
				</ul>
		</c:when>
		<c:when test="${sessionScope.sessionId != null}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> ${sessionScope.sessionId }님 환영합니다 <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="memberView?nickname=${sessionScope.sessionId}">My page</a></li>
						<li><a href="logout">Log Out</a></li>
		</ul>
		</li>

		</ul>
		</c:when>
		
		</c:choose>

		<!-- Banner -->
		<section id="banner">
			<a href="MovieList_Cnt?choice=0">
				<h2>
					ICIA <strong>cinema</strong>
				</h2>
			</a>

		</section>
	</div>
	</header>

	
<head>
	
		
		<title>ICIA Movie</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	 	<link rel="stylesheet" href="assets/css/LoginBar.css" /> 
	 	<link rel="stylesheet" href="assets/css/checkBox.css" /> 
	 	
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="assets/js/MenuToggle.js"></script>
</head>
<style>
.box{
    background-color: white;
    border: none;
}
 
.box_main{
    display: inline-block;
    width: 33%;
    height: 250px;
    border: 2px solid black;
    font-size: 25px;
    text-align: center;
    padding : 50px;
}


</style>






<script>
$(document).ready(function(){
	$("#Mainbtn").click(function(){
		location.href='CustomerCenter.jsp';
	});
	$("#Noticebtn").click(function(){
		location.href='noticeList';
	});
	$("#Faqbtn").click(function(){
		location.href='faqList';
	});
	$("#Emailbtn").click(function(){
		location.href='MailForm.jsp';
	});
	
});
</script>
	
<body>

<div class="container">
		<!-- MenuButton -->
		<a class="menu-toggle rounded"  href="#"> <h3>&#9776;</h3>
		</a>
		<nav id="sidebar-wrapper" class="active">
		
			<ul class="sidebar-nav">
				 <li class="sidebar-brand">
			        <a class="js-scroll-trigger" href="#page-top"></a>
			    </li> 
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="MovieList_Cnt?choice=0">Main</a></li>
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="Ticketing_Cnt">영화 예매</a></li>
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="noticeList">공지사항</a></li>
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="faqList">Q/A</a></li>
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="CustomerCenter.jsp">고객센터</a></li>
				
				<!-- admin계정 전용 -->
				<c:if test="${sessionScope.sessionId=='admin'}">
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="InputMovie.jsp">영화 등록</a></li>
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="MovieList_Cnt?choice=1">영화 삭제</a></li>
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="MovieList_Cnt?choice=2">상영시간 등록</a></li>
					 </c:if>
		</nav>
		

<br><br>
	<h1 align="center"> 고객센터 </h1>
	<h3 align="center"> ICIA 영화관 입니다. </h3>

<br><br><hr><br><br>





 
<div class="box">
    <div class="box_1 box_main" id="menubar"
          style="cursor: pointer;" onclick="location.href='noticeList'">
          <span style='font-size:70px;'>&#128227;</span><br>         
                   공지사항<br>
         <h4>공지사항을 확인하세요.</h4>         
          </div>
    <div class="box_2 box_main"
          style="cursor: pointer; " onclick="location.href='faqList'">
          <span style='font-size:70px;'>&#128269;</span><br>
             FAQ<br>
           <h4>자주 찾는 질문</h4>       
                    </div>
    <div class="box_3 box_main"
          style="cursor: pointer; " onclick="location.href='MailForm.jsp'">
          <span style='font-size:70px;'>&#128233;</span><br>
                     이메일 문의 <br>
          <h4>24시간 언제든지 문의주세요</h4>
                     </div>
</div>















		
</div>
	
	

		<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
	<script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/coming-sssoon.js" type="text/javascript"></script>
	
		 <%@include file="IncludeFooter.jsp"%>
</body>
</html>