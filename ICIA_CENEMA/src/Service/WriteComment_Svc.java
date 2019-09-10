package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.DBDAO;

public class WriteComment_Svc {

	public int writeComment_Svc(String sessionId, int movieNumber, String comment) {
		System.out.println("WriteComment_svc 호출됨");
				// DBDAO 클래스에 대한 싱글톤 객체 생성
				DBDAO dbdao = DBDAO.getInstrance();
				// db접속 , Connection이라는 인터페이스사용
				Connection con =getConnection();
				// DAO 클래스에 접속 완료된 정보를 전달
				dbdao.setConnection(con);
		
		int result = dbdao.writeComment_DAO(sessionId, movieNumber,comment);
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	
	}

}
