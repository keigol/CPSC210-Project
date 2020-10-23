package ui;

import model.Program;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.views.ProgramView;
import ui.views.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Workout tracker application
// Referenced TellerApp ("https://github.students.cs.ubc.ca/CPSC210/TellerApp") for structure
public class WorkoutTrackerApplication {
    private static final String JSON_STORE = "./data/user_program.json";
    private Scanner scanner;
    private Program program;
    private View view;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: run the workout tracker application
    public WorkoutTrackerApplication() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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
                saveProgram();
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
        try {
            loadProgram();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
            System.out.println("Creating new save file ...");
            program = new Program("My Workout Program");
            saveProgram();
        }
        view = new ProgramView(this);
    }

    // EFFECTS: saves program to file
    private void saveProgram() {
        try {
            jsonWriter.open();
            jsonWriter.write(program);
            jsonWriter.close();
            System.out.println("Saved " + program.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: program
    // EFFECTS: loads program from file
    private void loadProgram() throws IOException {
        program = jsonReader.read();
        System.out.println("Loaded " + program.getName() + " from " + JSON_STORE);
    }
}
