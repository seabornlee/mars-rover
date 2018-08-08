package mobi.cangol;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Plateau plateau;
    private List<Rover> rovers;
    private List<String> commands;

    public Controller() {
        rovers = new ArrayList<>();
        commands = new ArrayList<>();
    }

    public void initPlateau(String command) {
        this.plateau = Plateau.initInstance(command);
    }

    public Rover addRover(String landCommand, String exploreCommand) {
        Rover rover = Rover.land(landCommand);
        rovers.add(rover);
        commands.add(exploreCommand);
        return rover;
    }


    public void startExplore() {
        Rover rover = null;
        for (int i = 0; i < rovers.size(); i++) {
            rover = rovers.get(i);
            rover.explore(plateau, commands.get(i));
        }
    }
}
