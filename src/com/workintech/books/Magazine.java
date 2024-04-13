package com.workintech.books;

import com.workintech.enums.FrequencyOfPublication;

public class Magazine extends Book {

    private FrequencyOfPublication frequency;

    public Magazine(int bookId, String name, String author, double price,
                    FrequencyOfPublication frequency) {
        super(bookId, name, author, price);
        this.frequency = frequency;
    }

    public FrequencyOfPublication getFrequency() {
        return frequency;
    }

    public void display() {
        System.out.println(" ID: " + this.getBookId() + " '" + this.getName() + "'" +
                " by" +
                " " + this.getAuthor() + ", Frequence : " + this.getFrequency());
    }
}
