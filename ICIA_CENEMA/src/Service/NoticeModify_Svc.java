package Service;

import static Db.JdbcUtil.*;

import java.sql.*;

import Dao.NoticeDAO;
import Dto.NoticeDTO;

public class NoticeModify_Svc {

	public int noticeModify(NoticeDTO noticeDTO) {
		//DB호출
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstrance();
		noticeDAO.setConnection(con);
		
		//게시글 수정 Service
		
		int result = noticeDAO.noticeModify(noticeDTO);
		
		if(result>0) {
			
			commit(con);
		} else {
			
			rollback(con);
		}
		close(con);
		
		
		return result;
	}
	

}
