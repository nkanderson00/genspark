import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        Project1 p1 = new Project1();
        p1.prompt();
    }

    public void prompt() {

        System.out.println("You live in a world of dragons.");
        System.out.println("You come across two caves. One dragon is friendly and will share his treasure with you."+
                "The other dragon is greedy and hungry, and will eat you on sight.");

        int cave;
        //check if input is a number either 1 or 2
        do {
            System.out.print("\nWhich cave will you go into? (1 or 2)? >> ");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt())
            {
                cave = input.nextInt();
                if (cave == 1 || cave == 2) {
                    break;
                }
            }
            System.out.println("\nPlease enter a number 1 or 2.");

        } while (true);

        int random_cave = (int) (Math.random() * 2) + 1;
        if (cave == random_cave) {
            System.out.println("You enter cave " + cave + ". You see a friendly dragon!");
            System.out.println("He shares his treasure with you and you live happily ever after.");
        }

        else
        {
            System.out.println("You enter cave " + cave + ". You see a hungry dragon!");
            System.out.println("He eats you! Game over.");
        }

    }
}

