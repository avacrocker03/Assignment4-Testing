package test.java.unitTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.java.project.Book;
import main.java.project.Library;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Book book = new Book("test", "author", "ibsn");
        Library lib = new Library();

        lib.addBook(book);
        assertEquals(1, lib.getTotalNumberOfBooks());
    }
    
}
