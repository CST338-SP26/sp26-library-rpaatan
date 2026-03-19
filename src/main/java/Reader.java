import Utilities.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {
    // Constant Fields
    public static final int CARD_NUMBER_ = 0;
    public static final int NAME_ = 1;
    public static final int PHONE_ = 2;
    public static final int BOOK_COUNT_ = 3;
    public static final int BOOK_START_ = 4;

    // Non-Constant Fields
    int cardNumber;
    String name;
    String phone;
    List<Book> books;

    // Constructors
    public Reader(int cardNumber,String name, String phone) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.phone = phone;

        List<Book> books = new ArrayList<>();
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBookCount() {
        return books.size();
    }

    // Methods
    public Code addBook(Book book) {
        if(books.contains(book)) {
            return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
        }

        books.add(book);
        return Code.SUCCESS;
    }

    // todo - check over this.
    public Code removeBook(Book book) {
        try {
            if (!books.contains(book)) {
                return Code.READER_DOESNT_HAVE_BOOK_ERROR;
            } else {
                books.remove(book);
                return Code.SUCCESS;
            }
        } catch (Exception e) {
            return Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;
        }
    }

    public boolean hasBook(Book book) {
        return books.contains(book);
    }
    // Special Methods
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return cardNumber == reader.cardNumber && Objects.equals(name, reader.name) && Objects.equals(phone, reader.phone) && Objects.equals(books, reader.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, name, phone, books);
    }

    public String toString(){
        return name + " (#" + cardNumber + ") has checked out " + books;
    }
}
