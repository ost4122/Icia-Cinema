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
<style>
#contents{
width:80%;
height:400px;
}
</style>

	
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

<!-- 자주찾는 질문 글 자세히 보기 -->
<body>
<h1 align="center"> 자주찾는질문 </h1>
<h3 align="center">회원님들께서 가장 자주하시는 질문을 모았습니다.</h3>
<h3 align="center">궁금하신 내용에 대해 검색해보세요.</h3>

<table border="1" style="width:60%; position:relative; left: 230px;">
<tr>
  <td>글번호</td>
  <td>${viewResult.faqNumber}</td>
</tr>
<tr>
  <td>작성자</td>
  <td>${viewResult.faqWriter}</td>
</tr>
<tr>
  <td>제목</td>
  <td>${viewResult.faqSubject}</td>
</tr>
<tr>
  <td>내용</td>
  <td id="contents">${viewResult.faqContents}
  <img alt="" src="D:/dev/jsp/MovieReservation/WebContent/fileUpload"></td>
</tr>
<tr>
  <td>날짜</td>
  <td>${viewResult.faqDate}</td>
</tr> 
<tr>
  <td>조회수</td>
  <td>${viewResult.faqHit}</td>
</tr> 
<tr>
  <td colspan="2" align="right">
      <button id=listbtn>목록으로</button>
  </td>
</tr>      
</table> 

<table border="1" style="width:15%; position:relative; left: 230px;">    
  <tr>
    <c:choose>
    <c:when test="${sessionScope.id == 'admin' || sessionScope.id == viewResult.faqWriter}">
    <td colspan="2" align="center">
    <a href="faqModify?faqNumber=${viewResult.faqNumber}">수정</a>
    </td>
    <td colspan="2" align="center">
    <a href="faqDelete?faqNumber=${viewResult.faqNumber}">삭제</a>
    </td></c:when>
    <c:otherwise>
    </c:otherwise>
    </c:choose>
  </tr>
</table>     
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