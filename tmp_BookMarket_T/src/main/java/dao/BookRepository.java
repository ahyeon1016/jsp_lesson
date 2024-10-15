package dao;

import java.util.ArrayList;
import dto.Book;


public class BookRepository{
	
	
	private ArrayList<Book> listOfBooks = new ArrayList<Book>();
	
	// BookRepository �겢�옒�뒪 媛앹껜�깮�꽦�쓣 誘몃━�븯怨� 怨듭쑀�릺�룄濡� 1媛쒕쭔 �쑀吏�
	private static BookRepository bookrepository = new BookRepository();
	// �떛湲��꽩 諛⑹떇�쑝濡� 1媛쒕줈 �쑀吏��릺�뒗 媛앹껜瑜� 由ы꽩�븿
	public static BookRepository getInstance() {
		return bookrepository;
	}
	
	public BookRepository() {
	
		Book book1= new Book("ISBN1234","C# �봽濡쒓렇�옒諛�", 27000);
		book1.setAuther("�슦�옱�궓");
		book1.setDescription("C#�쓣 泥섏쓬 �젒�븯�뒗 �룆�옄瑜� ���긽�쑝濡� �씪���씪 �닔�뾽泥섎읆 �옄�꽭�엳 �꽕紐낇븳 梨낆씠�떎. 瑗� �븣�븘�빞 �븷 �빑�떖 媛쒕뀗�� 湲곕낯 �삁�젣濡� 理쒕��븳 �돺寃� �꽕紐낇뻽�쑝硫�, 以묒슂�븳 �궡�슜�� �쓳�슜 �삁�젣, �댁쫰, ���봽 �뒪�꽣�뵒, �삁�젣 紐⑥쓬�쑝濡� �븳踰� �뜑 蹂듭뒿�븷 �닔 �엳�떎.");
		book1.setPublisher("�븳鍮쏆븘移대뜲誘�");
		book1.setCategory("IT紐⑤컮�씪");
		book1.setUnitsInStock(1000);	
		book1.setReleaseDate("2022/10/06");
		
		
		Book book2 = new Book("ISBN1235","�옄諛붾쭏�뒪�꽣", 30000);
		book2.setAuther("�넚誘몄쁺");
		book2.setDescription("�옄諛붾�� 泥섏쓬 諛곗슦�뒗 �븰�깮�쓣 �쐞�빐 �옄諛붿쓽 湲곕낯 媛쒕뀗怨� �떎�뒿 �삁�젣瑜� 洹몃┝�쓣 �씠�슜�븯�뿬 �돺寃� �꽕紐낇빀�땲�떎. �옄諛붿쓽 �씠濡좎쟻 媛쒕뀗�넂湲곕낯 �삁�젣�넂�봽濡쒖젥�듃 �닚�쑝濡� �떒怨꾨퀎 �븰�뒿�씠 媛��뒫�븯硫�, 媛� 梨뺥꽣�쓽 �봽濡쒖젥�듃瑜� �떎�뒿�븯硫댁꽌 �삩�씪�씤 �꽌�젏�쓣 �셿�꽦�븷 �닔 �엳�룄濡� 援ъ꽦�븯���뒿�땲�떎.");
		book2.setPublisher("�븳鍮쏆븘移대뜲誘�");
		book2.setCategory("IT紐⑤컮�씪");
		book2.setUnitsInStock(1000);		
		book2.setReleaseDate("2023/01/01");
		
		
		Book book3= new Book("ISBN1236","�뙆�씠�뜫 �봽濡쒓렇�옒諛�", 30000);
		book3.setAuther("理쒖꽦泥�");
		book3.setDescription(" �뙆�씠�뜫�쑝濡� �봽濡쒓렇�옒諛띿쓣 �떆�옉�븯�뒗 �엯臾몄옄媛� �돺寃� �씠�빐�븷 �닔 �엳�룄濡� 湲곕낯 媛쒕뀗�쓣 �긽�꽭�븯寃� �꽕紐낇븯硫�, �떎�뼇�븳 �삁�젣瑜� �젣�떆�빀�땲�떎. �삉�븳 �봽濡쒓렇�옒諛띿쓽 湲곗큹 �썝由щ�� �씠�빐�븯硫댁꽌 �뙆�씠�뜫�쑝濡� �뜲�씠�꽣瑜� 泥섎━�븯�뒗 湲곕쾿�룄 諛곗썎�땲�떎.");
		book3.setPublisher("�븳鍮쏆븘移대뜲誘�");
		book3.setCategory("IT紐⑤컮�씪");
		book3.setUnitsInStock(1000);	
		book3.setReleaseDate("2023/01/01");
		
		
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
		
		
	}
	public ArrayList<Book> getAllBooks() {
		return listOfBooks;
	}
	public Book getBookById(String bookId) {
		//Book bookById = null;

		for (int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if (book.getBookId().equals(bookId)) {
				
				return book;
				//bookById = book;
				//break;
			}
		}
		return null;
	}
	

}
