package HyunController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.FaqList_Svc;
import Dto.FaqDTO;


@WebServlet("/faqListOrder")
public class FaqListOrder_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FaqListOrder_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("FaqListOrderController 호출");
    	
    	//조회순서로 정렬
    	
    	FaqList_Svc faqList_Svc = new FaqList_Svc();
    	ArrayList<FaqDTO> faqList = faqList_Svc.faqListOrder();
    	//service를 따로 만들필요 없이 noticeList로 보내주면 된다
    	request.setAttribute("faqList", faqList);
    	RequestDispatcher dispatcher = 
    			request.getRequestDispatcher("FaqList.jsp");
    	dispatcher.forward(request, response);
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
