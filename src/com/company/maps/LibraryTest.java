package com.company.maps;

import com.company.maps.models.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Wes Lanning
 * @version 2019-11-13
 */
class LibraryTest {

    private Library library = new Library();



    @BeforeEach
    void setUp() {
        library.addBook(new Book("It", "1979", 9.95, false, "Steven King"));
        library.addBook(new Book("Jurassic Park", "1985", 11.83, false, "Michael Crichton"));
        library.addBook(new Book("Brave New World", "1935", 8.09, false, "Aldous Huxley"));
        library.addBook(new Book("Gang of Four", "1879", 5.50, false, "Arthur Conan Doyle"));
        library.addBook(new Book("Hounds of Bakersfield", "1881", 6.50, false, "Arthur Conan Doyle"));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBook() {
        var author = "Steven King";
        var title = "It";
        Book book = library.getBook(author, title);
        assertNotNull(book, "Book expected to not be null");
        assertEquals(author, book.getAuthorName(), "Expected author to be: " + author + "\n actual author is: " + book.getAuthorName());
    }

    @Test
    void isCheckedOut() {
        var author = "Michael Crichton";
        var title = "Jurassic Park";
        var book = library.getBook(author, title);
        assertFalse(library.isCheckedOut(author, title), "Expected book to not be checked out");

        library.checkOut(author, title);
        assertTrue(library.isCheckedOut(author, title), "Book was expected to be checked out");

        library.checkIn(author, title);
        assertFalse(library.isCheckedOut(author, title), "Book was expected to not be checked out");
    }

    @Test
    void reserveBook() {
        var author = "Michael Crichton";
        var title = "Jurassic Park";
        var customerName = "Cletus";

        var book = library.getBook(author, title);
        var reserveNumber = book.reserveBook(customerName);

        assertEquals(1, reserveNumber, "Expected no one else to be in the queue");

        reserveNumber = book.reserveBook("Homer");
        assertEquals(2, reserveNumber, "Expected 2 people to be in the queue");

        String removedCustomerName = book.removeReservation();
        assertEquals(customerName, removedCustomerName, customerName + " should have been removed");
    }
}