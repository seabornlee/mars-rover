package nasa.mars.rovers;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

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

    @Test
    public void move() throws Exception {

        // 测试非法输入
        RoverConsole.scan = new Scanner(new ByteArrayInputStream("SSS".getBytes()));
        rover.execute();
        assertArrayEquals(new int[]{30, 40}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.UP, rover.getOrientation());

        // 移动一步
        RoverConsole.scan = new Scanner(new ByteArrayInputStream("M".getBytes()));
        rover.execute();
        assertArrayEquals(new int[]{30, 41}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.UP, rover.getOrientation());

        // 转换方向
        RoverConsole.scan = new Scanner(new ByteArrayInputStream("LL".getBytes()));
        rover.execute();
        assertArrayEquals(new int[]{30, 41}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.DOWN, rover.getOrientation());

        // 多个指令连续执行
        RoverConsole.scan = new Scanner(new ByteArrayInputStream("MMRMMRMRRM".getBytes()));
        rover.execute();
        assertArrayEquals(new int[]{28, 39}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.DOWN, rover.getOrientation());

        // 超出边界
        RoverConsole.scan = new Scanner(new ByteArrayInputStream("RRMMMMMMMMMMMMMMM".getBytes()));
        rover.execute();
        assertArrayEquals(new int[]{28, plateau.getWidth()}, new int[]{rover.getX(), rover.getY()});
        assertEquals(Rover.Orientation.UP, rover.getOrientation());

        System.setIn(System.in);
    }

}