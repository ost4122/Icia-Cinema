package Controller;

import java.io.IOException;
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

/**
 * Servlet implementation class TicketHistory_CTR
 */
@WebServlet("/TicketHistory_Cnt")
public class TicketHistory_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TicketHistory_Cnt() {
        super();
    }
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	HttpSession session = request.getSession();
    	
    	
    	String sessionId = (String)session.getAttribute("sessionId");
    	
    	Ticketing_Svc ticketingSVC = new Ticketing_Svc();
    	
    	
    	ArrayList<TicketDTO> ticketHistory = ticketingSVC.ticketHistory(sessionId);
    	request.setAttribute("ticketHistory", ticketHistory);//영화제목 가져오기.
    
    	RequestDispatcher dispatcher = 
    			request.getRequestDispatcher("TicketHistory.jsp");
    	dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
