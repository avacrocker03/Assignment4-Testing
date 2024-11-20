package test.java.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import project.Book;

public class BookTest {

    @Test
    public void testBookTitle() {
        Book book = new Book("Harry Potter", "J.K. Rowling", "1234ABCD");
        assertEquals("Harry Potter", book.getTitle());
    }
    
}
