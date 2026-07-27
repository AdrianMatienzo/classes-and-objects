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

}
