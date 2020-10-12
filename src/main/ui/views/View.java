package ui.views;

import ui.WorkoutTrackerApplication;

// Represents the functionality that a user currently has access to
public interface View {

    // EFFECTS: shows list of commands and their functions
    public void displayMenu();

    // MODIFIES: this
    // EFFECTS: uses command to call its corresponding method
    public void processCommand(String command);

    // EFFECTS: shows details about current view
    public void display();

    // MODIFIES: app
    // EFFECTS: changes the view in app
    public void changeView();
}
