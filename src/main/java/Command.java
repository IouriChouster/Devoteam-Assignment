/**
 * @author Juri Chouster
 * Represents the command.
 */
public enum Command {
    LEFT('L'), RIGHT('R'), FORWARD('F');

    private final char value;

    Command(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    /**
     * Converts command from char to enum representation.
     *
     * @param command The specified instruction in char format.
     * @return The enum representation of the command.
     */
    public static Command convertChar(char command) {
        switch (command) {
            case 'L':
                return LEFT;
            case 'R':
                return RIGHT;
            case 'F':
                return FORWARD;
            default:
                throw new UnsupportedOperationException("Illegal command");
        }
    }

}
