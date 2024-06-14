import java.util.ArrayList;
import java.util.List;

public class BookList {

	//빌드 테스트하려고 주석 추가했다!
	
	private List<Book> bookList = new ArrayList<>();
	public class Book {
		int id;// 아이디
		String title;// 제목
		String author;// 저자
		int pubYear;// 발행연도
		
		public Book(int id, String title, String author, int pubYear) {
	        this.id = id;
	        this.title = title;
	        this.author = author;
	        this.pubYear = pubYear;
	    }
	}
	
	public void addBook(Book newBook) throws Exception {
		for (Book book : bookList) {
			if (book.id == newBook.id) {// 중복 ID 값에 대해 예외처리
				System.out.println(String.format("해당 ID(%d)는 이미 존재합니다.", newBook.id));
				throw new Exception("중복 발견");
			}
		}
		// 정렬된 위치에 삽입 추후 이진트리를 위해 미리 정렬
		int index = 0;
		while (index < bookList.size() && bookList.get(index).id < newBook.id) {
			index++;
		}
		bookList.add(index, newBook);
		System.out.println(String.format("Book {id: '%d', 제목: '%s', 저자: '%s', 출판년도: %d}를 추가하였습니다.", newBook.id,
				newBook.title, newBook.author, newBook.pubYear));
		return;

	}

	public void viewBookList() throws Exception {
		if (bookList.isEmpty()) {// arraylist 에 아무 값도 존재하지 않으면 예외처리
			System.out.print("리스트에 도서가 존재하지 않습니다.");
			throw new Exception("빈 리스트");
		}
		System.out.print("전체 조회:\n");
		for (Book book : bookList) {
			System.out.println(String.format("Book {id: '%d', 제목: '%s', 저자: '%s', 출판년도: %d}", book.id, book.title,
					book.author, book.pubYear));
		}
	}

	public void searchBook(int id) throws Exception {
		for (Book book : bookList) {
			if (book.id == id) {
				System.out.println(String.format("Book {id: %d, 제목: %s, 저자: %s, 연도: %d}를 찾았습니다.", id, book.title,
						book.author, book.pubYear));
				return;
			}
		}
		// arraylist 에 존재하지 않으면 예외처리
		System.out.println(String.format("해당 ID(%d)의 도서를 찾을 수 없습니다.", id));
		throw new Exception("데이터 없음");
	}

	public void deleteBook(int id) throws Exception {
		for (Book book : bookList) {
			if (book.id == id) {
				bookList.remove(book);
				System.out.println(String.format("Book {id: %d, 제목: %s, 저자: %s, 연도: %d}를 삭제했습니다.", id, book.title,
						book.author, book.pubYear));
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

			if (midBook.id == id) {
				System.out.println(String.format("Book {id: %d, 제목: %s, 저자: %s, 연도: %d}를 찾았습니다.", id, midBook.title,
						midBook.author, midBook.pubYear));
				return;
			}

			if (midBook.id < id) {
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
