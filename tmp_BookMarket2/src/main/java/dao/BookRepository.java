package dao;

import java.util.ArrayList;
import dto.Book;

public class BookRepository {
	//����� ����
	private static ArrayList<Book> listOfBooks = new ArrayList<Book>();
	private static BookRepository repository = new BookRepository();
	
	public BookRepository() {
		Book book1 = new Book("ISBN1234", "C# ���α׷���", 27000);
		book1.setAuther("���糲");
		book1.setDescription("C#�� ó�� ���ϴ� ���ڸ� ������� �ϴ��� ����ó�� �ڼ��� ������ å�̴�. �� �˾ƾ� �� �ٽ� ������ �⺻ ������ �ִ��� ���� ����������, �߿��� ������ ���� ����, ����, ���� ���͵�, ���� �������� �ѹ� �� ������ �� �ִ�.");
		book1.setPublisher("�Ѻ� ��ī����");
		book1.setCategory("IT �����");
		book1.setUnitsInStock(1000);
		book1.setReleaseDate("2022/10/06");
		
		Book book2 = new Book("ISBN1235", "�ڹ� ���α׷���", 30000);
		book2.setAuther("�۹̿�");
		book2.setDescription("C#�� ó�� ���ϴ� ���ڸ� ������� �ϴ��� ����ó�� �ڼ��� ������ å�̴�. �� �˾ƾ� �� �ٽ� ������ �⺻ ������ �ִ��� ���� ����������, �߿��� ������ ���� ����, ����, ���� ���͵�, ���� �������� �ѹ� �� ������ �� �ִ�.");
		book2.setPublisher("�Ѻ� ��ī����");
		book2.setCategory("IT �����");
		book2.setUnitsInStock(1000);
		book2.setReleaseDate("2023/01/01");
		
		Book book3 = new Book("ISBN1236", "���̽� ���α׷���", 30000);
		book3.setAuther("�ּ�ö");
		book3.setDescription("C#�� ó�� ���ϴ� ���ڸ� ������� �ϴ��� ����ó�� �ڼ��� ������ å�̴�. �� �˾ƾ� �� �ٽ� ������ �⺻ ������ �ִ��� ���� ����������, �߿��� ������ ���� ����, ����, ���� ���͵�, ���� �������� �ѹ� �� ������ �� �ִ�.");
		book3.setPublisher("�Ѻ� ��ī����");
		book3.setCategory("IT �����");
		book3.setUnitsInStock(1000);
		book3.setReleaseDate("2023/01/01");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	
	public static ArrayList<Book> getAllBooks(){
		return listOfBooks;
	}
	public static BookRepository getRepository() {
		return repository;
	}
	
	public Book getBookById(String bookId) {
		Book bookById = null;
		
		for(int i=0; i<listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			
			if(book!=null && book.getBookId()!=null && book.getBookId().equals(bookById)) {
				bookById=book;
				break;
			}
		}
		return bookById;
	}
}
