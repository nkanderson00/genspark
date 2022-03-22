import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class project5Test {

    static project5 p5;

    @BeforeAll
    static void setUpBeforeClass() {
        p5 = new project5();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Passed");
    }

    @Test
    void setup() {
        System.out.println("Testing setup()");
        p5.setup();
    }

    @Test
    void guessLetter() {
        System.out.println("Testing guessLetter()");
        assertTrue(p5.guessLetter("a"));
    }

    @Test
    void printGallows() {
        System.out.println("Testing printGallows()");
        p5.printGallows();
    }

    @Test
    void printGuesses() {
        System.out.println("Testing printGuesses()");
        p5.printGuesses();
    }

    @Test
    void isWordGuessed() {
        System.out.println("Testing isWordGuessed()");
        assertTrue(p5.isWordGuessed());
    }
}