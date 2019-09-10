package Service;

import static Db.JdbcUtil.*;

import java.sql.*;

import Dao.FaqDAO;
import Dto.FaqDTO;

public class FaqModify_Svc {

	public int faqModify(FaqDTO faqDTO) {
		//DB호출
		Connection con = getConnection();
		FaqDAO faqDAO = FaqDAO.getInstrance();
		faqDAO.setConnection(con);
		
		//자주찾는 질문 수정 Service
		
		int result = faqDAO.faqModify(faqDTO);
		
		if(result>0) {
			
			commit(con);
		} else {
			
			rollback(con);
		}
		close(con);
		
		
		return result;
	}
	

}
