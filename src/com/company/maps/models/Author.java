package com.company.maps.models;

import java.util.HashMap;

/**
 * @author Wes Lanning
 * @version 2019-11-13
 */
public class Author {
    /**
     * book key = title
     */
    private HashMap<String, Book> books = new HashMap<>();
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook(String title) {
        return books.get(title);
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }
}
