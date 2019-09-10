package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.TicketDTO;
import Service.Ticketing_Svc;

@WebServlet("/TicketingStart_Cnt")
public class TicketingStart_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TicketingStart_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	HttpSession session = request.getSession();
    	
    	
    	String sessionId = (String)session.getAttribute("sessionId");
    	
    	Ticketing_Svc ticketingSVC = new Ticketing_Svc();
    	
    	
    	ArrayList<TicketDTO> movieSubjectList = ticketingSVC.movieSubjectList();
    	request.setAttribute("movieSubjectList", movieSubjectList);//영화제목 가져오기.
    	
    	PrintWriter out = response.getWriter();
    	
    	
    	if(sessionId!=null) {
    		out.println("<script>");
    		out.println("alert('로그인이 필요합니다.')");
    		out.println("location.href='mainPage.jsp'</script>");
    	}
    System.out.println("movieSubjectList : "+movieSubjectList);
    	
    	RequestDispatcher dispatcher = 
    			request.getRequestDispatcher("Ticketing.jsp");
    	dispatcher.forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
