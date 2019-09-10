package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Join_Svc;
import Controller.GoogleAuthentication;
import Dto.MailDTO;

@WebServlet("/FindPw")
public class FindPw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindPw() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	request.setCharacterEncoding("UTF-8");
    	  
    	
    	
    	int ran = (int) (Math.floor(Math.random() * 10000) + 1000);
    	String sender = "ht090716@gmail.com";
		String receiver = request.getParameter("receiver");
		String subject = "임시비밀번호";
		String content = Integer.toString(ran);
		String content1= "임시비밀번호는 '"+content+"' 입니다.";
		
		//RandomNum andomNum = new RandomNum();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MailDTO mailDTO = new MailDTO();
		mailDTO.setSender(sender);
		mailDTO.setReceiver(receiver);
		mailDTO.setSubject(subject);
		mailDTO.setContent(content);
		
		Join_Svc joinService = new Join_Svc();
		
		boolean result =false;
		result=joinService.mailDB(mailDTO);

		
		try {
			Properties properties = System.getProperties();
			properties.put("mail.smtp.starttls.enable","true");
			properties.put("mail.smtp.host","smtp.gmail.com");
			properties.put("mail.smtp.auth","true");
			properties.put("mail.smtp.port","587");
			Authenticator auth = new GoogleAuthentication();
			Session s = Session.getDefaultInstance(properties, auth);
			//메시지 전송 객체 생성 
			Message message = new MimeMessage(s);
			//송수신 이메일 주소를 위한 객체 생성 
			Address sender_address = new InternetAddress(sender);
			Address receiver_address = new InternetAddress(receiver);
			//mailForm에서 작성한 내용을 message 객체에 담음. 
			message.setHeader("content-type", "text/html;charset=UTF-8");
			message.setFrom(sender_address);
			message.addRecipient(Message.RecipientType.TO, 
								receiver_address);
			message.setSubject(subject);
			message.setContent(content1, "text/html;charset=UTF-8");
			message.setSentDate(new java.util.Date());
			//message 객체를 전송. 
			Transport.send(message);
			out.println("<script>");
			out.println("alert('메일로 보내드린 임시비밀번호로 로그인후 비밀번호 변경해주세요!')");
			out.println("window.close()");
			out.println("location.href='Passmailchk.jsp'</script>");
			out.close();
			

		}catch (Exception e) {
			out.println("SMTP 서버가 잘못 설정되었거나, 서비스에 문제가 있습니다.");
			e.printStackTrace();
		}
    
    
    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
