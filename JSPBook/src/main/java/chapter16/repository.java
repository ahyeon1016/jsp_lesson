package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
			
			String sql = "insert into member values('"+id+"', '"+pwd+"', '"+name+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
