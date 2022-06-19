/**
 * @author Juri Chouster
 * Represents a room.
 */
public class Room {

    private final int width;
    private final int depth;

    /**
     * Creates an instance of a room.
     *
     * @param width The width of the room.
     * @param depth The depth of the room.
     */
    public Room(int width, int depth) {
        this.width = width;
        this.depth = depth;
    }

    /**
     * Validates if an object is inside the room.
     *
     * @param currentX The x coordinate of the object.
     * @param currentY The y coordinate of the object.
     * @return True if the room contains the object.
     */
    public boolean isInside(int currentX, int currentY) {
        return !(currentX < 0 || currentY < 0 || currentX >= width || currentY >= depth);
    }

    @Override
    public String toString() {
        return width + " " + depth;
    }

}
