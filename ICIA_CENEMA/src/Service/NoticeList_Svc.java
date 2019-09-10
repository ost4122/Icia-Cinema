package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Dao.NoticeDAO;
import Dto.NoticeDTO;

public class NoticeList_Svc {

	public int boardCount() {
		//DB호출
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstrance();
		noticeDAO.setConnection(con);
		
		//
		
		int boardCount = noticeDAO.boardCount();
		close(con);
		
		return boardCount;
	}
	
    
	
	//게시글 목록 페이징처리 Service
	public ArrayList<NoticeDTO> noticeListPaging(int startRow, int endRow) {
		//DB호출
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstrance();
		noticeDAO.setConnection(con);
		
		ArrayList<NoticeDTO> noticeList = 
				noticeDAO.noticeListPaging(startRow, endRow);
		close(con);
		
		return noticeList;
	}

    //게시글 조회순으로 정렬 Service
	public ArrayList<NoticeDTO> noticeListOrder() {
		//DB호출
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstrance();
		noticeDAO.setConnection(con);
		
		
		ArrayList<NoticeDTO> noticeList = 
				noticeDAO.noticeListOrder();
		close(con);
		return noticeList;
	}
		
}
