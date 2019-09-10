package Service;

import java.sql.Connection;

import Dao.NoticeDAO;

import static Db.JdbcUtil.*;

import Dto.NoticeDTO;

public class NoticeWrite_Svc {

	public boolean noticeWrite(NoticeDTO noticeDTO) {
		
		//DB호출
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstrance();
		noticeDAO.setConnection(con);
		
		//게시글 쓰기 Service
		int result = noticeDAO.noticeWrite(noticeDTO);
		
		boolean writeResult;
		
		if(result==1) {
			writeResult=true;
			commit(con);
		} else {
			writeResult=false;
			rollback(con);
		}
		
		
		return writeResult;
	}

}
