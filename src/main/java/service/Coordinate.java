package service;

import entity.MarsCar;

import java.util.List;
import java.util.Scanner;

public class Coordinate{
    public static void run(int x, int y, String fx, List<MarsCar> carList, Scanner sc){
        MarsCar car = new MarsCar(x,y,fx);
        if(car.inspect()){
            String str = sc.next();
            if(str!=null && str.length()>0){
                boolean isSuccess = true;//标记若是命令错误则提示重输递归
                for(int i=0; i<str.length(); i++){
                    if("M".equals(String.valueOf(str.charAt(i)))){
                        car.move();
                    } else if("L".equals(String.valueOf(str.charAt(i)))){
                        car.gotoLeft();
                    } else if("R".equals(String.valueOf(str.charAt(i)))){
                        car.gotoRight();
                    } else {
                        System.out.println("命令输入错误，请重新输入！");
                        isSuccess = false;
                        break;
                    }
                }
                if(isSuccess){
                    carList.add(car);
                } else {
                    Coordinate.run(x, y, fx, carList, sc);
                }
            }
        } else {
            System.out.println("坐标输入错误，请重新输入！");
        }
    }

}
