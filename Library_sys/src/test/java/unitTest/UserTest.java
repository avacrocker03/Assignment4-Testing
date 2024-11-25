package test.java.unitTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.project.Book;
import main.java.project.User;

public class UserTest {
    static User user;
    static Book book;

    // Creating user and book before tests
    @BeforeAll
    public static void createObjects()
    {
        user = new User("Ava", "1234");
        book = new Book("Harry Potter", "J.K. Rowling",  "1234ABCD");
        user.borrowBook(book);
    }

    // Testing borrowing borrowed book
    @Test
    public void testBorrowedBook()
    {
        assertThrows(IllegalStateException.class, () -> user.borrowBook(book));
    }

    // Testing user values
    @Test
    public void testUserInfo()
    {
        assertFalse(user.getName() == "Taylor");
        assertTrue(user.getName() == "Ava");

        assertEquals(user.getUserId(), "1234");

        assertEquals(user.getBorrowedBooks().size(), 1);
    }

    // Testing return book
    @Test
    public void testReturn()
    {
        Book testBook = new Book("Lord of the Rings", "J.R.R Tolkien", "5678EFGH");

        // Testing valid book
        user.returnBook(book);
        assertEquals(user.getBorrowedBooks().size(), 0);

        // Testing invalid book
        assertThrows(IllegalStateException.class, () -> user.returnBook(testBook));
    }

    
}
