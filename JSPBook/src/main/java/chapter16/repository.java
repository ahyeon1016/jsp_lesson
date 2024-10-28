package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

public class repository {
	private static repository repo = new repository();
	
	public static repository getInstance(){
		System.out.println("reopsitory 주소 GET");
		return repo;
	}
	
	//create
	public Connection dbconn(){
		System.out.println("dbconn 함수 호출");
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String database = "jdbc:mysql://localhost:3306/JSPBook";
			String user = "root";
			String pwd = "1234";
			conn = DriverManager.getConnection(database, user, pwd);
			System.out.println("데이터 베이스 연결 성공");
			if(conn==null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터 베이스 연결 실패");
		} 
		return conn;
	}
	
	public void createMember(dto d1){
		System.out.println("createMember함수 호출");
		Connection conn = dbconn();
		
		try {
			Statement stmt = conn.createStatement();
			String id = d1.getId();
			String pwd = d1.getPwd();
			String name = d1.getName();
			//insert into member values('id', 'pwd', 'name')
			String sql = "insert into member values('"+id+"', '"+pwd+"', '"+name+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println("Statememt 닫음");
			stmt.close();
			System.out.println("Connection 닫음");
			conn.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void createMember_pstmt(dto d1){
		System.out.println("pstmt 함수 호출");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String database = "jdbc:mysql://localhost:3306/JSPBook";
			String id = "root";
			String pwd = "1234";
			Connection conn = DriverManager.getConnection(database, id, pwd);
			
			//insert into member values('id', 'pwd', 'name')
			String user_id = d1.getId();
			String user_pwd = d1.getPwd();
			String name = d1.getName();
			String sql = "insert into member values(?, ?, ?)";
			System.out.println(sql);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pwd);
			pstmt.setString(3, name);
			System.out.println(pstmt);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public ArrayList<dto> getMember(){
		System.out.println("getMember 함수 호출");
		ArrayList<dto> arr = new ArrayList<dto>();
		
		Connection conn = dbconn();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			//select * from member 
			String sql = "select * from member";	
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				
				dto d1 = new dto();
				d1.setId(id);
				d1.setPwd(pwd);
				d1.setName(name);
				
				arr.add(d1);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arr;
	}
	
	public dto getOnemember(String userid){
		dto d1 = new dto();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String database = "jdbc:mysql://localhost:3306/JSPBook";
			String id = "root";
			String pwd = "1234";
			Connection conn = DriverManager.getConnection(database, id, pwd);
			
			//select * from member where id=?
			String sql = "select * from member where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs);
			
			if(rs.next()) {
				d1.setId(rs.getString("id"));
				d1.setPwd(rs.getString("pwd"));
				d1.setName(rs.getString("name"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d1;
	}
	
	
	public void updateMember(dto d1){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db = "jdbc:mysql://localhost:3306/JSPBook";
			String id = "root";
			String pwd = "1234";
			Connection conn = DriverManager.getConnection(db, id, pwd);
			
			//update member set pwd=?, name=? where id=?
			String sql = "update member set pwd=?, name=? where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d1.getPwd());
			pstmt.setString(2, d1.getName());
			pstmt.setString(3, d1.getId());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteMember(String id){
		System.out.println("deleteMember 함수 도착");
		Connection conn = dbconn();
		try {
			//delete from member where id=?
			String sql = "delete from member where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
