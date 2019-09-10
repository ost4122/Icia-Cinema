package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.FaqDAO;

public class FaqDelete_Svc {

	public boolean faqDelete(int faqNumber) {
		
		//DB호출
		Connection con = getConnection();
		FaqDAO faqDAO = FaqDAO.getInstrance();
		faqDAO.setConnection(con);
		
		//자주찾는 질문 삭제 Service
		
		int result = faqDAO.faqDelete(faqNumber);
		
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
