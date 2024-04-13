import com.workintech.books.Book;
import com.workintech.books.Magazine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    static List<Book> books = new ArrayList<>();
    static List<User> users = new ArrayList<>();

    //Books Op
    public static List<Book> getBooks() {
        return books;
    }

    public static void displayBooks() {
        if (books.toArray().length == 0) {
            System.out.println("There are no books in the library");
        }
        for (Book book : books) {
            book.display();
        }
    }

    public static void addBook(Book... books) {
        Collections.addAll(Library.books, books);
    }


    public static void deleteBook(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                books.remove(book);
                break;
            }
        }
    }

    //User Op
    public static void addUser(User... users) {
        Collections.addAll(Library.users, users);
    }

    public static boolean login(String phoneNumber, String email) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }


}
