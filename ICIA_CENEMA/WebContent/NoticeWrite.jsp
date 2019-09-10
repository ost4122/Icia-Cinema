<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#contents{
width:100%;
height:400px;
}
</style>
</head>
<body>

<!-- 게시판 글 쓰기 -->
<h1 align="center"> 공지/뉴스 </h1>
<h3 align="center">CGV의 주요한 이슈 및 여러가지 소식들을 확인하실 수 있습니다.</h3>

<form action="noticeWrite" method="post" enctype="multipart/form-data">
<table border="1" align="center" width="500">
<tr>
  <td>제목</td> 
  <td><input type="text" name="noticeSubject"></td>
</tr>
<tr>
  <td>작성자 </td> 
  <td><input type="text" name="noticeWriter" value="${sessionScope.id}" readonly><td>
</tr>  
<tr>    
  <td>첨부파일</td>  
  <td><input type="file" name="noticeFile"></td>
</tr>
<tr>
  <td>내용 </td>
  <td><input id ="contents" type="text" name="noticeContents"><td>
</tr>
<tr>
  <td colspan="2" align="center">
    <input type = "submit" value="글작성">
    <input type = "reset" value="초기화"></td>      
</tr>
</table>
</form>

</body>
</html>