package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Dto.MovieDTO;
import Service.InputMovie_Svc;


@WebServlet("/InputMovie_Cnt")
public class InputMovie_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InputMovie_Cnt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 영화 등록 */		
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		int size = 10*1024*1024;
		String realPath =  "D:/dev/Jsp/TeamProject/WebContent/moviePoster";
		
	
		MultipartRequest multi = new MultipartRequest(
				
				request,
				realPath,
				size,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		// 영화제목
		String subject = multi.getParameter("movieSubject");
		// 평점
		double grade = Double.parseDouble(multi.getParameter("grade"));
		// 감독
		String director = multi.getParameter("director");
		//관람 등급
		int filmRatings = Integer.parseInt(multi.getParameter("filmRatings"));
		//상영시간
		int showTimes = Integer.parseInt(multi.getParameter("showTimes"));
		//개봉일
		String releaseDate = multi.getParameter("releaseDate");
		//출연진
		String castMembers = multi.getParameter("castMembers");
		//줄거리
		String contents = multi.getParameter("movieContents");
		//포스터
		String poster =multi.getOriginalFileName(
				(String)multi.getFileNames().nextElement());
		//예고편
		String trailer = multi.getParameter("trailer");
		
		

		MovieDTO mdto = new MovieDTO();
		
		mdto.setMovieSubject(subject);
		mdto.setGrade(grade);
		mdto.setDirector(director);
		mdto.setFilmRatings(filmRatings);
		mdto.setShowTimes(showTimes);
		mdto.setReleaseDate(releaseDate);
		mdto.setCastMembers(castMembers);
		mdto.setMovieContents(contents);
		mdto.setPoster(poster);
		mdto.setTrailer(trailer);
		
		InputMovie_Svc ims = new InputMovie_Svc();
		
		int inputResult = ims.inputMovie(mdto);
		
		if(inputResult>0) {
			out.println("<script>alert('등록 완료 !!')");
			out.println("location.href='MovieList_Cnt?choice=0'");
			out.println("</script>");
			out.close();
		}else {
			out.println("<script>alert('등록 실패 !!')");
			out.println("location.back();</script>");
			out.close();
		}
		
		
	}

}
