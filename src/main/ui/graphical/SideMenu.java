package ui.graphical;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The side menu which allows navigation
public class SideMenu extends JPanel implements ActionListener {
    WorkoutTracker workoutTracker;
    private JButton b1;
    private JButton b2;

    // MODIFIES: this
    // EFFECTS: creates the side menu with navigation buttons
    public SideMenu(WorkoutTracker workoutTracker) {
        this.workoutTracker = workoutTracker;

        setBackground(Color.WHITE); // tests visibility
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        initializeButtons();
    }

    // MODIFIES: workoutTracker
    // EFFECTS: on button click, shows the corresponding card in the main screen
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cards = (CardLayout) workoutTracker.getMainScreen().getLayout();
        switch (e.getActionCommand()) {
            case "Home":
                cards.show(workoutTracker.getMainScreen(), "Home");
                break;
            case "My Program":
                cards.show(workoutTracker.getMainScreen(), "My Program");
                break;
            default:
                break;
        }
    }

    private void initializeButtons() {
        b1 = new JButton("Home");
        b2 = new JButton("My Program");
        b1.addActionListener(this);
        b2.addActionListener(this);

        add(b1);
        add(b2);
    }
}
