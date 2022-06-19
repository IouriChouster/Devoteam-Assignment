/**
 * @author Juri Chouster
 * Represents a position with a direction on a two-dimensional field.
 */
public class Position {

    private final int currentX;
    private final int currentY;
    private CardinalDirection cardinalDirection;

    /**
     * Creates an instance of a position.
     *
     * @param x                 The x coordinate of the position.
     * @param y                 The y coordinate of the position.
     * @param cardinalDirection The cardinal direction.
     */
    public Position(int x, int y, CardinalDirection cardinalDirection) {
        currentX = x;
        currentY = y;
        this.cardinalDirection = cardinalDirection;
    }

    @Override
    public String toString() {
        return currentX + " " + currentY + " " + cardinalDirection;
    }

    /**
     * Get x coordinate of the position.
     *
     * @return The x coordinate.
     */
    public int getX() {
        return currentX;
    }

    /**
     * Get y coordinate of the position.
     *
     * @return The y coordinate.
     */
    public int getY() {
        return currentY;
    }

    /**
     * Get the cardinal direction of the position.
     *
     * @return The cardinal direction.
     */
    public CardinalDirection getCardinalDirection() {
        return cardinalDirection;
    }

    /**
     * Set the cardinal direction of the position.
     *
     * @param direction The new cardinal direction.
     */
    public void setCardinalDirection(CardinalDirection direction) {
        cardinalDirection = direction;
    }

    /**
     * Move forward one step.
     *
     * @return New position.
     */
    public Position goForward() {
        int newX = currentX;
        int newY = currentY;

        switch (cardinalDirection) {
            case NORTH:
                newY--;
                break;
            case WEST:
                newX--;
                break;
            case SOUTH:
                newY++;
                break;
            case EAST:
                newX++;
                break;
        }
        return new Position(newX, newY, cardinalDirection);
    }
}
