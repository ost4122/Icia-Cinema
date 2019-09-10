package Service;

import static Db.JdbcUtil.*;


import java.sql.Connection;

import Dao.DBDAO;
import Dto.MemberDTO;

public class MemberModifyService {

	public boolean memberModify(MemberDTO memberDTO) {
		Connection con =getConnection();
		// DBDAO 클래스에 대한 싱글톤 객체 생성
		DBDAO dbdao = DBDAO.getInstrance();
		// DAO 클래스에 접속 완료된 정보를 전달
		dbdao.setConnection(con);		
	
		int result = dbdao.MemberModify2(memberDTO);
		boolean modifyResult = false;
		if(result >0) {
			modifyResult =true;
			commit(con);
			
		}else {
			
			modifyResult = false;
			rollback(con);
		}
		
		close(con);
		
	
		
		return modifyResult;
	}

}
