package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.DBDAO;
import Dto.MemberDTO;

public class MemberViewService {
	//회원정보 
	public MemberDTO member(String nickname) {

		// db접속 , Connection이라는 인터페이스사용
		Connection con =getConnection();
		// DBDAO 클래스에 대한 싱글톤 객체 생성
		DBDAO dbdao = DBDAO.getInstrance();
		// DAO 클래스에 접속 완료된 정보를 전달
		dbdao.setConnection(con);
		
		
		MemberDTO resultList=	
				dbdao.memberList(nickname);
		
		close(con);
		return resultList;
	}

	//정보수정 1
	public MemberDTO modify(String name) {
		Connection con =getConnection();
		// DBDAO 클래스에 대한 싱글톤 객체 생성
		DBDAO dbdao = DBDAO.getInstrance();
		// DAO 클래스에 접속 완료된 정보를 전달
		dbdao.setConnection(con);
		

		MemberDTO resultList=	
				dbdao.membermodify(name);
		
		close(con);
		return resultList;
	}

}
