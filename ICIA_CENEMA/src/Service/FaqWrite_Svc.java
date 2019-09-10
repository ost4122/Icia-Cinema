package Service;

import java.sql.Connection;

import Dao.FaqDAO;

import static Db.JdbcUtil.*;

import Dto.FaqDTO;

public class FaqWrite_Svc {

	public boolean faqWrite(FaqDTO faqDTO) {
		
		//DB호출
		Connection con = getConnection();
		FaqDAO faqDAO = FaqDAO.getInstrance();
		faqDAO.setConnection(con);
		
		//자주찾는 질문 쓰기 Service
		int result = faqDAO.faqWrite(faqDTO);
		
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
