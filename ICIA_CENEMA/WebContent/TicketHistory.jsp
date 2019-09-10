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

<br><br>		
<h1 align="center"> 예매 내역 </h1>

<br><hr>
<table border="1" style="width: 80%; text-align: center;  margin: auto;">
		<tr>
			<td>영화제목</td> 
			<td>영화 상영 날짜</td>
			<td>영화 상영 시간</td>
			<td>영화 예매 좌석</td>
			<td>영화 예매 영화관</td>
			<td>영화 예매 날짜</td>
			<td>영화 티켓 번호</td>
		</tr>
		<c:forEach items="${ticketHistory}" var="ticketHistory">
		<tr>
			<td>${ticketHistory.movieSubject}</td>
			<td>${ticketHistory.showDate}</td>
			<td>${ticketHistory.showTime}</td>
			<td>${ticketHistory.seatNum}</td>
			<td>${ticketHistory.movieTheater}</td>
			<td>${ticketHistory.historyDate}</td>
			<td>${ticketHistory.ticketNum}</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<button id="historyBTN" onclick="location.href='MovieList_Cnt?choice=0'" style="float: right; margin-right: 15%; margin-top:15px;">메인화면</button>
	 <br><br><br><br><br>
	 <%@include file="IncludeFooter.jsp"%>
</body>
</html>