package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.DBDAO;
import Dto.MemberDTO;

public class Login_Svc {

	public String loginDB(String email, String password) {
		
		

				// db접속 , Connection이라는 인터페이스사용
				Connection con =getConnection();
				// DBDAO 클래스에 대한 싱글톤 객체 생성
				DBDAO dbdao = DBDAO.getInstrance();
				// DAO 클래스에 접속 완료된 정보를 전달
				dbdao.setConnection(con);
		
		//service객채생성후 메소드 호출하면서 매개값 전달
		
		
		String loginresult = dbdao.loginDB(email,password);
	
		close(con);
		return loginresult;
		
	
		
	
		
	}
		//아이디중복확인
	public boolean check(String email) {
		// db접속 , Connection이라는 인터페이스사용
		Connection con =getConnection();
		// DBDAO 클래스에 대한 싱글톤 객체 생성
		DBDAO dbdao = DBDAO.getInstrance();
		// DAO 클래스에 접속 완료된 정보를 전달
		dbdao.setConnection(con);
		boolean joinResult;
		boolean result;
		
		
		
		
		int loginresult =dbdao.checkDB(email);
	
		if(loginresult>0) {
			
			result =true;
			commit(con);
			
			
		}else {
			result =false;
			rollback(con);
		}
		return result;
	
	}
	
	//닉네임 중복확인
	
	public boolean nickname(String nickname) {
		// db접속 , Connection이라는 인터페이스사용
				Connection con =getConnection();
				// DBDAO 클래스에 대한 싱글톤 객체 생성
				DBDAO dbdao = DBDAO.getInstrance();
				// DAO 클래스에 접속 완료된 정보를 전달
				dbdao.setConnection(con);
				
				boolean result;
				boolean joinResult;
				
				int loginresult =dbdao.nickcheckDB(nickname);
				
				if(loginresult>0) {
					
					result =true;
					commit(con);
					
					
				}else {
					result =false;
					rollback(con);
				}
				return result;
	}

	
	


																										// 클래스에 대한
		
		

}

