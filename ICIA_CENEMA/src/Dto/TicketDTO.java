package Dto;

import java.util.ArrayList;

import Controller.TicketingSeat_Cnt;
import Service.Ticketing_Svc;

public class TicketDTO {

	public String movieSubject;
	public String showDate;
	public String showTime;
	public String seatCheck;
	public String seatNum;
	public String seatNumCheck;
	public String allSeat;
	public String movieTheater;
	public int seatCount;
	public int seatCount2;//좌석이 0인것을 빼기위한 필드
	public int ticketNum;
	public String historyDate;
	public String checkbox;
	public String checkbox1;

	
	public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public String getCheckbox1() {
		return checkbox1;
	}
	public void setCheckbox1(String checkbox1) {
		this.checkbox1 = checkbox1;
	}
	public int getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	public String getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}
	public String getSeatNumCheck() {
	return seatNumCheck;
	}
	public void setSeatNumCheck(String seatNumCheck) {
		this.seatNumCheck = seatNumCheck;
	}
	public int getSeatCount2() {
		return seatCount2;
	}
	public String getAllSeat() {
		return allSeat;
	}
	public void setAllSeat(String allSeat) {
		this.allSeat = allSeat;
	}
	public void setSeatCount2(int seatCount2) {
		seatCount2=seatCount-1;
		this.seatCount2 = seatCount2;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	public String getMovieSubject() {
		return movieSubject;
	}
	public void setMovieSubject(String movieSubject) {
		this.movieSubject = movieSubject;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getSeatCheck() {
		return seatCheck;
	}
	public void setSeatCheck(String seatCheck) {
		this.seatCheck = seatCheck;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public String getMovieTheater() {
		return movieTheater;
	}
	public void setMovieTheater(String movieTheater) {
		this.movieTheater = movieTheater;
	}
}
	
	
	