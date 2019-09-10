package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Ticketing_Svc;

/**
 * Servlet implementation class TicketingLastCTR
 */
@WebServlet("/ticketingLast")
public class TicketingLast_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TicketingLast_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String movieSubject = request.getParameter("movieSubject");//영화이름
    	String movieTheater = request.getParameter("movieTheater");//영화관
    	String showDate = request.getParameter("showDate");//영화날짜
    	String showTime = request.getParameter("showTime");//영화시간
    	int seatCount = Integer.parseInt(request.getParameter("seatCount"));//예매인원
    	String[] ticketingSeat = request.getParameterValues("ticketingSeat");//예매 좌석번호
    	
    	HttpSession session = request.getSession();
    	
    	String sessionId = (String)session.getAttribute("sessionId");
  
    	
    	System.out.println("seatCount값!!!!:::"+seatCount);
    	Ticketing_Svc ticketingSVC = new Ticketing_Svc();
    	PrintWriter out = response.getWriter();
    	
    	int result =ticketingSVC.ticketingLast(movieSubject, movieTheater, showDate, showTime, ticketingSeat, sessionId);

    	
    	 if(ticketingSeat==null) {
    		 out.println("<script>");
     		out.println("alert('자리를 선택하세요.')");
     		out.println("history.back();</script>");
    	 }
    	else if(seatCount!=ticketingSeat.length) {
    		out.println("<script>");
    		out.println("alert('예매인원에 맞게 선택하세요.')");
			out.println("history.back();</script>");
    	}
    	else if(seatCount==ticketingSeat.length) {
    		
    		if(result==1) {
    		out.println("<script>");
    		out.println("alert('예매가 완료되었습니다.')");
			out.println("location.href='TicketHistory_Cnt'</script>");
    		
    	}else {
    		out.println("<script>");
    		out.println("alert('예매오류.')");
    		out.println("history.back();</script>");
    		
    	}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
