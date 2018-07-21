package nasa.mars.rovers;

import java.util.Scanner;

/**
 * 对漫游者探测器输入操作指令的控制台
 * Created by lin on 2018/7/21.
 */
public class RoverConsole {

    public static void main(String[] args) {

        scan = new Scanner(System.in); // 获取控制台输入

        // 初始化探索的目的地
        Plateau plateau = new Plateau();

        // 漫游者一号执行任务
        Rover rover1 = new Rover(plateau);
        rover1.execute();

        // 漫游者二号执行任务
        Rover rover2 = new Rover(plateau);
        rover2.execute();

        scan.close();

        System.out.println("---------------output-------------------");
        System.out.println(rover1);
        System.out.println(rover2);
    }

    static Scanner scan;

}
