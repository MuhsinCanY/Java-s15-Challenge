package com.workintech.user;

import com.workintech.books.Book;

import java.util.*;
import java.util.Objects;

public class User {

    private String name;
    private String email;
    private String phoneNumber;
    private Set<Book> borrowedBooks = new HashSet<>();
    private double invoicePrice = 0;

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Set<Book> getBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("There is not borrowed book in the user");
        }
        return borrowedBooks;
    }

    public void getInvoicePrice() {
        System.out.println("User's current invoice price : " + invoicePrice);
    }

    public void addInvoicePrice(double price) {
        this.invoicePrice += price;
        System.out.println("User's current invoice price : " + invoicePrice);
    }

    public void subtractInvoicePrice(double price) {
        if (this.invoicePrice >= price) {
            this.invoicePrice -= price;
            System.out.println("User's current invoice price : " + invoicePrice);
        } else {
            System.out.println("Transaction could not be completed");
        }
    }

    public void addBorrowedBooks(Book borrowedBook) {
        if (this.borrowedBooks.size() < 5) {
            this.borrowedBooks.add(borrowedBook);

        } else {
            System.out.println("You have reached the maximum number of book borrowings. This book" +
                    " cannot be borrowed.");
        }
    }

    public void removeBorrowedBooks(Book book) {
        if (this.borrowedBooks.contains(book)) {
            this.borrowedBooks.remove(book);
            System.out.println("Book successfully returned to the Library");
        } else {
            System.out.println("There is not found any borrowed book");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
