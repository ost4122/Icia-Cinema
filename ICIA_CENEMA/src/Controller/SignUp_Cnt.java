package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Dto.MemberDTO;
import Service.Join_Svc;

@WebServlet("/JoinController")
public class SignUp_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SignUp_Cnt() {
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	String email= request.getParameter("email");
    	String nickname = request.getParameter("nickname");
    	String password= request.getParameter("password");
    	String name= request.getParameter("name");
    	String birth =request.getParameter("birth");
    	String phone =request.getParameter("phone");	
    	
    	   
    	MemberDTO memberDTO = new MemberDTO();
		memberDTO.setEmail(email);
		memberDTO.setNickname(nickname);
		memberDTO.setPassword(password);
		memberDTO.setName(name);
		memberDTO.setBirth(birth);
		memberDTO.setPhone(phone);
		//response.setContentType("text/html; charset=UTF-8");

		
		Join_Svc joinService = new Join_Svc();
		int result 
			=joinService.joinDB(memberDTO);
		
		
		
		//회원정보가 DB에 성공적으로 저장되면 lofinForm.jsp으로 이동시킴
		//회원가입 실패하면 alert을 띄우고 joinFormjsp으로 머무르기
		if(result>0) {
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out1 = response.getWriter();
			
			out1.println("<script>");
			out1.println("alert('회원가입이완료되엇습니다!!')");
			out1.println("location.href='Login.jsp'</script>");
			 out1.close();
		}
		
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out1 = response.getWriter();
			out1.println("<script>");
			out1.println("alert('회원가입실패!! 중복체크가 되었는지 확인하세요!!')");
			out1.println("history.back();</script>");
			 out1.close();
		}
		
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
