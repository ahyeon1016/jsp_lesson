package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.member_dto;


public class member_repository {
	//1���� �����ؾ��ϹǷ� �̱������� �ۼ�
	private static member_repository mr = new member_repository(); 
	
	public static member_repository getInstance() {
		System.out.println("member_repository �ּ� get");
		return mr;
	}
	// �����ͺ��̽� ���� �޼���(�ߺ� ����� �����Ƿ� ����ϱ� ���ϰ� �Լ� ó��)
	private Connection DBconn() throws Exception{
		// Step 1. JDBC ����̹� �ε�
		Class.forName("com.mysql.jdbc.Driver");
		// Step 2. Connection ��ü ���� : Ȯ�� ���� 1. �����ͺ��̽� ���� ���� 2. WEB-INF ������ ���̺귯�� Ȯ��
		Connection conn = null;
		String database = "jdbc:mysql://localhost:3306/login_crud";
		String id = "root";
		String password = "1234";
		conn = DriverManager.getConnection(database, id, password);
		System.out.println("������ ���̽� ���� �Ϸ�");
		return conn;
	}
	
	//CREATE
	//Create
	public void member_create(member_dto dto) {
		System.out.println("member_create����");
		try {
			Connection conn = DBconn();
			
			// Step 3. SQL ���۰�ü ���� �� ����
			// SQL ������ �����ؾ��� : �����ͺ��̽��� �����͸� �����ϴ� ����
			Statement stmt = conn.createStatement();
			String userid = dto.getId();
			String pwd = dto.getPwd();
			int age = dto.getAge();
			// "insert into member values('admin', '1234', 10)" : ��ũ��ġ���� �� �۵��ϴ��� �׽�Ʈ ����
			// "insert into member values('userid', 'pwd', age)"
			//  �з�
			// "insert into member valuse('"+userid
			//	userid + "','" + pwd
			//  pwd + "'," + age+")" 
			String sql = "insert into member values('"+userid+"','"+pwd+"',"+age+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} 
		catch (Exception e) {System.out.println("������ ���̽� ���� ����");
		}
		
		
		// Step 4. ������ �ִٸ� ResultSet��ü�� ��� (CUD�� �ش� ����)
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
				                       //�÷���
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
			//Step 1. DB����
			Connection conn = DBconn();
			//Step 2. Query �����ϱ�
			Statement stmt = conn.createStatement();
			String sql = "select * from member where id='"+userid+"'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			//�� ���� ���� while�� �ƴ� if�� �����
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
			//Step 1.DB����
			Connection conn = DBconn();
			//Step 2. Query ���� �� ����
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
			//Step 1. DB����
			Connection conn = DBconn();
			//Step 2. Query ���� �� ����
			Statement stmt = conn.createStatement();
			String sql = "delete from member where id='"+id+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (Exception e) {}
	}
}
