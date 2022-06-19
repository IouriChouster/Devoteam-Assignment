import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Juri Chouster
 * Tests for Robot class.
 * Includes validating the final result through three repetitions:
 * The first two are from the assignment instructions. The unit test validates that the results are correct.
 * The third one confirms a failed result.
 */
class RobotTest {

    private int[] roomWidth = {5, 5, 5};
    private int[] roomDepth = {5, 5, 5};
    private int[] x = {1, 0, 0};
    private int[] y = {2, 0, 0};
    private char[] orientation = {'N', 'E', 'E'};
    private String[] command = {"RFRFFRFRF", "RFLFFLRF", "RFLFFLRF"};
    private String[] result = {"1 3 N", "3 1 E", "3 2 E"};
    private static int testIndex;
    private Position currentPosition;

    @BeforeAll
    static void setUpClass() {
        testIndex = 0;
    }

    @BeforeEach
    void setUp() {
        Room room = new Room(roomWidth[testIndex], roomDepth[testIndex]);
        Position position = new Position(x[testIndex], y[testIndex], CardinalDirection.convertChar(orientation[testIndex]));
        Robot robot = new Robot(room, position);
        CommandList cmd = new CommandList();
        for (var currentCommand : command[testIndex].toCharArray()) {
            cmd.add(Command.convertChar(currentCommand));
        }
        robot.runCommands(cmd);
        currentPosition = robot.getState();
    }

    @AfterEach
    void tearDown() {
        testIndex++;
    }

    @RepeatedTest(3)
    void test() {
        if (testIndex < 2)
            assertEquals(currentPosition.toString(), result[testIndex]);
        else
            assertNotEquals(currentPosition.toString(), result[testIndex]);
    }

}