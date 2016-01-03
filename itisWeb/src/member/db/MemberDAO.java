package member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
		
	public static MemberDAO getInstance(){
		
		return instance;
	}
	
	public MemberDAO(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch(Exception e){
			System.out.println("Error: JDBC Driver loading Failed.");
		}
	}//end constructor
	
	private Connection getConnection() throws Exception {
		Context initCtx=new InitialContext();
		Context envCtx=(Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/itis");
		
		return ds.getConnection();
	}

	public int isMember(MemberBean member){
		int result=-1;
		
		try{
			conn=getConnection();
			String sql="select MEMBER_PW FROM MEMBER WHERE MEMBER_ID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getMEMBER_ID());
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("MEMBER_PW").equals(member.getMEMBER_PW())){
					result=2;
				}else{
					result=0;
				}
			} else {
				result=-1;
			}
		}catch(Exception ex){
			System.out.println("isMember 에러: " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(conn!=null)try{conn.close();}catch(SQLException ex){}
		}
		
		return result;
	}
	
	public boolean insertMember(MemberBean bean){
		boolean flag=false;
		
		try{
			conn=getConnection();
			String sql="insert into member values(?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getMEMBER_ID());
			pstmt.setString(2, bean.getMEMBER_PW());
			pstmt.setString(3, bean.getMEMBER_NAME());
			pstmt.setInt(4, bean.getMEMBER_AGE());
			pstmt.setString(5, bean.getMEMBER_SEX());
			pstmt.setString(6, bean.getMEMBER_EMAIL());
			pstmt.setString(7, bean.getMEMBER_ADDRESS());
			pstmt.setString(8, bean.getMEMBER_PHONE());
			if(pstmt.executeUpdate()==1) flag=true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close(); } catch(SQLException ex) {}
			if(conn!=null) try {conn.close(); } catch(SQLException ex) {}
		}
		
		
		return flag;
	}
	
	//회원 목록 출력
	public Vector<MemberBean> getMemberList(){
		Connection conn=null;
		Statement stmt=null;
			ResultSet rs=null;
			Vector<MemberBean> vecList = new Vector<MemberBean>();
			try{
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/itis","tihola","jun58967");
				String strQuery="SELECT * FROM MEMBER";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(strQuery);
					while(rs.next()) {
						MemberBean mb = new MemberBean();
						mb.setMEMBER_ID(rs.getString("MEMBER_ID"));
						mb.setMEMBER_PW(rs.getString("MEMBER_PW"));
						mb.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
						mb.setMEMBER_AGE(rs.getInt("MEMBER_AGE"));
						mb.setMEMBER_SEX(rs.getString("MEMBER_SEX"));
						mb.setMEMBER_PHONE(rs.getString("MEMBER_PHONE"));
						mb.setMEMBER_ADDRESS(rs.getString("MEMBER_ADDRESS"));
						mb.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
						
						vecList.add(mb);						
					}
			} catch(Exception ex) {
				System.out.println("Exception"+ex);
			} finally {
				if(rs!=null) try{rs.close();} catch(SQLException e){}
				  if(stmt!=null) try{rs.close();} catch(SQLException e){}
				  if(conn!=null) try{conn.close();} catch(SQLException e){}
			}
			
			return vecList;
	}
	
	//회원 상세 정보
	public MemberBean getMemberInfo(String id){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		MemberBean mb = new MemberBean();
			
			try{
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/itis","tihola","jun58967");
				String strQuery="SELECT * FROM MEMBER WHERE MEMBER_ID='"+id+"'";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(strQuery);
				
						if(rs.next()){
							mb.setMEMBER_ID(rs.getString("MEMBER_ID"));
							mb.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
							mb.setMEMBER_AGE(rs.getInt("MEMBER_AGE"));
							mb.setMEMBER_SEX(rs.getString("MEMBER_SEX"));
							mb.setMEMBER_PHONE(rs.getString("MEMBER_PHONE"));
							mb.setMEMBER_ADDRESS(rs.getString("MEMBER_ADDRESS"));
							mb.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
						}				
					
			} catch(Exception ex) {
				System.out.println("Exception"+ex);
			} finally {
				if(rs!=null) try{rs.close();} catch(SQLException e){}
				  if(stmt!=null) try{rs.close();} catch(SQLException e){}
				  if(conn!=null) try{conn.close();} catch(SQLException e){}
			}
			
			return mb;
	}
	
	public boolean deleteMember(String id){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try{
			conn = getConnection();
			
			//sql part for delete course.
			String sql = "DELETE FROM MEMBER WHERE MEMBER_ID='"+id+"'";
			pstmt=conn.prepareStatement(sql);
			
			result=pstmt.executeUpdate();
			
			if(result!=0){
				return true;
			}
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); } catch(SQLException ex) {}
			if(conn!=null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return false;
	}
}
