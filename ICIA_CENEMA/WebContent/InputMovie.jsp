<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/main.css" />


</head>
<body>

 <%@include file= "Include.jsp"%>  
<!-- 영화 등록 -->
<form action="InputMovie_Cnt" method="post" enctype="multipart/form-data">
영화제목 : <input type ="text" name ="movieSubject"required><br>
평점 : <input type ="text" name ="grade"required><br>
감독 : <input type = "text" name ="director"required><br>
관람 등급 : <input type = "text" name ="filmRatings"required><br>
상영 시간 : <input type = "text" name ="showTimes"required><br>
개봉일 : <input type = "date" name ="releaseDate"required><br>
출연진 : <input type = "text" name ="castMembers"required><br>
줄거리 : <textarea style="width:40%; height:400px;  resize:none;" name = "movieContents" required>
</textarea><br>
포스터 : <input type ="file" name="poster"><br>
예고편 : <input type ="text" name="trailer">

<input type = "submit" value="작성">
<input type = "reset" value ="초기화"><br>
</form>

	 <%@include file="IncludeFooter.jsp"%>
</body>
</html>