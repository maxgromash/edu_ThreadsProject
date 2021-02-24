import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void parseInput() {
        String[] args = { "23", "12"};
        Main.parseInput(args);
        Assertions.assertEquals(23, Main.dray.getX());
        Assertions.assertEquals(12, Main.dray.getY());
        Main.dray.setNewCord(0, 0);

        String[] args1 = { "22"};
        Main.parseInput(args1);
        Assertions.assertEquals(22, Main.dray.getX());
        Assertions.assertEquals(0, Main.dray.getY());
        Main.dray.setNewCord(0, 0);

        String[] args2 = { "fgsdf", "22", "sfgfs"};
        Main.parseInput(args2);
        Assertions.assertEquals(0, Main.dray.getX());
        Assertions.assertEquals(22, Main.dray.getY());
        Main.dray.setNewCord (0, 0);

        String[] args3 = { "10", "fgsdf", "40"};
        Main.parseInput(args3);
        Assertions.assertEquals(10, Main.dray.getX());
        Assertions.assertEquals(0, Main.dray.getY());
    }

    @Test
    void randSleepTime() {
        for (int i=0; i<1000; i++){
            double x = Main.randSleepTime();
            assertTrue(x >= 1000);
            assertTrue(x < 5000);
        }
    }

    @Test
    void randPullTime() {
        for (int i=0; i<1000; i++){
            double x = Main.randPullTime();
            assertTrue(x >= 1);
            assertTrue(x < 10);
        }
    }
}