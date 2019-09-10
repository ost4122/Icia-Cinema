package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dto.MovieDTO;
import Dao.DBDAO;

public class MovieInformation_Service {

	public MovieDTO movieInformation(int num) {
		
		System.out.println("movieInformation_Service 호출됨");
				// DBDAO 클래스에 대한 싱글톤 객체 생성
				DBDAO dbdao = DBDAO.getInstrance();
				// db접속 , Connection이라는 인터페이스사용
				Connection con =getConnection();
				// DAO 클래스에 접속 완료된 정보를 전달
				dbdao.setConnection(con);
		// dao.movieInfor에 subject 값을 전달하고 리턴값을 result에 담음
		MovieDTO result = dbdao.movieInfor(num);
		close(con);
		return result;
	}
	
	

}
