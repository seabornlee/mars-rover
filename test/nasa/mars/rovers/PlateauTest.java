package nasa.mars.rovers;

import static org.junit.Assert.*;

/**
 * Created by lin on 2018/7/21.
 */
public class PlateauTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    /**
     * 测试Plateau的初始化
     * @throws Exception
     */
    @org.junit.Test
    public void getPlateau() throws Exception {
        Plateau plateau = new Plateau(5, 6);
        assertNotNull(plateau);
        assertEquals(5, plateau.getLength().longValue());
        assertEquals(6, plateau.getWidth().longValue());
    }

}