package Dto;

import java.util.Date;

public class CommentDTO {
	
	
	private String writer;				// 작성자
	private String contents;		
	private int movieNumber;
	private int commentHit;
	private Date writeDate;
	private int commentNumber;
	private String nickName;			// 댓글 추천인
	
	
	
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getMovieNumber() {
		return movieNumber;
	}
	public void setMovieNumber(int movieNumber) {
		this.movieNumber = movieNumber;
	}
	public int getCommentHit() {
		return commentHit;
	}
	public void setCommentHit(int commentHit) {
		this.commentHit = commentHit;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

}
