package Service;

import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.DBDAO;

public class CommentLike_Svc {

	public void CommentLike_svc(String sessionId, int movieNumber, int cmNumber) {
			// db�젒�냽 , Connection�씠�씪�뒗 �씤�꽣�럹�씠�뒪�궗�슜
				Connection con =getConnection();
				// DBDAO �겢�옒�뒪�뿉 ���븳 �떛湲��넠 媛앹껜 �깮�꽦
				DBDAO dbdao = DBDAO.getInstrance();
				// DAO �겢�옒�뒪�뿉 �젒�냽 �셿猷뚮맂 �젙蹂대�� �쟾�떖
				dbdao.setConnection(con);
				int likeResult = dbdao.CommentLike_DAO(sessionId,movieNumber,cmNumber);		
				
				if(likeResult>0) {
					commit(con);
				}else {
					rollback(con);
				}
				close(con);
	}

	public int LikeCount(int cmNumber) {
		// db�젒�냽 , Connection�씠�씪�뒗 �씤�꽣�럹�씠�뒪�궗�슜
		Connection con =getConnection();
		// DBDAO �겢�옒�뒪�뿉 ���븳 �떛湲��넠 媛앹껜 �깮�꽦
		DBDAO dbdao = DBDAO.getInstrance();
		// DAO �겢�옒�뒪�뿉 �젒�냽 �셿猷뚮맂 �젙蹂대�� �쟾�떖
		dbdao.setConnection(con);
		int countResult = dbdao.PlusLike_DAO(cmNumber);
		if(countResult>0) {
			commit(con);
		}else {
			rollback(con);	
		}
		close(con);
		return countResult;
	}

}
