package nasa.mars.rovers;

import java.util.Scanner;
import java.util.regex.Pattern;

import static nasa.mars.rovers.RoverConsole.scan;

/**
 * 矩形火星地表高地，漫游者机器人的探测目标
 * Created by lin on 2018/7/21.
 */
public class Plateau {

    // 私有化构造方法
    public Plateau() {
        System.out.println("please input the upper-right coordinates of the plateau:");
        while (true) {
            /*
             * 校验输入的右上角坐标是否合法
             */
            String coordinates = scan.nextLine();
            if (null == coordinates || !Pattern.matches("^\\d+\\s\\d+$", coordinates)) {
                System.err.println("invalid parameters, plase retry again:");
                continue;
            }
            /*
             * 保存输入的坐标
             */
            String[] coordinatesArray = coordinates.split(" ");
            this.length = Integer.valueOf(coordinatesArray[0]);
            this.width = Integer.valueOf(coordinatesArray[1]);
            break;
        }
    }

    public Plateau(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    // 长度
    private Integer length;

    // 宽度
    private Integer width;

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return this.length;
    }

    public Integer getWidth() {
        return this.width;
    }
}
