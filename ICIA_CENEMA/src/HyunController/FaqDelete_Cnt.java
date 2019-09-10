package HyunController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.FaqDelete_Svc;

@WebServlet("/faqDelete")
public class FaqDelete_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FaqDelete_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//자주찾는 질문 글 삭제 Controller
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
		
    	int faqNumber =
				Integer.parseInt(request.getParameter("faqNumber"));
		
		FaqDelete_Svc faqDelete_Svc = new FaqDelete_Svc();
		
		
		PrintWriter out = response.getWriter();
		
    	boolean deleteResult = 
    			faqDelete_Svc.faqDelete(faqNumber);
    	
    	if(deleteResult) {
    		response.sendRedirect("faqList");
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
