import java.util.Scanner;

public class project6 {

    public static void main(String[] args) {

        Scene scene = new Scene();

        System.out.println("Goblins are after you. Kill them!");
        System.out.println("You have " + scene.human.health + " health left.");
        System.out.println("Your weapon is a " +
                scene.human.weapon.name + " and does " +
                scene.human.weapon.damage + " damage.");

        while (!scene.ended) {

            scene.draw();

            System.out.println("Where will you go? (N, S, E, W)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            input = input.toUpperCase();

            switch (input) {
                case "N":
                    scene.human.move(scene.buildVec(0, -1));
                    break;
                case "S":
                    scene.human.move(scene.buildVec(0, 1));
                    break;
                case "E":
                    scene.human.move(scene.buildVec(1, 0));
                    break;
                case "W":
                    scene.human.move(scene.buildVec(-1, 0));
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

            scene.moveGoblins();
        }



    }
}
