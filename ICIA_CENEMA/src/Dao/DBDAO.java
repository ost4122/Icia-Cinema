package Dao;
import static Db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.DBDAO;
import Dto.CommentDTO;
import Dto.MailDTO;
import Dto.MemberDTO;
import Dto.MovieDTO;

public class DBDAO {
	
	
	private static DBDAO dbdao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result=0;
	
	public static DBDAO getInstrance() { 
		// 싱글톤 : 하나의 객체만 만들수 있게 만듬                        
		if(dbdao == null) {
			dbdao = new DBDAO();
		}
		return dbdao;
	}
	
	public  void setConnection(Connection con) {
		this.con = con;
	}

	
	// 영화 정보 가져오기
	public MovieDTO movieInfor(int num) {
		System.out.println("movieInfor DAO 호출");
		String sql = "SELECT * FROM MOVIE WHERE MOVIENUMBER=?";
		MovieDTO result = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MovieDTO();
				result.setMovieNumber(rs.getInt("MOVIENUMBER"));
				result.setMovieSubject(rs.getString("MOVIESUBJECT"));
				result.setGrade(rs.getDouble("GRADE"));
				result.setDirector(rs.getString("DIRECTOR"));
				result.setFilmRatings(rs.getInt("FILMRATINGS"));
				result.setShowTimes(rs.getInt("SHOWTIMES"));
				result.setReleaseDate(rs.getString("RELEASEDATE"));
				result.setCastMembers(rs.getString("CASTMEMBERS"));
				result.setPoster(rs.getString("POSTER"));
				result.setMovieContents(rs.getString("MOVIECONTENTS"));
				result.setTrailer(rs.getString("MOVIETRAILER"));
			}
		} catch (Exception e) {
			System.out.println("movieInfor DAO 오류");
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
	
	
	/* 영화 목록 */
	public ArrayList<MovieDTO> List_dao() {
		System.out.println("movieList DAO 호출");
		String sql = "SELECT * FROM MOVIE";
		ArrayList<MovieDTO> movieList = new ArrayList<MovieDTO>();
		MovieDTO movieDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					movieDTO = new MovieDTO();
					movieDTO.setMovieNumber(rs.getInt("MOVIENUMBER"));
					movieDTO.setMovieSubject(rs.getString("MOVIESUBJECT"));
					movieDTO.setGrade(rs.getDouble("GRADE"));
					movieDTO.setDirector(rs.getString("DIRECTOR"));
					movieDTO.setFilmRatings(rs.getInt("FILMRATINGS"));
					movieDTO.setShowTimes(rs.getInt("SHOWTIMES"));
					movieDTO.setReleaseDate(rs.getString("RELEASEDATE"));
					movieDTO.setCastMembers(rs.getString("CASTMEMBERS"));
					movieDTO.setPoster(rs.getString("POSTER"));
					movieDTO.setMovieContents(rs.getString("MOVIECONTENTS"));
					movieDTO.setTrailer(rs.getString("MOVIETRAILER"));
					
					movieList.add(movieDTO);
					
				}while(rs.next());
			}
			
			
		} catch (Exception e) {
			System.out.println("movieList DAO 오류");
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return movieList;
	}
	
	
	/* 영화 등록 */
	public int inputMovie(MovieDTO mdto) {
		String sql ="INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getMovieSubject());
			pstmt.setDouble(2, mdto.getGrade());
			pstmt.setString(3, mdto.getDirector());
			pstmt.setInt(4, mdto.getFilmRatings());
			pstmt.setInt(5, mdto.getShowTimes());
			pstmt.setString(6, mdto.getReleaseDate());
			pstmt.setString(7, mdto.getCastMembers());
			pstmt.setString(8, mdto.getPoster());
			pstmt.setString(9, mdto.getMovieContents());
			pstmt.setString(10, mdto.getTrailer());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("InputMovie_DAO 오류");
			e.printStackTrace();
		}finally {
		close(pstmt);
		}
		return result;
	}

	/* 평점주기 참여자 */
	public void giveRating_Count_DAO(int movieNumber) {
		String sql = "UPDATE MOVIE SET GIVERATING = GIVERATING+1 WHERE MOVIENUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, movieNumber);
			pstmt.executeUpdate();
			commit(con);
		} catch (Exception e) {
			System.out.println("giveRating_Count_DAO 오류");
			e.printStackTrace();
		}finally {
			close(pstmt);
		} 
	}

	/* 평점 업데이트 */
	public int giveRating_DAO(int movieNumber, int star) {
		String sql = "UPDATE MOVIE SET GRADE = (GRADE+(?/GIVERATING))/100 WHERE MOVIENUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, star);
			pstmt.setInt(2, movieNumber);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("giveRating_DAO 오류");
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	return result;	
	}

	/*글 삭제*/
	public int deleteMovie_DAO(int[] movieNumber) {
		String sql = "DELETE MOVIE WHERE MOVIENUMBER=?";
		int result = 0;
		try {
			for(int i = 0 ; i < movieNumber.length; i++) {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieNumber[i]);
			result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("deleteMovie_DAO 오류");
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

	/* 댓글 등록 */
	
	public int writeComment_DAO(String sessionId, int movieNumber,String comment) {
		String sql="INSERT INTO CMBOARD VALUES(COMMENT_SEQ.NEXTVAL,?,?,SYSDATE,?,0)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sessionId);
			pstmt.setInt(2, movieNumber);
			pstmt.setString(3, comment);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("writeComment_DAO 오류");
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/* 댓글 목록 불러오기 */
	public ArrayList<CommentDTO> commentList_DAO(int num) {
		ArrayList<CommentDTO> commentList = new ArrayList<CommentDTO>();
		CommentDTO cDTO = null;
		String sql="SELECT * FROM CMBOARD WHERE MOVIENUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
				if(rs.next()) {
				do {
					cDTO = new CommentDTO();
					cDTO.setCommentNumber(rs.getInt("CMNUMBER"));
					cDTO.setMovieNumber(rs.getInt("MOVIENUMBER"));
					cDTO.setWriter(rs.getString("NICKNAME"));
					cDTO.setContents(rs.getString("CONTENTS"));
					cDTO.setWriteDate(rs.getDate("WRITEDATE"));
					cDTO.setCommentHit(rs.getInt("COMMENTHIT"));
					commentList.add(cDTO);
				}while(rs.next());
				
			}
			
		} catch (Exception e) {
			System.out.println("commentList_DAO 오류");
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return commentList;
	}
	
	
	public String loginDB(String email, String password) {
		String sql= ("SELECT * FROM MEMBERS WHERE EMAIL=? AND PASSWORD=?");//값이 하나여서 물음표가 한개이고 두개만 
		String nickname = null;
		try {
			System.out.println("doa호출");
			//쿼리문 세팅 
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			
			//(1,data1)에서 1은 물음표의 위치
			
			//문자말고 숫자를 입력할땐 setInt를 쓴다 
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nickname = rs.getString("NICKNAME");
			}
			
			//result가 성공하면 1 실패하면0
			//System.out.println("result값 :"+result);
			//DB에 commit을 주기위한 commit 메소드 호출
			
		} catch (Exception e) {
			System.out.println("로그인안됨!!");
			e.printStackTrace();
			
		}finally {
			close(pstmt);
			close(rs);
		}
		return nickname;
	}

	/* 이메일(아이디)중복확인*/
	public int checkDB(String email) {
		String sql= ("SELECT EMAIL FROM MEMBERS WHERE EMAIL=?");//값이 하나여서 물음표가 한개이고 두개만 
		int result = 0;
		try {
			System.out.println("doa호출");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,email);
			
			
			
			result =pstmt.executeUpdate();
			System.out.println("sql 완료");
			
		} catch (Exception e) {
			System.out.println("아이디중복체크가 잘못됐다!!");
			e.printStackTrace();
			
		}finally {
			close(pstmt);
		}
		
	
		return result;
	}

	/* 이메일 찾기 */
	public String idFindDB(String name, String birth, String phone) {
		String sql= "SELECT EMAIL FROM MEMBERS WHERE NAME=? AND BIRTH=? AND PHONE=?";//값이 하나여서 물음표가 한개이고 두개만 
		String email = null;
		try {
			System.out.println("doa호출");
			//쿼리문 세팅 
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,birth);
			pstmt.setString(3,phone);
			
			//(1,data1)에서 1은 물음표의 위치
			
			//문자말고 숫자를 입력할땐 setInt를 쓴다 
			rs =pstmt.executeQuery();
			//result가 성공하면 1 실패하면0
			
			if(rs.next()) {
				email = rs.getString("EMAIL");
				System.out.println("sql 완료");
				
			}
			
		} catch (Exception e) {
			System.out.println("아이디찾기실패!");
			e.printStackTrace();
			
		}finally {
			close(pstmt);
			close(rs);
		}
		
	
		return email;
	}


	/* 회원가입 */
	public int joinDB(MemberDTO memberDTO) {
		//전달받은 data1을 sql문을 이용해서 db에 저장
		String sql= "INSERT INTO MEMBERS VALUES(?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?)"; //값이 하나여서 물음표가 한개이고 두개만 
		int result = 0;
		
		try {
			System.out.println("doa호출");
			//쿼리문 세팅 
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,memberDTO.getEmail());
			pstmt.setString(2,memberDTO.getNickname());
			pstmt.setString(3,memberDTO.getPassword());
			pstmt.setString(4, memberDTO.getName());
			pstmt.setString(5, memberDTO.getBirth());
			pstmt.setString(6, memberDTO.getPhone());
			
			result =pstmt.executeUpdate();
			System.out.println("sql 완료");
		
		} catch (Exception e) {
			System.out.println("회원가입하다가 잘못됐다!!");
			e.printStackTrace();
			
		}finally {
			close(pstmt);
		}
	
		return result;
	}
	/* 좋아요 중복확인*/
	public String SelectLike_DAO(String sessionId, int movieNumber,int cmNumber) {
		String nickName = null;
		String sql ="SELECT NICKNAME FROM CMLIKE WHERE MOVIENUMBER=? AND CMNUMBER=? AND NICKNAME=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, movieNumber);
			pstmt.setInt(2, cmNumber);
			pstmt.setString(3,sessionId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nickName = rs.getString("NICKNAME");
			}
			
		} catch (Exception e) {
			System.out.println("SelectLike_DAO 오류");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return nickName;
	}

	/* 좋아요 */
	public int CommentLike_DAO(String sessionId, int movieNumber, int cmNumber) {
		int likeResult=0;
		String sql ="INSERT INTO CMLIKE VALUES(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movieNumber);
			pstmt.setInt(2, cmNumber);
			pstmt.setString(3, sessionId);
			likeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("CommentLike_DAO 오류");
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return likeResult;
	}

	/* 좋아요 */
	public int CommentLike_DAO(int cmNumber) {
		int CountResult = 0;
		String sql = "UPDATE CMBOARD SET COMMENTHIT=COMMENTHIT+1 WHERE CMNUMBER=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cmNumber);
			CountResult = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("CommentLike_DAO 오류");
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return CountResult;
	}

	//닉네임 죽복체크
	public int nickcheckDB(String nickname) {
		String sql= ("SELECT NICKNAME FROM MEMBERS WHERE NICKNAME=?");//값이 하나여서 물음표가 한개이고 두개만 
		try {
			System.out.println("doa호출");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,nickname);
			
			result =pstmt.executeUpdate();
			System.out.println("sql 완료");
			
		} catch (Exception e) {
			System.out.println("회원가입하다가 잘못됐다!!");
			e.printStackTrace();
			
		}
		
	
		return result;
	}

	
	//비밀번호찾기 임버비밀번호 메일인증
	public int mailDB(MailDTO mailDTO) {

		String sql= "UPDATE MEMBERS SET PASSWORD=? WHERE EMAIL=?"; //값이 하나여서 물음표가 한개이고 두개만 

		try {
			System.out.println("doa호출");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,mailDTO.getContent());
			pstmt.setString(2,mailDTO.getReceiver());
			
			result =pstmt.executeUpdate();
			System.out.println("sql 완료");
		
		} catch (Exception e) {
			System.out.println("임시이메일등록완료");
			e.printStackTrace();
			
		}
		return result;
	}

	//회원정보 (mypage)
	public MemberDTO memberList(String nickname) {
		String sql = "SELECT * FROM MEMBERS WHERE NICKNAME =?";

		MemberDTO memberDTO = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery(); 

			if (rs.next()) { 

				memberDTO = new MemberDTO();
				memberDTO.setEmail(rs.getString("EMAIL"));
				memberDTO.setNickname(rs.getString("NICKNAME"));
				memberDTO.setPassword(rs.getString("PASSWORD"));
				memberDTO.setName(rs.getString("NAME"));
				memberDTO.setBirth(rs.getString("BIRTH"));
				memberDTO.setPhone(rs.getString("PHONE"));
				
				System.out.println("확인.");

			}
		} catch (SQLException e) { // SQLException SQL인셉션을 볼것인지 Exception모든 인셉션 볼것인지
			System.out.println("오류뜸");
			e.printStackTrace();

		} finally {
			close(con);
			
		}

		return memberDTO;
	}

	public MemberDTO membermodify(String name) {
		String sql = "SELECT * FROM MEMBERS WHERE NAME =?";// 디벨로퍼 안에 테이블의 셀렉트한걸 sql 매개값을 설정

		MemberDTO memberDTO = null;

		try {
			pstmt = con.prepareStatement(sql);// 쿼리문 준비 (DAO에서 위에 sql을 디벨로퍼로 전송할것이다 라는준비상태)
			pstmt.setString(1, name);
			rs = pstmt.executeQuery(); // 쿼리문 실행 결과값을 임시로 저장 executeQuery(컨트롤엔터한것을)rs로 저장한다

			if (rs.next()) { // next 결과값이 있는지 없는지 확인하는 메소드 트루면 1 패일이면 0

				memberDTO = new MemberDTO();

//					
				memberDTO = new MemberDTO();
				memberDTO.setEmail(rs.getString("EMAIL"));
				memberDTO.setNickname(rs.getString("NICKNAME"));
				memberDTO.setPassword(rs.getString("PASSWORD"));
				memberDTO.setName(rs.getString("NAME"));
				memberDTO.setBirth(rs.getString("BIRTH"));
				memberDTO.setPhone(rs.getString("PHONE"));
				
				System.out.println("확인.");

			}
		} catch (SQLException e) { // SQLException SQL인셉션을 볼것인지 Exception모든 인셉션 볼것인지
			System.out.println("오류뜸");
			e.printStackTrace();

		} finally {
			close(con);
			
		}

		return memberDTO;
	}

	public int MemberModify2(MemberDTO memberDTO) {
		String sql = "UPDATE MEMBERS SET PASSWORD=?,NAME=?, BIRTH=? WHERE NICKNAME =?";
		int modifyResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);//쿼리문 준비...
			pstmt.setString(1,memberDTO.getPassword());
			pstmt.setString(2,memberDTO.getName());
			pstmt.setString(3,memberDTO.getBirth());
			pstmt.setString(4,memberDTO.getNickname());
			modifyResult=pstmt.executeUpdate();//쿼리문 실행

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return modifyResult;
	}

	//회원탈퇴
	public int DROP(String nickname) {
		String sql = "DELETE FROM MEMBERS WHERE NICKNAME=?";
		int result = 0;

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, nickname);

			result = pstmt.executeUpdate(); 
			MemberDTO memberDTO = null; 

			System.out.println(result);

		} catch (SQLException e) { 
			System.out.println("오류뜸");
			e.printStackTrace();

		} 
		return result;
	}


	/* 좋아요올림*/
	public int PlusLike_DAO(int cmNumber) {
		int CountResult = 0;
		String sql = "UPDATE CMBOARD SET COMMENTHIT=COMMENTHIT+1 WHERE CMNUMBER=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cmNumber);
			CountResult = pstmt.executeUpdate();
			commit(con);
		} catch (Exception e) {
			System.out.println("CommentLike_DAO �삤瑜�");
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return CountResult;
	}

	/*좋아요내리기*/
	public int DeleteLike_DAO(int cmNumber,String sessionId) {
		String sql = "DELETE CMLIKE WHERE CMNUMBER=? AND NICKNAME=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cmNumber);
			pstmt.setString(2, sessionId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DeleteLike_DAO �삤瑜�");
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
	}
//좋아요 내림
	public int DeleteLikeUpdate(int cmNumber) {
		String sql="UPDATE CMBOARD SET COMMENTHIT=COMMENTHIT-1 WHERE CMNUMBER=? ";
		int result =0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cmNumber);
			result = pstmt.executeUpdate();
			commit(con);
			
		} catch (Exception e) {
			System.out.println("DeleteLikeUpdate_DAO �삤瑜�");
			e.printStackTrace();
			
		}
		return result;
	}



	/* 좋아요 누른사람갖고오기*/
	public ArrayList<CommentDTO> LikeList_DAO(int cmNumber) {
		 ArrayList<CommentDTO> likeList = new  ArrayList<CommentDTO>();
		 CommentDTO cdto = null;
		 String sql ="SELECT NICKNAME FROM CMLIKE WHERE CMNUMBER=?";
					 try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, cmNumber);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					do {
						cdto = new CommentDTO();
						cdto.setNickName(rs.getString("NICKNAME"));
						likeList.add(cdto);
								
					}while(rs.next());
				}
			} catch (Exception e) {
				System.out.println("LikeList_DAO �삤瑜� !");
				e.printStackTrace();
			}
			 
		return likeList;
	}






}

	

	 
