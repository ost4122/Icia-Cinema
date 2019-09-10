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
import javax.servlet.http.HttpSession;

import Dto.CommentDTO;
import Dto.MovieDTO;
import Service.CommentLike_Svc;
import Service.CommentList_Svc;
import Service.MovieInformation_Service;

/**
 * Servlet implementation class CommentLike_Cnt
 */
@WebServlet("/CommentLike_Cnt")
public class CommentLike_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentLike_Cnt() {
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
		
		HttpSession session = request.getSession();
		
		String sessionId = (String)session.getAttribute("sessionId");
		int movieNumber = Integer.parseInt(request.getParameter("movieNumber"));
		int cmNumber = Integer.parseInt(request.getParameter("cmNumber"));
		
		CommentLike_Svc cl = new CommentLike_Svc();
		cl.CommentLike_svc(sessionId,movieNumber,cmNumber);
		int countResult = cl.LikeCount(cmNumber);
		
		
		if(countResult>0) {
			out.println("<script>");
			out.println("location.href='MovieInformation_Cnt?movieNumber="+movieNumber+"'");
			out.println("</script>");
			out.close();
			/*
			 * request.setAttribute("movieNumber", movieNumber); RequestDispatcher
			 * dispatcher = request.getRequestDispatcher("MovieInformation_Cnt");
			 * dispatcher.forward(request, response);
			 */
		}

		
		
	}

}
