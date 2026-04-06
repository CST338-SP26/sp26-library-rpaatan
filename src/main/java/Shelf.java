import java.util.HashMap;
import java.util.Objects;

public class Shelf {
    // Constant Fields
    // todo: figure out what to intialize the constant fields with.
    public static final int SHELF_NUMBER_ = 0;
    public static final int SUBJECT_ = 0;


    // Non-Constant Fields
    private HashMap<Book, Integer> books;
    private int shelfNumber;
    private String subject;

    // Constructors
    public Shelf() {
        // Deprecated constructor, does nothing. To be removed in future versions.
    }

    public Shelf(int shelfNumber, String subject) {
        this.shelfNumber = shelfNumber;
        this.subject = subject;
    }

    // Getters & Setters
    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    // Special Methods
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Shelf shelf = (Shelf) o;
        return shelfNumber == shelf.shelfNumber && Objects.equals(subject, shelf.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shelfNumber, subject);
    }

    public String toString(){
        return shelfNumber + " : " + subject;
    }
}
