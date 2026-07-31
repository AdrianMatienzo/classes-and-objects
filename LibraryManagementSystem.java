import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.Year;

public class LibraryManagementSystem{
    public static final Scanner sc = new Scanner(System.in);
    public static String inputValidation(String prompt, String errorMessage, String regex) {
        String input = "";
        boolean running = true;
        while (running){
            System.out.print(prompt);
            input = sc.nextLine();

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                break;
            }
            System.out.println(errorMessage);
        } 
        return input;
    }
    public static int yearValidation(String prompt, String regex) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            int year;
            int currentYear = Year.now().getValue();

            if (input.isEmpty()) {
                System.out.println("Invalid. Please enter a valid year.");
                continue;
            }
            if (!input.matches(regex)) {
                System.out.println("Invalid. Please enter a valid year.");
                continue;
            }
            if (input.length() > 4) {
                System.out.println("Invalid year. Please enter a year between 1000 and " + currentYear + ".");
                continue;
            }
            try {
                year = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid year.");
                continue;
            }
            if (year < 1000 || year > currentYear) {
                System.out.println("Invalid year. Please enter a year between 1000 and " + currentYear + ".");
                continue;
            }

            return year;
        }
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

            String choiceString = inputValidation("Choose an option (1-4): ","Invalid input. Please enter a number between 1 and 4.","^[1-4]$");
            int choice = Integer.parseInt(choiceString);

            switch (choice){
                case 1:
                    String title = inputValidation("Enter book Title: ", "Invalid. Please enter a valid title (letters, numbers, spaces, and basic punctuation only).", "^[a-zA-Z0-9.,'\"!?-][a-zA-Z0-9\\s.,'\"!?-]*$").trim();
                    String author = inputValidation("Enter book Author: ", "Invalid. Please enter a valid author name.", "^[a-zA-Z.,-][a-zA-Z\\s.,-]*$").trim();
                    int year = yearValidation("Enter Publication Year (4 digits only): ", "^[0-9]+$");
                    library.addBook(title, author, year);
                    break;
                    
                case 2:
                    library.displayAllBooks();
                    break;

                case 3:
                    String searchTitle = inputValidation("Enter book title to search: ", "Invalid title. Please enter a valid title.", "^[a-zA-Z0-9\\s.,'\"!?-]+$").trim();
                    boolean found = false;
                    for (Book book : library.books) {
                        found = library.findBook(searchTitle, book);
                        break;
                    }
                    if (!found) {
                        System.out.printf("\"%s\" was not found.\n", searchTitle);
                    }
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using the Library Management System!");
                    break;
            }
        }
    }
}