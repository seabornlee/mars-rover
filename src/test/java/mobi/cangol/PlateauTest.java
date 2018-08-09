package mobi.cangol;

import org.junit.Assert;
import org.junit.Test;


public class PlateauTest {

    @Test(expected = IllegalArgumentException.class)
    public void testLand(){

        Assert.assertNotNull(Plateau.initInstance(""));
        Assert.assertNotNull(Plateau.initInstance(null));
        Assert.assertNotNull(Plateau.initInstance("11"));
        Assert.assertNotNull(Plateau.initInstance("11 11 11"));
        Assert.assertNotNull(Plateau.initInstance("12ads"));
        Assert.assertNotNull(Plateau.initInstance("5 af"));
        Assert.assertNotNull(Plateau.initInstance("ad 2"));
    }

    @Test
    public void testIsReachable() {
        Plateau plateau=Plateau.initInstance("6 6");
        Assert.assertNotNull(plateau);
        Assert.assertTrue(plateau.isReachable(new int[]{0,0}));
        Assert.assertTrue(plateau.isReachable(new int[]{6,6}));
        Assert.assertTrue(plateau.isReachable(new int[]{2,2}));
        Assert.assertFalse(plateau.isReachable(new int[]{-1,0}));
        Assert.assertFalse(plateau.isReachable(new int[]{0,-1}));
        Assert.assertFalse(plateau.isReachable(new int[]{6,7}));
        Assert.assertFalse(plateau.isReachable(new int[]{7,6}));
        Assert.assertFalse(plateau.isReachable(new int[]{7,7}));

    }

    @Test
    public void testSetReachable() {
        Plateau plateau=Plateau.initInstance("6 6");
        Assert.assertNotNull(plateau);

        Assert.assertTrue(plateau.setReachable(new int[]{0,0},false));
        Assert.assertTrue(plateau.setReachable(new int[]{6,6},false));
        Assert.assertTrue(plateau.setReachable(new int[]{2,2},false));
        Assert.assertFalse(plateau.setReachable(new int[]{-1,0},false));
        Assert.assertFalse(plateau.setReachable(new int[]{0,-1},false));
        Assert.assertFalse(plateau.setReachable(new int[]{6,7},false));
        Assert.assertFalse(plateau.setReachable(new int[]{7,6},false));
        Assert.assertFalse(plateau.setReachable(new int[]{7,7},false));

        Assert.assertTrue(plateau.setReachable(new int[]{0,0},true));
        Assert.assertTrue(plateau.setReachable(new int[]{6,6},true));
        Assert.assertTrue(plateau.setReachable(new int[]{2,2},true));
        Assert.assertFalse(plateau.setReachable(new int[]{-1,0},true));
        Assert.assertFalse(plateau.setReachable(new int[]{0,-1},true));
        Assert.assertFalse(plateau.setReachable(new int[]{6,7},true));
        Assert.assertFalse(plateau.setReachable(new int[]{7,6},true));
        Assert.assertFalse(plateau.setReachable(new int[]{7,7},true));

        Assert.assertTrue(plateau.setReachable(new int[]{0,0},true)==plateau.isReachable(new int[]{0,0}));
        Assert.assertTrue(plateau.setReachable(new int[]{6,6},true)==plateau.isReachable(new int[]{6,6}));
        Assert.assertTrue(plateau.setReachable(new int[]{2,2},true)==plateau.isReachable(new int[]{2,2}));
        Assert.assertTrue(plateau.setReachable(new int[]{-1,0},true)==plateau.isReachable(new int[]{-1,0}));
        Assert.assertTrue(plateau.setReachable(new int[]{0,-1},true)==plateau.isReachable(new int[]{0,-1}));
        Assert.assertTrue(plateau.setReachable(new int[]{6,7},true)==plateau.isReachable(new int[]{6,7}));
        Assert.assertTrue(plateau.setReachable(new int[]{7,6},true)==plateau.isReachable(new int[]{7,6}));
        Assert.assertTrue(plateau.setReachable(new int[]{7,7},true)==plateau.isReachable(new int[]{7,7}));

        Assert.assertTrue(plateau.setReachable(new int[]{0,0},false)==!plateau.isReachable(new int[]{0,0}));
        Assert.assertTrue(plateau.setReachable(new int[]{6,6},false)==!plateau.isReachable(new int[]{6,6}));
        Assert.assertTrue(plateau.setReachable(new int[]{2,2},false)==!plateau.isReachable(new int[]{2,2}));
        Assert.assertTrue(plateau.setReachable(new int[]{-1,0},false)==plateau.isReachable(new int[]{-1,0}));
        Assert.assertTrue(plateau.setReachable(new int[]{0,-1},false)==plateau.isReachable(new int[]{0,-1}));
        Assert.assertTrue(plateau.setReachable(new int[]{6,7},false)==plateau.isReachable(new int[]{6,7}));
        Assert.assertTrue(plateau.setReachable(new int[]{7,6},false)==plateau.isReachable(new int[]{7,6}));
        Assert.assertTrue(plateau.setReachable(new int[]{7,7},false)==plateau.isReachable(new int[]{7,7}));
    }
}
