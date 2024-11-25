package test.java.unitTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;


import main.java.project.Book;

public class BookTest {
    static Book book;

    // Populating book object before each test
    @BeforeAll
    public static void createBook()
    {
        book = new Book("Harry Potter", "J.K. Rowling",  "1234ABCD");
        book.borrowBook();
    }

    // Testing each book attributes value ie. title, author, ibsn
    @Test
    public void testBookAttributes() 
    {
        assertEquals("Harry Potter", book.getTitle());
        assertEquals("J.K. Rowling", book.getAuthor());
        assertEquals("1234ABCD", book.getIsbn());
        assertFalse(book.getIsbn().contains("5678"));
        assertTrue(!book.getTitle().isEmpty());
    }

    // Testing book status ie. borrowed, returned, available
    @Test
    public void testBookStatus()
    {
        assertFalse(book.isAvailable());

        // returning book
        book.returnBook();
        assertTrue(book.isAvailable());
    }

    // Testing null book borrow
    @Test
    public void testBorrowedBook()
    {
        assertThrows(IllegalStateException.class, () -> book.borrowBook());
    }

    // Grabbing values from null book
    @Test
    public void testNullValues()
    {
        Book nullBook = new Book(null,null,null);
        assertNull(nullBook.getAuthor());
        assertNull(nullBook.getIsbn());
        assertNull(nullBook.getTitle());
    }

    // Trying to return a book that isn't borrowed
    @Test
    public void testReturnedBook()
    {
        Book nullBook = new Book(null,null,null);
        assertTrue(nullBook.isAvailable());
    }

}
