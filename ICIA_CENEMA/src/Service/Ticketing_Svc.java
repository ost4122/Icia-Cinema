package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Dao.MovieDAO;
import Dto.TicketDTO;

public class Ticketing_Svc {

	public ArrayList<TicketDTO> movieSubject(String movieSubject) {
		
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		ArrayList<TicketDTO> list = movieDAO.movieSubject(movieSubject);
	
		close(con);
		return list;		
	}

	
	public ArrayList<TicketDTO> movieTheater(String movieTheater,String movieSubject) {
		
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		ArrayList<TicketDTO> list = movieDAO.movieTheater(movieTheater, movieSubject);
	
		close(con);
		return list;
	}

	
	public ArrayList<TicketDTO> showDate(String showDate,String movieSubject,String movieTheater) {
		
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		ArrayList<TicketDTO> list = movieDAO.showDate(showDate,movieSubject,movieTheater);
	
		close(con);
		return list;
	}

	
	
	public ArrayList<TicketDTO> showTime(String showDate, String movieSubject, String movieTheater, String showTime) {
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		ArrayList<TicketDTO> list = movieDAO.showTime(showDate,movieSubject,movieTheater,showTime);
		
		close(con);
		return list;
	}

	
	
	public int seatCount(String showDate, String movieSubject, String movieTheater, String showTime) {
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		int count = movieDAO.seatcount(showDate, movieSubject, movieTheater, showTime);
		
		close(con);
		return count;
	}


	public ArrayList<TicketDTO> ticketingSeatNum(String showDate, String movieSubject, String movieTheater, String showTime) {
		
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		ArrayList<TicketDTO> ticketingSeatNum = movieDAO.ticketingSeatNum(showDate, movieSubject, movieTheater, showTime);
		
		close(con);
		return ticketingSeatNum;
	}





	public int ticketingLast(String movieSubject, String movieTheater, String showDate, String showTime,String[] ticketingSeat, String sessionId) {
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		int result = movieDAO.ticketingLast(movieSubject,movieTheater,showDate,showTime,ticketingSeat,sessionId);
		
		if(result==1) {
			commit(con);
		}
		
		close(con);
		return result;
		
	}


	public ArrayList<TicketDTO> movieSubjectList() {
		
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		ArrayList<TicketDTO> movieSubjectList = movieDAO.movieSubjectList();
		
		close(con);
		return movieSubjectList;
	}


	public ArrayList<TicketDTO> ticketHistory(String sessionId) {
		
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		ArrayList<TicketDTO> ticketHistory = movieDAO.ticketHistory(sessionId);
		
		close(con);
		return ticketHistory;
	}


	public boolean inputShow(String movieSubject, String movieTheater, String showDate, String showTime) {
		
		MovieDAO movieDAO = MovieDAO.getInstance();
		Connection con = getConnection();
		movieDAO.setConnection(con);
		
		boolean result=false;
		int test=movieDAO.inputShow(movieSubject, movieTheater, showDate, showTime);
				
		if(test==1) {
			result=true;
			commit(con);
		}else {
			result=false;
		}
		close(con);
		return result;
	}

}
