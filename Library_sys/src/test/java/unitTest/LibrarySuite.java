package test.java.unitTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.jupiter.api.Test;

@Suite
@SelectClasses({LibraryTest.class, UserTest.class, BookTest.class})
public class LibrarySuite {
    // Test suite to test entire library functionality
    // Tests LibraryTest, UserTest, and BookTest
}