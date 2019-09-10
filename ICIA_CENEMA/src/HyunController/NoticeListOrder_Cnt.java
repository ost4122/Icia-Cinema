package HyunController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Service.NoticeList_Svc;
import Dto.NoticeDTO;


@WebServlet("/noticeListOrder")
public class NoticeListOrder_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeListOrder_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("NoticeListOrderController 호출");
    	
    	//조회순서로 정렬
    	
    	NoticeList_Svc noticeList_Svc = new NoticeList_Svc();
    	ArrayList<NoticeDTO> noticeList = noticeList_Svc.noticeListOrder();
    	//service를 따로 만들필요 없이 noticeList로 보내주면 된다
    	request.setAttribute("noticeList", noticeList);
    	RequestDispatcher dispatcher = 
    			request.getRequestDispatcher("NoticeList.jsp");
    	dispatcher.forward(request, response);
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
