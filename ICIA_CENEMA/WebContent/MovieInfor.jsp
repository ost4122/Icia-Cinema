<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" href="assets/css/main.css" /> -->
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<link rel="stylesheet" href="assets/css/main.css" />
<style>
	.movieInfor{
	text-align:center;
	}

</style>


</head>
<body>
<%@include file="Include.jsp"%>



<div class="features">
	<div class="movieInfor" id="${movieInfor }">
<h1>${movieInfor.movieSubject }</h1><br>
감독 : ${movieInfor.director }<br>
출연진 : ${movieInfor.castMembers }<br>
<hr>
  <img src="moviePoster/${movieInfor.poster }" width="340px" height="450px">
  

<br>

<c:choose>
					<c:when test="${movieInfor.grade >= 9.5}">
					<p>★★★★★ ${movieInfor.grade}</p>
					<!-- 	<img src="images/grade_img.png" alt="star"> -->
					</c:when>
					<c:when test="${movieInfor.grade >= 9}">
					<p>★★★★☆ ${movieInfor.grade}</p>
					<!-- 	<img src="images/grade_img.png" alt="star"> -->
					</c:when>
					<c:when test="${movieInfor.grade >= 7}">
					<p> ★★★☆☆ ${movieInfor.grade}</p>	
						<!-- <img src="images/grade_img.png" alt="star"> -->
					</c:when>
					<c:when test="${movieInfor.grade >= 5}">
					<p>★★☆☆☆ ${movieInfor.grade}</p>
						<!--<img src="images/grade_img.png" alt="star"> -->
					</c:when>
					<c:when test="${movieInfor.grade >= 3}">
					<p>★☆☆☆☆ ${movieInfor.grade}</p>
					<!-- 	<img src="images/grade_img.png" alt="star"> -->
					</c:when>
				</c:choose>
<c:choose>
			<c:when test="${movieInfor.filmRatings <= 0  }">
			<p>관람등급 : 전체이용가</p>
			</c:when>
			<c:when test="${movieInfor.filmRatings > 0  }">
			<p>관람등급 : ${movieInfor.filmRatings }세</p>
			</c:when>
		</c:choose>
상영시간 : ${movieInfor.showTimes}분<br>
개봉일 : ${movieInfor.releaseDate }<br>
<hr>
<h1>줄거리</h1>
${movieInfor.movieContents}<br>
<hr>

 <h1>예고편</h1>
<iframe width="560" height="315" src="${movieInfor.trailer }" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>


<c:choose>

<c:when test="${sessionScope.sessionId != null }">
<form action="WriteComment_Cnt" method="post" id="comment">
<input type ="hidden" value="${movieInfor.movieNumber }" name="movieNumber">
<input type ="hidden" value="${sessionScope.sessionId }" name="sessionId">
<div class="textArea">
<input type="text" placeholder="댓글을 입력하세요" width="550" name="comment_content">
<input type="submit" value ="[댓글등록]">
</div>
</form>
</c:when>

<c:when test="${sessionScope.sessionId == null}">
<input type="text" value="로그인후 댓글이용이 가능합니다" disabled>
</c:when>

</c:choose>

<c:choose>

<c:when test ="${not empty commentList}">
<table>
<tr>
<td>작성자</td>
<td>내용</td>
<td>작성날짜</td>
<td>좋아요</td>
</tr>
<c:forEach items="${commentList }" var="commentList">

<tr>
<td>${commentList.writer }</td>
<td>${commentList.contents }<a class="fa fa-thumbs-o-up" onclick="checkLogin(${commentList.commentNumber});"></a></td>
<td>${commentList.writeDate }</td>
<td>	
<a onclick="likeList(${commentList.commentNumber})">${commentList.commentHit }</a>
		
</td>

</tr>


</c:forEach>
</table>
</c:when>

<c:otherwise>
<input type="text" value="등록된 댓글이 없습니다." disabled>
</c:otherwise>

</c:choose>
<a href="MovieList_Cnt?choice=0">목록으로가기</a>
<script>
function checkLogin(commentNumber){
	if(${sessionScope.sessionId == null}){
		alert('로그인이 필요합니다 !!');
	}else{
		location.href="SelectLike_Cnt?movieNumber=${movieInfor.movieNumber}&cmNumber="+commentNumber;
	}
	
};

function likeList(commentNumber){
 window.open("LikeList_Cnt?cmNumber="+commentNumber,"chkForm", "width=400, height=400");
 };




</script>

</div><!-- feature End -->
</div><!-- features END  -->
	 <%@include file="IncludeFooter.jsp"%>
</body>
</html>