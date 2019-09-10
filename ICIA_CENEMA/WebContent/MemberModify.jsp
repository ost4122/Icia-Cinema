<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    function check1() {
	var pass = document.getElementById("pass").value; //pass라는 함수선언하면서 우변에 값을 호출
	var pass1 = document.getElementById("pass1").value;//pass1라는 함수선언하면서 우변에 값을 호출

	if (pass == pass1) {
		document.getElementById("fuck").innerHTML = "일치합니다" //innerHTML을 사용하므로써 비밀번호가 같으면 일치라고쓰기
	} else {
		document.getElementById("fuck").innerHTML = "비밀번호가일치하지 않습니다" //innerHTML을 사용하므로써 비밀번호가 틀렸을경우 다시입력하라는 문구뜨게하기
	}

}


</script>

</head>
<body>
<%@include file= "Include.jsp"%>  
<form action = "memberModify2" method="post">

아이디:<input type="email" name="email" value="${modify.email}" readonly><br>
닉네임:<input type="text" name="nickname" value="${modify.nickname}" readonly> <br>
이름 :<input type="text" name="name" value="${modify.name}" > <br>
비밀번호:<input type="password" id="pass" name="password" value="${modify.password}"><br>
비밀번화재확인:<input type="password" id="pass1" name="password" onkeyup="check1()" value = "${modify.password}"><br>
<span id="fuck"></span><br> 
생일:<input type="date" name="birth" value="${modify.birth}"><br>
핸드폰:<input type="text" name="phone" value="${modify.phone}"readonly><br>

<input type="submit" value="수정완료 ">
</form>

	 <%@include file="IncludeFooter.jsp"%>
</body>
</html>