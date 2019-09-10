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

<!-- 게시판 글 수정 -->
<body>
<h1 align="center"> 공지/뉴스 </h1>
<h3 align="center">CGV의 주요한 이슈 및 여러가지 소식들을 확인하실 수 있습니다.</h3>

<form action="noticeModifyProcess" method="post">
<table border="1" align="center" width="500">
<tr>
   <td>글번호</td> 
   <td><input type="text" value="${modifyView.noticeNumber}" 
         name="noticeNumber" readonly></td>
</tr>
<tr>
   <td>글쓴이</td> 
   <td><input type="text" value="${modifyView.noticeWriter}" 
         name="noticeWriter" readonly></td>
</tr>
<tr>         
   <td>제목</td>
   <td><input type="text" value="${modifyView.noticeSubject}"
         name="noticeSubject"></td>
</tr>
<tr>   
   <td>첨부파일</td>
   <td><input type="file" name="noticeFile"></td>        
</tr>  
<tr>
  <td>내용</td>
  <td><input type="text" value="${modifyView.noticeContents}"
         id="contents" name="noticeContents"></td>
</tr>          
<tr> 
  <td colspan="2" align="center">              
  <input type="submit" value="수정"></td> 
</tr>  
</table>
</form>


</body>
</html>