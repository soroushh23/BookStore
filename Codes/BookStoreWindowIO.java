package CSC8011;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class BookStoreWindowIO {

    private static BookStoreWindow b; //this is an object made from the BookStoreWindow class

    private static boolean readMenu = false; /* A boolean method that is used to check whether to execute the
                                             stated methods in cases 1,2,3 and 4 in the following switch statement in the
                                             main method.*/

    public static void main (String[]args) {

        boolean done = false; /* A variable that is set false at the beginning and is used
                                in the following while loop that keeps iterating until done is true.*/
        Scanner s = new Scanner(System.in); // The scanner s is created to be used in the following switch statements to prompt user to enter an input
        System.out.println("Welcome to this programme!");
        while (!done) {
            printMenu();
            String response = s.nextLine(); // This scanner prompts user to enter a value in the next line and stores it as the 'response' variable
            switch (response) {
                case "1": // Enters the name of the Bookstore
                    enterBookStoreName ();
                    break;
                case "2": // Opening up the CSV file and reading it via File class in java.io package.
                    readCSVMethod();
                    break;
                case "3": // Summary of the bookstore and its books list.
                    printBooksList();
                    break;
                case "4": // Statistics of the bookstore books such as oldest, highest value and average of books price are printed.
                    stats();
                    break;
                case "5": // Quitting the programme.
                    done= true;
                    System.out.println("Thank you, Goodbye!");
                    break;
                // In case the user enters an input other than 1,2,3,4,5 the following lines would be printed.
                default:
                    System.out.println("Invalid input! Please choose an option between 1-5.");
                    System.out.println("===================================================");
                    break;
            }
        }
    }



    // The following menu will be printed until the boolean 'done' is true.
    private static void printMenu() {
        System.out.println("Please choose an option from the menu list below:");
        System.out.println("1: Enter the name of the bookstore");
        System.out.println("2: Read in information of the books in the bookstore");
        System.out.println("3: List of the books in the bookstore window");
        System.out.println("4: Statistics on the books");
        System.out.println("5: Quit the programme");
    }



    private static void enterBookStoreName(){
        readMenu= false; /* This line is to make sure the readMenu boolean is false once gain after calling the method readCSVMethod
        * in the switch statement option 2. */
        Scanner c = new Scanner(System.in); // The scanner c is created to be used in the enterBookStoreName method to enter a name for the bookstore
        System.out.println("Enter the name of the bookstore: ");
        String input = c.nextLine(); // The bookstore name entered by the user is stored in the 'input' variable in the next line
        b = new BookStoreWindow(input); // The entered bookstore name by the user is stored as the object b in the BookstoreWindow class

        /* The following while loop ensures that after choosing the number 1 on the menu list,
        the user cannot just press the enter key on the keyboard.*/
        while (b.getBookstoreName().isEmpty()) {
            System.out.println("The bookstore name cannot be empty, please enter a valid name! ");
            input = c.nextLine(); // Once again prompts the user to enter a name for the bookstore name following pressing the enter key after choosing option 1 on the menu
            b = new BookStoreWindow(input);
        }
        System.out.println("The name of the bookstore has been saved!");
        System.out.println("================================================================");
    }



    private static boolean readCSVMethod() {
        if (!readMenu && b != null) {
            try {
                File readingcsv = new File("Books.csv"); // This line references to the stored CSV file via the File class.
                Scanner myReader = new Scanner(readingcsv);
                myReader.nextLine(); // To exclude the header row in the CSV file
                while (myReader.hasNext()) {
                    // This while loop splits the rows when encounters a comma(,).
                    String[] split = myReader.nextLine().split(",");
                    Book book = new Book(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]));
                    b.addingMethod(book); // This line splits the contents of the CSV file into the format of the book object stored in the Book class
                }
                System.out.println("You have successfully opened the CSV file containing the books details at the bookstore.");
                System.out.println("========================================================================================");
                readMenu = true;
                return true;

            } catch (FileNotFoundException e) {
                System.out.println(" NO BOOKSTORE CSV file Found"); /* This error is printed when there is a
                problem with CSV file i,e., incorrect file directory path.*/
                readMenu = false;
                return false;
            }
        }
        else {
            System.out.println("Please enter the name of the bookstore first!");
            System.out.println("=============================================");
            return false;
        }
    }



    // The following method will get the list of the books stored in the BookStoreWindow class as well as printing the name of the bookstore at the top
    private static void printBooksList() {
        if (readMenu && b != null) {
            System.out.println("Bookstore Name: " + b.getBookstoreName());
            for (Book b : b.getBooks()) {
                System.out.println(b);
            }
            System.out.println("=============================================================================");
        }
        else {
            System.out.println("Please make sure you have entered a valid bookstore name (option 1) and have opened the CSV file (option2)! ");
            System.out.println("==================================================================================================================");

        }
    }



    // The following method accesses the methods created in the BookStoreWindow class and print them out
    private static void stats() {
        if (readMenu && b != null) {
            System.out.println("The statistics on highest value, oldest book, and average value of the books:");
            System.out.println("Highest value book: " + b.highestValueBook().getTitle()+ " (published "+ b.highestValueBook().getYearPublished()+ "), "+ "£"+b.highestValueBook().getValue());
            System.out.println("Oldest book: " + b.oldestBook().getTitle() + " (published "+ b.oldestBook().getYearPublished()+ ")" );
            System.out.printf("Average value of books: £%.2f. ", b.averageValue());
            System.out.println(); /* This empty line is necessary after the printf statement in the previous line in
            order to print the separation line underneath the average value statement.*/
            System.out.println("===================================================================================");
        }
        else {
            System.out.println("Please make sure you have entered a valid bookstore name (option 1) and have opened the CSV file (option2)!");
            System.out.println("============================================================================================================");
        }
    }
}