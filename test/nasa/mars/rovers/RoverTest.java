package nasa.mars.rovers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by lin on 2018/7/21.
 */
public class RoverTest {

    private Plateau plateau;
    private Rover rover;

    @Before
    public void before() throws Exception {
        // 初始化火星高地
        plateau = new Plateau(100, 50);
        // 初始化机器人
        rover = new Rover(plateau, 30, 40, Rover.Orientation.UP);
    }

    // 测试非法输入
    @Test
    public void testIllegalInstructions() throws Exception {
        rover.execute("SSS");
        assertArrayEquals(new int[]{30, 40}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.UP, rover.getOrientation());
    }

    // 移动一步
    @Test
    public void testNormalInstructions() throws Exception {
        rover.execute("M");
        assertArrayEquals(new int[]{30, 41}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.UP, rover.getOrientation());
    }

    // 转换方向
    @Test
    public void testTurnAround() throws Exception {
        rover.execute("MRM");
        assertArrayEquals(new int[]{31, 41}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.RIGHT, rover.getOrientation());
    }

    // 多个指令连续执行
    @Test
    public void testMultiInstructions() throws Exception {
        rover.execute("MMRMMRMRRM");
        rover.execute("LMLMLMLMM");
        assertArrayEquals(new int[]{32, 43}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.UP, rover.getOrientation());
    }

    // 超出边界
    @Test
    public void testOutOfRange() throws Exception {
        rover.execute("MMMMMMMMMMMMMMM");
        assertArrayEquals(new int[]{30, plateau.getWidth()}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.UP, rover.getOrientation());
    }

}