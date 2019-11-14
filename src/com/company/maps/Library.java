package com.company.maps;

import com.company.maps.models.Author;
import com.company.maps.models.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wes Lanning
 * @version 2019-11-13
 */
public class Library {
    /**
     * Uses the author's name as the key and the Book is the value
     * key = author's name
     * value = the book
     */
    private Map<String, Author> authors = new HashMap<>();

    public Library() {


    }

    public Book getBook(String authorName, String title) {
        var author = authors.get(authorName);
        var book = author.getBook(title);
        return book;
    }

    public boolean isCheckedOut(String authorName, String title) {
        Author author = authors.get(authorName);
        Book book = author.getBook(title);
        return book.isCheckedOut();
    }

    public void checkOut(String authorName, String title) {
        Author author = authors.get(authorName);
        Book book = author.getBook(title);
        book.setCheckedOut(true);
    }

    public void checkIn(String authorName, String title) {
        Author author = authors.get(authorName);
        Book book = author.getBook(title);
        book.setCheckedOut(false);
    }

    public void addBook(Book book) {
        Author author = authors.get(book.getAuthorName());
        if (author == null) {
            author = new Author(book.getAuthorName());
        }
        author.addBook(book);
        authors.put(author.getName(), author);
    }

    /**
     * Allows a customer to reserve a book if all have been checked out.
     *
     * @param authorName
     * @param title
     * @param customerName - who wnats to reserve the book
     * @return the spot in the reserve queue (from 1 to whatever)
     */
    public int reserveBook(String authorName, String title, String customerName) {
        Author author = authors.get(authorName);
        Book book = author.getBook(title);
        int reservationNumber = book.reserveBook(customerName);
        return reservationNumber;
    }

}
