package Dto;

import java.sql.Date;

public class NoticeDTO {
	
	private int noticeNumber;         //게시글 번호
	private String noticeWriter;      //작성자
	private String noticePassword;    //비밀번호
	private String noticeSubject;     //제목
	private String noticeContents;    //내용
	private Date noticeDate;          //작성날짜
	private int noticeHit;            //조회수
	private String noticeFile;        //첨부파일
	private String noticeSearch;      //검색
	
	
	
	public String getNoticeSearch() {
		return noticeSearch;
	}
	public void setNoticeSearch(String noticeSearch) {
		this.noticeSearch = noticeSearch;
	}
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public String getNoticePassword() {
		return noticePassword;
	}
	public void setNoticePassword(String noticePassword) {
		this.noticePassword = noticePassword;
	}
	public String getNoticeSubject() {
		return noticeSubject;
	}
	public void setNoticeSubject(String noticeSubject) {
		this.noticeSubject = noticeSubject;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public int getNoticeHit() {
		return noticeHit;
	}
	public void setNoticeHit(int noticeHit) {
		this.noticeHit = noticeHit;
	}
	public String getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
	
	
	
	
	

}
