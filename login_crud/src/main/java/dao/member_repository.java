package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.member_dto;


public class member_repository {
	//1개만 존재해야하므로 싱글톤으로 작성
	private static member_repository mr = new member_repository(); 
	
	public static member_repository getInstance() {
		System.out.println("member_repository 주소 get");
		return mr;
	}
	// 데이터베이스 연결 메서드(중복 사용이 많으므로 사용하기 편하게 함수 처리)
	private Connection DBconn() throws Exception{
		// Step 1. JDBC 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		// Step 2. Connection 객체 생성 : 확인 사항 1. 데이터베이스 생성 여부 2. WEB-INF 폴더에 라이브러리 확인
		Connection conn = null;
		String database = "jdbc:mysql://localhost:3306/login_crud";
		String id = "root";
		String password = "1234";
		conn = DriverManager.getConnection(database, id, password);
		System.out.println("데이터 베이스 연결 완료");
		return conn;
	}
	
	//CREATE
	//Create
	public void member_create(member_dto dto) {
		System.out.println("member_create진입");
		try {
			Connection conn = DBconn();
			
			// Step 3. SQL 전송객체 생성 및 전송
			// SQL 쿼리를 전송해야함 : 데이터베이스에 데이터를 삽입하는 절차
			Statement stmt = conn.createStatement();
			String userid = dto.getId();
			String pwd = dto.getPwd();
			int age = dto.getAge();
			// "insert into member values('admin', '1234', 10)" : 워크밴치에서 잘 작동하는지 테스트 실행
			// "insert into member values('userid', 'pwd', age)"
			//  분류
			// "insert into member valuse('"+userid
			//	userid + "','" + pwd
			//  pwd + "'," + age+")" 
			String sql = "insert into member values('"+userid+"','"+pwd+"',"+age+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} 
		catch (Exception e) {System.out.println("데이터 베이스 연결 실패");
		}
		
		
		// Step 4. 리턴이 있다면 ResultSet객체에 담기 (CUD는 해당 없음)
	} 
	
	//Read
	public ArrayList<member_dto> getAllmember() {
		ArrayList<member_dto> arr = new ArrayList<member_dto>();
 		ResultSet rs = null;
 		try {
			Connection conn = DBconn();
			Statement stmt = conn.createStatement();
			String sql = "select * from member";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				                       //컬럼명
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				int age = rs.getInt("age");
				
				member_dto dto = new member_dto();
				dto.setId(id);
				dto.setPwd(pwd);
				dto.setAge(age);
				/*
				 	member_dto dto = new member_dto();
					dto.setId(rs.getString("id"));
					dto.setPwd(rs.getString("pwd"));
					dto.setAge(rs.getInt("age"));
				 */
				arr.add(dto);
			}
		} catch (Exception e) {}
		return arr;
	}
	
	
	public member_dto getOnemember(String userid) {
		ResultSet rs = null;
		member_dto dto = new member_dto();
		try {
			//Step 1. DB연결
			Connection conn = DBconn();
			//Step 2. Query 전송하기
			Statement stmt = conn.createStatement();
			String sql = "select * from member where id='"+userid+"'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			//한 줄일 때는 while이 아닌 if문 사용함
			if(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				int age = rs.getInt("age");
				
				dto.setId(id);
				dto.setPwd(pwd);
				dto.setAge(age);
			}
		}catch (Exception e) {}
		return dto;
	} 
	//Update 
	
	public void update_member(member_dto dto) {
		try {
			//Step 1.DB연결
			Connection conn = DBconn();
			//Step 2. Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String id = dto.getId();
			String pwd = dto.getPwd();
			int age = dto.getAge();
			String sql = "update member set pwd='"+pwd+"', age="+age+" where id='"+id+"'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {e.printStackTrace();}
		
	}
	
	//Delete
	public void deleteUser(String id) {
		try {
			//Step 1. DB연결
			Connection conn = DBconn();
			//Step 2. Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "delete from member where id='"+id+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (Exception e) {}
	}
}
