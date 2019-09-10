package HyunController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.NoticeSearch_Svc;
import Dto.NoticeDTO;

@WebServlet("/noticeSearch")
public class NoticeSearch_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeSearch_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
    	
        //게시글 검색 Controller
        
        System.out.println("NoticeSearch_Cnt 호출");
    	String noticeSearch = request.getParameter("noticeSearch");
    	System.out.println("검색할 단어="+noticeSearch);
    	NoticeSearch_Svc noticeSearch_Svc =
    			new NoticeSearch_Svc();
    	ArrayList<NoticeDTO> searchList = new ArrayList<NoticeDTO>();
    	searchList = noticeSearch_Svc.noticeSearch(noticeSearch);
    	
    	request.setAttribute("searchList", searchList);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("NoticeList.jsp");
    	dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
