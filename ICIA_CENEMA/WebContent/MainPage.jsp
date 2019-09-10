<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="assets/css/main.css?" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<style>
a {
	text-decoration: none;
}

.card {
	transform-style: preserve-3d;
	transition: 0.7s;
}

.face {
	width: 100%;
	height: 100%;
	line-height: 50px;
	backface-visibility: hidden;
}

.back {
	z-index: 1;
	transform: rotateY(180deg);
}

.List>div:hover>.card {
	-webkit-transform: rotateY(150deg);
	-moz-transform: rotateY(150deg);
	-ms-transform: rotateY(150deg);
	-o-transform: rotateY(150deg);
	transform: rotateY(150deg);
}

.List:hover .front {
	/*   z-index: 0; */
	
}

.${
movieList
}
{
padding
:
 
2
em
 
2
em
 
0
.1em
 
2
em
;

		
border-style
:
 
solid
;

		
border-width
:
 
1
px
;
/*margin-left: -1px;
		margin-top: -1px;*/

		
text-align
:center
;

	
}
#title {
	text-align: center;
	font-size: 150%;
}

.feature>a {
	text-align: center;
}
.back {
	position:absolute;
	top:0;
	padding: 25px;
    line-height: 10px;
    letter-spacing: 2px;
}
}
</style>

<title>ICIA Movie</title>
</head>

<%@include file="Include.jsp"%>
<hr>
<div id="title">
	<h1>현재 상영중인 영화</h1>
	<hr>
</div>

<!-- <div class="features"> -->
<div class="List" style="position:relative; left: 6%;">
	<c:forEach items="${movieList }" var="movieList">
		<div class="feature">
			<h3>${movieList.movieSubject }</h3>
			<div class="card" style="position: relative;">
				<!-- 앞면 -->
				<div class="face front">
					<img src="moviePoster/${movieList.poster }" width="340px"
						height="450px">
				</div>
				<!-- 뒷면  -->
				<div class="face back">
					<h1>줄거리</h1>
					<h2>${movieList.movieContents }</h2>
					<hr>
					
				</div>
			</div>
			<p>감독 : ${movieList.director }</p>
			<c:set var="star" value="${movieList.grade}" />

			<c:choose>
				<c:when test="${star >= 9}">
					<p>${movieList.grade}★★★★☆</p>
					<!-- 	<img src="images/grade_img.png" alt="star"> -->
				</c:when>
				<c:when test="${star >= 7}">
					<p>${movieList.grade}★★★☆☆</p>
					<!--< img src="images/grade_img.png" alt="star"> -->
				</c:when>
				<c:when test="${star >= 5}">
					<p>${movieList.grade}★★☆☆☆</p>
					<!--<img src="images/grade_img.png" alt="star"> -->
				</c:when>
				<c:when test="${star >= 3}">
					<p>${movieList.grade}★☆☆☆☆</p>
					<!-- 	<img src="images/grade_img.png" alt="star"> -->
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${movieList.filmRatings <= 0  }">
					<p>관람등급 : 전체이용가</p>
				</c:when>
				<c:when test="${movieList.filmRatings > 0  }">
					<p>관람등급 : ${movieList.filmRatings }세</p>
				</c:when>
			</c:choose>
			<p>상영시간 : ${movieList.showTimes }분</p>

			<a href="MovieInformation_Cnt?movieNumber=${movieList.movieNumber }">상세보기</a>
			<a href="TicketingStart_Cnt">예매하기</a>
			<hr>
		</div>
	</c:forEach>
</div>
<!-- </div> -->




	 <%@include file="IncludeFooter.jsp"%>

</body>
</html>