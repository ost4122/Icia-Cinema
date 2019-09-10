package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Dao.DBDAO;
import Dto.CommentDTO;

public class CommentList_Svc {

	public ArrayList<CommentDTO> commentList_Svc(int num) {
		
		System.out.println("CommentList_svc 호출됨");
		// DBDAO 클래스에 대한 싱글톤 객체 생성
		DBDAO dbdao = DBDAO.getInstrance();
		// db접속 , Connection이라는 인터페이스사용
		Connection con =getConnection();
		// DAO 클래스에 접속 완료된 정보를 전달
		dbdao.setConnection(con);
		
		ArrayList<CommentDTO> commentList = new ArrayList<CommentDTO>();
		commentList = dbdao.commentList_DAO(num);
		
		
		close(con);
		return commentList;
	}

}
