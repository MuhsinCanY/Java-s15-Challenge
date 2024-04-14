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

    public static Book searchById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                book.display();
                return book;
            }
        }
        System.out.println("Book not found...");
        return null;
    }

    public static ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> search = new ArrayList<>();
        System.out.println(title.toLowerCase());
        for (Book book : books) {
            if (book.getName().toLowerCase().contains(title.toLowerCase())) {
                book.display();
                search.add(book);
            }
        }
        return search;
    }

    public static ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> search = new ArrayList<>();
        System.out.println(author.toLowerCase());
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                book.display();
                search.add(book);
            }
        }
        return search;
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
