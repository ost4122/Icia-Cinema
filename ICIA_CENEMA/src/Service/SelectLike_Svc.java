package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.DBDAO;

public class SelectLike_Svc {

	public String SelectLike_svc(String sessionId, int movieNumber,int cmNumber) {
		
		// db접속 , Connection이라는 인터페이스사용
		Connection con =getConnection();
		// DBDAO 클래스에 대한 싱글톤 객체 생성
		DBDAO dbdao = DBDAO.getInstrance();
		// DAO 클래스에 접속 완료된 정보를 전달
		dbdao.setConnection(con);
		String nickName = dbdao.SelectLike_DAO(sessionId,movieNumber,cmNumber);
		
	
		
		close(con);
		return nickName;
		
	}
	/* 좋아요 삭제*/
	public void DeleteLike_Svc(int cmNumber, String sessionId) {
				// db접속 , Connection이라는 인터페이스사용
				Connection con =getConnection();
				// DBDAO 클래스에 대한 싱글톤 객체 생성
				DBDAO dbdao = DBDAO.getInstrance();
				// DAO 클래스에 접속 완료된 정보를 전달
				dbdao.setConnection(con);
				
				int result = dbdao.DeleteLike_DAO(cmNumber,sessionId);
				
				if(result>0) {
					commit(con);
					
				}else {
					rollback(con);
				}
				close(con);
	}
	
	public void DeleteUpdate(int cmNumber) {
		// db접속 , Connection이라는 인터페이스사용
		Connection con =getConnection();
		// DBDAO 클래스에 대한 싱글톤 객체 생성
		DBDAO dbdao = DBDAO.getInstrance();
		// DAO 클래스에 접속 완료된 정보를 전달
		dbdao.setConnection(con);
		
		int result = dbdao.DeleteLikeUpdate(cmNumber);
	
		close(con);
	}	

}
