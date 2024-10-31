package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;

public class MemberReopository {
	private static MemberReopository mr = new MemberReopository();

	private MemberReopository() {}

	public static MemberReopository getMr() {
		System.out.println("MemberReopository�� �ּ� get");
		return mr;
	}
	
	//DB���� �Լ�
	public Connection dbconn(){
		System.out.println("[������ ���̽� ���� �Լ� dbconn() ȣ��]");
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db = "jdbc:mysql://localhost:3306/BookMarket_CRUD";
			String id = "root";
			String pwd = "1234";
			conn = DriverManager.getConnection(db, id, pwd);
			System.out.println("DB���Ἲ��");
		} catch (Exception e) {
			System.out.println("DB�������");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	//Create
	public void create(Member mb){
		System.out.println("ȸ�������� ���� create() ȣ��");
		//DB ����
		Connection conn = dbconn();
		//SQL ����
		System.out.println("SQL���� �õ�");
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPassword());
			pstmt.setString(3, mb.getName());
			pstmt.setString(4, mb.getGender());
			pstmt.setString(5, mb.getBirth());
			pstmt.setString(6, mb.getMail());
			pstmt.setString(7, mb.getPhone());
			pstmt.setString(8, mb.getAddress());
			pstmt.setTimestamp(9, mb.getRegist_day());
			
			System.out.println("���۵Ǵ� SQL : "+pstmt);
			
			pstmt.executeUpdate();
			System.out.println("SQL���� ����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {	
				System.out.println("Create�� ����� ��ü �������� �ݴ���");
				if(pstmt!=null) {pstmt.close();}
				if(conn!=null) {conn.close();}
				System.out.println("Create�� ����� ��ü �ݱ� �Ϸ�");
			}catch(Exception e){
				System.out.println("Create�� ����� ��ü �ݱ� ����");
				e.printStackTrace();
			}
		}
		//ResultSet ó��(Read)
	}
	
	//Read
	public Member getUser(String id, String password){
		System.out.println("�α����� ���� getUser() ȣ��");
		Member returnData = new Member();
		//DB����
		Connection conn = dbconn();
		//SQL����
		System.out.println("SQL ���� �õ�");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE id=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			System.out.println("������ SQL : "+pstmt);
			rs = pstmt.executeQuery();
			System.out.println("SQL ���� ����");
			
			//ResultSet ��ȯ => DTO(1��)
			System.out.println("DTO ��ȯ �õ�");
			if(rs.next()) {
				returnData.setId(rs.getString("id"));
				returnData.setPassword(rs.getString("password"));
				returnData.setName(rs.getString("name"));
				returnData.setGender(rs.getString("gender"));
				returnData.setBirth(rs.getString("birth"));
				returnData.setMail(rs.getString("mail"));
				returnData.setPhone(rs.getString("phone"));
				returnData.setAddress(rs.getString("address"));
				returnData.setRegist_day(rs.getTimestamp("regist_day"));
				System.out.println("DTO ��ȯ �Ϸ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				System.out.println("getUser�� ����� ��ü �������� �ݱ�");
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				if(conn!=null) {conn.close();}
				System.out.println("getUser�� ����� ��ü �ݱ� ����");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return returnData;
	}
	
	//Update
	
	//Delete
}
