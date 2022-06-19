import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Juri Chouster
 * Tests for Position class.
 */
class PositionTest {

    Position position;

    @BeforeEach
    void setUp() {
        position = new Position(1, 2, CardinalDirection.EAST);
    }

    @Test
    void testToString() {
        assertEquals(position.toString(), "1 2 E");
    }

    @Test
    void goForward() {
        Position newPosition = position.goForward();
        assertEquals(newPosition.toString(), "2 2 E");
    }
}