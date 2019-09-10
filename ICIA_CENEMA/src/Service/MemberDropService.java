package Service;

import static Db.JdbcUtil.*;


import java.sql.Connection;

import Dao.DBDAO;

public class MemberDropService {

	public boolean DROP(String nickname) {
		// db접속 , Connection이라는 인터페이스사용
		Connection con =getConnection();
		// DBDAO 클래스에 대한 싱글톤 객체 생성
		DBDAO dbdao = DBDAO.getInstrance();
		// DAO 클래스에 접속 완료된 정보를 전달
		dbdao.setConnection(con);
		boolean drop;
		int result;
		result =dbdao.DROP(nickname);

		if(result>0) {
			
			drop= true;
			commit(con);
			
			
		}else {
			drop=false;
			rollback(con);
		}
		
		
		return drop;
	}

}
