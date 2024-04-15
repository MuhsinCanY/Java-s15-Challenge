import com.workintech.books.*;

import java.util.*;

public class Library {

    static List<Book> books = new ArrayList<>();
    static List<User> users = new ArrayList<>();

    //Books Op
    public static List<Book> getBooks() {
        return books;
    }

    public static List<Book> displayAllBooks() {
        if (books.toArray().length == 0) {
            System.out.println("There are no books in the library");
        }
        for (Book book : books) {
            book.display();
        }
        return getBooks();
    }

    public static List<Journal> displayJournal() {
        List<Journal> journals = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof Journal) {
                book.display();
                journals.add((Journal) book);
            }
        }
        if (journals.toArray().length == 0) {
            System.out.println("There are no Journal in the library");
        }
        return journals;
    }

    public static List<StudyBook> displayStudyBook() {
        List<StudyBook> studyBooks = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof StudyBook) {
                book.display();
                studyBooks.add((StudyBook) book);
            }
        }
        if (studyBooks.toArray().length == 0) {
            System.out.println("There are no Study Book in the library");
        }
        return studyBooks;
    }

    public static List<Magazine> displayMagazine() {
        List<Magazine> magazines = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof Magazine) {
                book.display();
                magazines.add((Magazine) book);
            }
        }
        if (magazines.toArray().length == 0) {
            System.out.println("There are no Magazine in the library");
        }
        return magazines;
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
