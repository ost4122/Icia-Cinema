package HyunController;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

import javax.mail.*;

import javax.mail.internet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mailSend")
public class MailSendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MailSendController() {
        super();
    }
    
    
    // 메일 보내기 Controller 

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	  
    	String sender = request.getParameter("sender");        //보내는사람
    	String receiver = request.getParameter("receiver");    //받는사람
    	String email = request.getParameter("email");          //이메일
    	String subject = request.getParameter("subject");      //제목
    	String content = request.getParameter("content");      //내용
    	  
    	Properties p = new Properties(); // 정보를 담을 객체
    	  
    	
    	p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.host","smtp.gmail.com");         //구글smtp 이용
		p.put("mail.smtp.auth","true");
		p.put("mail.smtp.port","587");
    	
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();  
    	
    	try{
    	    Authenticator authenticator = new SMTPAuthenticatior();
    	    Session session = Session.getInstance(p, authenticator);
    	      
    	    session.setDebug(true);
    	    MimeMessage msg = new MimeMessage(session); // 메일의 내용을 담을 객체 
    	 
    	    msg.setSubject(subject); //  제목
    	 
    	    StringBuffer buffer = new StringBuffer();
    	    buffer.append("이메일 : ");
    	    buffer.append(email+"<br>");   
    	    buffer.append("제목 : ");
    	    buffer.append(subject+"<br>");
    	    buffer.append("내용 : ");
    	    buffer.append(content+"<br>");
    	    
    	    Address senderAddr = new InternetAddress(sender);
    	    msg.setFrom(senderAddr);                                  //보내는 사람
    	 
    	    Address receiverAddr = new InternetAddress(receiver);
    	    msg.addRecipient(Message.RecipientType.TO, receiverAddr); // 받는 사람
    	     
    	    msg.setContent(buffer.toString(), "text/html;charset=UTF-8"); // 내용
    	    Transport.send(msg); // 전송  
    	    out.println("<script>");
			out.println("alert('메일이 전송 되었습니다.')");
			out.println("location.href='noticeList'</script>");
    	
    	} catch(Exception e){
    		out.println("<script>");
			out.println("alert('메일이 전송 실패하였습니다');");
			out.println("location.href='MailForm.jsp'</script>");
    	    e.printStackTrace();
    	    return;
    	}


    	
    	
    	
    	
    	
    	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
