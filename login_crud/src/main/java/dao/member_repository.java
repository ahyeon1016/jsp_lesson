package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import dto.member_dto;

public class member_repository {
	//1���� �����ؾ��ϹǷ� �̱������� �ۼ�
	private static member_repository mr = new member_repository(); 
	
	
	
	public static member_repository getInstance() {
		System.out.println("member_repository �ּ� get");
		return mr;
	}
	
	//Create
	public void member_create(member_dto dto) {
		System.out.println("member_create����");
		try {
			// Step 1. JDBC ����̹� �ε�
			Class.forName("com.mysql.jdbc.Driver");
			// Step 2. Connection ��ü ���� : Ȯ�� ���� 1. �����ͺ��̽� ���� ���� 2. WEB-INF ������ ���̺귯�� Ȯ��
			Connection conn = null;
			String database = "jdbc:mysql://localhost:3306/login_crud";
			String id = "root";
			String password = "1234";
			conn = DriverManager.getConnection(database, id, password);
			System.out.println("������ ���̽� ���� �Ϸ�");
		} 
		catch (Exception e) {System.out.println("������ ���̽� ���� ����");
}
		
		// Step 3. SQL ���۰�ü ���� �� ����
		
		// Step 4. ������ �ִٸ� ResultSet��ü�� ��� (CUD�� �ش� ����)
	} 
	
	
	//Read
	
	//Update
	
	//Delete
}
