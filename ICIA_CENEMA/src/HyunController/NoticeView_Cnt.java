package HyunController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.NoticeView_Svc;
import Dto.NoticeDTO;

@WebServlet("/noticeView")
public class NoticeView_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeView_Cnt() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("noticeView_Cnt 호출");
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/hrml; charset=UTF-8");
    	
    	//게시판 글 자세히 보기 Controller
    	
    	int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
    	
    	NoticeView_Svc noticeView_Svc = 
    			new NoticeView_Svc();
    	
    	NoticeDTO viewResult = noticeView_Svc.noticeView(noticeNumber);
    	
    	request.setAttribute("viewResult", viewResult);
    	
    	RequestDispatcher dispatcher = 
    			request.getRequestDispatcher("NoticeView.jsp");
    	dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
