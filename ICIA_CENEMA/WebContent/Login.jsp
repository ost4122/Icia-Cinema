<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login/Register Modal by Creative Tim</title>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">


	<style>body{padding-top: 60px;}</style>

    <link href="assets/css/bootstrap.css" rel="stylesheet">

	<link href="assets/css/login-register.css" rel="stylesheet">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

	<script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.js" type="text/javascript"></script>
	<script src="assets/js/login-register.js" type="text/javascript"></script>

<script>
	/* 	성태야 이건 비밀번호 중복부분이야!! */
	function check1() {
		var pass = document.getElementById("pass").value; //pass라는 함수선언하면서 우변에 값을 호출
		var pass1 = document.getElementById("pass1").value;//pass1라는 함수선언하면서 우변에 값을 호출

		if (pass == pass1) {
			document.getElementById("fuck").innerHTML = "일치합니다" //innerHTML을 사용하므로써 비밀번호가 같으면 일치라고쓰기
		} else {
			document.getElementById("fuck").innerHTML = "비밀번호가일치하지 않습니다" //innerHTML을 사용하므로써 비밀번호가 틀렸을경우 다시입력하라는 문구뜨게하기
		}

	}

	/* 성태야 이건 핸드폰이야~! */

	function phoneCheck() {
		var exp = /^\d{3}-\d{4}-\d{4}$/; //010-9999-9999 형식의 문자배열식을 exp의 선언 (/^\시작이라는표현, d는 숫자, $정규식의 끝)
		var phone = document.getElementById("phone"); //폰이라는 변수를 선언하면서 바디안의 폰의함수를 호출
		var phoneCheck = document.getElementById("phoneCheck");//폰체크라는 함수를 선언하면서 바디안의 함수체크호출

		if (phone.value.match(exp)) { //phone 에 대한변수의 값을 match(형식에 맞는)exp(정규식)값이어야함
			phoneCheck.style.color = "green";
			phoneCheck.innerHTML = "유요한 전화번호 형식";//phoneCheck 에 대한변수의 값을 match(형식에 맞는)exp(정규식)값이어야함

		} else {
			phoneCheck.style.color = "red";
			phoneCheck.innerHTML = "유요한 전화번호 형식이 아닙니다";

		}
	}

	/* 성태야 이건 회원가입창에서 중복확인버튼부분이야! */
	function openIdChk() {
		var email = document.getElementById("email1").value;
		console.log(email + "메롱메롱멜에");
		if (!email) {
			alert("아이디를 입력하지 않았습니다.");
		} else {
			//location.href="Emailcheck_Ctn?email="+email; 

			window.name = "parentForm";
			window.open("IdCheck.jsp?email=" + email, "chkForm",
					"width=500, height=300, resizable = no, scrollbars = no");

		}
		/* checkFormEmailcheck_Ctn */
	}

	/* 	/성태야 이건 닉네임 중복확인버튼이야!! */
	function openNicknameChk() {
		var nickname = document.getElementById("nickname1").value;
		console.log(nickname + "메롱메롱멜에");
		if (!nickname) {
			alert("닉네임을 입력하세요!");
		} else {

			window.name = "parentForm";
			window.open("NicknameCheck.jsp?nickname=", "chkForm",
					"width=500, height=300, resizable = no, scrollbars = no");

		}
	}

	/* 성태야 ID찾기 */
	function IDFind() {

		window.name = "parentForm";
		window.open("FindId.jsp", "chkForm",
				"width=500, height=300, resizable = no, scrollbars = no");

	}

	/* 성태야 이건 비밀번호찾기 */

	function PassFind() {

		window.name = "parentForm";
		window.open("FindPw.jsp", "chkForm",
				"width=500, height=300, resizable = no, scrollbars = no");

	}

	/* 성태야 비밀번호찾기 */

	function PasswordFing() {

		window.name = "parentForm";
		window.open("IDFind.jsp", "chkForm",
				"width=500, height=300, resizable = no, scrollbars = no");

	}
</script>








</head>
<body class="" style="">
	<div class="container">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<a class="btn big-login" data-toggle="modal"
					href="javascript:void(0)" onclick="openLoginModal();"style="padding-left:72px; padding-right:73px;">Log in</a> 
					<a class="btn big-register" data-toggle="modal"
					href="javascript:void(0)" onclick="openRegisterModal();">Register</a>
			</div>
			<div class="col-sm-4"></div>
		</div>


		<div class="modal fade login" id="loginModal" aria-hidden="true"
			style="display: none;">
			<div class="modal-dialog login animated">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title">Login with</h4>
					</div>
					<div class="modal-body">
						<div class="box">
							<div class="content">
								<div class="social"></div>
								<div class="division">
									<div class="line l"></div>
									<span>or</span>
									<div class="line r"></div>
								</div>
								<div class="error"></div>

								<!-- 성태야 여긴 로그인form창이야  -->

								<div class="form loginBox">
									<form method="post" action="Login" accept-charset="UTF-8">
										<input id="email" class="form-control" type="email"
											placeholder="Email" name="email"> <input
											id="password" class="form-control" type="password"
											placeholder="Password" name="password"> <input
											class="btn btn-default btn-login" type="submit" value="Login">
									</form>
								</div>
							</div>
						</div>
						<div class="box">
							<div class="content registerBox" style="display: none;">
								<div class="form">


									<!-- 성태야 여긴 회원가입form창이야  -->


									<form method="post" html="{:multipart=>true}"
										data-remote="true" action="JoinController"
										accept-charset="UTF-8" name="userInfo"
										onsubmit="return checkValue()">
										
										<input id="email1" class="form-control" type="email"
											placeholder="Email" name="email" onkeydown="inputIdChk()"required">
										
										<input class="form-control" type="button" value="중복확인"
											onclick="openIdChk()">
											
											 <input type="hidden"
											name="idDuplication" value=idUncheck>
											
											 <input
											id="nickname1" class="form-control" type="text"
											placeholder="Nick NAME" name="nickname"required">
											 <input class="form-control" type="button" value="중복확인"
											onclick="openNicknameChk()"> 
											
											<input type="hidden"
											name="idDuplication1" value="idUncheck1">
											 
											 <input
											id="pass" class="form-control" type="password"
											placeholder="Password" name="password" required> 
											
											<input
											id="pass1" class="form-control" type="password" required
											placeholder="Repeat Password" name="password_con"
											onkeyup="check1();">
											<span id="fuck"></span> 
											
											<input
											id="name" class="form-control" type="text" placeholder="Name"
											name="name" required><br> Birth Date 
											
											<input
											id="birth" class="form-control" type="date"
											placeholder="Birth Date" name="birth" required> 
											<input
											id="phone" class="form-control" type="text"
											placeholder="Phone Number(-포합)" name="phone" required
											onkeyup="phoneCheck();">
											<span id="phoneCheck"></span>

										<input class="btn btn-default btn-register" type="submit"
											value="Create account" name="commit">
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="forgot login-footer">
							<span>Looking to <a href="javascript: showRegisterForm();">create
									an account</a>?
							</span><br> <a onclick="IDFind();">ID</a>/ 
							<a onclick="PassFind()">PASSWORD</a>
						</div>
						<div class="forgot register-footer" style="display: none">
							<span>Already have an account?</span> <a
								href="javascript: showLoginForm();">Login</a>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
    $(document).ready(function(){
        openLoginModal();
    });
</script>





</body>
</html>