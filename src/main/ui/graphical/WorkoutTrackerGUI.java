package ui.graphical;

import model.WorkoutProgram;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.graphical.cards.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

// The main gui application
public class WorkoutTrackerGUI extends JFrame {
    private static final String JSON_STORE = "./data/user_program.json";

    private WorkoutProgram workoutProgram;
    private MainScreen mainScreen;
    private SideMenu sideMenu;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // MODIFIES: this
    // EFFECTS: Starts the WorkoutTrackerGUI application
    public WorkoutTrackerGUI() {
        super("WorkoutTrackerGUI");

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        try {
            workoutProgram = jsonReader.read();
        } catch (IOException e) {
            workoutProgram = new WorkoutProgram("My Workout Program");
        }

        initializeScreenComponents();
        initializePersistenceDialogs();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();
        setVisible(true);
    }

    // EFFECTS: creates a new instance of WorkoutTrackerGUI
    public static void main(String[] args) {
        new WorkoutTrackerGUI();
    }

    public WorkoutProgram getWorkoutProgram() {
        return workoutProgram;
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    private void initializePersistenceDialogs() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveDataPrompt();
                dispose();
            }
        });
    }

    private void initializeScreenComponents() {
        mainScreen = new MainScreen(this);
        sideMenu = new SideMenu(this);

        add(mainScreen, BorderLayout.CENTER);
        add(sideMenu, BorderLayout.WEST);
    }

    // EFFECTS: Opens a dialog box to prompt user to save data
    // if yes, saves data to file
    // if no, does nothing
    private void saveDataPrompt() {
        // TODO
    }

    // MODIFIES: this
    // EFFECTS: Opens a dialog box to prompt user to either load data or start a blank application
    private void loadDataPrompt() {
        // TODO
        JOptionPane loadDialog = new JOptionPane();

    }
}
