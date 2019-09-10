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

<!-- 자주찾는 질문 글 쓰기 -->
<h1 align="center"> 자주찾는질문 </h1>
<h3 align="center">회원님들께서 가장 자주하시는 질문을 모았습니다.</h3>
<h3 align="center">궁금하신 내용에 대해 검색해보세요.</h3>

<form action="faqWrite" method="post" enctype="multipart/form-data">
<table border="1" align="center" width="500">
<tr>
  <td>제목</td> 
  <td><input type="text" name="faqSubject"></td>
</tr>
<tr>
  <td>작성자 </td> 
  <td><input type="text" name="faqWriter" value="${sessionScope.id}" readonly><td>
</tr>  
<tr>    
  <td>첨부파일</td>  
  <td><input type="file" name="faqFile"></td>
</tr>
<tr>
  <td>내용 </td>
  <td><input id ="contents" type="text" name="faqContents"><td>
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