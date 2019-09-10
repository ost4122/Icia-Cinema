package Service;

import static Db.JdbcUtil.*;

import java.sql.*;

import Dao.FaqDAO;
import Dto.FaqDTO;

public class FaqView_Svc {

	public FaqDTO faqView(int faqNumber) {
		//DB호출
		Connection con = getConnection();
		FaqDAO faqDAO = FaqDAO.getInstrance();
		faqDAO.setConnection(con);
		
		//자주찾는 질문 상세보기 Service
		
		int result = faqDAO.increaseHit(faqNumber);
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		FaqDTO viewResult = faqDAO.faqView(faqNumber);
		close(con);
		
		return viewResult;
	}

	
}
