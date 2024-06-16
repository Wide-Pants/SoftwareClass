import java.util.Random;

public class PerformanceTest {

    final static int Books = 10000; // 테스트할 도서 수
    final static int Tests = 1000; // search 테스트 횟수

    public static void main(String[] args) throws Exception {
        BookList bookList = new BookList();
        Random random = new Random();

        // 도서 목록 채우기
        for (int i = 0; i < Books; i++) {
            BookList.Book book = bookList.new Book(i, "Test" + i, "Test", 2024);
            bookList.addBook(book);
        }
        
        long startTime, endTime;

        // searchBook 성능 측정
        startTime = System.currentTimeMillis();
        for (int i = 0; i < Tests; i++) {
            int id = random.nextInt(Books*2);
            try {
                bookList.searchBook(id);
            } catch (Exception e) {
                // 검색에 실패한 경우 무시
            }
        }
        endTime = System.currentTimeMillis();
        long searchBook_normalTotalTime = (endTime - startTime);
        double searchBook_NormalAverageTime = searchBook_normalTotalTime / (double) Tests;

        // search_bs 성능 측정
        startTime = System.currentTimeMillis();
        for (int i = 0; i < Tests; i++) {
            int id = random.nextInt(Books*2);
            //long startTime = System.currentTimeMillis();
            try {
                bookList.search_bs(id);
            } catch (Exception e) {
                // 검색에 실패한 경우 무시
            }
        }
        endTime = System.currentTimeMillis();
        long searchBook_BSTotalTime = (endTime - startTime);
        double searchBook_BSAverageTime = searchBook_BSTotalTime / (double) Tests;
        
        System.out.println("searchBook 평균 실행 시간: " + searchBook_NormalAverageTime + "ms");
        System.out.println("search_bs 평균 실행 시간: " + searchBook_BSAverageTime + "ms");

        // 비교 결과 출력
        System.out.println("search_bs가 searchBook보다 평균 " + (searchBook_NormalAverageTime / searchBook_BSAverageTime) + "배 빠릅니다.");
    }
}
