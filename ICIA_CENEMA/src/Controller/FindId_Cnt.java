package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.FindId_Svc
;

@WebServlet("/IDFind")
public class FindId_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FindId_Cnt() {
    
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	
    	
    	String name= request.getParameter("name");
    	System.out.println(name);
    	String birth =request.getParameter("birth");
    	System.out.println(birth);
    	String phone = request.getParameter("phone");
    	System.out.println(phone);
    	
    	FindId_Svc idFindservice = new FindId_Svc();
    	
    	String email;
    	
    	email=idFindservice.idFindDB(name,birth,phone);
    	
    	if(email!=null) {
    		System.out.println("email:"+email); 
    		response.setContentType("text/html; charset=UTF-8");
    		PrintWriter out1 = response.getWriter();
    		out1.println("<script>");
    		out1.println("alert('아이디는"+email+"입니다')");
    		out1.println("window.close();</script>");
    		//out1.println("location.href='FindId.jsp'</script>");
    		
    		out1.close();
    		
    	}else {
    		
    		response.setContentType("text/html; charset=UTF-8");
    		PrintWriter out1 = response.getWriter();
    		out1.println("<script>alert('일치하는 정보가 없습니다.')");
    		out1.println("history.back();</script>");
    		
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
