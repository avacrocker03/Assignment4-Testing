package test.java.unitTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.util.ArrayList;

import main.java.project.Book;
import main.java.project.Library;
import main.java.project.User;

public class LibraryTest {
    Book book1;
    Book book2;
    User user1;
    User user2;
    Library lib;


    // creating users, books, and library object before tests
    @BeforeEach
    public void createObjects()
    {
        lib = new Library();
        user1 = new User("Ava", "1234");
        user2 = new User("Taylor", "5678");

        book1 = new Book("Harry Potter", "J.K. Rowling",  "1234ABCD");
        book2 = new Book("Lord of the Rings", "J.R.R Tolkien", "5678EFGH");
        
        lib.addBook(book1);
        lib.addBook(book2);

        lib.registerUser(user1);
        lib.registerUser(user2);

        lib.borrowBook("1234", "1234ABCD");
        lib.borrowBook("5678", "5678EFGH");
    }

    // Testing the adding book functionality
    @Test
    public void testAddBook() {
        assertSame(2, lib.getTotalNumberOfBooks());
    }

    // Testing borrowing a null book
    @Test
    public void testNullBook()
    {
        Book bookNull = new Book (null, null, null);
        User userNull = new User(null,null);
        assertThrows(IllegalStateException.class, () -> lib.borrowBook(null, null));

    }

    // Testing return functionality
    @Test
    public void testReturnBook()
    {
        Book bookNull = new Book (null, null, null);
        User userNull = new User(null,null);
        lib.returnBook("1234", "1234ABCD");
        assertNotSame(lib.getTotalNumberOfBooks(), 5);
        
        // returning a null book
        assertThrows(IllegalStateException.class, () -> lib.returnBook(null, null));
    }

    // Testing available and borrowed books
    @Test
    public void testAvailBorrow()
    {
        List<Book> availBooks = lib.getAvailableBooks();
        
        // Testing available books
        assertSame(availBooks.size(), 0);

        // Testing borrowed books
        assertNotSame(lib.getTotalBorrowedBooks(), 0);
    }

    // Testing avg books per user
    @Test
    public void testAvgBooks()
    {
        // Testing when user list populated
        assertEquals(lib.getAverageBooksPerUser(), 1.0);

        // Testing when no users
        lib.removeUser("1234");
        lib.removeUser("5678");
        assertEquals(lib.getAverageBooksPerUser(), 0.0);
    }

    // Testing finding IBSN
    @Test
    public void testIBSN()
    {
        // Testing with valid IBSN
        assertNotNull(lib.findBookByIsbn("1234ABCD"));

        // Testing invalid IBSN
        assertNull(lib.findBookByIsbn("0000"));
    }
    
}
