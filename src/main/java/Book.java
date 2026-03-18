import java.time.LocalDate;
import java.util.Objects;

public class Book {
   // Constant Fields (static final fields)
    public static final int ISBN_ = 0;
    public static final int TITLE_ = 1;
    public static final int SUBJECT_ = 2;
    public static final int PAGE_COUNT_ = 3;
    public static final int AUTHOR_ = 4;
    public static final int DUE_DATE_ = 5;

    // Non-Constant fields
    private String isbn;
    private String title;
    private String subject;
    private int pageCount;
    private String author;
    private LocalDate dueDate;

    // Constructors
    public Book(String ISBN, String Title, String Subject, int PageCount, String Author, LocalDate DueDate) {
        this.isbn = ISBN;
        this.title = Title;
        this.subject = Subject;
        this.pageCount = PageCount;
        this.author = Author;
        this.dueDate = DueDate;
    }

    // Getters & Setters
    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Special Methods
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(subject, book.subject) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, subject, pageCount, author);
    }

    public String toString(){
        return title + " by " + author + " ISBN: " + isbn;
    }
}
