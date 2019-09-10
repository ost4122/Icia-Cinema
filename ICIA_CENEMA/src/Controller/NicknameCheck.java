package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Login_Svc;

@WebServlet("/nicknameckt")
public class NicknameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NicknameCheck() {
        super();
    }

    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	request.setCharacterEncoding("UTF-8");
    	String nickname = request.getParameter("nickname");
    	
    	
    	Login_Svc loginservice = new Login_Svc();
    	boolean result;
		result=loginservice.nickname(nickname);
		HttpSession session = request.getSession(); 
		
		
		if (result) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out1 = response.getWriter();
			out1.println("<script>");
			out1.println("alert('중복된 닉네임입니다.')");
			out1.println("window.close(); </script>");
			//out1.println("location.href='IdCheckForm.jsp'</script>");

			out1.close();
		}

		else {

			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out1 = response.getWriter();

			out1.println("<script>");
			out1.println("alert('사용가능한 닉네임입니다.')");
			session.setAttribute("nickname", nickname);
			out1.println("window.close(); </script>");
			// response.sendRedirect("LLogin.jsp");
			out1.close();

		}
    
    	
    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
