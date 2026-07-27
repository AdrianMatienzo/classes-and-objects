public class Book {
    public String title;
    public String author;
    public int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void displayBooks() {
        System.out.printf("%-40s %-39s %d\n", title, author, year);
    }

    public void displayBookInfo() {
        System.out.printf("%-20s: %s\n", "Title", title);
        System.out.printf("%-20s: %s\n", "Author", author);
        System.out.printf("%-20s: %d\n", "Publication Year", year);
    }
}
