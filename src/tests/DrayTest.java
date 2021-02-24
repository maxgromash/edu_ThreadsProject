import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DrayTest {

    @Test
    void pull() {
        Main.dray.setNewCord(0,0);
        Main.dray.pull(2, Math.toRadians(90));
        Assertions.assertEquals(2, 2 + Main.dray.getX());
        Assertions.assertEquals(2, Main.dray.getY());
    }

    @Test
    void testToString() {
        Main.dray.setNewCord(5,23);
        Assertions.assertEquals("5,00 23,00", Main.dray.toString());
    }
}