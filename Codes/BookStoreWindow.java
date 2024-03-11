package CSC8011;
import java.util.ArrayList;


// The following clas
public class BookStoreWindow {
    //Fields
    private String bookstoreName;
    private ArrayList<Book> books = new ArrayList<>();

    // Constructor
    public BookStoreWindow (String bookStoreName) {
        this.bookstoreName = bookStoreName;
    }


    //Getters and setters
    public String getBookstoreName() {
        return bookstoreName;
    }

    public ArrayList<Book>getBooks(){
        return books;
    }

    // The following setter method is not used in the BookStoreWindowIO
    public void setBookstoreName(String bookstoreName) {
        this.bookstoreName = bookstoreName;
    }


    // Methods
    public void addingMethod (Book b) {
        books.add(b);
    }  // This method adds books in the 'readCSVMethod' method in the BookStoreWindowIO class into the ArrayList of books


    /* The method for finding the most expensive listed book
    * the highest value book is initially assigned to the value of the first book in the ArrayList
    * and then compared and updated as we iterate through the list of books in the ArrayList.
    */
    public Book highestValueBook (){
        Book maxValueBook = books.get(0);
        for (Book b : books){
            if (b.getValue() > maxValueBook.getValue()){
                maxValueBook = b;
            }
        }
        return maxValueBook;
    }


    /* The method for finding the oldest listed book based on the publication date
    * the oldest book is initially assigned to the published date of the first book in the ArrayList
    * and then compared and updated as we iterate through the list of books in the ArrayList. */
    public Book oldestBook (){
       Book oldestBook = books.get(0);
       for (Book b : books){
           if (b.getYearPublished() < oldestBook.getYearPublished()){
               oldestBook = b;
           }
       }
       return oldestBook;
    }


    /* The method to find the average value of all books
    * first we initialise a variable with the value of 0 and then add all
    * the values as we iterate through the ArrayList to the same variable.
    * Finally, this variable would be divided by the number of books in the ArrayList */
    public double averageValue (){
        double total = 0;
        for (Book book : books){
            total += book.getValue();
        }
        return total/books.size();
    }
}

