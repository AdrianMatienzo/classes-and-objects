public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear(){
        return year;
    }

    public void bookInfo() {
        System.out.println("=============== Book Information ================");
        System.out.printf("%-20s: %s\n", "Title", title);
        System.out.printf("%-20s: %s\n", "Author", author);
        System.out.printf("%-20s: %d\n", "Publication Year", year);
    }
}
