import java.util.Arrays;
import java.util.Random;

public class Item extends GameObject {

    int damage;
    int health;
    String name;

    public Item() {
        this.name = Arrays.asList("Gun", "Sword").get(new Random().nextInt(2));
        this.damage = (int) (Math.random() * 5) + 1;
        this.health = (int) (Math.random() * 5) + 1;
    }

    public String draw() {
        return "**";
    }

}
