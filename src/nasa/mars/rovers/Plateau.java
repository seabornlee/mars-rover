package nasa.mars.rovers;

/**
 * 矩形火星地表高地，漫游者机器人的探测目标
 * Created by lin on 2018/7/21.
 */
public class Plateau {

    // 私有化构造方法
    public Plateau() {

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
