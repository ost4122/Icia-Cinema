package Dao;

import static Db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dto.NoticeDTO;

public class NoticeDAO {

	
		private static NoticeDAO noticeDAO;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		public static NoticeDAO getInstrance() {
			
			// 싱글톤 : 하나의 객체만 만들수 있게 만듬
			if(noticeDAO == null) {
				noticeDAO = new NoticeDAO();
			}
			return noticeDAO;
		}
		
		public  void setConnection(Connection con) {
			this.con = con;
		}
		
		
		
		
        //NoticeWrite 메소드
		public int noticeWrite(NoticeDTO noticeDTO) {
			String sql="INSERT INTO NOTICE VALUES(NOTICENUM_SEQ.NEXTVAL,?,?,?,SYSDATE,0,?)";
			int result=0;
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, noticeDTO.getNoticeWriter());    //작성자
				pstmt.setString(2, noticeDTO.getNoticeSubject());   //제목
				pstmt.setString(3, noticeDTO.getNoticeContents());  //내용
				pstmt.setString(4, noticeDTO.getNoticeFile());      //첨부파일
				result=pstmt.executeUpdate();
				
			} catch(Exception e) {
				System.out.println("noticeWrite DAO 오류");
				e.printStackTrace();
			}
			
			return result;
		}
		
		
        //BoardCount메소드 
		public int boardCount() {
			String sql = "SELECT COUNT(*) FROM NOTICE";
			int boardCount = 0;
			
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					boardCount = rs.getInt(1);  //getInt(1) 열에 있는 조회결과를 가지고 오겠다
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			
			return boardCount;
		}
		
		
		
		
		//NoticeList (글목록) 메소드
		public ArrayList<NoticeDTO> noticeListPaging(int startRow, int endRow) {
			String sql = "SELECT * FROM NOTICELIST WHERE NOTICELIST.RN BETWEEN ? AND ?";
			//조회결과를 정리해서 담을 ArrayList 객체 선언
			ArrayList<NoticeDTO> noticeList = 
					new ArrayList<NoticeDTO>();
			// BoardDTO 타입의 변수 선언
			NoticeDTO noticeDTO = null;
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					do {
						noticeDTO = new NoticeDTO();
						noticeDTO.setNoticeNumber(rs.getInt("noticeNumber"));        //글번호
						noticeDTO.setNoticeWriter(rs.getString("noticeWriter"));     //작성자
						noticeDTO.setNoticeSubject(rs.getString("noticeSubject"));   //제목
						noticeDTO.setNoticeContents(rs.getString("noticeContents")); //내용
						noticeDTO.setNoticeDate(rs.getDate("noticeDate"));           //작성날짜
						noticeDTO.setNoticeHit(rs.getInt("noticeHit"));              //조회수
					noticeList.add(noticeDTO);
					
					} while(rs.next());
				}
			} catch (Exception e) {
				  System.out.println("리스트를 찾을 수 없습니다.");
				  e.printStackTrace();
			  } finally {
					close(pstmt);
					close(rs);
				}
			
			return noticeList;
		}
		
	
		// NoticeListOrder (조회수순 정렬) 메소드
	    public ArrayList<NoticeDTO> noticeListOrder() {
		    String sql = "SELECT * FROM NOTICE ORDER BY NOTICEHIT DESC";
		    // 조회결과를 정리해서 담을 ArrayList 객체 선언
		    ArrayList<NoticeDTO> noticeList = 
				    new ArrayList<NoticeDTO>();
		    // BoardDTO 타입의 변수 선언
		    NoticeDTO noticeDTO = null;

		    try {
			    pstmt = con.prepareStatement(sql);
			    rs = pstmt.executeQuery();

			    if (rs.next()) {
				    do {
					    noticeDTO = new NoticeDTO();
					    noticeDTO.setNoticeNumber(rs.getInt("noticeNumber"));        //글번호
					    noticeDTO.setNoticeWriter(rs.getString("noticeWriter"));     //작성자
					    noticeDTO.setNoticeSubject(rs.getString("noticeSubject"));   //제목
					    noticeDTO.setNoticeContents(rs.getString("noticeContents")); //내용
					    noticeDTO.setNoticeDate(rs.getDate("noticeDate"));           //작성날짜
					    noticeDTO.setNoticeHit(rs.getInt("noticeHit"));              //조회수
					    noticeList.add(noticeDTO);

				    } while (rs.next());
			    }
		    } catch (Exception e) {
			    System.out.println("리스트를 찾을 수 없습니다.");
			    e.printStackTrace();
		    } finally {
		    	close(pstmt);
		    	close(rs);
		    }

		    return noticeList;
	    }
		
	
		//NoticeHit (조회수) 메소드
		public int increaseHit(int noticeNumber) {
			String sql =
					"UPDATE NOTICE SET NOTICEHIT = NOTICEHIT+1 WHERE NOTICENUMBER=?";
			int result =0;
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, noticeNumber);
				result = pstmt.executeUpdate();
			} catch(Exception e) {
				System.out.println("리스트를 찾을 수 없습니다");
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}
		
		
		//NoticeView (글 상세보기) 메소드
		public NoticeDTO noticeView(int noticeNumber) {
			String sql = "SELECT * FROM NOTICE WHERE NOTICENUMBER=?";
			NoticeDTO viewResult = null;
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, noticeNumber);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					viewResult = new NoticeDTO(); //viewResult를 객체로 선언
					viewResult.setNoticeNumber(rs.getInt("noticeNumber"));         //글번호
					viewResult.setNoticeWriter(rs.getString("noticeWriter"));      //작성자
					viewResult.setNoticeSubject(rs.getString("noticeSubject"));    //제목
					viewResult.setNoticeFile(rs.getString("noticeFile"));          //첨부파일
					viewResult.setNoticeContents(rs.getString("noticeContents"));  //내용
					viewResult.setNoticeDate(rs.getDate("noticeDate"));            //작성날짜
					viewResult.setNoticeHit(rs.getInt("noticeHit"));               //조회수
				}
			} catch (Exception e) {
				System.out.println("리스트를 찾을수 없습니다.");
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			return viewResult;
		}

		
		

		//NoticeDelete (글 삭제)메소드
		public int noticeDelete(int noticeNumber) {
			String sql = "DELETE FROM NOTICE WHERE NOTICENUMBER=?";
			int deleteResult=0;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, noticeNumber);
				deleteResult=pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			}  finally {
				close(pstmt);
			}
			
			return deleteResult;
		}

		
		//NoriceModify (글 수정)메소드
		public int noticeModify(NoticeDTO noticeDTO) {
			String sql = "UPDATE NOTICE SET NOTICEWRITER=?, NOTICESUBJECT=?, NOTICECONTENTS=? WHERE NOTICENUMBER=?";
			int modifyResult =0;
			
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, noticeDTO.getNoticeWriter());
				pstmt.setString(2, noticeDTO.getNoticeSubject());
				pstmt.setString(3, noticeDTO.getNoticeContents());
				pstmt.setInt(4, noticeDTO.getNoticeNumber());
				modifyResult = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return modifyResult;
		}
		
		
		//NoticeSearch (글 검색) 메소드

		public  ArrayList<NoticeDTO> noticeSearch(String noticeSearch) {
			
			String sql = "SELECT * FROM NOTICE WHERE NOTICESUBJECT LIKE ?";   //제목으로 찾기
			
			ArrayList<NoticeDTO> searchList = new ArrayList<NoticeDTO>();
			NoticeDTO noticeDTO = null;
			
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, "%"+noticeSearch+"%");  // 검색할 단어를 전부 입력안해도 앞뒤에 %를 붙여서 찾을 수 있게 해준다.
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					do {
						noticeDTO = new NoticeDTO();
						noticeDTO.setNoticeNumber(rs.getInt("noticeNumber"));
						noticeDTO.setNoticeWriter(rs.getString("noticeWriter"));
						noticeDTO.setNoticeSubject(rs.getString("noticeSubject"));
						noticeDTO.setNoticeContents(rs.getString("noticeContents"));
						noticeDTO.setNoticeDate(rs.getDate("noticeDate"));
						noticeDTO.setNoticeHit(rs.getInt("noticeHit"));
						searchList.add(noticeDTO);
					} while(rs.next());
				}
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		    return searchList;
		}
			
		
		
		
		

	

}
