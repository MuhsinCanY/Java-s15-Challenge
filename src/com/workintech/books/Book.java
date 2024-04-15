package com.workintech.books;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Book {

    private int bookId;
    private String name;
    private String author;
    private double price;
    private boolean status;
    private Date date_of_purchase;


    public Book(int bookId, String name, String author, double price) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = true;
        this.date_of_purchase = new Date();
    }

    public int getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getDate_of_purchase() {
        return date_of_purchase;
    }

    public void display() {
        System.out.println(" ID: " + this.getBookId() + " '" + this.getName() + "'" +
                " by" +
                " " + this.getAuthor());
    }

    @Override
    public String toString() {
        return "com.workintech.books.Book{" +
                "book Id=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", date_of_purchase=" + date_of_purchase +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
}
