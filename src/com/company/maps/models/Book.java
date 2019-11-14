package com.company.maps.models;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wes Lanning
 * @version 2019-11-13
 */
public class Book {
    private String title;
    private String datePublished;
    private double price;
    private boolean checkedOut; // not checked out by default
    private String authorName;

    private Queue<String> reservations = new LinkedList<>();

    public Book(String title, String datePublished, double price, boolean checkedOut, String authorName) {
        this.title = title;
        this.datePublished = datePublished;
        this.price = price;
        this.checkedOut = checkedOut;
        this.authorName = authorName;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    /**
     * Check out the book.
     * @param checkedOut - set to true to check out, false to check it back in
     */
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNextReservation()
    {
        return reservations.peek();
    }

    public String removeReservation()
    {
        return reservations.poll();
    }

    /**
     * Add a person to the reserve queue.
     * Then return the current spot in the
     * reservation line for this person.
     *
     * @param nameOfPerson - person to add to the queue
     * @return spot in the queue (from 1 to whatever)
     */
    public int reserveBook(String nameOfPerson) {
        reservations.add(nameOfPerson);
        return reservations.size();
    }
}
