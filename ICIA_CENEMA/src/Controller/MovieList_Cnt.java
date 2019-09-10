package Controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MovieDTO;
import Service.MovieList_Svc;

@WebServlet("/MovieList_Cnt")
public class MovieList_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieList_Cnt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 영화 목록 불러오기 */
		int choice = Integer.parseInt(request.getParameter("choice"));
		
		
		MovieList_Svc mls = new MovieList_Svc();
		
		ArrayList<MovieDTO> movieList = mls.List_svc();
		
		if(choice==1) {
			/* 초이스가 1이면 삭제하는 페이지 이동 */
			request.setAttribute("movieList", movieList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteMoviePage.jsp");
			dispatcher.forward(request, response);
			
		}
		else if(choice==2) {
			/* 초이스가 2이면 상영시간 등록하는 페이지 이동 */
			request.setAttribute("movieList", movieList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("InputShow.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			request.setAttribute("movieList", movieList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
			dispatcher.forward(request, response);
			
			
		}
	
		
		
		
	}
	

}
