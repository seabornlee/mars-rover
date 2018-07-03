import entity.MarsCar;
import org.junit.Test;
import service.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MarsCar> carList = new ArrayList<MarsCar>();
        System.out.println("请输入平台右上角坐标");
        MarsCar.Max_x = sc.nextInt();
        MarsCar.Max_y = sc.nextInt();
        System.out.println("命令输入完毕后请输入 EXIT 退出");
        while(!sc.hasNext("EXIT")){
            int x = sc.nextInt();
            int y = sc.nextInt();
            String fx = sc.next();
            Coordinate.run(x, y, fx, carList, sc);
        }
        if(carList!=null && carList.size()>0){
            MarsCar car = null;
            for(int i=0; i<carList.size(); i++){//输出每辆车的坐标
                car = carList.get(i);
                System.out.println(car.getX()+" "+car.getY()+" "+car.getFx());
            }
        } else {
            System.out.println("暂无车辆坐标信息！");
        }
        sc.close();
        carList.clear();
    }
}
