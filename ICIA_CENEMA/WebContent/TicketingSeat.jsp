<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

	function count_ck(obj) {
		var chkbox = document.getElementsByName("ticketingSeat");
		var chkCnt = 0;
		for (var i = 0; i < chkbox.length; i++) {
			if (chkbox[i].checked) {
				chkCnt++;
			}
		}
		if (chkCnt > ${seatCount+seatCountCheck}) {
			alert("${seatCount}개만 체크가 가능합니다.");
			obj.checked = false;
			return false;
		}
	}
	
	
	
	
</script>
</head>
<body>

	<%@include file="Include.jsp"%>
	<form action="ticketingLast">
	<div style="border:4px dotted #bcbcbc; text-align: center; margin-left:20%; margin-right:20%; margin-top:50px;">
	<div style="border:4px dashed #bcbcbc; text-align: center; margin-left:30%; margin-right:30%; margin-top:50px;">
	<h1>SCREEN</h1>
	</div>
	
<!-- A열 -->
	<div style="width: 90%;  margin: auto; margin-top:150px; margin-bottom:50px; margin-right:5%;">
		<c:forEach var="j" begin="1" end="5" step="1">
		<c:if test="${j==1}">
		<c:forEach var="i" begin="1" end="10" step="1">
	<c:if test="${i<11}">	
			<c:if test="${seatNumCheck[i-1].seatNumCheck!=seatNumCheck[i-1].allSeat}"> 
			
    A${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox${i-1}" value="A${i}" onclick="count_ck(this);">
				<label for="checkbox${i-1}"> </label>
		</c:if>		
	<c:if  test="${seatNumCheck[i-1].seatNumCheck==seatNumCheck[i-1].allSeat}">
    A${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox0${i-1}" value="A${i}" onclick="count_ck(this);" checked="checked" disabled="disabled">
	<label for="checkbox0
	${i-1}"> 
	
	</label>

	</c:if>
	</c:if>
	</c:forEach>
	<br><br>
	</c:if>

	
<!-- B열 -->
	<c:if test="${j==1}">
		<c:forEach var="i" begin="1" end="10" step="1">
	<c:if test="${i<11}">	
			<c:if test="${seatNumCheck[i-1+10].seatNumCheck!=seatNumCheck[i-1+10].allSeat}"> 
			
    B${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox1${i-1}" value="B${i}" onclick="count_ck(this);">
				<label for="checkbox1${i-1}"> </label>
		</c:if>		
	<c:if  test="${seatNumCheck[i-1+10].seatNumCheck==seatNumCheck[i-1+10].allSeat}">
    B${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox01${i-1}" value="B${i}" onclick="count_ck(this);" checked="checked" disabled="disabled">
	<label for="checkbox01${i-1}"> 
	
	</label>

	</c:if>
	</c:if>
	</c:forEach>
	<br><br>
	</c:if>

	
<!-- C열 -->
	<c:if test="${j==1}">
		<c:forEach var="i" begin="1" end="10" step="1">
	<c:if test="${i<11}">	
			<c:if test="${seatNumCheck[i-1+20].seatNumCheck!=seatNumCheck[i-1+20].allSeat}"> 
			
    C${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox2${i-1}" value="C${i}" onclick="count_ck(this);">
				<label for="checkbox2${i-1}"> </label>
		</c:if>		
	<c:if  test="${seatNumCheck[i-1+20].seatNumCheck==seatNumCheck[i-1+20].allSeat}">
    C${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox02${i-1}" value="C${i}" onclick="count_ck(this);" checked="checked" disabled="disabled">
	<label for="checkbox02${i-1}"> 
	
	</label>

	</c:if>
	</c:if>
	</c:forEach>
	<br><br>
	</c:if>

	
<!-- D열 -->
	<c:if test="${j==1}">
		<c:forEach var="i" begin="1" end="10" step="1">
	<c:if test="${i<11}">	
			<c:if test="${seatNumCheck[i-1+30].seatNumCheck!=seatNumCheck[i-1+30].allSeat}"> 
			
    D${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox3${i-1}" value="D${i}" onclick="count_ck(this);">
				<label for="checkbox3${i-1}"> </label>
		</c:if>		
	<c:if  test="${seatNumCheck[i-1+30].seatNumCheck==seatNumCheck[i-1+30].allSeat}">
    D${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox03${i-1}" value="D${i}" onclick="count_ck(this);" checked="checked" disabled="disabled">
	<label for="checkbox03${i-1}"> 
	
	</label>

	</c:if>
	</c:if>
	</c:forEach>
	<br><br>
	</c:if>

	
<!-- E열 -->
	<c:if test="${j==1}">
		<c:forEach var="i" begin="1" end="10" step="1">
	<c:if test="${i<11}">	
			<c:if test="${seatNumCheck[i-1+40].seatNumCheck!=seatNumCheck[i-1+40].allSeat}"> 
			
    E${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox4${i-1}" value="E${i}" onclick="count_ck(this);">
				<label for="checkbox4${i-1}"> </label>
		</c:if>		
	<c:if  test="${seatNumCheck[i-1+40].seatNumCheck==seatNumCheck[i-1+40].allSeat}">
    E${i}
    <input type="checkbox" name="ticketingSeat" id="checkbox04${i-1}" value="E${i}" onclick="count_ck(this);" checked="checked" disabled="disabled">
	<label for="checkbox04${i-1}"> 
	
	</label>

	</c:if>
	</c:if>
	</c:forEach>
	<br><br>
	</c:if>



	</c:forEach>
	</div>
	

	





	</div>
	<br>
		<div style=" border:6px double #bcbcbc;  position:relative; left: 1305px; display:inline-block; padding:3px;">
		<c:forEach var="i" begin="1" end="5" step="1">
			<c:if test= "${seatCount==i}"> 
		<h4>금액 : ${seatCount}명/ ${i}0000원</h4>
	
		</c:if></c:forEach>
		<br> <input type="submit" value="예매하기">
		     <input type="button" value="뒤로가기" onclick="history.back();">
	</div>
	
	
	
	
	
		<input type="hidden" name="movieSubject" value="${requestScope.movieSubject}"> 
		<input type="hidden" name="movieTheater" value="${requestScope.movieTheater}"> 
		<input type="hidden" name="showDate" value="${requestScope.showDate}">
		<input type="hidden" name="showTime" value="${requestScope.showTime}"> <input type="hidden"name="seatCount" value="${requestScope.seatCount}"> 
		<c:forEach var="seatNumCheck" items="${seatNumCheck}">
		<input type="hidden" name="seatNumCheck"value="${seatNumCheck.seatNumCheck}">
		</c:forEach>
	</form>
	 	 <%@include file="IncludeFooter.jsp"%>
</body>
</html>