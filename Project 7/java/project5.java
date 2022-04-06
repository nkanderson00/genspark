import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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

    String word;
    ArrayList<String> guesses;
    int wrongGuesses;
    String name;

    public static void main(String[] args) {

        project5 game = new project5();
        game.setup();
        game.play();

    }

    public void setup() {
        word = words[(int) (Math.random() * words.length)];
        System.out.println("Word: " + word);
        wrongGuesses = 0;
        guesses = (new ArrayList<>(Arrays.asList(word.split(""))))
                .stream().map(i -> "_")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        System.out.print("Enter your name to save your scores >> ");
        name = scan.nextLine();

    }

    public String readScoreFile() {
        File file = new File(String.format("src/scores/%s", name));
        try{
            file.createNewFile();
            return Files.readString(Path.of(String.format("src/scores/%s", name)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public boolean updateScore() {

        //returns true if new high score

        String data = readScoreFile();

        if (data.length() == 0)
            data = "100";

        int score = Integer.parseInt(data);

        if (wrongGuesses < score) {
            try {
                Files.writeString(Path.of(String.format("src/scores/%s", name)), String.valueOf(wrongGuesses));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }

        return false;

    }

    public int guessLetter(String letter) {
        if (word.contains(letter)) {
            guesses = IntStream.range(0, guesses.size())
                    .mapToObj(i -> Character.toString(word.charAt(i)).equals(letter) ? letter : guesses.get(i))
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
            return 0;
        }

        return 1;

    }

    public void printGallows() {
        //print gallows and draw body parts based on wrong guesses

        try {
            String art = Files.readString(Path.of(String.format("src/art/%s", wrongGuesses)));
            System.out.println(art);

        } catch (Exception e) {
            System.out.println("Missing art file");
        }

    }

    public void printGuesses() {
        //print guesses

        System.out.print("Word: " + String.join(" ", guesses));
        System.out.println();
    }

    public boolean isWordGuessed() {
        //check if word has been guessed

        return !guesses.contains("_");

    }

    public void play() {
        //play game

        Scanner scan = new Scanner(System.in);
        String letter;

        while (!isWordGuessed() && wrongGuesses < 6) {

            printGallows();
            printGuesses();
            System.out.print("Guess a letter: ");
            letter = scan.nextLine();

            if (letter.length() != 1)
                continue;

            wrongGuesses += guessLetter(letter);
        }

        if (isWordGuessed()) {
            System.out.println("You win!");
            if (updateScore())
                System.out.printf("New high score of only %d wrong guesses!%n", wrongGuesses);
        }
        else {
            System.out.println("You lose!");
            System.out.println("The word was " + word);
        }
    }
}



