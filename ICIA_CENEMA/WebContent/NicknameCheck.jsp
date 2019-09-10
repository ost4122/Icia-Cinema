<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>아이디 중복 체크</title>
    
    <style type="text/css">
        #wrap {
            width: 490px;
            text-align :center;
            margin: 0 auto 0 auto;
        }
        
        #chk{
            text-align :center;
        }
        
        #cancelBtn{
            visibility:visible;
        }
        
        #useBtn{
             visibility:visible;
        }
 
   </style>
    
    <script type="text/javascript">
    
        var httpRequest = null;
        
        // httpRequest 객체 생성
        function getXMLHttpRequest(){
            var httpRequest = null;
        
            if(window.ActiveXObject){
                try{
                    httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
                } catch(e) {
                    try{
                        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e2) { httpRequest = null; }
                }
            }
            else if(window.XMLHttpRequest){
                httpRequest = new window.XMLHttpRequest();
            }
            return httpRequest;    
        }
        
        
        // 회원가입창의 아이디 입력란의 값을 가져온다.
        function pValue2(){
            document.getElementById("nickname").value = opener.document.userInfo.nickname.value;
        }
        
  
     
   </script>
    
</head>
<body onload="pValue()">
<div id="wrap">
    <br>
    <b><font size="4" color="gray">닉네임 중복체크</font></b>
    <hr size="1" width="460">
    <br>
    <div id="chk">
        <form id="userInfo" action="nicknameckt" method="post">
            <input type="text" name="nickname" id="nickname" onclick="pValue2();" required>
            <input type="submit" value="중복확인" onclick="idCheck();" >
        </form>
        <div id="msg"></div>
        <br>    
        <input id="cancelBtn" type="button" value="취소" onclick="window.close();" >
        
        
    
    
    </div>
</div>    
</body>
</html>
	
