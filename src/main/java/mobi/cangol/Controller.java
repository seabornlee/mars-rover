package mobi.cangol;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Plateau plateau;
    private final List<Rover> rovers;
    private final List<String> commands;

    protected Controller() {
        rovers = new ArrayList<>();
        commands = new ArrayList<>();
    }

    public Plateau initPlateau(String command) {
        this.plateau = Plateau.initInstance(command);
        return this.plateau;
    }

    public Rover addRover(String landCommand, String exploreCommand) {
        Rover rover = Rover.land(landCommand);
        rovers.add(rover);
        commands.add(exploreCommand);
        return rover;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public void startExplore() {
        Rover rover;
        for (int i = 0; i < rovers.size(); i++) {
            rover = rovers.get(i);
            rover.explore(plateau, commands.get(i));
        }
    }
}
