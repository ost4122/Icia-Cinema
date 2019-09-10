package Controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.CommentDTO;
import Dto.MovieDTO;
import Service.CommentList_Svc;
import Service.MovieInformation_Service;


@WebServlet("/MovieInformation_Cnt")
public class MovieInformation_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieInformation_Cnt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 영화 번호값 가져옴
		int num = Integer.parseInt(request.getParameter("movieNumber"));
		
		/*댓글 목록 가져오기*/
		
		CommentList_Svc cls = new CommentList_Svc();
		
		ArrayList<CommentDTO> commentList = new ArrayList<CommentDTO>();
		
		commentList = cls.commentList_Svc(num);
		/* 영화 상세보기 */
		
		// 서비스 객체 생성
		MovieInformation_Service mis = new MovieInformation_Service();
		
		// mis에 subject값을 넘겨주면서 리턴값을 result에 담음
		MovieDTO result = mis.movieInformation(num);
		
		
		
		request.setAttribute("commentList", commentList);
		request.setAttribute("movieInfor", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieInfor.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
		
	}




}
