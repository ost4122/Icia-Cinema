package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDTO;
import Service.MemberViewService;

@WebServlet("/memberView")
public class MemberView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberView() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String nickname=request.getParameter("nickname");
    	System.out.println("nickname:"+nickname);
    	
    	MemberViewService memberModifyview = new MemberViewService();
    	MemberDTO resultList = memberModifyview.member(nickname);
    	
    	
    	 request.setAttribute("memberList", resultList);
 	    
 		RequestDispatcher dispatcher=
 				request.getRequestDispatcher("MyPage.jsp");
 		dispatcher.forward(request, response);
    	
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
