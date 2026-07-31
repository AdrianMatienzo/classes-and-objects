import java.util.ArrayList;
import java.util.List;

public class Library {
    public List <Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.add(book);
        System.out.println("Book added: \"" + title + "\"");
    }

    public void displayAllBooks(){
        System.out.println("==========================================================================================================");
        System.out.println("                                                 BOOK LIST                                                ");
        System.out.println("==========================================================================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-45s %-39s %s\n", "Title", "Author", "Publication Year");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        for (Book book : books) {
            System.out.printf("%-45s %-39s %d\n", book.getTitle(), book.getAuthor(), book.getYear());
            }
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

    public boolean findBook(String searchTitle, Book book){
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                    System.out.println("Book found!");
                    book.bookInfo();
                    return true;
            }
            return false;
    }
}