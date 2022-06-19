import java.io.Serial;
import java.util.ArrayList;

/**
 * @author Juri Chouster
 * Represents a list of commands.
 */
public class CommandList extends ArrayList<Command> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (var currentCommand : this) {
            out.append(currentCommand);
        }
        return out.toString();
    }

}
