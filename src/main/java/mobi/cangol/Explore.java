package mobi.cangol;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Explore {
    private static final Logger LOG = Logger.getLogger("Explore");

    public static void main(String[] args) {

        Controller controller = new Controller();
        try {
            controller.initPlateau(inputConsole());
            controller.addRover(inputConsole(), inputConsole());
            controller.addRover(inputConsole(), inputConsole());
            controller.startExplore();
            Rover rover;
            for (int i = 0; i < controller.getRovers().size(); i++) {
                rover = controller.getRovers().get(i);
                LOG.log(Level.INFO, rover.getStatusString());
            }
        } catch (IllegalArgumentException e) {
            LOG.log(Level.INFO, e.getMessage());
        }

    }

    private static String inputConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
