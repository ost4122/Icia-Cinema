package HyunController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.FaqSearch_Svc;
import Dto.FaqDTO;

@WebServlet("/faqSearch")
public class FaqSearch_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FaqSearch_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
    	
        //자주찾는 질문 검색 Controller
        
        System.out.println("FaqSearch_Cnt 호출");
    	String faqSearch = request.getParameter("faqSearch");
    	System.out.println("검색할 제목="+faqSearch);
    	FaqSearch_Svc faqSearch_Svc =
    			new FaqSearch_Svc();
    	ArrayList<FaqDTO> searchList = new ArrayList<FaqDTO>();
    	searchList = faqSearch_Svc.faqSearch(faqSearch);
    	
    	request.setAttribute("searchList", searchList);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("FaqList.jsp");
    	dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
