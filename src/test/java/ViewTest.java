import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Juri Chouster
 * Tests for View class.
 * First repetition tests the input of correct input data.
 * Second repetition tests exceptions from illegal input data.
 */

class ViewTest {

    private static InputStream inCopy;
    private static int testIndex;
    private View view;
    private String roomInput = "5 5";
    private String positionInput = "1 2 N";
    private String commandInput = "RFRFFRFRF";

    private String roomFailedInput = "5 A";
    private String positionFailedInput = "1 A N";
    private String commandFailedInput = "RFRFFRFRA";


    @BeforeAll
    static void setUpClass() {
        inCopy = System.in;
        testIndex = 0;
    }

    @AfterAll
    static void restoreAll() {
        System.setIn(inCopy);
    }

    @BeforeEach
    void setUp() {
        String input;
        if (testIndex == 0)
            input = roomInput + "\n" + positionInput + "\n" + commandInput;
        else
            input = roomFailedInput + "\n" + positionFailedInput + "\n" + commandFailedInput;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); //Simulate user input with predetermined values.
        view = new View();
    }

    @AfterEach
    void tearDown() {
        testIndex++;
    }

    @RepeatedTest(2)
    void test() {
        if (testIndex == 0) {
            inputRoom();
            inputPosition();
            inputCommand();
        } else {
            inputFailedRoom();
            inputFailedPosition();
            inputFailedCommand();
        }
    }

    private void inputRoom() {
        Room room = view.inputRoom();
        assertEquals(room.toString(), roomInput);
    }

    private void inputFailedRoom() {

        try {
            view.inputRoom();
            fail("Room: no exception for wrong input");
        } catch (IllegalArgumentException ex) {
        }
    }

    private void inputPosition() {

        Position position = view.inputPosition();
        assertEquals(position.toString(), positionInput);
    }

    private void inputFailedPosition() {

        try {
            view.inputPosition();
            fail("Position: no exception for wrong input");
        } catch (IllegalArgumentException ex) {
        }
    }

    private void inputCommand() {
        CommandList commandList = view.inputCommand();
        assertEquals(commandList.toString(), commandInput);
    }

    private void inputFailedCommand() {

        try {
            view.inputCommand();
            fail("Command: no exception for wrong input");
        } catch (IllegalArgumentException ex) {
        }
    }
}