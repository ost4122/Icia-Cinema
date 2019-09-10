package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.MemberDropService;

@WebServlet("/memberDrop")
public class MemberDrop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDrop() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String nickname= request.getParameter("nickname");
	MemberDropService memberDropService= new MemberDropService();
    
	boolean drop;
	drop= memberDropService.DROP(nickname);
	
	request.setAttribute("memberList", drop);
	
	
	
	
	response.sendRedirect("MainPage.jsp");
		/*
		 * //Dispatch 방식으로 MemberList.jsp로 포워딩 RequestDispatcher dispatcher=
		 * request.getRequestDispatcher("MainPage.jsp"); dispatcher.forward(request,
		 * response);
		 */
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
