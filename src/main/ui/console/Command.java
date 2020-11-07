package ui.console;

// Represents a command with a description
public class Command {
    private String command;
    private String description;

    // MODIFIES: this
    // EFFECTS: creates new Command with given command and description
    public Command(String command, String description) {
        this.command = command;
        this.description = description;
    }

    // EFFECTS: returns string representation of Command
    public String toString() {
        return "\t\"" + command + "\" - " + description;
    }
}
