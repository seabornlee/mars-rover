package mobi.cangol;

import org.junit.Assert;
import org.junit.Test;

public class ControllerTest {
    @Test(expected = IllegalArgumentException.class)
    public void testInitPlateau() {
        Controller controller = new Controller();
        Assert.assertNotNull(controller.initPlateau(""));
        Assert.assertNotNull(controller.initPlateau(null));
        Assert.assertNotNull(controller.initPlateau("11"));
        Assert.assertNotNull(controller.initPlateau("11 11 11"));
        Assert.assertNotNull(controller.initPlateau("12ads"));
        Assert.assertNotNull(controller.initPlateau("5 af"));
        Assert.assertNotNull(controller.initPlateau("ad 2"));
        Assert.assertNotNull(controller.initPlateau("6 6"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRover() {
        Controller controller = new Controller();
        Assert.assertNotNull(controller.addRover("4 4 E", null));
        Assert.assertNotNull(controller.addRover(null, "LMLMLMLMRR"));
    }

    @Test
    public void testStartExplore() {
        Controller controller = new Controller();
        Assert.assertNotNull(controller.initPlateau("5 5"));
        Assert.assertNotNull(controller.addRover("1 2 N", "LMLMLMLMM"));
        controller.startExplore();
        Assert.assertEquals("1 3 N", controller.getRovers().get(0).getStatusString());
    }

    @Test
    public void testGetRovers() {
        Controller controller = new Controller();
        Assert.assertNotNull(controller.getRovers());
    }
}
