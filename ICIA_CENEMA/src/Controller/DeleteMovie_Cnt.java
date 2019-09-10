package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DeleteMovie_Svc;

/**
 * Servlet implementation class DeleteMovie_Cnt3
 */
@WebServlet("/DeleteMovie_Cnt")
public class DeleteMovie_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMovie_Cnt() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 영화 삭제 */
		
		int choice = 0;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		// 배열 형변환		
		int[] movieNumber = Arrays.stream(request.getParameterValues("deleteMovie")).mapToInt(Integer::parseInt).toArray();
		
		DeleteMovie_Svc dms = new DeleteMovie_Svc();
		
		int result = dms.deleteMovie_Svc(movieNumber);
		
		if(result>0) {
			out.println("<script>alert('삭제 성공 !!')");
			out.println("location.href='MovieList_Cnt?choice=0'");
			out.println("</script>");
			out.close();
			
		}else {
			out.println("<script>alert('삭제 실패 !!')");
			out.println("location.back()</script>");
			out.close();
		}
		
		
	}
	

}
