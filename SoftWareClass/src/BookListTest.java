import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookListTest {
	
	private BookList bookList;

    @BeforeEach
    public void setUp() {
        bookList = new BookList();
    }

    @Test
    public void testAddBook() throws Exception {
    	System.out.println("addBook 테스트");
        BookList.Book book1 = bookList.new Book(1, "사람의 기본", "Jane", 2021);
        bookList.addBook(book1);
        assertThrows(Exception.class, () -> bookList.addBook(book1));
        
        BookList.Book book2 = bookList.new Book(2, "사람의 본질", "Tom", 2014);
        bookList.addBook(book2);
        assertThrows(Exception.class, () -> bookList.addBook(book2));
        System.out.println("addBook 종료");
    }

    @Test
    public void testViewBookList() throws Exception {
    	System.out.println("viewBookList 테스트");
    	assertThrows(Exception.class, () -> bookList.viewBookList());
    	BookList.Book book1 = bookList.new Book(1, "사람의 기본", "Jane", 2021);
    	BookList.Book book2 = bookList.new Book(2, "사람의 본질", "Tom", 2014);
    	bookList.addBook(book1);
    	bookList.addBook(book2);
    	bookList.viewBookList();
    	System.out.println("viewBookList 테스트 종료");
    }

    @Test
    public void testSearchBook() throws Exception {
    	System.out.println("searchBook 테스트");
    	assertThrows(Exception.class, () ->  bookList.searchBook(1));
    	BookList.Book book1 = bookList.new Book(1, "사람의 기본", "Jane", 2021);
    	bookList.addBook(book1);
        bookList.searchBook(1);
        System.out.println("searchBook 테스트 종료");
    }

    @Test
    public void testDeleteBook() throws Exception {
    	System.out.println("deleteBook 테스트");
    	assertThrows(Exception.class, () -> bookList.deleteBook(1));
    	BookList.Book book1 = bookList.new Book(1, "사람의 기본", "Jane", 2021);
    	bookList.addBook(book1);
        bookList.deleteBook(1);
        assertThrows(Exception.class, () -> bookList.deleteBook(1));
        System.out.println("deleteBook 테스트  종료");
        
    }


	@Test
	void testSearch_bs() throws Exception {
		System.out.println("search_bs 테스트");
    	assertThrows(Exception.class, () ->  bookList.searchBook(1));
    	BookList.Book book1 = bookList.new Book(1, "사람의 기본", "Jane", 2021);
    	bookList.addBook(book1);
        bookList.searchBook(1);
        System.out.println("search_bs 테스트 종료");
	}

}
