import java.util.ArrayList;
import java.util.List;

public class BookList {
	
	private List<Book> bookList = new ArrayList<>();

	public class Book {
		private int id;// 아이디
		private String title;// 제목
		private String author;// 저자
		private int pubYear;// 발행연도ㄴ
		
		public Book(int id, String title, String author, int pubYear) {
	        this.id = id;
	        this.title = title;
	        this.author = author;
	        this.pubYear = pubYear;
	    }
		public Book(String title, String author, int pubYear) {
	        this.id = bookList.size();
	        this.title = title;
	        this.author = author;
	        this.pubYear = pubYear;
	    }

		public int getId(){
			return this.id;
		}
		public String getTitle(){
			return this.title;
		}
		public String getAuthor(){
			return this.author;
		}
		public int getPubYear(){
			return this.pubYear;
		}
	}
	
	public void addBook(Book newBook) throws Exception {
		for (Book book : bookList) {
			if (book.getId() == newBook.getId()) {// 중복 ID 값에 대해 예외처리
				System.out.println(String.format("해당 ID(%d)는 이미 존재합니다.", newBook.id));
				throw new Exception("중복 발견");
			}
		}
		// 정렬된 위치에 삽입 추후 이진트리를 위해 미리 정렬
		int index = 0;
		while (index < bookList.size() && bookList.get(index).getId() < newBook.getId()) {
			index++;
		}
		bookList.add(index, newBook);
		System.out.println(String.format("Book {id: '%d', 제목: '%s', 저자: '%s', 출판년도: %d}를 추가하였습니다.", newBook.getId(),
				newBook.getTitle(), newBook.getAuthor(), newBook.getPubYear()));
		return;

	}

	public void viewBookList() throws Exception {
		if (bookList.isEmpty()) {// arraylist 에 아무 값도 존재하지 않으면 예외처리
			System.out.print("리스트에 도서가 존재하지 않습니다.");
			throw new Exception("빈 리스트");
		}
		System.out.print("전체 조회:\n");
		for (Book book : bookList) {
			System.out.println(String.format("Book {id: '%d', 제목: '%s', 저자: '%s', 출판년도: %d}", book.getId(),
				book.getTitle(), book.getAuthor(), book.getPubYear()));
		}
	}

	public void searchBook(int id) throws Exception {
		for (Book book : bookList) {
			if (book.getId() == id) {
				System.out.println(String.format("Book {id: %d, 제목: %s, 저자: %s, 연도: %d}를 찾았습니다.", id,
				book.getTitle(), book.getAuthor(), book.getPubYear()));
				return;
			}
		}
		// arraylist 에 존재하지 않으면 예외처리
		System.out.println(String.format("해당 ID(%d)의 도서를 찾을 수 없습니다.", id));
		throw new Exception("데이터 없음");
	}

	public void deleteBook(int id) throws Exception {
		for (Book book : bookList) {
			if (book.getId() == id) {
				bookList.remove(book);
				System.out.println(String.format("Book {id: %d, 제목: %s, 저자: %s, 연도: %d}를 삭제했습니다.", id,
				book.getTitle(), book.getAuthor(), book.getPubYear()));
				return;
			}
		}
		// arraylist 에 존재하지 않으면 예외처리
		System.out.println(String.format("해당 ID(%d)의 도서를 찾을 수 없습니다.", id));
		throw new Exception("데이터 없음");
	}

	public void searchBook_bs(int id) throws Exception {
		int leftId = 0;
		int rightId = bookList.size() - 1;

		while (leftId <= rightId) {
			int mid = leftId + (rightId - leftId) / 2;
			Book midBook = bookList.get(mid);

			if (midBook.getId() == id) {
				System.out.println(String.format("Book {id: %d, 제목: %s, 저자: %s, 연도: %d}를 찾았습니다.", id, midBook.getTitle(),
						midBook.getAuthor(), midBook.getPubYear()));
				return;
			}

			if (midBook.getId() < id) {
				leftId = mid + 1;
			} else {
				rightId = mid - 1;
			}
		}

		// arraylist에 존재하지 않으면 예외처리
		System.out.println(String.format("해당 ID(%d)의 도서를 찾을 수 없습니다.", id));
		throw new Exception("데이터 없음");
	}
}
