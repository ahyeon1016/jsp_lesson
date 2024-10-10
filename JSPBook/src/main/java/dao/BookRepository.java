package dao;

import java.util.ArrayList;
import dto.Book;

public class BookRepository {
	
	private ArrayList<Book> listOfBooks = new ArrayList<Book>();
	
	public BookRepository() {
		Book book1 = new Book("ISBN1234", "C# 프로그래밍", 27000);
		book1.setAuther("우재남");
		book1.setDescription("C#을 처음 접하는 독자를 대사응로 일대일 수업처럼 자세히 설명한 책이다. 꼭 알아야 할 핵심 개념은 기본 예제로 최대한 쉽게 설명했으며, 중요한 내용은 응요 예제, 퀴스, 셀프 스터디, 예제 모음으로 한번 더 복습할 수 있다.");
		book1.setPublisher("한빛 아카데미");
		book1.setCategory("IT 모바일");
		book1.setUnitsInStock(1000);
		book1.setReleaseDate("2022/10/06");
		
		Book book2 = new Book("ISBN1235", "자바 프로그래밍", 30000);
		book2.setAuther("송미영");
		book2.setDescription("C#을 처음 접하는 독자를 대사응로 일대일 수업처럼 자세히 설명한 책이다. 꼭 알아야 할 핵심 개념은 기본 예제로 최대한 쉽게 설명했으며, 중요한 내용은 응요 예제, 퀴스, 셀프 스터디, 예제 모음으로 한번 더 복습할 수 있다.");
		book2.setPublisher("한빛 아카데미");
		book2.setCategory("IT 모바일");
		book2.setUnitsInStock(1000);
		book2.setReleaseDate("2023/01/01");
		
		Book book3 = new Book("ISBN1236", "파이썬 프로그래밍", 30000);
		book3.setAuther("최성철");
		book3.setDescription("C#을 처음 접하는 독자를 대사응로 일대일 수업처럼 자세히 설명한 책이다. 꼭 알아야 할 핵심 개념은 기본 예제로 최대한 쉽게 설명했으며, 중요한 내용은 응요 예제, 퀴스, 셀프 스터디, 예제 모음으로 한번 더 복습할 수 있다.");
		book3.setPublisher("한빛 아카데미");
		book3.setCategory("IT 모바일");
		book3.setUnitsInStock(1000);
		book3.setReleaseDate("2023/01/01");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	
	public ArrayList<Book> getAllBooks(){
		return listOfBooks;
	}
}
