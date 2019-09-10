package Service;

import static Db.JdbcUtil.close;
import static Db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import Dao.DBDAO;
import Dto.MovieDTO;

public class MovieList_Svc {

	public ArrayList<MovieDTO> List_svc() {
		

		System.out.println("MovieList_svc 호출됨");
				// DBDAO 클래스에 대한 싱글톤 객체 생성
				DBDAO dbdao = DBDAO.getInstrance();
				// db접속 , Connection이라는 인터페이스사용
				Connection con =getConnection();
				// DAO 클래스에 접속 완료된 정보를 전달
				dbdao.setConnection(con);
		dbdao.setConnection(con);
		
		ArrayList<MovieDTO> result = dbdao.List_dao();
		
		close(con);
		return result;
	}

}
