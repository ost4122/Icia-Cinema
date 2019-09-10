package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.NoticeDAO;

public class NoticeDelete_Svc {

	public boolean noticeDelete(int noticeNumber) {
		
		//DB호출
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstrance();
		noticeDAO.setConnection(con);
		
		//게시글 삭제 Service
		
		int result = noticeDAO.noticeDelete(noticeNumber);
		
		boolean deleteResult = false;
		if(result>0) {
			deleteResult = true;
			commit(con);
		} else {
			deleteResult = false;
			rollback(con);
		}
		close(con);
		
		
		
		return deleteResult;
	}

}
