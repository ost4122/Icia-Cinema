package HyunController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.NoticeModify_Svc;
import Dto.NoticeDTO;

@WebServlet("/noticeModifyProcess")
public class NoticeModifyProcess_Ctn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeModifyProcess_Ctn() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8"); 
    	
    	//게시판 글 수정 Controller
    	
    	int noticeNumber =
    			Integer.parseInt(request.getParameter("noticeNumber"));
    	String noticeWriter = request.getParameter("noticeWriter");
    	String noticeSubject = request.getParameter("noticeSubject");
    	String noticeContents = request.getParameter("noticeContents");
    	
    	NoticeDTO noticeDTO = new NoticeDTO();
    	noticeDTO.setNoticeNumber(noticeNumber);
    	noticeDTO.setNoticeWriter(noticeWriter);
    	noticeDTO.setNoticeSubject(noticeSubject);
    	noticeDTO.setNoticeContents(noticeContents);
    	
    	NoticeModify_Svc noticeModify_Svc =
    			new NoticeModify_Svc();
    	
    	PrintWriter out =response.getWriter();
    	
    	int modifyResult =
    			noticeModify_Svc.noticeModify(noticeDTO);
    	
    	if(modifyResult>0) {
    		response.sendRedirect("noticeView?noticeNumber="+noticeNumber);
    	} else {
    		out.println("<script>");
			out.println("alert('회원정보 수정 실패');");
			out.println("location.href='NoticeMain.jsp'</script>");
    	}
    	
    	
		
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
