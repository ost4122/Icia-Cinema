package Dao;

import static Db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dto.TicketDTO;

public class MovieDAO {
	private static MovieDAO movieDAO;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public static MovieDAO getInstance() {
		if(movieDAO == null) {
			movieDAO = new MovieDAO();
		}
		return movieDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	
//	제목 검색으로 영화관 검색
	public ArrayList<TicketDTO> movieSubject(String movieSubject) {
		
		String sql = "SELECT DISTINCT MOVIETHEATER FROM TICKETING WHERE MOVIESUBJECT=?";
		 		
		ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
		TicketDTO ticketDTO=null;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movieSubject);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
			do{
				ticketDTO = new TicketDTO();
				ticketDTO.setMovieTheater(rs.getString("MOVIETHEATER"));
				list.add(ticketDTO);
			}while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("티켓팅 영화관 불러오기 오류!!");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	
//	영화관으로 영화날짜 검색
	public ArrayList<TicketDTO> movieTheater(String movieTheater, String movieSubject) {
		String sql = "SELECT DISTINCT SHOWDATE FROM TICKETING WHERE MOVIETHEATER=? AND MOVIESUBJECT=?";
 		
		ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
		TicketDTO ticketDTO=null;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movieTheater);
			pstmt.setString(2, movieSubject);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
			do{
				ticketDTO = new TicketDTO();		
				ticketDTO.setShowDate(rs.getString("SHOWDATE"));
				list.add(ticketDTO);
			}while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("티켓팅 날짜  불러오기 오류!!");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	
	
//	영화 날짜로 영화 시간 검색
	public ArrayList<TicketDTO> showDate(String showDate, String movieSubject, String movieTheater) {
	String sql = "SELECT DISTINCT SHOWTIME FROM TICKETING WHERE MOVIETHEATER=? AND MOVIESUBJECT=? AND SHOWDATE=?";
	
		ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
		TicketDTO ticketDTO=null;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movieTheater);
			pstmt.setString(2, movieSubject);
			pstmt.setString(3, showDate);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
			do{
				ticketDTO = new TicketDTO();
				ticketDTO.setShowTime(rs.getString("SHOWTIME"));
				list.add(ticketDTO);
				
			}while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("티켓팅 시간  불러오기 오류!!");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	
	
//영화 시간 으로 남은 좌석검색
	public ArrayList<TicketDTO> showTime(String showDate, String movieSubject, String movieTheater, String showTime) {
		String sql = "SELECT DISTINCT SEATCHECK FROM TICKETING WHERE MOVIETHEATER=? AND MOVIESUBJECT=? AND SHOWDATE=? AND SHOWTIME=?";
		
			ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
			TicketDTO ticketDTO=null;
			
			try {
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, movieTheater);
				pstmt.setString(2, movieSubject);
				pstmt.setString(3, showDate);
				pstmt.setString(4, showTime);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					
				do{
					ticketDTO = new TicketDTO();
					
					ticketDTO.setSeatCheck(rs.getString("SEATCHECK"));
					
					list.add(ticketDTO);
					
				}while(rs.next());
				}
			} catch (Exception e) {
				System.out.println("티켓팅 좌석  불러오기 오류!!");
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			return list;
		}
	
	
	
	public int seatcount(String showDate, String movieSubject, String movieTheater, String showTime) {
		
		String sql = "SELECT COUNT(*) FROM TICKETING WHERE SHOWDATE=? AND MOVIESUBJECT=? AND MOVIETHEATER=? AND SHOWTIME=? AND SEATCHECK='1'";
		int result=0;
try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, showDate);
			pstmt.setString(2, movieSubject);
			pstmt.setString(3, movieTheater);
			pstmt.setString(4, showTime);
			rs = pstmt.executeQuery();
			System.out.println("--------------------");
			System.out.println(showDate);
			System.out.println(movieSubject);
			System.out.println(movieTheater);
			System.out.println(showTime);
			System.out.println("--------------------");
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("예약된 자리 갯수  불러오기 오류!!");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public ArrayList<TicketDTO> ticketingSeatNum(String showDate, String movieSubject, String movieTheater, String showTime) {
		String sql = "SELECT SEATNUM,SEATNUMCHECK,ALLSEAT FROM TICKETING WHERE SHOWDATE=? AND MOVIESUBJECT=? AND MOVIETHEATER=? AND SHOWTIME=?";
		
		ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
		TicketDTO ticketDTO=null;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, showDate);
			pstmt.setString(2, movieSubject);
			pstmt.setString(3, movieTheater);
			pstmt.setString(4, showTime);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
			do{
				ticketDTO = new TicketDTO();
				
				ticketDTO.setSeatNum(rs.getString("SEATNUM"));
				ticketDTO.setSeatNumCheck(rs.getString("SEATNUMCHECK"));
				ticketDTO.setAllSeat(rs.getString("ALLSEAT"));
				
				
				list.add(ticketDTO);
				
			}while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("예약된 좌석  불러오기 오류!!");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	
	
	
	

