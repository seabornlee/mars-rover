package mobi.cangol;

import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test(expected = IllegalArgumentException.class)
    public void testGetPosition() {
        Assert.assertNotNull(Rover.land(null).getPosition());
        Assert.assertNotNull(Rover.land("").getPosition());
        Assert.assertNotNull(Rover.land(" ").getPosition());
        Assert.assertNotNull(Rover.land("12").getPosition());
        Assert.assertNotNull(Rover.land("1 2").getPosition());
        Assert.assertNotNull(Rover.land("1 2 ").getPosition());
        Assert.assertNotNull(Rover.land("a b N").getPosition());
        Assert.assertNotNull(Rover.land("a b c").getPosition());
        Assert.assertNotNull(Rover.land("1 1 F").getPosition());
        Assert.assertNotNull(Rover.land("1 1 N").getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetStatusString() {
        Assert.assertNotNull(Rover.land(null).getStatusString());
        Assert.assertNotNull(Rover.land("").getStatusString());
        Assert.assertNotNull(Rover.land(" ").getStatusString());
        Assert.assertNotNull(Rover.land("12").getStatusString());
        Assert.assertNotNull(Rover.land("1 2").getStatusString());
        Assert.assertNotNull(Rover.land("1 2 ").getStatusString());
        Assert.assertNotNull(Rover.land("a b N").getStatusString());
        Assert.assertNotNull(Rover.land("a b c").getStatusString());
        Assert.assertNotNull(Rover.land("1 1 F").getStatusString());
        Assert.assertNotNull(Rover.land("1 1 N").getStatusString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLand() {
        Assert.assertNotNull(Rover.land(null));
        Assert.assertNotNull(Rover.land(""));
        Assert.assertNotNull(Rover.land(" "));
        Assert.assertNotNull(Rover.land("12"));
        Assert.assertNotNull(Rover.land("1 2"));
        Assert.assertNotNull(Rover.land("1 2 "));
        Assert.assertNotNull(Rover.land("a b N"));
        Assert.assertNotNull(Rover.land("a b c"));
        Assert.assertNotNull(Rover.land("1 1 F"));
        Assert.assertNotNull(Rover.land("1 1 N"));
    }

    @Test
    public void testExplore() {
        Rover rover = Rover.land("1 2 N");
        Plateau plateau = Plateau.initInstance("5 5");
        Assert.assertNotNull(rover);
        Assert.assertNotNull(plateau);

        try {
            rover.explore(null, null);
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
        }

        try {
            rover.explore(plateau, null);
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
        }

        try {
            rover.explore(plateau, "11");
            Assert.assertEquals("1 2 N", rover.getStatusString());
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
        }

        try {
            rover.explore(plateau, "asfa");
            Assert.assertEquals("1 2 N", rover.getStatusString());
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
        }

        try {
            rover.explore(plateau, "LMRdfa");
            Assert.assertEquals("1 2 N", rover.getStatusString());
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
        }

        Assert.assertEquals("1 2 N", rover.getStatusString());
        rover.explore(plateau, "LML");
        Assert.assertEquals("0 2 S", rover.getStatusString());
        rover.explore(plateau, "MLM");
        Assert.assertEquals("1 1 E", rover.getStatusString());
        rover.explore(plateau, "LMM");
        Assert.assertEquals("1 3 N", rover.getStatusString());
    }
}
