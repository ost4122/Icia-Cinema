package Service;

import static Db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;

import Dao.NoticeDAO;
import Dto.NoticeDTO;

public class NoticeSearch_Svc {

	public ArrayList<NoticeDTO> noticeSearch(String noticeSearch) {
		//DB호출
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstrance();
		noticeDAO.setConnection(con);
		
		//게시글 검색 Service
		ArrayList<NoticeDTO> searchList = 
				noticeDAO.noticeSearch(noticeSearch);
		close(con);
		
		return searchList;
		
	
	}
	
	

}
