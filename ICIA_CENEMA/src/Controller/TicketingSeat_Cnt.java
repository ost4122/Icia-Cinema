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

@WebServlet("/ticketingSeat")
public class TicketingSeat_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TicketingSeat_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	
	String movieSubject = request.getParameter("movieSubject");//영화이름
	String movieTheater = request.getParameter("movieTheater");//영화관
	String showDate = request.getParameter("showDate");//영화날짜
	String showTime = request.getParameter("showTime");//영화시간
	String seatCount =request.getParameter("seatCount");//남은자리
	String seatCountCheck =request.getParameter("seatCountCheck");
	String seatCountChoice =request.getParameter("seatCount");
	
	
	HttpSession session = request.getSession();
	
	String sessionId = (String)session.getAttribute("sessionId");
	
	
	Ticketing_Svc TicketingSVC = new Ticketing_Svc();
	
	
	ArrayList<TicketDTO> seatNumCheck=TicketingSVC.ticketingSeatNum(showDate, movieSubject, movieTheater, showTime);
	
	request.setAttribute("seatNumCheck", seatNumCheck);
	request.setAttribute("movieSubject", movieSubject);
	request.setAttribute("movieTheater", movieTheater);
	request.setAttribute("showDate", showDate);
	request.setAttribute("showTime", showTime);
	request.setAttribute("seatCount", seatCount);
	request.setAttribute("seatCountCheck", seatCountCheck);
	
	System.out.println("예약좌석리스트:"+seatNumCheck);
	System.out.println("예매된 좌석 카운트 :"+seatCountCheck);
	
	System.out.println("safsf:"+seatCountChoice);
	
	PrintWriter out = response.getWriter();
	
	if(movieSubject=="") {
		out.println("<script>");
		out.println("alert('영화를 선택하세요.')");
		out.println("history.back();</script>");
	}
	else if(movieTheater=="") {
		out.println("<script>");
		out.println("alert('영화관을 선택하세요.')");
		out.println("history.back();</script>");
	}
	else if(showDate=="") {
		out.println("<script>");
		out.println("alert('날짜를 선택하세요.')");
		out.println("history.back();</script>");
	}
	else if(showTime=="") {
		out.println("<script>");
		out.println("alert('시간을 선택하세요.')");
		out.println("history.back();</script>");
	}
	else if(seatCountChoice=="") {
		out.println("<script>");
		out.println("alert('인원수를 선택하세요.')");
		out.println("history.back();</script>");
	}
	else if(sessionId==null) {
	out.println("<script>");
	out.println("alert('로그인이 필요합니다.')");
	out.println("history.back();</script>");
	}
	
	else {
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("TicketingSeat.jsp");
		dispatcher.forward(request, response);
		
	}
	

}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
