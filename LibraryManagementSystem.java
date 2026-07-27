import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryManagementSystem{
    public static final Scanner sc = new Scanner(System.in);

    public static String inputValidation(String prompt, String errorMessage, String regex, boolean caseSensitive) {
        String input;

        do {
            System.out.print(prompt);
            input = sc.nextLine();

            Pattern pattern = Pattern.compile(regex);
            if (!caseSensitive) {
                pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            }
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                break;
            }
            System.out.println(errorMessage);
        } while (true);
        return input;

    }
    public static void main(String[]args){
        Library library = new Library();
        boolean isRunning = true;

        while(isRunning){
            System.out.println("=========== Library Management System ===========");
            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Exit");

            int choice = inputValidation("Choose an option (1-4): ","Invalid input. Please enter a number between 1 and 4.","^[1-4]$",true).charAt(0) - '0';

            switch (choice){
                case 1:
                    String title = inputValidation("Enter book Title: ", "Invalid. Please enter a valid title (letters, numbers, spaces, and basic punctuation only).", "^[a-zA-Z0-9\\s.,'\"!?-]+$", true).trim();
                    String author = inputValidation("Enter book Author: ", "Invalid. Please enter a valid author name.", "^[a-zA-Z\\s.-]+$", false).trim();
                    String yearString = inputValidation("Enter Publication Year (4 digits only): ", "Invalid. Please enter a valid year.", "^\\d{4}$", true);
                    int year = Integer.parseInt(yearString);
                    library.addBook(title, author, year);
                    break;
                    
                case 2:
                    System.out.println("==================================================================================================");
                    System.out.println("                                          BOOK INFORMATION                                        ");
                    System.out.println("==================================================================================================");
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    System.out.printf("%-40s %-39s %s\n", "Title", "Author", " Publication Year");
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    for (Book book : library.books) {
                        book.displayBooks();
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------");
                    break;

                case 3:
                    String searchTitle = inputValidation("Enter book title to search: ", "Invalid title. Please enter a valid title.", "^[a-zA-Z0-9\\s.,'\"!?-]+$", false).trim();
                    boolean found = false;
                    for (Book book : library.books) {
                        if (book.title.equalsIgnoreCase(searchTitle)) {
                            System.out.println("Book found:");
                            book.displayBookInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.printf("\"%s\" was not found.\n", searchTitle);
                    }
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using the Library Management System!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
    }
}