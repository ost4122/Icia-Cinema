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
				<h2 >
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
<h1 align="center"> 이메일 문의하기 </h1>
<h4 align="center">자주찾는 질문에서 원하는 답변을 찾지 못하셨군요 </h4>
<h4 align="center">불편사항이나 문의사항을 남겨주시면 최대한 신속하게 답변 드리겠습니다.</h4>
<br><hr>

<div style="text-align: center;">
<button id=Mainbtn style="  position:relative; left: 0px; display:inline-block;">고객센터 메인</button>
<button id=Noticebtn style="  position:relative; left: 10px; display:inline-block;">공지사항</button>
<button id=Faqbtn style="  position:relative; left: 20px; display:inline-block;">자주 찾는 질문</button>
<button id=Emailbtn style="  position:relative; left: 30px; display:inline-block;">이메일 문의</button>
</div><hr>


<br>
<form align="center" name="a" action="mailSend" method="post">
이메일 : <input type="text" name="email" style=" width:40%; position:relative; left: 0px; display:inline-block;"><br> <!-- 문의 글 작성자가 입력할 자기 자신 아이디 -->
       <br><br>
제목  : <input type=text name="subject" style=" width:40%; position:relative; left: 0px; display:inline-block;"><br>
       <br><br>
내용  : <textarea name="content" style=" width:40%; height:300px; position:relative; left: 0px; display:inline-block;"></textarea><br>
       <br><br>
<input type="button" value="메일발송" onclick="check()">
<input type="hidden" name="receiver" value="rhdtkwnd56@gmail.com">    <!-- 받는 사람 메일 주소 (관리자) --> 
<input type="hidden" name="sender" value="rhdtkwnd56@gmail.com">      <!-- 보내는 사람 메일 주소 (관리자) -->


</form>
<script> 
 function check() {
    document.a.submit();
}
</script>
		
		
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
