import org.junit.jupiter.api.BeforeAll;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SceneTest {

    static Scene scene;

    @BeforeAll
    static void setUpClass() {
        scene = new Scene();
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void generateGoblin() {
        scene.generateGoblin();
        assert(scene.goblins.size() >= 1);
    }

    @org.junit.jupiter.api.Test
    void getEntity() {
        Entity g = scene.goblins.get(0);
        assert(scene.getEntity(g.pos) == g);
    }

    @org.junit.jupiter.api.Test
    void setEntity() {
        Entity g = scene.goblins.get(0);
        Vector<Integer> pos = scene.buildVec(0, 0);
        scene.setEntity(pos, g);
        assert(scene.getEntity(pos) == g);
    }

    @org.junit.jupiter.api.Test
    void buildVec() {
        Vector<Integer> pos = scene.buildVec(0, 0);
        assert(pos.get(0) == 0);
        assert(pos.get(1) == 0);
    }
}