package ui;

import model.Program;
import ui.views.ProgramView;
import ui.views.View;

import java.util.Scanner;

// Workout tracker application
// Referenced TellerApp ("https://github.students.cs.ubc.ca/CPSC210/TellerApp") for structure
public class WorkoutTrackerApplication {
    private Scanner scanner;
    private Program program;
    private View view;

    // EFFECTS: run the workout tracker application
    public WorkoutTrackerApplication() {
        runWorkoutTracker();
    }

    public void setView(View view) {
        this.view = view;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Program getProgram() {
        return program;
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runWorkoutTracker() {
        String command;

        init();

        while (true) {
            view.displayMenu();
            command = scanner.nextLine().toLowerCase();
            System.out.println();

            if (command.equals("quit")) {
                break;
            }

            view.processCommand(command);
        }

        System.out.println("Bye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes scanner, program and view
    private void init() {
        scanner = new Scanner(System.in);
        program = new Program("My Workout Program");
        view = new ProgramView(this);
    }
}
