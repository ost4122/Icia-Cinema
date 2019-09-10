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
import Dto.PagingDTO;

@WebServlet("/noticeList")
public class NoticeList_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeList_Cnt() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//게시판 글 목록 Controller
    	//페이징 처리 
    	
    	int page = 1;
    	int limit = 10; //한페이지에 표시할 글 목록 갯수
    	
    	if(request.getParameter("page")!=null) {
    		page = Integer.parseInt(request.getParameter("page"));
    	}
    	
    	NoticeList_Svc noticeList_Svc = new NoticeList_Svc();
    	//DB에 저장된 전체 글 갯수를 가지고 오는 메소드
    	int boardCount = noticeList_Svc.boardCount();
    	
    	//출력할 범위값 계산
    	int startRow = (page-1)*limit +1;
    	int endRow = page*limit;
    	
    	System.out.println("NoticeListController 호출");
    	ArrayList<NoticeDTO> noticeList = 
    			noticeList_Svc.noticeListPaging(startRow, endRow);
    	
    	int maxPage = (int)((double)boardCount/limit + 0.9);
    	//페이지 수가 10개를 넘어갈때 1~10 / 11~20 / 21~30 ... 이렇게 나오게 해준다
    	int startPage = 
    			(((int)((double)page/10 + 0.9))-1) * 10+1;
    	int endPage = startPage + 10 -1;
    	//페이지가 10개를 안넘어갈때는 maxPage가 endPage가 된다.
    	if(endPage>maxPage) {
    		endPage = maxPage;
    	}
    	//PagingDTO의 paging 객체 생성
    	PagingDTO paging = new PagingDTO();
    	paging.setPage(page);
    	paging.setStartPage(startPage);
    	paging.setEndPage(endPage);
    	paging.setMaxPage(maxPage);
    	paging.setBoardCount(boardCount);
    	//파라미터값
    	request.setAttribute("paging", paging);
    	request.setAttribute("noticeList", noticeList);
    	//두개의 파라미터값을 가지고 BoardListPaging.jsp로간다
    	RequestDispatcher dispatcher =
    			request.getRequestDispatcher("NoticeList.jsp");
    	dispatcher.forward(request, response);
    	
    	//search
    	
    	
    	
    	
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
