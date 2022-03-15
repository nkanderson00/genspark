import java.util.Scanner;

public class Project1 {

    private int random_cave;
    private int cave_choice;

    public static void main(String[] args) {
        Project1 p1 = new Project1();
        p1.set_good_cave();
        p1.prompt();
    }

    public void set_good_cave()
    {
        random_cave = (int) (Math.random() * 2) + 1;
    }

    public void set_choice_cave(int cave_choice)
    {
        this.cave_choice = cave_choice;
    }

    public boolean good_cave()
    {
        return cave_choice == random_cave;
    }

    public void get_input()
    {
        do {
            System.out.print("\nWhich cave will you go into? (1 or 2)? >> ");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt())
            {
                cave_choice = input.nextInt();
                if (cave_choice == 1 || cave_choice == 2) {
                    break;
                }
            }
            System.out.println("\nPlease enter a number 1 or 2.");

        } while (true);
    }

    public void prompt() {

        System.out.println("You live in a world of dragons.");
        System.out.println("You come across two caves. One dragon is friendly and will share his treasure with you."+
                "The other dragon is greedy and hungry, and will eat you on sight.");

        //check if input is a number either 1 or 2
        get_input();


        if (good_cave()) {
            System.out.println("You enter cave " + cave_choice + ". You see a friendly dragon!");
            System.out.println("He shares his treasure with you and you live happily ever after.");
        }

        else
        {
            System.out.println("You enter cave " + cave_choice + ". You see a hungry dragon!");
            System.out.println("He eats you! Game over.");
        }

    }
}

