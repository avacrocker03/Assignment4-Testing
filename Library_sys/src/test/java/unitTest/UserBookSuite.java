package test.java.unitTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.jupiter.api.Test;

@Suite
@SelectClasses({UserTest.class, BookTest.class})
public class UserBookSuite {
    // Test Suite to test User and Book functionalities
    // Tests UserTest and BookTest
}