package test.java.integrationTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import project.Book;
import project.Library;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Book book = new Book("test", "author", "ibsn");
        Library lib = new Library();

        lib.addBook(book);
        assertEquals(1, lib.getTotalNumberOfBooks());
    }
    
}
