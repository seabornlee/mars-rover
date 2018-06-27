package com.cyssxt.main;
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

        public Point(int x, int y,char face) {
            this.x = x;
            this.y = y;
            this.face = face;
            this.index = getDirIndex(face);
            this.currentIndex = this.index;
            this.currentFace = face;
        }

        public Point(String line){
            this(Integer.valueOf(line.split(" ")[0]),Integer.valueOf(line.split(" ")[1]),line.split(" ")[2].charAt(0));
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

        public void setY(int y) {
            this.y = y;
        }
        public char getFace() {
            return face;
        }

        public void setFace(char face) {
            this.face = face;
        }

        public char getCurrentFace() {
            return currentFace;
        }

        public void setCurrentFace(char currentFace) {
            this.currentFace = currentFace;
        }

        public int getCurrentIndex() {
            return currentIndex;
        }

        public void setCurrentIndex(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String toResult() {
            return this.getX()+" "+ this.getY()+" "+String.valueOf(direactions[this.currentIndex]);
        }

        /**
         * 执行命令
         * @param cmdStr
         */
        public void cmd(String cmdStr){
            Point point = this;
            String cmd = cmdStr.toUpperCase();
            for(int i=0;i<cmd.length();i++){
                char word = cmd.charAt(i);
                if('M'==word){
                    int index = point.getCurrentIndex();
                    switch (index){
                        case 0:
                            point.y = point.y+1;
                            break;
                        case 1:
                            point.x = point.x+1;
                            break;
                        case 2:
                            point.y = point.y-1;
                            break;
                        case 3:
                            point.x = point.x-1;
                            break;
                    }
                }else{
                    point.nextIndex(word);
                }
            }
        }
    }

    /**
     * 提供案例的测试用例
     */
    public static void testCase(){
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
        if(args.length==1){
            testCase();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        //第一次命令输入
        String result1 = calc(scanner);
        //第二次命令输入
        String result2 = calc(scanner);
        System.out.println(result1);
        System.out.println(result2);
//        Scanner scanner = new Scanner(System.in);
//        String text = scanner.next();
//        System.out.println(text);
//        String test1 = scanner.next();
//        System.out.println(test1);
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
        if(1>=10){
            System.out.println("异常终端");
            System.exit(0);
        }
        return point.toResult();
    }
}
