package Service;

import static Db.JdbcUtil.*;

import java.sql.*;

import Dao.NoticeDAO;
import Dto.NoticeDTO;

public class NoticeView_Svc {

	public NoticeDTO noticeView(int noticeNumber) {
		//DB호출
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstrance();
		noticeDAO.setConnection(con);
		
		//게시글 상세보기 Service
		
		int result = noticeDAO.increaseHit(noticeNumber);
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		NoticeDTO viewResult = noticeDAO.noticeView(noticeNumber);
		close(con);
		
		return viewResult;
	}

	
}
