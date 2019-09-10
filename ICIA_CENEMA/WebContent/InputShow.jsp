<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="Include.jsp"%>

<br><br><br><br><br>
<form action="InputShow_CTR">
<table border="1" style="width: 1400px; text-align: center;  margin: auto;">
<tr>
<td style="width:30%;">영화제목</td>
<td style="width:27%;">영화관</td>
<td style="width:23%;">상영날짜</td>
<td style="width:20%;">상영시간</td>
</tr>
</table>
<br>

<select name="movieSubject" style="position:relative; left: 280px; width:340px; text-align: center; display:inline-block;">
<c:forEach var="movieList" items="${movieList}">
<option value="${movieList.movieSubject }">${movieList.movieSubject}</option>
</c:forEach>
</select>


<input type="text" name="movieTheater" placeholder="영화관을 입력하세요." style=" position:relative; left: 360px; width:320px; display:inline-block;">

<input type="date" name="showDate" style=" position:relative; left: 470px; display:inline-block;">

<input type="time" name="showTime" style=" position:relative; left: 620px; display:inline-block;">
<br><br><hr style="width: 1400px; text-align: center;  margin: auto;">
<br><br>
<div style=" position:relative; left: 1400px; display:inline-block;">
<input type="submit" value="등록하기">
<input type="button" onclick="history.back();" value="뒤로가기">
</div>

</form>
	 <%@include file="IncludeFooter.jsp"%>
</body>
</html>