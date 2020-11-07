package ui.console.views;

import ui.console.Command;
import ui.console.WorkoutTrackerApplication;

import java.util.List;

// Represents the functionality that a user currently has access to
public abstract class View {
    protected WorkoutTrackerApplication app;


    // MODIFIES: this
    // EFFECTS: creates view with app and commands
    public View(WorkoutTrackerApplication app) {
        this.app = app;
    }

    // EFFECTS: shows list of commands and their functions
    public void displayMenu() {
        System.out.println("Commands:");

        for (Command c : getCommands()) {
            System.out.println(c);
        }

        System.out.println();
    }

    // MODIFIES: this
    // EFFECTS: uses command to call its corresponding method
    public abstract void processCommand(String command);

    // EFFECTS: shows details about current view
    public abstract void display();

    // MODIFIES: app
    // EFFECTS: changes the view in app
    public abstract void changeView();

    public abstract List<Command> getCommands();
}
