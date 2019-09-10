<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

/* function modify(){
	location.href='memberModify?name=${memberList.name}';
	

} */

$(document).ready(function(){
	   $("#btn2").click(function(){
		   
		   
	   
	   var passwordConfirm=${memberList.password};
		var text = prompt("비밀번호를 입력하세요."); /* prompt scan같은기능 */
		console.log("password값"+passwordConfirm)//
	   
	   
	   if(passwordConfirm==text){
			alert("회원탈퇴가 정상적으로 완료되었습니다");
			location.href="memberModify?name=${memberList.name}";
	   }else if (text==null){
		}
		else if (passwordConfirm!=text){
			alert("불일치");
			}
		
			
	   });
	});
</script>
	<script>

	$(document).ready(function(){
	   $("#btn1").click(function(){
		   
		   
	   
	   var passwordConfirm=${memberList.password};
		var text = prompt("비밀번호를 입력하세요."); /* prompt scan같은기능 */
		console.log("password값"+passwordConfirm)//
	   
	   
	   if(passwordConfirm==text){
			alert("회원탈퇴가 정상적으로 완료되었습니다");
			location.href="memberDrop?nickname=${memberList.nickname}";
	   }else if (text==null){
		}
		else if (passwordConfirm!=text){
			alert("불일치");
			}
			
	   });
	});




</script>

</head>
<body>
<%@include file= "Include.jsp"%>  
<br><br>
<table border="1" style="width: 80%; text-align: center;  margin: auto;">
<tr>
<td>아이디</td>
<td>닉네임</td>
<td>이름</td>
<td>생일</td>
<td>핸드폰번호</td>
</tr>
<tr>
<td>${memberList.email}</td>
<td>${memberList.nickname}</td>
<td>${memberList.name}</td>
<td>${memberList.birth}</td>
<td>${memberList.phone}</td>
</tr>
</table>
<br>
<button style="position:relative; left: 10%;" onclick="location.href='TicketHistory_Cnt'">예매내역보기</button>

 <button id="btn1" style="position:relative; left: 70%;">회원탈퇴</button> 
<button id="btn2" style="position:relative; left: 71%;">정보수정</button>

 
<br><br><br><br><br>
	 <%@include file="IncludeFooter.jsp"%>
</body>
</html>