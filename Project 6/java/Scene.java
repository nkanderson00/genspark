import java.util.ArrayList;
import java.util.Vector;

public class Scene {

    // instance variables
    GameObject[][] grid;
    Human human;
    int gridSize = 10;
    boolean ended = false;
    boolean inAttack = false;
    ArrayList<Entity> goblins;


    public Scene() {
        grid = new Entity[gridSize][gridSize];
        goblins = new ArrayList<Entity>();
        Vector<Integer> pos = new Vector<Integer>(2);
        pos.add(0,5);
        pos.add(0,5);
        human = new Human(pos, this);
        generateGoblin();
    }

    public void generateGoblin() {
        int randX = (int) (Math.random() * 10);
        int randY = (int) (Math.random() * 10);
        Vector<Integer> pos = buildVec(randX, randY);
        Goblin g = new Goblin(pos, this);
        setEntity(pos, g);
        goblins.add(g);
    }

    public void draw() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == null)
                    System.out.print("[]");
                else
                    System.out.print(grid[i][j].getSymbol());
            }
            System.out.println();
        }
    }

    public GameObject getEntity(Vector<Integer> pos) {
        return grid[pos.get(1)][pos.get(0)];
    }

    public void setEntity(Vector<Integer> pos, GameObject entity) {
        grid[pos.get(1)][pos.get(0)] = entity;
    }

    public void onCollision(GameObject collider, GameObject collidee) {
        if (collider instanceof Entity && collidee instanceof Entity) {
            System.out.println("An attack has started!");
            do {
                ((Entity) collider).attack((Entity) collidee);
                //alternator to rotate human and goblins attacks
                GameObject temp = collider;
                collider = collidee;
                collidee = temp;
            } while (inAttack);
        }
        else if (collider instanceof Entity && collidee instanceof Item) {
            ((Entity) collider).pickUp((Item) collidee);
        }
    }

    public void moveGoblins() {
        for (Entity g : goblins) {
            ((Goblin) g).move(((Goblin) g).getHumanVector());
        }
    }

    public void triggerEnd() {
        ended = true;
    }

    public Vector<Integer> buildVec(int x, int y) {
        Vector<Integer> v = new Vector<Integer>(2);
        v.add(x);
        v.add(y);
        return v;
    }


}
