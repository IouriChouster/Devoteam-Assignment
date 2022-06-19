import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Juri Chouster
 * Tests for Room class.
 */
class RoomTest {

    private Room room;

    @BeforeEach
    void setUp() {
        room=new Room(7,7);
    }

    @Test
    void isInside() {
        assertTrue(room.isInside(6,6));
        assertFalse(room.isInside(7,7));
    }

    @Test
    void testToString() {
         assertEquals(room.toString(),"7 7");
    }
}