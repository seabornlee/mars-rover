package mobi.cangol;

import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test(expected = IllegalArgumentException.class)
    public void testGetPosition() {
        Rover.land(null).getPosition();
        Rover.land("").getPosition();
        Rover.land(" ").getPosition();
        Rover.land("12").getPosition();
        Rover.land("1 2").getPosition();
        Rover.land("1 2 ").getPosition();
        Rover.land("a b N").getPosition();
        Rover.land("a b c").getPosition();
        Rover.land("1 1 F").getPosition();
        Rover.land("1 1 N").getPosition();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetStatusString() {
        Rover.land(null).getStatusString();
        Rover.land("").getStatusString();
        Rover.land(" ").getStatusString();
        Rover.land("12").getStatusString();
        Rover.land("1 2").getStatusString();
        Rover.land("1 2 ").getStatusString();
        Rover.land("a b N").getStatusString();
        Rover.land("a b c").getStatusString();
        Rover.land("1 1 F").getStatusString();
        Rover.land("1 1 N").getStatusString();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLand() {
        Rover.land(null);
        Rover.land("");
        Rover.land(" ");
        Rover.land("12");
        Rover.land("1 2");
        Rover.land("1 2 ");
        Rover.land("a b N");
        Rover.land("a b c");
        Rover.land("1 1 F");
        Rover.land("1 1 N");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExplore() {
        Rover rover = Rover.land("1 1 N");
        Plateau plateau = Plateau.initInstance("6 6");
        Assert.assertNotNull(rover);
        Assert.assertNotNull(plateau);

        rover.explore(null, null);
        rover.explore(plateau, null);
        rover.explore(null, "");
        rover.explore(plateau, "11");
        rover.explore(plateau, "asfa");
        rover.explore(plateau, "LMRdfa");
        rover.explore(plateau, "faLMR");
        rover.explore(plateau, "LMR");
        rover.explore(plateau, "MLR");
        rover.explore(plateau, "MMMRRRRL");
    }
}
