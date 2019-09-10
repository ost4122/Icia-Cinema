<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/main.css" />
<style>

</style>
</head>
<body>
<div class="div_likeList">
<c:forEach items="${likeList }" var ="likeList">
<p class="fa fa-thumbs-o-up"> ${likeList.nickName}</p><hr>

</c:forEach>
</div>
</body>
</html>