package Service;

import static Db.JdbcUtil.close;
import static Db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import Dao.DBDAO;
import Dto.CommentDTO;

public class LikeList_Svc {

	public ArrayList<CommentDTO> likelist_svc(int cmNumber) {
		// db접속 , Connection이라는 인터페이스사용
				Connection con =getConnection();
				// DBDAO 클래스에 대한 싱글톤 객체 생성
				DBDAO dbdao = DBDAO.getInstrance();
				// DAO 클래스에 접속 완료된 정보를 전달
				dbdao.setConnection(con);
				
				ArrayList<CommentDTO> likeList = dbdao.LikeList_DAO(cmNumber);
				close(con);
				return likeList;
	}

}
