package gui.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseJunitTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("this is junit before all test");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("this is junit before each test");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("this is junit after each test");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("this is junit after all test");
    }
}
