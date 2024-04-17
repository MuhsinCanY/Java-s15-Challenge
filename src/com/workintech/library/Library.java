package com.workintech.library;

import com.workintech.books.*;
import com.workintech.user.User;

import java.util.*;

public class Library {

    public static Map<Integer, Book> books = new HashMap<>();
    public static Map<String, User> users = new HashMap<>();
    private static User loggedUser;

    //Books Op

    public static void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("There are no books in the library");
        }
        List<Book> bookList = new ArrayList<>(books.values());
        for (Book book : bookList) {
            book.display();
        }
    }

    public static void displayJournal() {
        List<Journal> journals = new ArrayList<>();
        List<Book> bookList = new ArrayList<>(books.values());
        for (Book book : bookList) {
            if (book instanceof Journal) {
                book.display();
                journals.add((Journal) book);
            }
        }
        if (journals.isEmpty()) {
            System.out.println("There are no Journal in the library");
        }
    }

    public static void displayStudyBook() {
        List<StudyBook> studyBooks = new ArrayList<>();
        List<Book> bookList = new ArrayList<>(books.values());
        for (Book book : bookList) {
            if (book instanceof StudyBook) {
                book.display();
                studyBooks.add((StudyBook) book);
            }
        }
        if (studyBooks.isEmpty()) {
            System.out.println("There are no Study Book in the library");
        }
    }

    public static void displayMagazine() {
        List<Magazine> magazines = new ArrayList<>();
        List<Book> bookList = new ArrayList<>(books.values());
        for (Book book : bookList) {
            if (book instanceof Magazine) {
                book.display();
                magazines.add((Magazine) book);
            }
        }
        if (magazines.isEmpty()) {
            System.out.println("There are no Magazine in the library");
        }
    }

    public static void addBook(Book... books) {
        for (Book book : books) {
            Library.books.put(book.getBookId(), book);
        }
    }

    public static void deleteBook(int id) {
        Library.books.remove(id);
    }

    public static void searchById(int id) {
        Book book = Library.books.get(id);
        if (book != null) {
            book.display();
        } else {
            System.out.println("Book not found...");
        }
    }

    public static void searchByTitle(String title) {
        System.out.println(title.toLowerCase());
        List<Book> bookList = new ArrayList<>(Library.books.values());
        for (Book book : bookList) {
            if (book.getName().toLowerCase().contains(title.toLowerCase())) {
                book.display();
            }
        }
    }

    public static void searchByAuthor(String author) {
        System.out.println(author.toLowerCase());
        List<Book> bookList = new ArrayList<>(Library.books.values());
        for (Book book : bookList) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                book.display();
            }
        }
    }

    public static void updateBook(int id, String name, String author, int price) {
        Book book = Library.books.get(id);
        if (book != null) {
            book.setName(name);
            book.setAuthor(author);
            book.setPrice(price);
        }
    }

    //User Op
    public static void addUser(User... users) {
        for (User user : users) {
            Library.users.put(user.getEmail(), user);
        }
    }

    public static boolean login(String email) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                loggedUser = user;
                return true;
            }
        }
        return false;
    }

    public static void borrowBook(int bookId) {
        Book book = Library.books.get(bookId);
        if (book != null && book.checkBookStatusAndBorrow()) {
            loggedUser.addBorrowedBooks(book);
            loggedUser.addInvoicePrice(book.getPrice());
        }
    }

    public static void getBorrowedBooks() {
        System.out.println("\n Borrowed Books : \n");
        for (Book book : loggedUser.getBorrowedBooks()) {
            book.display();
        }
    }

    public static void returnBorrowedBook(int bookId) {
        Book book = Library.books.get(bookId);
        if (book != null) {
            loggedUser.removeBorrowedBooks(book);
            loggedUser.subtractInvoicePrice(book.getPrice());
        }
    }

    public static void displayInvoice() {
        loggedUser.getInvoicePrice();
    }

}



