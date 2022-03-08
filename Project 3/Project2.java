import java.util.Scanner;

public class Project2
{
    public static void main(String[] args){
        Project2 p2 = new Project2();
        p2.run();
    }
    public void run()
    {
        //random number from 1 to 20
        int randomNumber = (int) (Math.random() * 20 + 1);
        boolean won = false;
        int guess = 0;
        Scanner input;

        //the user guesses a number amd program says if it is too high or too low
        //there are 6 tries
        for (int i = 0; i < 6; i++)
        {
            //do while loop to make sure the user enters a number
            do
            {
                //prompt the user to guess a number
                System.out.println("Guess a number between 1 and 20");
                System.out.print(">> ");
                input = new Scanner(System.in);

                //check if the user input is a number
                if (input.hasNextInt()) {
                    guess = input.nextInt();
                    if (guess >= 1 && guess <= 20)
                        break;
                }
            }
            while (true);

            if (guess == randomNumber)
            {
                won = true;
                break;
            }

            //if the user guessed too high
            else if (guess > randomNumber)
                System.out.println("\nYou guessed too high!");

            //if the user guessed too low
            else
                System.out.println("\nYou guessed too low!");

            System.out.println("You have " + (5 - i) + " tries left.\n");

        }

        if (won == false)
            System.out.println("You did not guess the number!");
        else
            System.out.println("You guessed the number!");

    }
}