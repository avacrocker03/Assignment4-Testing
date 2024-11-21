package test.java.unitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import main.java.project.Book;

public class BookTest {
    Book book;

    // Populating book object before each test
    @BeforeEach
    public void createBook()
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

}
