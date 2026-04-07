import Utilities.Code;
import java.util.HashMap;
import java.util.Objects;

public class Shelf {
    // Constant Fields
    public static final int SHELF_NUMBER_ = 0;
    public static final int SUBJECT_ = 0;


    // Non-Constant Fields
    private HashMap<Book, Integer> books;
    private int shelfNumber;
    private String subject;

    // Constructors
    public Shelf() {
        // Deprecated constructor, does nothing. To be removed in future versions.

        this.books = new HashMap<>();
        // Still need to initialize the HashMap to reduce errors.
    }

    public Shelf(int shelfNumber, String subject) {
        this.shelfNumber = shelfNumber;
        this.subject = subject;

        this.books = new HashMap<>();
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

    // Methods
    public int getBookCount(Book book) {
        if (books.containsKey(book)) {
            return books.get(book);
        }

        // if book isn't stored on shelf, return -1.
        // 0 is a valid index, since the book can be on the shelf, but have all it's copies checked out.
        return -1;
    }

    public Code addBook(Book book) {
        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);

            return Code.SUCCESS;
        } else if (!books.containsKey(book) && Objects.equals(this.subject, book.getSubject())) {
            // if the book doesn't exist on the shelf, but the subject of the book we're trying to place exists,
            // add it to the shelf as a new book.

            books.put(book, 1);
            System.out.println(book.getTitle() + " added to shelf" + this.toString());
            // todo: could cause an error, this.toString is greyed out.

            return Code.SUCCESS;
        }

        // if the program reaches this point, then there was no book that exists on the shelf, or the book's subject didn't match.
        return Code.SHELF_SUBJECT_MISMATCH_ERROR;
    }

    public Code removeBook(Book book){
        if(!books.containsKey(book)) {
            System.out.println(book.getTitle() + " is not on shelf " + this.subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else if (books.containsKey(book) && books.get(book) == 0) {
            System.out.println("No copies of " + book.getTitle() + " remain on shelf " + this.subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else if (books.containsKey(book) && books.get(book) > 0) {
            System.out.println(book.getTitle() + " successfully removed from shelf " + this.subject);
            books.put(book, books.get(book) - 1);

            return Code.SUCCESS;
        }

        // If somehow we get outside the bounds of the code, then return this error.
        System.out.println("Other error occured trying to remove " + book.getTitle());
        return Code.BOOK_NOT_IN_INVENTORY_ERROR;
    }

    public String listBooks() {
        StringBuilder sb = new StringBuilder(books.size() + " books on shelf: " + toString());

        for(Book book : books.keySet()) {
            sb.append("\n" + book.getTitle() + " by " + book.getAuthor() + " " + book.getISBN() + books.get(book));
            // should be the title, plus the author name, plus the book ISBN, and then the amount of books that are available.
            // books.get(book) should access the value connected to the key
        }

        return sb.toString();
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
