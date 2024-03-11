package CSC8011;

public class Book {

    //Fields
    private String bookID;
    private String title;
    private int yearPublished;
    private double value;


    //Constructors
    public Book (String bookID,String title, int yearPublished, double value){
        this.bookID = bookID;
        this.title = title;
        this.yearPublished = yearPublished;
        this.value = value;
    }


    // Getters and Setters
    public String getTitle() {
        return title;
    }


    public int getYearPublished() {
        return yearPublished;
    }


    public double getValue() {
        return value;
    }


    // The following getters and Setters were not used in the other two classes.
    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setYearPublished(int yearpublished) {
        this.yearPublished = yearpublished;
    }
    public void setValue(double value) {
        this.value = value;
    }

    @Override // This method returns the objects made from this class in the form of a string.
    public String toString() {
        return ("Book ID: " + bookID + ", Title: " + title + ", Year published: " + yearPublished + ", Value: £" + value);
    }
}
