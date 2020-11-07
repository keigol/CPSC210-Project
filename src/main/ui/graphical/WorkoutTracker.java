package ui.graphical;

import ui.graphical.screens.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WorkoutTracker extends JFrame {

    MainScreen mainScreen;
    SideMenu sideMenu;

    // MODIFIES: this
    // EFFECTS: Starts the WorkoutTracker application
    public WorkoutTracker() {
        super("WorkoutTracker");

        mainScreen = new MainScreen();
        sideMenu = new SideMenu();

        add(mainScreen, BorderLayout.CENTER);
        add(sideMenu, BorderLayout.WEST);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveDataPrompt();
                dispose();
            }
        });

        pack();
        setVisible(true);
    }

//    // Centres frame on desktop (borrowed from B5-SpaceInvader)
//    // modifies: this
//    // effects:  location of frame is set so frame is centred on desktop
//    private void centreOnScreen() {
//        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
//        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
//    }


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

    // EFFECTS: creates a new instance of WorkoutTracker
    public static void main(String[] args) {
        new WorkoutTracker();
    }
}
