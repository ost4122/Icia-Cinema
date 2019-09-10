package HyunController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.FaqModify_Svc;
import Dto.FaqDTO;

@WebServlet("/faqModifyProcess")
public class FaqModifyProcess_Ctn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FaqModifyProcess_Ctn() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8"); 
    	
    	//게시판 글 수정 Controller
    	
    	int faqNumber =
    			Integer.parseInt(request.getParameter("faqNumber"));
    	String faqWriter = request.getParameter("faqWriter");
    	String faqSubject = request.getParameter("faqSubject");
    	String faqContents = request.getParameter("faqContents");
    	
    	FaqDTO faqDTO = new FaqDTO();
    	faqDTO.setFaqNumber(faqNumber);
    	faqDTO.setFaqWriter(faqWriter);
    	faqDTO.setFaqSubject(faqSubject);
    	faqDTO.setFaqContents(faqContents);
    	
    	FaqModify_Svc faqModify_Svc =
    			new FaqModify_Svc();
    	
    	PrintWriter out =response.getWriter();
    	
    	int modifyResult =
    			faqModify_Svc.faqModify(faqDTO);
    	
    	if(modifyResult>0) {
    		response.sendRedirect("faqView?faqNumber="+faqNumber);
    	} else {
    		out.println("<script>");
			out.println("alert('회원정보 수정 실패');");
			out.println("location.href='FaqList'</script>");
    	}
    	
    	
		
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
