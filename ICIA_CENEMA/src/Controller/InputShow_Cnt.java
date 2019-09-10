package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Ticketing_Svc;

/**
 * Servlet implementation class InputShowLast_CTR
 */
@WebServlet("/InputShow_CTR")
public class InputShow_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InputShow_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    

    	String movieSubject = request.getParameter("movieSubject");//영화이름
    	String movieTheater = request.getParameter("movieTheater");//영화관
    	String showDate = request.getParameter("showDate");//영화날짜
    	String showTime = request.getParameter("showTime");//영화시간
    	
    	Ticketing_Svc ticketingSVC = new Ticketing_Svc();
    	PrintWriter out = response.getWriter();
    	
    	boolean result =ticketingSVC.inputShow(movieSubject, movieTheater, showDate, showTime);
    	
    	if(result==true) {
    		out.println("<script>");
    		out.println("alert('등록이 완료되었습니다.')");
			out.println("location.href='MovieList_Cnt?choice=0'</script>");
    	}
    	else {
    		out.println("<script>");
    		out.println("alert('영화등록에 실패하였습니다.')");
			out.println("history.back();</script>");
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
