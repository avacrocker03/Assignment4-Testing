package test.java.integrationTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


import main.java.project.Library;
import main.java.project.Book;
import main.java.project.User;

public class PairwiseTechniqueTest {
    private static Library library;
    private static User user;
    private static Book book;
    private static Book book_two;

    @BeforeEach
    void setUp() {
        library = new Library();
        user = new User("Ava Crocker", "1234");
        book = new Book("Harry Potter", "J.K. Rowling",  "1234ABCD");
        book_two = new Book("Harry Potter: Chamber of Secrets", "J.K. Rowling",  "1234EFGH");

        library.addBook(book);
        library.addBook(book_two);
        library.registerUser(user);
    }

    @Test
    void borrowedBookAvailability() {
        library.borrowBook("1234", "1234ABCD");
        assertFalse(book.isAvailable());
    }

    @Test
    void borrowedBookError() {
        library.borrowBook("1234", "1234ABCD");
        assertThrows(IllegalStateException.class, () -> library.borrowBook("1234", "1234ABCD"));
    }

    @Test
    void noBook() {
        assertThrows(IllegalStateException.class, () -> library.borrowBook("1234", "1234IJKL"));
    }

    @Test
    void userBorrowedBooks() {
        library.borrowBook("1234", "1234ABCD");
        assertEquals(1, user.getBorrowedBooks().size());
    }

    @Test
    void returnBookError() {
        library.borrowBook("1234", "1234ABCD");
        assertThrows(IllegalStateException.class, () -> library.returnBook("1234", "1234EFGH"));
    }

    @Test
    void noUser() {
        library.borrowBook("1234", "1234ABCD");
        assertThrows(IllegalStateException.class, () -> library.returnBook("5678", "1234ABCD"));
    }

    @Test
    void borrowedBookReturned() {
        library.borrowBook("1234", "1234ABCD");
        library.returnBook("1234", "1234ABCD");
        assertTrue(book.isAvailable());

    }

    @Test
    void userReturnedBook() {
        library.borrowBook("1234", "1234EFGH");
        library.returnBook("1234", "1234EFGH");
        assertEquals(0, user.getBorrowedBooks().size());
    }    
}
