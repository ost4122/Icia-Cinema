package Service;

import static Db.JdbcUtil.*;

import java.sql.*;

import Dao.DBDAO;

public class FindId_Svc {

	public String idFindDB(String name, String birth, String phone) {
		
				// db접속 , Connection이라는 인터페이스사용
				Connection con =getConnection();
				// DBDAO 클래스에 대한 싱글톤 객체 생성
				DBDAO dbdao = DBDAO.getInstrance();
				// DAO 클래스에 접속 완료된 정보를 전달
				dbdao.setConnection(con);
		
		String loginresult =dbdao.idFindDB(name,birth,phone);

		close(con);
		return loginresult;
		
	}
	
	

}
