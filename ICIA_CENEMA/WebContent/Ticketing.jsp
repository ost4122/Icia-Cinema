<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	<%@include file="Include.jsp"%>
	
	<br>		
<h1 align="center"> 영화 예매 </h1>
<h5 align="right">*환불이 불가합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5>
<hr>
	
<!-- 영화제목 선택 -->
<table border="1" style="width: 80%; text-align: center;  margin: auto; margin-top:30px;">
		<tr>
			<td>영화제목</td> 
			<td>영화관</td>
			<td>영화 상영 날짜</td>
			<td>영화 상영 시간</td>
			
		</tr>
		
<tr>
<td>
	<c:forEach var="movieSubjectList" items="${movieSubjectList}">  <!-- TicketingStart_Cnt를 통해 jsp로 들어온 방법 -->
	<br>
		<button name="movieSubject" value="${movieSubjectList.movieSubject}" style="margin:1px;" onclick="location.href='Ticketing_Cnt?movieSubject=${movieSubjectList.movieSubject}'">
		${movieSubjectList.movieSubject}</button>
		
	</c:forEach>
<br><br>


<!-- 영화관선택 -->
<td>
	<c:forEach var="movieTheaterList" items="${movieTheaterList}">
	<br>
	<button name="movieTheater" value="${movieTheaterList.movieTheater}" style="margin:1px;" onclick="location.href='Ticketing_Cnt?movieTheater=${movieTheaterList.movieTheater }&movieSubject=${requestScope.movieSubject }'">
	${movieTheaterList.movieTheater }</button>
	</c:forEach>
	<br><br>
</td>

<!-- 날짜선택 -->
<td>
	<c:forEach var="showDateList" items="${showDateList}">
	<br>
	<button name="showDate" value="${showDateList.showDate}" style="margin:1px;" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${showDateList.showDate}'">
	${showDateList.showDate }</button>
	</c:forEach>
	<br><br>
</td>

<!-- 시간선택 -->
<td>
	<c:forEach var="showTimeList" items="${showTimeList}">
	<br>
	<button name="showTime" value="${showTimeList.showTime}" style="margin:1px;" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${showTimeList.showTime}'">
	${showTimeList.showTime }</button>
	</c:forEach>
	<br><br>
</td></tr>
</table>
<div style="float: left; margin-left: 39%;">
<c:if test="${requestScope.movieSubject!=null}">
<br>
<button>${requestScope.movieSubject}</button>
</c:if>

<c:if test="${requestScope.movieTheater!=null}">
<button>${requestScope.movieTheater}</button>
</c:if>

<c:if test="${requestScope.showDate!=null}">
<button>${requestScope.showDate}</button>
</c:if>

<c:if test="${requestScope.showTime!=null}">
<button>${requestScope.showTime}</button>
</c:if>
<br><br>
</div>

<!-- 남은좌석 예약 -->
<table border="1" style="width: 80%; text-align: center;  margin: auto; margin-top:20px;">
<tr>
<td>예매인원</td>
</tr>
<tr><td>
	<c:forEach var="seatCountList" items="${seatCountList}">
	<c:if test="${seatCountList.seatCount>0}">
	<button>
	${seatCountList.seatCount}/50  석 남음.</button> 
	인원수 선택: 
		<c:forEach var="i" begin="1" end="5" step="1">
		<c:if test="${seatCountChoice==null}">
	${i}명
  	  <input type="radio" name="seatCount" id="A${i}" value="${i}" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=${i}'">
  	  <label for="A${i}">
   	 </label>
	</c:if>
    </c:forEach>
<%@include file="IncludeSeatCountChoice.jsp"%>
</c:if>
</c:forEach>
</td>
</tr>
</table>
<br>
<input type="button" value="예매하기"  style="float: right; margin-right: 47.5%; margin-top:15px;"
onclick="location.href='ticketingSeat?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCount=${requestScope.seatCountChoice}&seatCountCheck=${seatCountCheck}&seatCountChoice=${requestScope.seatCountChoice}'">



<br><br><br><br><br>
	 <%@include file="IncludeFooter.jsp"%>

</body>
</html>


