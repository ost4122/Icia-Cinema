package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.MemberDTO;
import Service.Login_Svc;

@WebServlet("/Login")
public class Login_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login_Cnt() {
        super();
    }

    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
        String email =request.getParameter("email");
        String password =request.getParameter("password");
        
         
        Login_Svc loginservice = new Login_Svc();
       
        String nickName
        = loginservice.loginDB(email,password);
        
        if (nickName != null) {
			HttpSession session = request.getSession(); 

			session.setAttribute("sessionId",nickName); 
			response.sendRedirect("MovieList_Cnt?choice=0");
			
	} else {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out1 = response.getWriter();
		out1.println("<script>");
		out1.println("alert('아이디 또는 패스워드가 일치하지않습니다.')");
		out1.println("history.back();</script>");
	}
        
        
    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
