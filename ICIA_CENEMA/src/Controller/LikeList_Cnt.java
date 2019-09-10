package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.CommentDTO;
import Service.LikeList_Svc;

@WebServlet("/LikeList_Cnt")
public class LikeList_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LikeList_Cnt() {
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
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int cmNumber = Integer.parseInt(request.getParameter("cmNumber"));
		
		LikeList_Svc lls = new LikeList_Svc();
		
		ArrayList<CommentDTO> likeList = lls.likelist_svc(cmNumber);
		request.setAttribute("likeList", likeList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("LikeList.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
		
	}
	

}
