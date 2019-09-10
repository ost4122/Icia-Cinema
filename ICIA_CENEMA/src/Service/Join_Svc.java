package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.DBDAO;
import Dto.MailDTO;
import Dto.MemberDTO;

public class Join_Svc {

	//로그인
	public int joinDB(MemberDTO memberDTO) {
		
		// db접속 , Connection이라는 인터페이스사용
		Connection con =getConnection();
		// DBDAO 클래스에 대한 싱글톤 객체 생성
		DBDAO dbdao = DBDAO.getInstrance();
		// DAO 클래스에 접속 완료된 정보를 전달
		dbdao.setConnection(con);
	
		
		//service객채생성후 메소드 호출하면서 매개값 전달
		int result = dbdao.joinDB(memberDTO);
		
		if(result>0) {
			commit(con);
			
		}else {
			rollback(con);
		}
		
		close(con);
		return result;

	}

	
	//아이디찾기 이메일인증
	
	public boolean mailDB(MailDTO mailDTO) {
		// db접속 , Connection이라는 인터페이스사용
				Connection con =getConnection();
				// DBDAO 클래스에 대한 싱글톤 객체 생성
				DBDAO dbdao = DBDAO.getInstrance();
				// DAO 클래스에 접속 완료된 정보를 전달
				dbdao.setConnection(con);
				
				boolean joinResult;
				int result ;
				result =dbdao.mailDB(mailDTO);
				
				if(result>0) {
					
					joinResult =true;
					commit(con);
					
					
				}else {
					joinResult =false;
					rollback(con);
				}
				
				return joinResult;

			}
	

	


}
