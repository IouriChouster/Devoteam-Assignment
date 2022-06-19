import java.util.Scanner;

/**
 * @author Juri Chouster
 * This class is a placeholder for the view interface.
 */
public class View {


    private final Scanner scanner;

    /**
     * Creates an instance of the view interface.
     */
    public View() {
        scanner = new Scanner(System.in);
        System.out.println("Robot programming (type 'exit' to finish)");
    }

    /**
     * Log error message.
     *
     * @param message The error message to be displayed to the user.
     */
    public void logError(String message) {
        System.out.println(message);
    }

    /**
     * Ask the user to input room width and depth and validate the parameters.
     * Generate exception in case validation fails.
     *
     * @return Instance of the specified room.
     */
    public Room inputRoom() {
        System.out.println("Input room width and depth");
        String room = getNextLine();
        return validateRoom(room);
    }

    /**
     * Ask the user to input starting position and validate it.
     * Generate exception in case validation fails.
     *
     * @return Instance of the specified position.
     */
    public Position inputPosition() {
        System.out.println("Input starting position");
        String startingPosition = getNextLine();
        return validatePosition(startingPosition);
    }

    /**
     * Ask the user to input commands and validate them.
     * Generate exception in case validation fails.
     *
     * @return List of commands.
     */
    public CommandList inputCommand() {
        System.out.println("Input command");
        String command = getNextLine();
        return validateCommand(command);
    }

    /**
     * Print out the position.
     *
     * @param position Position to be reported.
     */
    public void reportPosition(Position position) {
        System.out.println("Report: " + position.toString());
    }

    private Room validateRoom(String room) {
        String[] roomValues = room.split(" ");
        int roomWidth;
        int roomDepth;
        if (roomValues.length < 2) {
            throw new IllegalArgumentException("Must be two values");
        }
        try {
            roomWidth = Integer.parseInt(roomValues[0]);
            roomDepth = Integer.parseInt(roomValues[1]);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Room property: NumberFormatException " + ex.getMessage());
        }

        return new Room(roomWidth, roomDepth);
    }

    private Position validatePosition(String position) {
        String cardinalDirectionSet = "NWSE";
        int x;
        int y;
        char orientation;
        String[] positionValues = position.split(" ");
        if (positionValues.length < 3) {
            throw new IllegalArgumentException("Must be three values");
        }
        try {
            x = Integer.parseInt(positionValues[0]);
            y = Integer.parseInt(positionValues[1]);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Starting position: NumberFormatException " + ex.getMessage());
        }
        if (positionValues[2].length() > 1) {
            throw new IllegalArgumentException("Cardinal direction must be one character");
        }
        orientation = positionValues[2].charAt(0);
        if (cardinalDirectionSet.indexOf(orientation) < 0) {
            throw new IllegalArgumentException("Illegal cardinal direction character:" + orientation);
        }

        return new Position(x, y, CardinalDirection.convertChar(orientation));
    }

    private CommandList validateCommand(String commandStr) {
        String commandSet = "LRF";
        CommandList commandList = new CommandList();
        for (var c : commandStr.toCharArray()) {
            if (commandSet.indexOf(c) < 0) {
                throw new IllegalArgumentException("Illegal command character:" + c);
            }
            commandList.add(Command.convertChar(c));
        }
        return commandList;
    }

    private String getNextLine() {
        String input = scanner.nextLine();
        if ("exit".equals(input)) {
            System.out.println("Application exited");
            System.exit(0);
        }

        return input;
    }

}
