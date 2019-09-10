package HyunController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Service.FaqWrite_Svc;
import Dto.FaqDTO;

@WebServlet("/faqWrite")
public class FaqWrite_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FaqWrite_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		//자주찾는 질문 글 쓰기 Controller
		
		//첨부파일 첨부
		int size = 10 * 1020 * 1020; // 10메가바이트 용량값 지정
		String realPath = "D:/dev/jsp/MovieReservation/WebContent/fileUpload";

		MultipartRequest multi = new MultipartRequest(request, realPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		FaqDTO faqDTO = new FaqDTO();
		faqDTO.setFaqWriter(multi.getParameter("faqWriter"));     //작성자
		faqDTO.setFaqSubject(multi.getParameter("faqSubject"));   //제목
		faqDTO.setFaqContents(multi.getParameter("faqContents")); //내용
		faqDTO.setFaqFile(multi.getOriginalFileName((String)multi.getFileNames().nextElement())); //첨부파일
		
		FaqWrite_Svc faqWrite_Svc = new FaqWrite_Svc();
		
		boolean writeResult = faqWrite_Svc.faqWrite(faqDTO);
		
		PrintWriter out = response.getWriter();
		
		if(writeResult==true) {
			out.println("<script>");
			out.println("alert('게시물이 등록되었습니다.')");
			out.println("location.href='faqList'</script>");
		} else if (faqDTO.getFaqSubject()=="") {
			out.println("<script>");
			out.println("alert('제목을 입력하세요!!')");
			out.println("history.back()</script>");
		} else {
			out.println("<script>");
			out.println("alert('작성 실패!!')");
			out.println("history.back()</script>");
		}
		
    	
    	
    	
    	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
