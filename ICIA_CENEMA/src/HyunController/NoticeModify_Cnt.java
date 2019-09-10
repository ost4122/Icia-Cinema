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

@WebServlet("/noticeModify")
public class NoticeModify_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeModify_Cnt() {
        super();
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("NoticeModify_Cnt 호출");
    	request.setCharacterEncoding("UTF-8");
    	
    	//게시판 글 수정 Controller
    	
    	int noticeNumber = 
    			Integer.parseInt(request.getParameter("noticeNumber"));
    	
    	//BoardView내용을 다시 가져와서 이용!!!!
    	//BoardViewService 객체선언
    	NoticeView_Svc noticeView_Svc = new NoticeView_Svc();
    	//호출한 내용을 BoardDTO타입에 modifyView에 담는다.
    	NoticeDTO modifyView = noticeView_Svc.noticeView(noticeNumber);
    	
    	request.setAttribute("modifyView", modifyView);
    	//Dispatcher객체 선언
    	RequestDispatcher dispatcher = 
    			request.getRequestDispatcher("NoticeModify.jsp");
		dispatcher.forward(request, response);
    	
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
