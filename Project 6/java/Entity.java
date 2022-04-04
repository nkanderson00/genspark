import java.util.Objects;
import java.util.Vector;

public class Entity extends GameObject {

    int health = 10;
    int gridSize;
    Vector<Integer> pos;
    Item weapon;
    Scene scene;
    boolean isAlive = true;
    String species;

    public Entity(Vector<Integer> pos, Scene scene, String species) {
        this.gridSize = scene.gridSize;
        this.scene = scene;
        this.weapon = new Item();
        this.species = species;
        setLocation(pos);
    }

    public Vector<Integer> getLocation() {
        return pos;
    }


    public void setLocation(Vector<Integer> newPos) {
        if (scene.getEntity(newPos) != null)
            scene.onCollision(this, scene.getEntity(newPos));
        if (pos != null)
            scene.setEntity(pos, null);
        pos = newPos;
        scene.setEntity(pos, this);
    }

    //takes a unit vector to move the entity in that direction by one unit
    public void move(Vector<Integer> newPos) {
        newPos.set(0, Math.min(Math.max(pos.get(0) + newPos.get(0), 0), gridSize - 1));
        newPos.set(1, Math.min(Math.max(pos.get(1) + newPos.get(1), 0), gridSize - 1));
        if (Objects.equals(newPos.get(0), pos.get(0)) && Objects.equals(newPos.get(1), pos.get(1)))
            return;
        setLocation(newPos);
    }

    public void attack(Entity other)
    {
        scene.inAttack = true;
        other.health -= weapon.damage / ((int) (Math.random()*2) + 1);
        System.out.println(species + " attacked " + other.species + " with " + weapon.damage + " damage!");
        weapon.health -= 1;
        if (weapon.health <= 0) {
            //weapon = null;
            System.out.println("The " + species + "'s weapon has broken!");
        }
        if(other.health <= 0) {
            weapon = other.weapon;
            weapon.health += 5;
            health += 5;
            other.die();
        }
    }


    public void die()
    {
        isAlive = false;
        System.out.println(species + " has died!");
        scene.inAttack = false;
    }

    public void pickUp(Item item)
    {
        weapon = item;
        System.out.println(species + " picked up " + item.name);
    }
}