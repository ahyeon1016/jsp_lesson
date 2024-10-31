package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class BoardRepository {
	private static BoardRepository br = new BoardRepository();
	
	private BoardRepository() {}

	public static BoardRepository getBr() {
		System.out.println("BoardRepository�� �ּҸ� get");
		return br;
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
			System.out.println("db���Ἲ��");
		} catch (Exception e) {
			System.out.println("db�������");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//���� ������ �����ϴ� �Լ�
	public int getTotalCount() {
		System.out.println("getTotalCount() ȣ��");
		int count=0;
		//DB ����
		Connection conn = dbconn();
		//SQL ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) FROM board";
		try {
			System.out.println("SQL ���� �õ�");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("SQL ���� ����");
			//ResultSet
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				if(conn!=null) {conn.close();}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}		
		return count;
	}
	
	//Create
	public void create(){
		
	}
	
	//ReadAll
	public ArrayList<Board> getAllBoard() {
		System.out.println("getAllBoard() ȣ��");
		ArrayList<Board> arr = new ArrayList<Board>();
		//DB����
		Connection conn = dbconn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board";
		try {
			//SQL ����
			System.out.println("SQL ���� �õ�");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("SQL ���� ����");
			//ResultSet
			System.out.println("ArrayList�� ���");
			int i=0;
			while(rs.next()) {
				
				Board bd = new Board();
				bd.setNum(rs.getInt("num"));
				bd.setId(rs.getString("id"));
				bd.setName(rs.getString("name"));
				bd.setSubject(rs.getString("subject"));
				bd.setContent(rs.getString("content"));
				bd.setRegist_day(rs.getTimestamp("regist_day"));
				bd.setHit(rs.getInt("hit"));
				bd.setIp(rs.getString("ip"));
				
				arr.add(bd);
				i++;
				System.out.println(i+"ȸ ����");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				if(conn!=null) {conn.close();}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("ArrayList ��ȯ");
		return arr;
	} 
	
	//ReadOne
	public Board getOneBoard(String id) {
		Board bd = new Board();
		
		return bd;
	}
	
	//Update
	
	
	//Delete
}
