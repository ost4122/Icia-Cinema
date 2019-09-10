package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDTO;
import Service.MemberModifyService;
import Service.MemberViewService;

@WebServlet("/memberModify2")
public class MemberModify2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberModify2() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String email = request.getParameter("email");
    	System.out.println(email);
    	String nickname = request.getParameter("nickname");
    	System.out.println(nickname);
    	String name = request.getParameter("name");
    	System.out.println(name);
    	String password = request.getParameter("password");
    	String birth = request.getParameter("birth");
    	String phone =request.getParameter("phone");
    	
    	MemberDTO memberDTO =new MemberDTO();
    	memberDTO.setEmail(email);
    	memberDTO.setNickname(nickname);
    	memberDTO.setName(name);
    	memberDTO.setPassword(password);
    	memberDTO.setBirth(birth);
    	memberDTO.setPhone(phone);
    	
    	MemberModifyService memberModifyService = new MemberModifyService();
    	MemberViewService memberModifyview = new MemberViewService();
    	
    	boolean modifyResult = memberModifyService.memberModify(memberDTO);
    	MemberDTO resultList = memberModifyview.member(nickname);
    	
    	if(modifyResult) {
    		
    		 request.setAttribute("memberList", resultList);
    	 	    
    	 		RequestDispatcher dispatcher=
    	 				request.getRequestDispatcher("MyPage.jsp");
    	 		dispatcher.forward(request, response);
    	    	
    		
    	}
    	
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
