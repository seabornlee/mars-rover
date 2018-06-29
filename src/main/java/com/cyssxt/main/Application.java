package com.cyssxt.main;
import org.junit.Test;

import java.util.Scanner;
/**
 * Created by zqy on 2018/6/26.
 */
public class Application {
    /**
     * 通过数组下标映射实际方向
     */
    final static char[] direactions = {'N','E','S','W'};

    private static int getDirIndex(char cmd){
        for(int index=0;index<direactions.length;index++){
            char key = direactions[index];
            if(key==cmd){
                return index;
            }
        }
        return 0;
    }
    private static class Point{
        private int x;
        private int y;
        private int currentIndex;
        private int index;
        private char face;
        private char currentFace;

        public Point(String line){
            String[] words = line.split(" ");
            this.x = Integer.valueOf(words[0]);
            this.y = Integer.valueOf(words[1]);
            this.face = words[2].charAt(0);
            this.index = getDirIndex(this.face);
            this.currentFace = face;
            this.currentIndex = this.index;
        }

        public void nextIndex(char cmd){
            int index = 'L'==cmd ? this.currentIndex-1:this.currentIndex+1;
            if(index< 0){
                index = 3;
            }
            if(index>3){
                index = 0;
            }
            this.currentIndex = index;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getCurrentIndex() {
            return currentIndex;
        }

        public String toResult() {
            return this.getX()+" "+ this.getY()+" "+String.valueOf(direactions[this.currentIndex]);
        }

        /**
         * 执行命令
         * @param cmdStr
         */
        public void cmd(String cmdStr){
            String cmd = cmdStr.toUpperCase();
            for(int i=0;i<cmd.length();i++){
                char word = cmd.charAt(i);
                if('M'==word){
                    int index = this.getCurrentIndex();
                    this.y += (1-index)*((index+1)%2);
                    this.x += (2-index)*((index)%2);
                }else{
                    this.nextIndex(word);
                }
            }
        }
    }

    /**
     * 提供案例的测试用例
     */
    @Test
    public void testCase(){
        String[] pointStr = {
                "5 5",
                "1 2 N",
                "LMLMLMLMM",
                "3 3 E",
                "MMRMMRMRRM"};
        Point point = new Point(pointStr[1]);
        point.cmd(pointStr[2]);
        Point point1 = new Point(pointStr[3]);
        point1.cmd(pointStr[4]);
        System.out.println(point.toResult());
        System.out.println(point1.toResult());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String result1 = calc(scanner);
        String result2 = calc(scanner);
        System.out.println(result1);
        System.out.println(result2);
    }

    private static String calc(Scanner scanner) {
        String pointStr = scanner.nextLine();
        Point point = null;
        int i = 0;
        while(point==null&&i<10) {
            i++;
            try {
                point = new Point(pointStr);
                String cmdStr = scanner.nextLine();
                point.cmd(cmdStr);
            } catch (Exception e) {
                System.out.println("输入有误请重新输入");
            }
        }
        if(i>=10){
            System.out.println("异常终端");
            System.exit(0);
        }
        return point.toResult();
    }
}
