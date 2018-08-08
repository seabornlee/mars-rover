package mobi.cangol;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Explore {

    public static void main(String[] args) {

        Controller controller = new Controller();
        try {
//            controller.initPlateau("5 5");
//            controller.addRover("1 2 N", "LMLMLMLMM");
//            controller.addRover( "3 3 E", "MMRMMRMRRM");
//            controller.startExplore();

            controller.initPlateau(inputConsole());
            controller.addRover(inputConsole(), inputConsole());
            controller.addRover(inputConsole(), inputConsole());
            controller.startExplore();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inputConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
