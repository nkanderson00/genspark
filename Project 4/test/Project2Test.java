import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Project2Test {

    static Project2 p2;

    @BeforeEach
    void setUp() {
        p2 = new Project2();
        System.out.println("Testing:");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test complete.");
    }

    @Test
    void set_random_number() {
        System.out.println("set_random_number");
        p2.set_random_number();
    }

    @Test
    void set_guess() {
        System.out.println("set_guess");
        p2.set_guess(10);
    }

    @Test
    void check_won() {
        System.out.println("check_won");
        p2.set_random_number();
        p2.set_guess(10);
        assertTrue((p2.guess == p2.random_number), "The wrong number was guessed.");
    }
}