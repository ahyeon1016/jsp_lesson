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
		System.out.println("BoardRepository의 주소를 get");
		return br;
	}
	
	//DB연결 함수
	public Connection dbconn(){
		System.out.println("[데이터 베이스 생성 함수 dbconn() 호출]");
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String db = "jdbc:mysql://localhost:3306/BookMarket_CRUD";
			String id = "root";
			String pwd = "1234";
			conn = DriverManager.getConnection(db, id, pwd);
			System.out.println("db연결성공");
		} catch (Exception e) {
			System.out.println("db연결실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//행의 갯수를 리턴하는 함수
	public int getTotalCount() {
		System.out.println("getTotalCount() 호출");
		int count=0;
		//DB 연결
		Connection conn = dbconn();
		//SQL 전송
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) FROM board";
		try {
			System.out.println("SQL 전송 시도");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("SQL 전송 성공");
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
		System.out.println("getAllBoard() 호출");
		ArrayList<Board> arr = new ArrayList<Board>();
		//DB연결
		Connection conn = dbconn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board";
		try {
			//SQL 전송
			System.out.println("SQL 전송 시도");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("SQL 전송 성공");
			//ResultSet
			System.out.println("ArrayList에 담기");
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
				System.out.println(i+"회 담음");
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
		System.out.println("ArrayList 반환");
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
