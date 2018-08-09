package mobi.cangol;

import java.util.Scanner;

public class Explore {

    public static void main(String[] args) {


        Controller controller = new Controller();
        try {
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
