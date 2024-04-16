import com.workintech.books.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String name;
    private String email;
    private String phoneNumber;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }


    public void addBorrowedBooks(Book borrowedBook) {
        if (this.borrowedBooks.toArray().length < 5) {
            this.borrowedBooks.add(borrowedBook);

        } else {
            System.out.println("You have reached the maximum number of book borrowings. This book" +
                    " cannot be borrowed.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phoneNumber);
    }
}
