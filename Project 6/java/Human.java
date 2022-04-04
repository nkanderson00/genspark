import java.util.Vector;

public class Human extends Entity {

    public Human(Vector<Integer> pos, Scene scene) {
        super(pos, scene, "Human");
    }

    public String getSymbol() {
        return ":)";
    }

    public void die() {
        super.die();
        scene.triggerEnd();
    }


}
