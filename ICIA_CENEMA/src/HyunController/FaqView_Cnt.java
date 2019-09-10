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

@WebServlet("/faqView")
public class FaqView_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FaqView_Cnt() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("faqView_Cnt 호출");
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/hrml; charset=UTF-8");
    	
    	//자주찾는 질문 글 자세히 보기 Controller
    	
    	int faqNumber = Integer.parseInt(request.getParameter("faqNumber"));
    	
    	FaqView_Svc faqView_Svc = 
    			new FaqView_Svc();
    	
    	FaqDTO viewResult = faqView_Svc.faqView(faqNumber);
    	
    	request.setAttribute("viewResult", viewResult);
    	
    	RequestDispatcher dispatcher = 
    			request.getRequestDispatcher("FaqView.jsp");
    	dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
