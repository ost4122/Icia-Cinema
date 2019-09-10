package Dto;

import java.sql.Date;

public class FaqDTO {
	private int faqNumber;         //게시글 번호
	private String faqWriter;      //작성자
	private String faqPassword;    //비밀번호
	private String faqSubject;     //제목
	private String faqContents;    //내용
	private Date faqDate;          //작성날짜
	private int faqHit;            //조회수
	private String faqFile;        //첨부파일
	private String faqSearch;      //검색
	
	
	public int getFaqNumber() {
		return faqNumber;
	}
	public void setFaqNumber(int faqNumber) {
		this.faqNumber = faqNumber;
	}
	public String getFaqWriter() {
		return faqWriter;
	}
	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
	}
	public String getFaqPassword() {
		return faqPassword;
	}
	public void setFaqPassword(String faqPassword) {
		this.faqPassword = faqPassword;
	}
	public String getFaqSubject() {
		return faqSubject;
	}
	public void setFaqSubject(String faqSubject) {
		this.faqSubject = faqSubject;
	}
	public String getFaqContents() {
		return faqContents;
	}
	public void setFaqContents(String faqContents) {
		this.faqContents = faqContents;
	}
	public Date getFaqDate() {
		return faqDate;
	}
	public void setFaqDate(Date faqDate) {
		this.faqDate = faqDate;
	}
	public int getFaqHit() {
		return faqHit;
	}
	public void setFaqHit(int faqHit) {
		this.faqHit = faqHit;
	}
	public String getFaqFile() {
		return faqFile;
	}
	public void setFaqFile(String faqFile) {
		this.faqFile = faqFile;
	}
	public String getFaqSearch() {
		return faqSearch;
	}
	public void setFaqSearch(String faqSearch) {
		this.faqSearch = faqSearch;
	}

}
