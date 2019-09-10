package HyunController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.NoticeDelete_Svc;

@WebServlet("/noticeDelete")
public class NoticeDelete_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NoticeDelete_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//공지사항 글 삭제 Controller
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
		
    	int noticeNumber =
				Integer.parseInt(request.getParameter("noticeNumber"));
		
		NoticeDelete_Svc noticeDelete_Svc = new NoticeDelete_Svc();
		
		
		PrintWriter out = response.getWriter();
		
    	boolean deleteResult = 
    			noticeDelete_Svc.noticeDelete(noticeNumber);
    	
    	if(deleteResult) {
    		response.sendRedirect("noticeList");
    	} else {
    		out.println("<script>");
    		out.println("alert(삭제실패)");
    		out.println("hisroy.back()</script>");
    	}
    	out.close();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
