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

@WebServlet("/memberModify")
public class MemberModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberModify() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String name =request.getParameter("name");
    	System.out.println("이름:"+name);
    	
    	MemberViewService memberModifyService = new MemberViewService();
    	
    	MemberDTO memberDTO = memberModifyService.modify(name);
    	System.out.println(memberDTO.getName());
    	
    	request.setAttribute("modify",memberDTO);
    	 RequestDispatcher dispatcher = request.getRequestDispatcher("MemberModify.jsp");
  	    dispatcher.forward(request, response);
    	
    	
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
