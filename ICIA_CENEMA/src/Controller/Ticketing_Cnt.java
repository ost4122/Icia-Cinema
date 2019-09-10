package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.TicketDTO;
import Service.Ticketing_Svc;

@WebServlet("/Ticketing_Cnt")
public class Ticketing_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ticketing_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String movieSubject = request.getParameter("movieSubject");//영화이름으로 영화관 검색
    	String movieTheater = request.getParameter("movieTheater");//영화관으로 영화날짜 검색
    	String showDate = request.getParameter("showDate");//영화날짜로 영화시간 검색
    	String showTime = request.getParameter("showTime");//영화시간으로 남은 좌석 검색
    	String seatCountChoice = request.getParameter("seatCountChoice");
    	
    	Ticketing_Svc ticketingSVC = new Ticketing_Svc();
    	TicketDTO ticketDTO = new TicketDTO();
    	
    	request.setAttribute("movieSubject", movieSubject);
    	request.setAttribute("movieTheater", movieTheater);
    	request.setAttribute("showDate", showDate);
    	request.setAttribute("showTime", showTime);
    	
    	ArrayList<TicketDTO> list0 = ticketingSVC.movieSubjectList();
    	request.setAttribute("movieSubjectList", list0);//영화이름으로 영화관 검색
    	
    	ArrayList<TicketDTO> list = ticketingSVC.movieSubject(movieSubject);
    	request.setAttribute("movieTheaterList", list);//영화이름으로 영화관 검색
    	
    	ArrayList<TicketDTO> list2 = ticketingSVC.movieTheater(movieTheater,movieSubject);
    	request.setAttribute("showDateList", list2);//영화관으로 영화날짜 검색
    	
    	ArrayList<TicketDTO> list3 = ticketingSVC.showDate(showDate, movieSubject, movieTheater);
    	request.setAttribute("showTimeList", list3);//영화날짜로 영화시간 검색
    	
    	ArrayList<TicketDTO> list4 = ticketingSVC.showTime(showDate, movieSubject, movieTheater,showTime);
    	request.setAttribute("seatCountList", list4);//영화시간으로 좌석검색
    	
    	
    	int seatCountCheck = ticketingSVC.seatCount(showDate, movieSubject, movieTheater, showTime);
    	int seatCount=0;//전체좌석으로 남은좌석 구하기.
    	
    	if(showTime==null) {
    		seatCount=0;
    	}else {seatCount=51;
    	ticketDTO.setSeatCount(seatCount);
    	}
    	System.out.println("seatCount:"+seatCount);
    	ticketDTO.setSeatCount2(seatCount);
    	seatCount= ticketDTO.seatCount2-seatCountCheck;
    	ticketDTO.setSeatCount(seatCount);
    	System.out.println("전체좌석 ticketDTO.seatCount2 :"+ticketDTO.getSeatCount2());
    	System.out.println("예약된좌석 seatCountCheck :"+seatCountCheck);
    	System.out.println("남은좌석 seatCount :"+seatCount);
    	
    	list4.add(ticketDTO);
    	
    	request.setAttribute("seatCount", list4);//남은좌석 검색
    	request.setAttribute("seatCountChoice", seatCountChoice);
    	request.setAttribute("seatCountCheck", seatCountCheck);
    	System.out.println("예매된 좌석 카운트1 :"+seatCountCheck);
    	
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
