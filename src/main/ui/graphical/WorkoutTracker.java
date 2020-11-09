package ui.graphical;

import model.Program;
import ui.graphical.cards.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// The main gui application
public class WorkoutTracker extends JFrame {
    private Program program;
    private MainScreen mainScreen;
    private SideMenu sideMenu;

    // MODIFIES: this
    // EFFECTS: Starts the WorkoutTracker application
    public WorkoutTracker() {
        super("WorkoutTracker");

        program = new Program("My Program");

        initializeScreenComponents();
        initializePersistenceDialogs();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();
        setVisible(true);
    }

    // EFFECTS: creates a new instance of WorkoutTracker
    public static void main(String[] args) {
        new WorkoutTracker();
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
        mainScreen = new MainScreen(program);
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
    }
}
