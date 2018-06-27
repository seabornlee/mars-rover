package com.flyingwillow.mars;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入右上点坐标(例：5 5):");
        String rt = scanner.nextLine();
        while (!rt.matches("\\d+\\s+\\d+")){
            System.out.println("请输入正确的坐标(空格分割的数字)，例： 5 5");
            rt = scanner.nextLine();
        }

        Plateau plateau = parsePlateau(rt);//解析边界

        System.out.println("火星车的位置及朝向(例：1 2 N):");

        String rover = scanner.nextLine();
        while (!rover.matches("\\d+\\s+\\d+\\s+[NSWE]")){
            System.out.println("请输入正确的位置及朝向，例：1 2 N");
            rover = scanner.nextLine();
        }

        Position position = parsePosition(rover,plateau);//解析位置

        System.out.println("输入指令序列(LRM):");
        String order = scanner.nextLine();

        while(!order.matches("[LlRrMm]+")){
            System.out.println("请输入正确的序列");
            order = scanner.nextLine();
        }

        //遍历
        char[] orders = order.toCharArray();
        for (char c : orders){
            Order o = Order.valueOf(String.valueOf(c).toUpperCase());
            switch (o){
                case L: position.left();break;
                case M: position.move();break;
                case R: position.right(); break;
            }
        }

        //打印结果

        System.out.println("结果：" + position);
    }

    public static Plateau parsePlateau(String rt){

        String[] data = rt.split(" ");
        int x = Integer.parseInt(data[0]);
        int y = Integer.parseInt(data[1]);

        return new Plateau(new Point(x,y));
    }

    public static Position parsePosition(String rover, Plateau plateau){

        String[] data = rover.split(" ");
        int x = Integer.parseInt(data[0]);
        int y = Integer.parseInt(data[1]);
        Face face = Face.valueOf(data[2]);

        return new Position(new Point(x,y),face, plateau);
    }
}
