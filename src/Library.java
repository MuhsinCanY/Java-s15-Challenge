import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    static List<Book> books = new ArrayList<>();
    static List<User> users = new ArrayList<>();

    //Books Op
    public static List<Book> getBooks() {
        if (books.toArray().length == 0) {
            System.out.println("There are no books in the library");
        }

        for (int i = 0; i < books.toArray().length; i++) {
            Book book = books.get(i);
            System.out.println(i + ". '" + book.getName() + "' by " + book.getAuthor());
        }
        return books;
    }

    public static void addBook(Book... books) {
        Collections.addAll(Library.books, books);
    }


    public static void deleteBook(int index) {
        if (books.contains(books.get(index))) {
            books.remove(books.get(index));
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
