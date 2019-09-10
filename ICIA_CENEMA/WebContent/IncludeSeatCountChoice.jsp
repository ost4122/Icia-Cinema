<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"
uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${seatCountChoice==1}">
    1명
    <input type="radio" name="seatCount" checked="checked" id="1" value="1" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=1'">
<label for="1">
    </label>
    2명
    <input type="radio" name="seatCount" id="2" value="2" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=2'">
<label for="2">
    </label>
    3명
    <input type="radio" name="seatCount" id="3" value="3" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=3'">
<label for="3">
    </label>
    4명
    <input type="radio" name="seatCount" id="4" value="4" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=4'">
<label for="4">
    </label>
    5명
    <input type="radio" name="seatCount" id="5" value="5" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=5'">
<label for="5">
    </label>
</c:if>

<c:if test="${seatCountChoice==2}">
    1명
    <input type="radio" name="seatCount" id="1" value="1" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=1'">
<label for="1">
    </label>
    2명
    <input type="radio" name="seatCount" checked="checked" id="2" value="2" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=2'">
<label for="2">
    </label>
    3명
    <input type="radio" name="seatCount" id="3" value="3" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=3'">
<label for="3">
    </label>
    4명
    <input type="radio" name="seatCount" id="4" value="4" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=4'">
<label for="4">
    </label>
    5명
    <input type="radio" name="seatCount" id="5" value="5" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=5'">
<label for="5">
    </label>
</c:if>

<c:if test="${seatCountChoice==3}">
    1명
    <input type="radio" name="seatCount" id="1" value="1" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=1'">
<label for="1">
    </label>
    2명
    <input type="radio" name="seatCount" id="2" value="2" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=2'">
<label for="2">
    </label>
    3명
    <input type="radio" name="seatCount" checked="checked" id="3" value="3" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=3'">
<label for="3">
    </label>
    4명
    <input type="radio" name="seatCount" id="4" value="4" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=4'">
<label for="4">
    </label>
    5명
    <input type="radio" name="seatCount" id="5" value="5" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=5'">
<label for="5">
    </label>
</c:if>

<c:if test="${seatCountChoice==4}">
    1명
    <input type="radio" name="seatCount" id="1" value="1" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=1'">
<label for="1">
    </label>
    2명
    <input type="radio" name="seatCount" id="2" value="2" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=2'">
<label for="2">
    </label>
    3명
    <input type="radio" name="seatCount" id="3" value="3" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=3'">
<label for="3">
    </label>
    4명
    <input type="radio" name="seatCount" checked="checked" id="4" value="4" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=4'">
<label for="4">
    </label>
    5명
    <input type="radio" name="seatCount" id="5" value="5" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=5'">
<label for="5">
    </label>
</c:if>

<c:if test="${seatCountChoice==5}">
    1명
    <input type="radio" name="seatCount" id="1" value="1" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=1'">
<label for="1">
    </label>
    2명
    <input type="radio" name="seatCount" id="2" value="2" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=2'">
<label for="2">
    </label>
    3명
    <input type="radio" name="seatCount" id="3" value="3" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=3'">
<label for="3">
    </label>
    4명
    <input type="radio" name="seatCount" checked="checked" id="4" value="4" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=4'">
<label for="4">
    </label>
    5명
    <input type="radio" name="seatCount" checked="checked" id="5" value="5" onclick="location.href='Ticketing_Cnt?movieTheater=${requestScope.movieTheater}&movieSubject=${requestScope.movieSubject}&showDate=${requestScope.showDate}&showTime=${requestScope.showTime}&seatCountChoice=5'">
<label for="5">
    </label>
</c:if>

</body>
</html>