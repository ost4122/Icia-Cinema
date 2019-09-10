package HyunController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.FaqView_Svc;
import Dto.FaqDTO;

@WebServlet("/faqModify")
public class FaqModify_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FaqModify_Cnt() {
        super();
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("FaqModify_Cnt 호출");
    	request.setCharacterEncoding("UTF-8");
    	
    	//자주찾는 질문 글 수정 Controller
    	
    	int faqNumber = 
    			Integer.parseInt(request.getParameter("faqNumber"));
    	
    	//BoardView내용을 다시 가져와서 이용!!!!
    	//BoardViewService 객체선언
    	FaqView_Svc faqView_Svc = new FaqView_Svc();
    	//호출한 내용을 BoardDTO타입에 modifyView에 담는다.
    	FaqDTO modifyView = faqView_Svc.faqView(faqNumber);
    	
    	request.setAttribute("modifyView", modifyView);
    	//Dispatcher객체 선언
    	RequestDispatcher dispatcher = 
    			request.getRequestDispatcher("FaqModify.jsp");
		dispatcher.forward(request, response);
    	
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
