package Dao;

import static Db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dto.FaqDTO;

public class FaqDAO {
	private static FaqDAO faqDAO;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static FaqDAO getInstrance() {
		
		// 싱글톤 : 하나의 객체만 만들수 있게 만듬
		if(faqDAO == null) {
			faqDAO = new FaqDAO();
		}
		return faqDAO;
	}
	
	public  void setConnection(Connection con) {
		this.con = con;
	}
	
	//FaqWrite 메소드
			public int faqWrite(FaqDTO faqDTO) {
				String sql="INSERT INTO FAQ VALUES(FAQNUM_SEQ.NEXTVAL,?,?,?,SYSDATE,0,?)";
				int result=0;
				
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, faqDTO.getFaqWriter());    //작성자
					pstmt.setString(2, faqDTO.getFaqSubject());   //제목
					pstmt.setString(3, faqDTO.getFaqContents());  //내용
					pstmt.setString(4, faqDTO.getFaqFile());      //첨부파일
					result=pstmt.executeUpdate();
					
				} catch(Exception e) {
					System.out.println("faqWrite DAO 오류");
					e.printStackTrace();
				}
				
				return result;
			}
			
			
	        //BoardCount메소드 
			public int boardCount() {
				String sql = "SELECT COUNT(*) FROM FAQ";
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
			
			
			
			
			//FaqList (글목록) 메소드
			public ArrayList<FaqDTO> faqListPaging(int startRow, int endRow) {
				String sql = "SELECT * FROM FAQLIST WHERE FAQLIST.RN BETWEEN ? AND ?";
				//조회결과를 정리해서 담을 ArrayList 객체 선언
				ArrayList<FaqDTO> faqList = 
						new ArrayList<FaqDTO>();
				// BoardDTO 타입의 변수 선언
				FaqDTO faqDTO = null;
				
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					rs=pstmt.executeQuery();
					
					if(rs.next()) {
						do {
							faqDTO = new FaqDTO();
							faqDTO.setFaqNumber(rs.getInt("faqNumber"));        //글번호
							faqDTO.setFaqWriter(rs.getString("faqWriter"));     //작성자
							faqDTO.setFaqSubject(rs.getString("faqSubject"));   //제목
							faqDTO.setFaqContents(rs.getString("faqContents")); //내용
							faqDTO.setFaqDate(rs.getDate("faqDate"));           //작성날짜
							faqDTO.setFaqHit(rs.getInt("faqHit"));              //조회수
						faqList.add(faqDTO);
						
						} while(rs.next());
					}
				} catch (Exception e) {
					  System.out.println("리스트를 찾을 수 없습니다.");
					  e.printStackTrace();
				  } finally {
						close(pstmt);
						close(rs);
					}
				
				return faqList;
			}
			
		
			// FaqListOrder (조회수순 정렬) 메소드
		    public ArrayList<FaqDTO> faqListOrder() {
			    String sql = "SELECT * FROM FAQ ORDER BY FAQHIT DESC";
			    // 조회결과를 정리해서 담을 ArrayList 객체 선언
			    ArrayList<FaqDTO> faqList = 
					    new ArrayList<FaqDTO>();
			    // BoardDTO 타입의 변수 선언
			    FaqDTO faqDTO = null;

			    try {
				    pstmt = con.prepareStatement(sql);
				    rs = pstmt.executeQuery();

				    if (rs.next()) {
					    do {
					    	faqDTO = new FaqDTO();
					    	faqDTO.setFaqNumber(rs.getInt("FaqNumber"));        //글번호
					    	faqDTO.setFaqWriter(rs.getString("FaqWriter"));     //작성자
					    	faqDTO.setFaqSubject(rs.getString("FaqSubject"));   //제목
					    	faqDTO.setFaqContents(rs.getString("FaqContents")); //내용
					    	faqDTO.setFaqDate(rs.getDate("FaqDate"));           //작성날짜
					    	faqDTO.setFaqHit(rs.getInt("FaqHit"));              //조회수
						    faqList.add(faqDTO);

					    } while (rs.next());
				    }
			    } catch (Exception e) {
				    System.out.println("리스트를 찾을 수 없습니다.");
				    e.printStackTrace();
			    } finally {
			    	close(pstmt);
			    	close(rs);
			    }

			    return faqList;
		    }
			
		
			//FaqHit (조회수) 메소드
			public int increaseHit(int faqNumber) {
				String sql =
						"UPDATE FAQ SET FAQHIT = FAQHIT+1 WHERE FAQNUMBER=?";
				int result =0;
				
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, faqNumber);
					result = pstmt.executeUpdate();
				} catch(Exception e) {
					System.out.println("리스트를 찾을 수 없습니다");
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
				return result;
			}
			
			
			//FaqView (글 상세보기) 메소드
			public FaqDTO faqView(int faqNumber) {
				String sql = "SELECT * FROM FAQ WHERE FAQNUMBER=?";
				FaqDTO viewResult = null;
				
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, faqNumber);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						viewResult = new FaqDTO(); //viewResult를 객체로 선언
						viewResult.setFaqNumber(rs.getInt("faqNumber"));         //글번호
						viewResult.setFaqWriter(rs.getString("faqWriter"));      //작성자
						viewResult.setFaqSubject(rs.getString("faqSubject"));    //제목
						viewResult.setFaqFile(rs.getString("faqFile"));          //첨부파일
						viewResult.setFaqContents(rs.getString("faqContents"));  //내용
						viewResult.setFaqDate(rs.getDate("faqDate"));            //작성날짜
						viewResult.setFaqHit(rs.getInt("faqHit"));               //조회수
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

			
			

			//FaqDelete (글 삭제)메소드
			public int faqDelete(int faqNumber) {
				String sql = "DELETE FROM FAQ WHERE FAQNUMBER=?";
				int deleteResult=0;
				try {
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, faqNumber);
					deleteResult=pstmt.executeUpdate();
				} catch(Exception e) {
					e.printStackTrace();
				}  finally {
					close(pstmt);
				}
				
				return deleteResult;
			}

			
			//FaqModify (글 수정)메소드
			public int faqModify(FaqDTO faqDTO) {
				String sql = "UPDATE FAQ SET FAQWRITER=?, FAQSUBJECT=?, FAQCONTENTS=? WHERE FAQNUMBER=?";
				int modifyResult =0;
				
				try {
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, faqDTO.getFaqWriter());
					pstmt.setString(2, faqDTO.getFaqSubject());
					pstmt.setString(3, faqDTO.getFaqContents());
					pstmt.setInt(4, faqDTO.getFaqNumber());
					modifyResult = pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
				
				return modifyResult;
			}
			
			
			//FaqSearch (글 검색) 메소드

			public  ArrayList<FaqDTO> faqSearch(String faqSearch) {
				
				String sql = "SELECT * FROM FAQ WHERE FAQSUBJECT LIKE ?";   //제목으로 찾기
				ArrayList<FaqDTO> searchList = new ArrayList<FaqDTO>();
				FaqDTO faqDTO = null;
				
				try {
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, "%"+faqSearch+"%");  // 검색할 단어를 전부 입력안해도 앞뒤에 %를 붙여서 찾을 수 있게 해준다.
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						do {
							faqDTO = new FaqDTO();
							faqDTO.setFaqNumber(rs.getInt("faqNumber"));
							faqDTO.setFaqWriter(rs.getString("faqWriter"));
							faqDTO.setFaqSubject(rs.getString("faqSubject"));
							faqDTO.setFaqContents(rs.getString("faqContents"));
							faqDTO.setFaqDate(rs.getDate("faqDate"));
							faqDTO.setFaqHit(rs.getInt("faqHit"));
							searchList.add(faqDTO);
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
