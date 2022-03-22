import java.util.Scanner;

/*
command line ascii hangman game
have a list of words to choose from
the user has to guess the word one letter at a time
the user has a limited number of guesses
if the user guesses the word correctly, the game is over
if the user runs out of guesses, the game is over
if the user guesses a letter that is in the word, reveal the letter
if the user guesses a letter that is not in the word, a body part is added to the gallows
 */


public class project5 {

    static String[] words = {"cat", "dog", "bird",
            "fish", "cow", "pig", "horse",
            "sheep", "chicken", "snake",
            "lion", "tiger", "zebra", "giraffe",
            "elephant", "monkey", "panda",
            "koala", "penguin", "dolphin",
            "whale", "shark", "octopus",
            "squid", "crab", "crocodile",
            "cobra", "alligator", "dinosaur",
            "bat", "beetle", "butterfly"};

    static String word;
    static char[] guesses;
    static int wrongGuesses;

    public void main(String[] args) {

        setup();
        play();

    }

    public void setup() {
        word = words[(int) (Math.random() * words.length)];
        guesses = new char[word.length()];
        wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++)
            guesses[i] = '_';
    }

    public boolean guessLetter(String letter) {

        boolean found = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter.charAt(0)) {
                guesses[i] = letter.charAt(0);
                found = true;
            }
        }

        return found;

    }

    public void printGallows() {
        //print gallows and draw body parts based on wrong guesses

        System.out.println("+----+");
        System.out.println("|    |");
        System.out.println((wrongGuesses >= 1) ? "O    |" : "     |");
        System.out.println((wrongGuesses >= 2) ? "|    |" : "     |");
        System.out.println((wrongGuesses >= 3) ? "I    |" : "     |");
        System.out.println("=======\n");
    }

    public void printGuesses() {
        //print guesses

        System.out.print("Word: ");
        for (int i = 0; i < word.length(); i++)
            System.out.print(guesses[i] + " ");
        System.out.println();
    }

    public boolean isWordGuessed() {
        //check if word has been guessed

        for (int i = 0; i < word.length(); i++)
            if (guesses[i] == '_')
                return false;

        return true;
    }

    public void play() {
        //play game

        Scanner scan = new Scanner(System.in);
        String letter;

        while (!isWordGuessed() && wrongGuesses < 3) {
            printGallows();
            printGuesses();
            System.out.print("Guess a letter: ");
            letter = scan.nextLine();
            if (!guessLetter(letter))
                wrongGuesses++;
        }

        if (isWordGuessed())
            System.out.println("You win!");
        else
            System.out.println("You lose!");

        System.out.println("The word was " + word);
    }
}



