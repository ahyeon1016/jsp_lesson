package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
}
