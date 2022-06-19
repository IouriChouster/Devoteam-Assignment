/**
 * @author Juri Chouster
 * Starts the entire application. Contains the main method.
 */
public class Application {

    private final View view;
    private Robot robot;

    /**
     * Creates a new instance for the view interface.
     */
    public Application() {
        view = new View();
    }

    private void startApplication() {
        Room room = createRoom();
        Position startPosition = getStartPosition(room);
        robot = new Robot(room, startPosition);
        run();
    }

    private Room createRoom() {
        while (true) {
            try {
                return view.inputRoom();
            } catch (IllegalArgumentException ex) {
                view.logError(ex.getMessage());
            }
        }
    }

    private Position getStartPosition(Room room) {
        while (true) {
            try {
                Position position = view.inputPosition();
                if (!room.isInside(position.getX(), position.getY())) {
                    view.logError("Starting position is not inside the room");
                    continue;
                }
                return position;
            } catch (IllegalArgumentException ex) {
                view.logError(ex.getMessage());

            }
        }
    }

    private void run() {
        while (true) {
            try {
                CommandList commandList = view.inputCommand();
                robot.runCommands(commandList);
                view.reportPosition(robot.getState());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    /**
     * This main method is used to start the application.
     *
     * @param args This application does not take any command line parameters.
     */
    public static void main(String[] args) {
        Application myApp = new Application();
        myApp.startApplication();
    }

}
