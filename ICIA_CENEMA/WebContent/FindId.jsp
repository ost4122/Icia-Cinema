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
        
        
   	 function phoneCheck(){
         var exp=/^\d{3}-\d{4}-\d{4}$/; //010-9999-9999 형식의 문자배열식을 exp의 선언 (/^\시작이라는표현, d는 숫자, $정규식의 끝)
         var phone = document.getElementById("phone"); //폰이라는 변수를 선언하면서 바디안의 폰의함수를 호출
         var phoneCheck =document.getElementById("phoneCheck");//폰체크라는 함수를 선언하면서 바디안의 함수체크호출

         if(phone.value.match(exp)){      //phone 에 대한변수의 값을 match(형식에 맞는)exp(정규식)값이어야함
             phoneCheck.style.color="green";
             phoneCheck.innerHTML="유요한 전화번호 형식";//phoneCheck 에 대한변수의 값을 match(형식에 맞는)exp(정규식)값이어야함

         } else{
             phoneCheck.style.color="red";
             phoneCheck.innerHTML="유요한 전화번호 형식이 아닙니다";

         }
     }
        
        
        
      
  
     
   </script>
    
</head>
<body onload="pValue()">
<div id="wrap">
    <br>
    <b><font size="4" color="gray">아이디찾기</font></b>
    <hr size="1" width="460">
    <br>
    <div id="chk">
        <form id="IDFind" action="IDFind" method="post">
            <input type="text" class="form-control" name="name" placeholder="Name" id="name"  required><br>
            
            <input id ="birth" class="form-control" type="date" placeholder="Birth Date" name="birth"required><br>
            
        <input id ="phone" class="form-control" type="text" placeholder="Phone Number(-포합)" name="phone" required
                              onkeyup="phoneCheck();"><br><span id="phoneCheck"></span>
       
       
       
        <div id="msg"></div>
        <br>    
         <input type="submit" value="찾기"  >
        <input id="cancelBtn" type="button" value="취소" onclick="window.close()" >
        
         </form>
    
    
    </div>
</div>    
</body>
</html>
	

