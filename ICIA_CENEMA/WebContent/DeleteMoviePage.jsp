<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="assets/css/main.css?ver=1" /> 
 <style>
 #deleteMovie{
 background-color:red;
 }
 </style>
</head>
<body>
 <%@include file= "Include.jsp"%>  
<form action="DeleteMovie_Cnt" method="post">
<c:forEach  items="${movieList }" var="movieList" >
<input type="checkbox" value=${movieList.movieNumber } name="deleteMovie" id="${movieList }">
	<label for="${movieList}">
	
<img src="moviePoster/${movieList.poster }"
	width="340px" height="450px">
	</label>
</c:forEach>
<input type="submit" value="삭제">
</form>
	 <%@include file="IncludeFooter.jsp"%>
</body>
</html>