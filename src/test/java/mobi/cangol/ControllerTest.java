package mobi.cangol;

import org.junit.Test;

public class ControllerTest {
    @Test(expected = IllegalArgumentException.class)
    public void testInitPlateau() {
        Controller controller = new Controller();
        controller.initPlateau("");
        controller.initPlateau(null);
        controller.initPlateau("11");
        controller.initPlateau("11 11 11");
        controller.initPlateau("12ads");
        controller.initPlateau("5 af");
        controller.initPlateau("ad 2");
        controller.initPlateau("6 6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRover() {
        Controller controller = new Controller();
        controller.addRover("4 4 E", null);
        controller.addRover(null, "LMLMLMLMRR");
    }

    @Test
    public void testStartExplore() {
        Controller controller = new Controller();
        controller.initPlateau("5 5");
        controller.addRover("1 2 N","LMLMLMLMM");
        controller.startExplore();
    }
}
