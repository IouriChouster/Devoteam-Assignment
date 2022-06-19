/**
 * @author Juri Chouster
 * Represents the four cardinal directions.
 */
public enum CardinalDirection {
    NORTH('N'), SOUTH('S'), WEST('W'), EAST('E');

    private final char value;

    CardinalDirection(char value) {
        this.value = value;
    }

    /**
     * Converts from char to enum representation.
     *
     * @param direction The specified cardinal direction in char format.
     * @return The enum representation of the cardinal direction.
     */
    public static CardinalDirection convertChar(char direction) {
        switch (direction) {
            case 'N':
                return NORTH;
            case 'W':
                return WEST;
            case 'S':
                return SOUTH;
            case 'E':
                return EAST;
            default:
                throw new UnsupportedOperationException("Illegal cardinal direction");
        }
    }

    @Override
    public String toString() {
        return "" + value;
    }

    /**
     * Change state of current direction to the right.
     *
     * @return The new direction.
     */
    public CardinalDirection turnRight() {
        switch (this) {
            case NORTH:
                return CardinalDirection.EAST;
            case WEST:
                return CardinalDirection.NORTH;
            case SOUTH:
                return CardinalDirection.WEST;
            case EAST:
                return CardinalDirection.SOUTH;
            default:
                throw new UnsupportedOperationException("Illegal cardinal direction");
        }
    }

    /**
     * Change state of current direction to the left.
     *
     * @return The new direction.
     */
    public CardinalDirection turnLeft() {
        switch (this) {
            case NORTH:
                return CardinalDirection.WEST;
            case WEST:
                return CardinalDirection.SOUTH;
            case SOUTH:
                return CardinalDirection.EAST;
            case EAST:
                return CardinalDirection.NORTH;
            default:
                throw new UnsupportedOperationException("Illegal cardinal direction");
        }
    }
}