	public int ticketingLast(String movieSubject, String movieTheater, String showDate, String showTime,String[] ticketingSeat, String sessionId) {
	String sql = "UPDATE TICKETING SET SEATCHECK='1', SEATNUM=?, SEATNUMCHECK=?, HISTORYDATE=SYSDATE, TICKETNUM=TICKET_SEQ.NEXTVAL, LOGINID=?  WHERE MOVIESUBJECT=? AND SHOWDATE=? AND SHOWTIME=? AND MOVIETHEATER=? AND ALLSEAT=?";
		
	int result=0;
	if(ticketingSeat==null) {
		result=0;
	}else {
		for(int i=0; i<ticketingSeat.length; i++) {
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, ticketingSeat[i]);
			pstmt.setString(2, ticketingSeat[i]);	
			pstmt.setString(3, sessionId);
			pstmt.setString(4, movieSubject);
			pstmt.setString(5, showDate);
			pstmt.setString(6, showTime);
			pstmt.setString(7, movieTheater);
			pstmt.setString(8, ticketingSeat[i]);
			
			System.out.println( "-------------------------------");
			System.out.println( ticketingSeat[i]);
			System.out.println( ticketingSeat[i]);
			System.out.println( movieSubject);
			System.out.println( showDate);
			System.out.println( showTime);
			System.out.println( movieTheater);
			System.out.println( ticketingSeat[i]);
			System.out.println( "-------------------------------");
			
			result = pstmt.executeUpdate();
			System.out.println("twetasdasdf : "+result);
			
		} catch (Exception e) {
			System.out.println("영화 예매 오류!!");
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
	}
	}
		return result;
	}

	public ArrayList<TicketDTO> movieSubjectList() {
		String sql = "SELECT DISTINCT MOVIESUBJECT FROM TICKETING";
		
		ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
		TicketDTO ticketDTO=null;
		
		try {
			
			pstmt = con.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
			do{
				ticketDTO = new TicketDTO();
				
				ticketDTO.setMovieSubject(rs.getString("MOVIESUBJECT"));
				
				list.add(ticketDTO);
				
			}while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("영화제목  불러오기 오류!!");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public ArrayList<TicketDTO> ticketHistory(String sessionId) {
		
		String sql = "SELECT * FROM TICKETING WHERE LOGINID=?";
				
		ArrayList<TicketDTO> list = new ArrayList<TicketDTO>();
		TicketDTO ticketDTO=null;
		
			try {
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, sessionId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
				do{
					ticketDTO = new TicketDTO();
					
					ticketDTO.setMovieSubject(rs.getString("MOVIESUBJECT"));
					ticketDTO.setShowDate(rs.getString("SHOWDATE"));
					ticketDTO.setShowTime(rs.getString("SHOWTIME"));
					ticketDTO.setSeatNum(rs.getString("SEATNUM"));
					ticketDTO.setMovieTheater(rs.getString("MOVIETHEATER"));
					ticketDTO.setTicketNum(rs.getInt("TICKETNUM"));
					ticketDTO.setHistoryDate(rs.getString("HISTORYDATE"));
					list.add(ticketDTO);
					
				}while(rs.next());
				}
			} catch (Exception e) {
				System.out.println("예매내역  불러오기 오류!!");
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			return list;
		}

	
	
	public int inputShow(String movieSubject, String movieTheater, String showDate, String showTime) {
		
		String sql = "INSERT INTO TICKETING VALUES(?,?,?,'0','A0','0',?,?,'','','')";
		
		int result=0;
		String str="";
		
		for(int j=1; j<6; j++) {
			if(j==1) {
				str="A";
			}else if(j==2) {
				str="B";
			}else if(j==3) {
				str="C";
			}else if(j==4) {
				str="D";
			}else if(j==5) {
				str="E";
			}
		
		for(int i=1; i<11; i++) {
			try {
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, movieSubject);
				pstmt.setString(2, showDate);			
				pstmt.setString(3, showTime);
				pstmt.setString(4, movieTheater);
				pstmt.setString(5, str+i);
				
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("영화 등록 오류!!");
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
		}}
			return result;
		}


}
