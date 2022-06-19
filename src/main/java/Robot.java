/**
 * @author Juri Chouster
 * Represents a robot.
 */
public class Robot {

    private final Room room;
    private Position position;

    /**
     * Creates an instance of a robot.
     *
     * @param room             The room that the robot is in.
     * @param startingPosition The initial position of a robot.
     */
    Robot(Room room, Position startingPosition) {
        this.room = room;
        this.position = startingPosition;
    }

    /**
     * Runs commands from the command list.
     *
     * @param commandList List of instructions.
     */
    public void runCommands(CommandList commandList) {
        for (var currentCommand : commandList) {
            execute(currentCommand);
        }
    }

    /**
     * Gets the state of the current position.
     *
     * @return The current position of the robot.
     */
    public Position getState() {
        return position;
    }

    private void execute(Command command) {
        switch (command) {
            case LEFT:
                turnLeft();
                break;
            case RIGHT:
                turnRight();
                break;
            case FORWARD:
                goForward();
                break;
            default:
                throw new UnsupportedOperationException("Illegal command");
        }
    }

    private void turnLeft() {
        position.setCardinalDirection(position.getCardinalDirection().turnLeft());
    }

    private void turnRight() {
        position.setCardinalDirection(position.getCardinalDirection().turnRight());
    }

    private void goForward() {
        Position newPosition = position.goForward();
        if (room.isInside(newPosition.getX(), newPosition.getY())) {
            position = newPosition;
        }
    }

}
