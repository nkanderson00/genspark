import java.util.Vector;

public class Goblin extends Entity {


    public Goblin(Vector<Integer> pos, Scene scene) {
        super(pos, scene, "Goblin");
    }

    public Vector<Integer> getHumanVector() {
        Vector<Integer> v = scene.buildVec(
                getLocation().get(0) - scene.human.getLocation().get(0),
                getLocation().get(1) - scene.human.getLocation().get(1));
        float divisor = -(int) Math.sqrt(v.get(0)*v.get(0) + v.get(1)*v.get(1));
        v.set(0, Math.round(v.get(0)/divisor));
        v.set(1, Math.round(v.get(1)/divisor));
        return v;
    }

    public String getSymbol() {
        return ":#";
    }

    public void die() {
        super.die();
        scene.goblins.remove(this);
        scene.generateGoblin();
        //if a 1 in 3 chance, generate another goblin
        if (Math.random() < 0.33)
            scene.generateGoblin();
    }
}
