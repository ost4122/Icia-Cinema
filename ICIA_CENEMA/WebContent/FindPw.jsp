<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>비밀번호 인증보내기 </title>
    
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
        
        

        
      
  
     
   </script>
    
</head>
<body onload="pValue()">
<div id="wrap">
    <br>
    <b><font size="4" color="gray">임시비밀번호 전송하기</font></b>
    <hr size="1" width="460">
    <br>
    <div id="chk">
        <form id="mailSend" action="FindPw" method="post">
            <input type="email" class="form-control" name="receiver" placeholder="Email" id="name"  required><br>
            
            
            
        
       
        <div id="msg"></div>
        <br>    
         <input type="submit" value="보내기"  >
        <input id="cancelBtn" type="button" value="취소" onclick="window.close()" >
        
         </form>
    
    
    </div>
</div>    
</body>
</html>
	