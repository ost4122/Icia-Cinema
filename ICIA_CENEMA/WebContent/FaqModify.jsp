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

<!-- 자주찾는 질문 글 수정 -->
<body>
<h1 align="center"> 자주찾는질문 </h1>
<h3 align="center">회원님들께서 가장 자주하시는 질문을 모았습니다.</h3>
<h3 align="center">궁금하신 내용에 대해 검색해보세요.</h3>

<form action="faqModifyProcess" method="post">
<table border="1" align="center" width="500">
<tr>
   <td>글번호</td> 
   <td><input type="text" value="${modifyView.faqNumber}" 
         name="faqNumber" readonly></td>
</tr>
<tr>
   <td>글쓴이</td> 
   <td><input type="text" value="${modifyView.faqWriter}" 
         name="faqWriter" readonly></td>
</tr>
<tr>         
   <td>제목</td>
   <td><input type="text" value="${modifyView.faqSubject}"
         name="faqSubject"></td>
</tr>
<tr>   
   <td>첨부파일</td>
   <td><input type="file" name="faqFile"></td>        
</tr>  
<tr>
  <td>내용</td>
  <td><input type="text" value="${modifyView.faqContents}"
         id="contents" name="faqContents"></td>
</tr>          
<tr> 
  <td colspan="2" align="center">              
  <input type="submit" value="수정"></td> 
</tr>  
</table>
</form>


</body>
</html>