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
<h1 align="center"> 자주찾는질문 </h1>
<h3 align="center">회원님들께서 가장 자주하시는 질문을 모았습니다.</h3>
<h3 align="center">궁금하신 내용에 대해 검색해보세요.</h3>
<br><hr>

<div style="text-align: center;">
<button id=Mainbtn style="  position:relative; left: 0px; display:inline-block;">고객센터 메인</button>
<button id=Noticebtn style="  position:relative; left: 10px; display:inline-block;">공지사항</button>
<button id=Faqbtn style="  position:relative; left: 20px; display:inline-block;">자주 찾는 질문</button>
<button id=Emailbtn style="  position:relative; left: 30px; display:inline-block;">이메일 문의</button>
</div><hr>


<!-- 자주찾는 질문 글 목록 -->
<table border="1" style="width:80%; position:relative; left: 100px;" >
  <tr>
    <td>글번호</td>
    <td>작성자</td>
    <td>글제목</td>
    <td>작성일자</td>
    <td>조회수</td>
  </tr>
 <c:forEach items="${faqList}" var="faq">
 <tr>
    <td>${faq.faqNumber}</td>
    <td>관리자</td>
   <%--  <td>${faq.faqWriter}</td> --%>
    <td>
    <a href="faqView?faqNumber=${faq.faqNumber}&page=${paging.page}">${faq.faqSubject}</a></td>
    <td>${faq.faqDate}</td>
    <td>${faq.faqHit}</td>
  </tr>
 </c:forEach>
 <c:forEach items="${searchList}" var="search">
 <tr>
   <td>${search.faqNumber}</td>
    <td>${search.faqWriter}</td>
    <td>
    <a href="faqView?faqNumber=${search.faqNumber}&page=${paging.page}">${search.faqSubject}</a></td>
    <td>${search.faqDate}</td>
    <td>${search.faqHit}</td>
 </tr>
 </c:forEach>
</table>

<div class="pager" align="center">
  
		<!-- 페이징 처리 -->
		<c:if test="${paging.page<=1}">[이전]&nbsp;</c:if>

		<c:if test="${paging.page>1}">
			<a href="faqList?page=${paging.page-1}">[이전]</a>&nbsp;
        </c:if>

		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
			step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
                ${i}
                </c:when>

				<c:otherwise>
					<a href="faqList?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${paging.page>=paging.maxPage}">[다음]</c:if>

		<c:if test="${paging.page<paging.maxPage}">
			<a href="faqList?page=${paging.page+1}">[다음]</a>
		</c:if>
        <br>
		<a href="faqListOrder">조회수순 정렬</a><br>
</div>	
 

	
	
<!-- 검색창 -->
<form name="faqSearch" method="post" action="faqSearch"
      align="center" >
<select name=searchList style=" width:8%; position:relative; left: 0px; display:inline-block;">
<option value="none">전체목록</option>
<option value="faqSubject">제목</option>

</select>
<input type="text" name="faqSearch" style=" width: 30%; position:relative; left: 0px; display:inline-block;">
<input type="submit" value="검색">
</form>

<!-- 관리자 아이디 admin으로 로그인 했을때만 글쓰기 가능 -->

	<c:if test="${sessionScope.sessionId == 'admin'}" >
<button onclick="location.href='FaqWrite.jsp'">글쓰기</button>
</c:if>
		
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