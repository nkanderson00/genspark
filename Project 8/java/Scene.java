import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Scene extends JPanel implements ActionListener, KeyListener {

    // instance variables
    GameObject[][] grid;
    Human human;
    final int GRID_SIZE = 10;
    final int TILE_SIZE = 50;
    boolean ended = false;
    boolean inAttack = false;
    ArrayList<Entity> goblins;


    public Scene() {
        setPreferredSize(new Dimension(TILE_SIZE * GRID_SIZE, TILE_SIZE * GRID_SIZE));
        setBackground(new Color(232, 232, 232));
        grid = new Entity[GRID_SIZE][GRID_SIZE];
        goblins = new ArrayList<Entity>();
        Point pos = new Point(5,5);
        human = new Human(pos, this);
        generateGoblin();
    }

    public void generateGoblin() {
        int randX = (int) (Math.random() * 10);
        int randY = (int) (Math.random() * 10);
        Point pos = new Point(randX, randY);
        Goblin g = new Goblin(pos, this);
        setEntity(pos, g);
        goblins.add(g);
    }

    public void drawBackground(Graphics g) {

        g.setColor(new Color(214, 214, 214));

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if ((i + j) % 2 == 1) {
                    g.fillRect(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("painting");
        super.paintComponent(g);
        drawBackground(g);
        //drawScore(g);
        for (Entity goblin: goblins)
            goblin.draw(g, this);
        human.draw(g, this);
        Toolkit.getDefaultToolkit().sync();
    }

    public GameObject getEntity(Point pos) {
        return grid[pos.y][pos.x];
    }

    public void setEntity(Point pos, GameObject entity) {
        grid[pos.y][pos.x] = entity;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("pressed");
        human.keyPressed(e);
        moveGoblins();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

