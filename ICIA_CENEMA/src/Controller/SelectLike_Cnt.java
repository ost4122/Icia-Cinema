package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.SelectLike_Svc;

@WebServlet("/SelectLike_Cnt")
public class SelectLike_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectLike_Cnt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			/* 댓글 좋아요 중복 확인*/
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		

		
		String sessionId = (String)session.getAttribute("sessionId");
		int movieNumber = Integer.parseInt(request.getParameter("movieNumber"));
		int cmNumber = Integer.parseInt(request.getParameter("cmNumber"));
		
		SelectLike_Svc sls = new SelectLike_Svc();
		String nickName = sls.SelectLike_svc(sessionId,movieNumber,cmNumber);
		
		if(nickName	==	null) {
			request.setAttribute("movieNumber", movieNumber);
			request.setAttribute("cmNumber", cmNumber);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CommentLike_Cnt");
			dispatcher.forward(request, response);
			
		}else {
			sls.DeleteLike_Svc(cmNumber,sessionId);
			sls.DeleteUpdate(cmNumber);
			
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
