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

import Service.WriteComment_Svc;

@WebServlet("/WriteComment_Cnt")
public class WriteComment_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WriteComment_Cnt() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 댓글 등록 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		
		  String sessionId = (String)session.getAttribute("sessionId");
		
		String comment = request.getParameter("comment_content");
		int movieNumber = Integer.parseInt(request.getParameter("movieNumber"));

		WriteComment_Svc wcsvc = new WriteComment_Svc();

		int result = wcsvc.writeComment_Svc(sessionId, movieNumber, comment);

		if (result > 0) {
			
			out.println("<script>");
			out.println("location.href='MovieInformation_Cnt?movieNumber="+movieNumber+"'");
			out.println("</script>");
			out.close();
			/*
			 * request.setAttribute("movieNumber", movieNumber); RequestDispatcher
			 * dispatcher = request.getRequestDispatcher("MovieInformation_Cnt");
			 * dispatcher.forward(request, response);
			 */
		} else {
			out.println("<script>alert('댓글등록실패 !!')");
			out.println("history.back();</scirpt>");
			out.close();

		}

	}

}
