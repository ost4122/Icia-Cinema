package Service;

import static Db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;

import Dao.FaqDAO;
import Dto.FaqDTO;

public class FaqSearch_Svc {

	public ArrayList<FaqDTO> faqSearch(String faqSearch) {
		//DB호출
		Connection con = getConnection();
		FaqDAO faqDAO = FaqDAO.getInstrance();
		faqDAO.setConnection(con);
		
		//자주찾는 질문 검색 Service
		ArrayList<FaqDTO> searchList = 
				faqDAO.faqSearch(faqSearch);
		close(con);
		
		return searchList;
		
	
	}
	
	

}
