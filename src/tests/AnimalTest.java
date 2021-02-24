import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnimalTest {

    @Test
    void run() {
        Animal animal = new Animal(0, 5, 4000, 25);
        Main.dray.setNewCord(0,0);
        animal.run();
        Assertions.assertEquals(35, Main.dray.getX());
        Assertions.assertEquals(0, Main.dray.getY());
    }
}