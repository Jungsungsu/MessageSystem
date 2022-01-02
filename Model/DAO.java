package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class DAO {
   
   public int Join(String email, String pw, String tel, String address) {
      int cnt = 0;
      Connection conn = null;
      PreparedStatement psmt = null;
      
      // try��
      // JDBC �ڵ�� ������ �´���, �����߿� �߻��ϴ� ����(��Ÿ�� ����) ó�� �ʿ�
      try {
         
         // JDBC
         // 1. �����ε�
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         // 2. ���ᰴü ����
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String dbid = "hr";
         String dbpw = "hr";
         
         conn = DriverManager.getConnection(url, dbid, dbpw);
         
         // 3. sql�� �غ�
         String sql = "insert into web_member values ( ?, ?, ?, ? )";
         psmt = conn.prepareStatement(sql);
         
         // 4. ���ε� ���� ä���
         psmt.setString(1, email);
         psmt.setString(2, pw);
         psmt.setString(3, tel);
         psmt.setString(4, address);
         
         // 5. ����
         // select -> executeQuery() --> return ResultSet
         // insert, delete, update -> executeUpdate() --> return int(�� ���� �����ߴ���)
         cnt = psmt.executeUpdate();
         
      } catch (Exception e) {
         
         e.printStackTrace();
         
      }finally {
         
         // 6. ������ �ݾ��ֱ�
         try {
            if(psmt != null) {
               psmt.close();
            }
            if(conn != null) {
               conn.close();
            }
            
         } catch (Exception e2) {
            // TODO: handle exception
         }
         
      }
      return cnt;
   }
   // =======================================================

public MemberVO Login(String email, String pw) {
	
	Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    MemberVO vo = null;
    
    // try��
    // JDBC �ڵ�� ������ �´���, �����߿� �߻��ϴ� ����(��Ÿ�� ����) ó�� �ʿ�
    try {
       
       // JDBC
       // 1. �����ε�
       Class.forName("oracle.jdbc.driver.OracleDriver");
       
       // 2. ���ᰴü ����
       String url = "jdbc:oracle:thin:@localhost:1521:xe";
       String dbid = "hr";
       String dbpw = "hr";
       
       conn = DriverManager.getConnection(url, dbid, dbpw);
       
       // 3. sql�� �غ�
       String sql = "select * from web_member where email = ? and pw = ?";
       psmt = conn.prepareStatement(sql);
       
       // 4. ���ε� ���� ä���
       psmt.setString(1, email);
       psmt.setString(2, pw);
      
       
       // 5. ����
       // select -> executeQuery() --> return ResultSet
       // insert, delete, update -> executeUpdate() --> return int(�� ���� �����ߴ���)
      rs = psmt.executeQuery();
       
       if(rs.next() == true) {
    	   String userEmail = rs.getString(1);
    	   String userPw = rs.getString(2);
    	   String usertel = rs.getString(3);
    	   String useraddress = rs.getString(4);
    	   
    	   // select���� ����� ��� VO��ü�� �����.
    	   vo = new MemberVO(userEmail, userPw, usertel, useraddress);
       }
       
    } catch (Exception e) {
       
       e.printStackTrace();
       
    }finally {
       
       // 6. ������ �ݾ��ֱ�
       try {
    	   
    	  if(rs != null) {
    		  rs.close();
    	  }
          if(psmt != null) {
             psmt.close();
          }
          if(conn != null) {
             conn.close();
          }
          
       } catch (Exception e2) {
          // TODO: handle exception
       }
       
    }
    return vo;
}
    // =====================================================================

	public int Update(String email, String pw, String tel, String address) {
	
	int cnt = 0;
	Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    MemberVO vo = null;
    
    // try��
    // JDBC �ڵ�� ������ �´���, �����߿� �߻��ϴ� ����(��Ÿ�� ����) ó�� �ʿ�
    try {
       
       // JDBC
       // 1. �����ε�
       Class.forName("oracle.jdbc.driver.OracleDriver");
       
       // 2. ���ᰴü ����
       String url = "jdbc:oracle:thin:@localhost:1521:xe";
       String dbid = "hr";
       String dbpw = "hr";
       
       conn = DriverManager.getConnection(url, dbid, dbpw);
       
       // 3. sql�� �غ�
       String sql = "update web_member set pw = ?, tel =?, address =?  where email=?";
       psmt = conn.prepareStatement(sql);
       
       // 4. ���ε� ���� ä���
       psmt.setString(1, pw);
       psmt.setString(2, tel);
       psmt.setString(3, address);
       psmt.setString(4, email);
      
       
       // 5. ����
       // select -> executeQuery() --> return ResultSet
       // insert, delete, update -> executeUpdate() --> return int(�� ���� �����ߴ���)
       cnt = psmt.executeUpdate();
       
       if(rs.next() == true) {
    	   String userpw = rs.getString(1);
    	   String usertel = rs.getString(2);
    	   String useraddress = rs.getString(3);
    	   String useremail = rs.getString(4);
    	   
    	   // select���� ����� ��� VO��ü�� �����.
    	   vo = new MemberVO(userpw, usertel, useraddress, useremail);
       }
       
    } catch (Exception e) {
       
       e.printStackTrace();
       
    }finally {
       
       // 6. ������ �ݾ��ֱ�
       try {
    	   
    	  if(rs != null) {
    		  rs.close();
    	  }
          if(psmt != null) {
             psmt.close();
          }
          if(conn != null) {
             conn.close();
          }
          
       } catch (Exception e2) {
          
       }
       
    }
	
	return cnt;
}
	// ==================================================================

	public ArrayList<MemberVO> SelectAll() {
			
			Connection conn = null;
		    PreparedStatement psmt = null;
		    ResultSet rs = null;
		    
		    // ����� ����� ArrayList
		    ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		    
		    // try��
		    // JDBC �ڵ�� ������ �´���, �����߿� �߻��ϴ� ����(��Ÿ�� ����) ó�� �ʿ�
		    try {
		       
		       // JDBC
		       // 1. �����ε�
		       Class.forName("oracle.jdbc.driver.OracleDriver");
		       
		       // 2. ���ᰴü ����
		       String url = "jdbc:oracle:thin:@localhost:1521:xe";
		       String dbid = "hr";
		       String dbpw = "hr";
		       
		       conn = DriverManager.getConnection(url, dbid, dbpw);
		       
		       // 3. sql�� �غ�
		       String sql = "select * from web_member";
		       psmt = conn.prepareStatement(sql);
		       
		       // 4. ���ε� ���� ä���
		       
		       // 5. ����
		       // select -> executeQuery() --> return ResultSet
		       // insert, delete, update -> executeUpdate() --> return int(�� ���� �����ߴ���)
		      rs = psmt.executeQuery();
		       
		      // �α��� ����, rs�� �� 1�ุ �־���
		      // ��� ȸ�������� ������ > ��� �ݺ��ؾ� ���� �� > while
		       while(rs.next() == true) {
		    	   String userEmail = rs.getString(1);
		    	   String userPw = rs.getString(2);
		    	   String usertel = rs.getString(3);
		    	   String useraddress = rs.getString(4);
		    	   
		    	   // select���� ����� ��� VO��ü�� �����.
		    	   MemberVO vo = new MemberVO(userEmail, userPw, usertel, useraddress);
		    	   // rs�κ��� ������ �� ���� ������ ArrayList �߰�
		    	   list.add(vo);
		       }
		       
		    } catch (Exception e) {
		       
		       e.printStackTrace();
		       
		    }finally {
		       
		       // 6. ������ �ݾ��ֱ�
		       try {
		    	   
		    	  if(rs != null) {
		    		  rs.close();
		    	  }
		          if(psmt != null) {
		             psmt.close();
		          }
		          if(conn != null) {
		             conn.close();
		          }
		          
		       } catch (Exception e2) {
		          // TODO: handle exception
		       }
		       
		    }
		
		
		return list;
	}
	
	// ===============================================================================
	
	public int Delete(String email) {
		
			int cnt = 0;
			Connection conn = null;
		    PreparedStatement psmt = null;
		    ResultSet rs = null;
		    MemberVO vo = null;
		    
		    // try��
		    // JDBC �ڵ�� ������ �´���, �����߿� �߻��ϴ� ����(��Ÿ�� ����) ó�� �ʿ�
		    try {
		       
		       // JDBC
		       // 1. �����ε�
		       Class.forName("oracle.jdbc.driver.OracleDriver");
		       
		       // 2. ���ᰴü ����
		       String url = "jdbc:oracle:thin:@localhost:1521:xe";
		       String dbid = "hr";
		       String dbpw = "hr";
		       
		       conn = DriverManager.getConnection(url, dbid, dbpw);
		       
		       // 3. sql�� �غ�
		       String sql = "delete from web_member where email=?";
		       psmt = conn.prepareStatement(sql);
		       
		       // 4. ���ε� ���� ä���
		       psmt.setString(1, email);
		      
		       
		       // 5. ����
		       // select -> executeQuery() --> return ResultSet
		       // insert, delete, update -> executeUpdate() --> return int(�� ���� �����ߴ���)
		       cnt = psmt.executeUpdate();
		       
		       if(rs.next() == true) {
		    	   String userpw = rs.getString(1);
		    	   String usertel = rs.getString(2);
		    	   String useraddress = rs.getString(3);
		    	   String useremail = rs.getString(4);
		    	   
		    	   // select���� ����� ��� VO��ü�� �����.
		    	   vo = new MemberVO(userpw, usertel, useraddress, useremail);
		       }
		       
		    } catch (Exception e) {
		       
		       e.printStackTrace();
		       
		    }finally {
		       
		       // 6. ������ �ݾ��ֱ�
		       try {
		    	   
		    	  if(rs != null) {
		    		  rs.close();
		    	  }
		          if(psmt != null) {
		             psmt.close();
		          }
		          if(conn != null) {
		             conn.close();
		          }
		          
		       } catch (Exception e2) {
		          
		       }
		       
		    }
			
		
		
		return cnt;
	}
	// =========================================================================

	public int MsgSend(String send_name, String receive_email, String content) {
		int cnt = 0;
	    Connection conn = null;
	    PreparedStatement psmt = null;
	    
	    // try��
	    // JDBC �ڵ�� ������ �´���, �����߿� �߻��ϴ� ����(��Ÿ�� ����) ó�� �ʿ�
	    try {
	       
	       // JDBC
	       // 1. �����ε�
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	       
	       // 2. ���ᰴü ����
	       String url = "jdbc:oracle:thin:@localhost:1521:xe";
	       String dbid = "hr";
	       String dbpw = "hr";
	       
	       conn = DriverManager.getConnection(url, dbid, dbpw);
	       
	       // 3. sql�� �غ�
	       String sql = "insert into web_message values(msg_num_seq.nextval,?, ?, ?, sysdate)";
	       psmt = conn.prepareStatement(sql);
	       
	       // 4. ���ε� ���� ä���
	       
	       psmt.setString(1, send_name);
	       psmt.setString(2, receive_email);
	       psmt.setString(3, content);
	     
	       
	       // 5. ����
	       // select -> executeQuery() --> return ResultSet
	       // insert, delete, update -> executeUpdate() --> return int(�� ���� �����ߴ���)
	       cnt = psmt.executeUpdate();
	       
	    } catch (Exception e) {
	       
	       e.printStackTrace();
	       
	    }finally {
	       
	       // 6. ������ �ݾ��ֱ�
	       try {
	          if(psmt != null) {
	             psmt.close();
	          }
	          if(conn != null) {
	             conn.close();
	          }
	          
	       } catch (Exception e2) {
	          // TODO: handle exception
	       }
	       
	    }
	   

		return cnt;
	}

	 // ==================================================================================
	public ArrayList<MessageVO> SelectMsg(String email) {
		
		Connection conn = null;
	    PreparedStatement psmt = null;
	    ResultSet rs = null;
	    
	    // ����� ����� ArrayList
	    ArrayList<MessageVO> list = new ArrayList<MessageVO>();
	
	    
	    // try��
	    // JDBC �ڵ�� ������ �´���, �����߿� �߻��ϴ� ����(��Ÿ�� ����) ó�� �ʿ�
	    try {
	       
	       // JDBC
	       // 1. �����ε�
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	       
	       // 2. ���ᰴü ����
	       String url = "jdbc:oracle:thin:@localhost:1521:xe";
	       String dbid = "hr";
	       String dbpw = "hr";
	       
	       conn = DriverManager.getConnection(url, dbid, dbpw);
	       
	       // 3. sql�� �غ�
	       String sql = "select * from web_message where receive_email=?";
	       psmt = conn.prepareStatement(sql);
	       
	       // 4. ���ε� ���� ä���
	       psmt.setString(1, email);
	       // 5. ����
	       // select -> executeQuery() --> return ResultSet
	       // insert, delete, update -> executeUpdate() --> return int(�� ���� �����ߴ���)
	      rs = psmt.executeQuery();
	       
	      // �α��� ����, rs�� �� 1�ุ �־���
	      // ��� ȸ�������� ������ > ��� �ݺ��ؾ� ���� �� > while
	       while(rs.next() == true) {
	    	  
	    	   int bnum = rs.getInt(1); 
	    	   String send_name  = rs.getString(2); 
	    	   String receive_email = email;
	    	   String content = rs.getString(4); 
	    	   String dates = rs.getString(5); 
	    	   
	    	   MessageVO vo = new MessageVO(bnum, send_name, receive_email,
	    			   						content, dates);
	    	   
	    	   list.add(vo);
	       }
	       
	    } catch (Exception e) {
	       
	       e.printStackTrace();
	       
	    }finally {
	       
	       // 6. ������ �ݾ��ֱ�
	       try {
	    	   
	    	  if(rs != null) {
	    		  rs.close();
	    	  }
	          if(psmt != null) {
	             psmt.close();
	          }
	          if(conn != null) {
	             conn.close();
	          }
	          
	       } catch (Exception e2) {
	          // TODO: handle exception
	       }
	       
	    }
	
	    return list;
	}
	// =======================================================================================
	public int WriteBoard(String writer, String title, String fileName, String content) {
		
			int cnt = 0;
		    Connection conn = null;
		    PreparedStatement psmt = null;
		    
		    // try��
		    // JDBC �ڵ�� ������ �´���, �����߿� �߻��ϴ� ����(��Ÿ�� ����) ó�� �ʿ�
		    try {
		       
		       // JDBC
		       // 1. �����ε�
		       Class.forName("oracle.jdbc.driver.OracleDriver");
		       
		       // 2. ���ᰴü ����
		       String url = "jdbc:oracle:thin:@localhost:1521:xe";
		       String dbid = "hr";
		       String dbpw = "hr";
		       
		       conn = DriverManager.getConnection(url, dbid, dbpw);
		       
		       // 3. sql�� �غ�
		       String sql = "insert into web_board values(board_num_seq.nextval,?,?,?,?,sysdate)";
		       psmt = conn.prepareStatement(sql);
		       
		       // 4. ���ε� ���� ä���
		       
		       psmt.setString(1, writer);
		       psmt.setString(2, title);
		       psmt.setString(3, fileName);
		       psmt.setString(4, content);
		     
		       
		       // 5. ����
		       // select -> executeQuery() --> return ResultSet
		       // insert, delete, update -> executeUpdate() --> return int(�� ���� �����ߴ���)
		       cnt = psmt.executeUpdate();
		       
		    } catch (Exception e) {
		       
		       e.printStackTrace();
		       
		    }finally {
		       
		       // 6. ������ �ݾ��ֱ�
		       try {
		          if(psmt != null) {
		             psmt.close();
		          }
		          if(conn != null) {
		             conn.close();
		          }
		          
		       } catch (Exception e2) {
		          // TODO: handle exception
		       }
		       
		    }
		   

		return cnt;
	}

	// =====================================================================
	
	public ArrayList<BoardVO> SelectBoard() {
		
		Connection conn = null;
	    PreparedStatement psmt = null;
	    ResultSet rs = null;
	    
	    // ����� ����� ArrayList
	    ArrayList<BoardVO> list = new ArrayList<BoardVO>();
	
	    
	    // try��
	    // JDBC �ڵ�� ������ �´���, �����߿� �߻��ϴ� ����(��Ÿ�� ����) ó�� �ʿ�
	    try {
	       
	       // JDBC
	       // 1. �����ε�
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	       
	       // 2. ���ᰴü ����
	       String url = "jdbc:oracle:thin:@localhost:1521:xe";
	       String dbid = "hr";
	       String dbpw = "hr";
	       
	       conn = DriverManager.getConnection(url, dbid, dbpw);
	       
	       // 3. sql�� �غ�
	       String sql = "select * from web_board";
	       psmt = conn.prepareStatement(sql);
	       
	       // 4. ���ε� ���� ä���
	       
	       // 5. ����
	       // select -> executeQuery() --> return ResultSet
	       // insert, delete, update -> executeUpdate() --> return int(�� ���� �����ߴ���)
	      rs = psmt.executeQuery();
	       
	      // �α��� ����, rs�� �� 1�ุ �־���
	      // ��� ȸ�������� ������ > ��� �ݺ��ؾ� ���� �� > while
	       while(rs.next() == true) {
	    	  
	    	   //  �۹�ȣ, �ۼ���, ����, �����̸�, ����, ��¥
	    	   int num = rs.getInt(1);
	    	   String writer = rs.getString(2);
	    	   String title = rs.getString(3);
	    	   String filename = rs.getString(4);
	    	   String content = rs.getString(5);
	    	   String day= rs.getString(6);
	    	 
	    	   // �Ѻ������� ���´�.
	    	   BoardVO vo = new BoardVO(num, writer, title, filename, content, day);
	    	   
	    	   list.add(vo);
	       }
	       
	    } catch (Exception e) {
	       
	       e.printStackTrace();
	       
	    }finally {
	       
	       // 6. ������ �ݾ��ֱ�
	       try {
	    	   
	    	  if(rs != null) {
	    		  rs.close();
	    	  }
	          if(psmt != null) {
	             psmt.close();
	          }
	          if(conn != null) {
	             conn.close();
	          }
	          
	       } catch (Exception e2) {
	          // TODO: handle exception
	       }
	       
	    }
	    return list;
	
	}
  }

	
    








