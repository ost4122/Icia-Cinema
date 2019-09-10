package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Dao.FaqDAO;
import Dto.FaqDTO;

public class FaqList_Svc {

	public int boardCount() {
		//DB호출
		Connection con = getConnection();
		FaqDAO faqDAO = FaqDAO.getInstrance();
		faqDAO.setConnection(con);
		
		//
		
		int boardCount = faqDAO.boardCount();
		close(con);
		
		return boardCount;
	}
	
    
	
	//자주찾는 질문 목록 페이징처리 Service
	public ArrayList<FaqDTO> faqListPaging(int startRow, int endRow) {
		//DB호출
		Connection con = getConnection();
		FaqDAO faqDAO = FaqDAO.getInstrance();
		faqDAO.setConnection(con);
		
		ArrayList<FaqDTO> faqList = 
				faqDAO.faqListPaging(startRow, endRow);
		close(con);
		
		return faqList;
	}

    //게시글 조회순으로 정렬 Service
	public ArrayList<FaqDTO> faqListOrder() {
		//DB호출
		Connection con = getConnection();
		FaqDAO faqDAO = FaqDAO.getInstrance();
		faqDAO.setConnection(con);
		
		
		ArrayList<FaqDTO> faqList = 
				faqDAO.faqListOrder();
		close(con);
		return faqList;
	}
		
}
