package mobi.cangol;

import java.util.regex.Pattern;

public class Rover {
    private static final char COMMAND_L='L';
    private static final char COMMAND_R='R';
    private static final char COMMAND_M='M';
    private int x;
    private int y;
    private Direction direction;
    private boolean running;
    private Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int[] getPosition() {
        return new int[]{x,y};
    }

    public String getStatusString() {
        return String.format("%s %s %s", x, y, direction);
    }

    private int[] preMove() {
        int preX=this.x;
        int preY=this.y;
        switch (direction) {
            case N:
                preY = preY + 1;
                break;
            case S:
                preY = preY - 1;
                break;
            case E:
                preX= preX+ 1;
                break;
            case W:
                preX = preX - 1;
                break;
            default:
                break;
        }
        return new int[]{preX,preY};
    }

    private void move() {
        switch (direction) {
            case N:
                this.y = this.y + 1;
                break;
            case S:
                this.y = this.y - 1;
                break;
            case E:
                this.x = this.x + 1;
                break;
            case W:
                this.x = this.x - 1;
                break;
            default:
                break;
        }
    }
    private void turnLeft() {
        switch (direction) {
            case N:
                this.direction =Direction.W;
                break;
            case S:
                this.direction =Direction.E;
                break;
            case E:
                this.direction =Direction.N;
                break;
            case W:
                this.direction =Direction.S;
                break;
            default:
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case N:
                this.direction =Direction.E;
                break;
            case S:
                this.direction =Direction.W;
                break;
            case E:
                this.direction =Direction.S;
                break;
            case W:
                this.direction =Direction.N;
                break;
            default:
                break;
        }
    }

    public void start() {
        this.running=true;
    }

    public void stop() {
        this.running=false;
        System.out.println(this.getStatusString());
    }


    public static Rover land(String command) {
        if(command==null||"".equals(command)||command.isEmpty()){
            throw  new IllegalArgumentException("error command!");
        }
        String[] array=command.split(" ");
        if(array.length!=3){
            throw  new IllegalArgumentException("error command!");
        }else{
            int x=0;
            int y=0;
            Direction direction = null;
            Rover rover=null;
            try {
                x=Integer.valueOf(array[0]);
            }catch (IllegalArgumentException e){
                throw  new IllegalArgumentException("error command! x{"+array[0]+"} is Invalid");
            }
            try {
                y=Integer.valueOf(array[1]);
            }catch (IllegalArgumentException e){
                throw  new IllegalArgumentException("error command! y{"+array[1]+"} is Invalid");
            }
            try {
                direction=Direction.valueOf(array[2]);
            }catch (IllegalArgumentException e){
                throw  new IllegalArgumentException("error command! Direction{"+array[2]+"} is Invalid");
            }

            rover=new Rover(x,y,direction);
            return  rover;
        }
    }

    public void explore(Plateau plateau, String command){
        if(command==null||"".equals(command)||command.isEmpty()){
            throw  new IllegalArgumentException("error command!");
        }
        if(!Pattern.compile("[L|R|M]+?").matcher(command).matches()){
            throw  new IllegalArgumentException("error command!");
        }
        this.start();
        for (int i = 0; i < command.length(); i++) {
            //StringBuilder sb=new StringBuilder();
            //sb.append(this.getStatusString());
            //sb.append("<"+command.charAt(i)+">");
            switch (command.charAt(i)){
                case COMMAND_L:
                    this.turnLeft();
                    break;
                case COMMAND_R:
                    this.turnRight();
                    break;
                case COMMAND_M:
                    synchronized (plateau){
                        if(plateau.isReachable(this.preMove())){
                            plateau.setReachable(this.getPosition(),true);
                            this.move();
                            plateau.setReachable(this.getPosition(),false);
                        }
                    }
                    break;
                default:
                    break;
            }
            //sb.append(this.getStatusString());
            //System.out.println(sb.toString());
        }
        this.stop();
    }
}
