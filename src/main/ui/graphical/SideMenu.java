package ui.graphical;

import ui.graphical.cards.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The side menu which allows navigation
public class SideMenu extends JPanel implements ActionListener {
    private WorkoutTrackerGUI application;
    private JButton b1;
    private JButton b2;

    // MODIFIES: this
    // EFFECTS: creates the side menu with navigation buttons
    public SideMenu(WorkoutTrackerGUI application) {
        this.application = application;

        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        initializeButtons();
    }

    // MODIFIES: workoutTrackerGUI
    // EFFECTS: on button click, shows the corresponding card in the main screen
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cards = (CardLayout) application.getMainScreen().getLayout();
        switch (e.getActionCommand()) {
            case "Home":
                cards.show(application.getMainScreen(), "Home");
                break;
            case "My Workout Program":
                cards.show(application.getMainScreen(), "My Workout Program");
                break;
            default:
                break;
        }
    }

    private void initializeButtons() {
        b1 = new JButton("Home");
        b2 = new JButton("My Workout Program");
        b1.addActionListener(this);
        b2.addActionListener(this);


        // TODO: styling make superclass
//        b1.setBorderPainted(false);
//        b1.setFocusPainted(false);
//        b1.setContentAreaFilled(false);

        add(b1);
        add(b2);
    }
}
