import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Juri Chouster
 * Tests for Command.
 */
class CommandTest {
    Command command;

    @BeforeEach
    void setUp() {
        command= Command.FORWARD;
    }

    @Test
    void testToString() {
        assertEquals(command.toString(), "F");
    }

    @Test
    void convertChar() {
        assertEquals(Command.convertChar('F'), Command.FORWARD);
        assertEquals(Command.convertChar('L'), Command.LEFT);
        assertEquals(Command.convertChar('R'), Command.RIGHT);
    }
}