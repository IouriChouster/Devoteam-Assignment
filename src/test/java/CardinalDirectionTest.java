import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Juri Chouster
 * Tests for CardinalDirection.
 */

class CardinalDirectionTest {

    CardinalDirection cardinalDirection;

    @Test
    void convertChar() {
        assertEquals(CardinalDirection.convertChar('W'), CardinalDirection.WEST);
    }

    @Test
    void testToString() {
        cardinalDirection=CardinalDirection.EAST;
        assertEquals(cardinalDirection.toString(), "E");
    }

    @Test
    void turnRight() {
        cardinalDirection=CardinalDirection.EAST;
        assertEquals(cardinalDirection.turnRight(), CardinalDirection.SOUTH);
    }

    @Test
    void turnLeft() {
        cardinalDirection=CardinalDirection.EAST;
        assertEquals(cardinalDirection.turnLeft(), CardinalDirection.NORTH);
    }
}