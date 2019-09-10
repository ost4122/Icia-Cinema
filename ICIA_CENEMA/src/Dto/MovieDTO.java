package Dto;

import java.util.*;

public class MovieDTO {
	// 영화제목
	private String movieSubject ;
	// 영화감독
	private String director;
	// 출연진
	private String castMembers;
	// 영화 포스터
	private String poster;
	// 영화 줄거리
	private String movieContents;
	// 영화 평점
	private double grade;
	// 관람 등급
	private int filmRatings;
	// 상영 시간
	private int showTimes;
	// 개봉 날짜
	private String releaseDate;
	// 영화 번호
	private int movieNumber;
	// 평점주기 참여자 수
	private int giveRating;
	// 예고편
	private String trailer;
	
	
	
	
	
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public int getGiveRating() {
		return giveRating;
	}
	public void setGiveRating(int giveRating) {
		this.giveRating = giveRating;
	}
	
	public int getMovieNumber() {
		return movieNumber;
	}
	public void setMovieNumber(int movieNumber) {
		this.movieNumber = movieNumber;
	}
	public String getMovieSubject() {
		return movieSubject;
	}
	public void setMovieSubject(String movieSubject) {
		this.movieSubject = movieSubject;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCastMembers() {
		return castMembers;
	}
	public void setCastMembers(String castMembers) {
		this.castMembers = castMembers;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMovieContents() {
		return movieContents;
	}
	public void setMovieContents(String movieContents) {
		this.movieContents = movieContents;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getFilmRatings() {
		return filmRatings;
	}
	public void setFilmRatings(int filmRatings) {
		this.filmRatings = filmRatings;
	}
	public int getShowTimes() {
		return showTimes;
	}
	public void setShowTimes(int showTimes) {
		this.showTimes = showTimes;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	
	

}
