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
		System.out.println("MemberReopository의 주소 get");
		return mr;
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
			System.out.println("DB연결성공");
		} catch (Exception e) {
			System.out.println("DB연결실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	//Create
	public void create(Member mb){
		System.out.println("회원가입을 위한 create() 호출");
		//DB 연결
		Connection conn = dbconn();
		//SQL 전송
		System.out.println("SQL전송 시도");
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
			
			System.out.println("전송되는 SQL : "+pstmt);
			
			pstmt.executeUpdate();
			System.out.println("SQL전송 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {	
				System.out.println("Create에 사용한 객체 역순으로 닫는중");
				if(pstmt!=null) {pstmt.close();}
				if(conn!=null) {conn.close();}
				System.out.println("Create에 사용한 객체 닫기 완료");
			}catch(Exception e){
				System.out.println("Create에 사용한 객체 닫기 실패");
				e.printStackTrace();
			}
		}
		//ResultSet 처리(Read)
	}
	
	//Read
	public Member getUser(String id, String password){
		System.out.println("로그인을 위한 getUser() 호출");
		Member returnData = new Member();
		//DB연결
		Connection conn = dbconn();
		//SQL전송
		System.out.println("SQL 전송 시도");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE id=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			System.out.println("전송할 SQL : "+pstmt);
			rs = pstmt.executeQuery();
			System.out.println("SQL 전송 성공");
			
			//ResultSet 변환 => DTO(1개)
			System.out.println("DTO 변환 시도");
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
				System.out.println("DTO 변환 완료");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				System.out.println("getUser에 사용한 객체 역순으로 닫기");
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				if(conn!=null) {conn.close();}
				System.out.println("getUser에 사용한 객체 닫기 성공");
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
