import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Project1Test {

    static Project1 p1;

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("Setting up class");
        p1 = new Project1();
    }

    @BeforeEach
    void setUp() {
        System.out.println("testing method:");
    }

    @AfterEach
    void tearDown() {
        System.out.println("finished test.\n");
    }

    @Test
    void set_good_cave() {
        System.out.println("set_good_cave");
        p1.set_good_cave();
    }

    @Test
    void set_choice_cave() {
        System.out.println("set_choice_cave");
        p1.set_choice_cave(1);
    }

    @Test
    void good_cave() {
        System.out.println("good_cave");
        p1.good_cave();
        assertTrue(p1.good_cave(), "You did not select the right cave. Run again to see different random results.");
    }

}