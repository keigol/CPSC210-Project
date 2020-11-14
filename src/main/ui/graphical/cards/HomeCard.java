package ui.graphical.cards;

import ui.graphical.Styling;
import ui.graphical.WorkoutTrackerGUI;

import javax.swing.*;
import java.awt.*;

// Displays the home page
public class HomeCard extends JPanel implements Card {
    public static final String TITLE = "Home";
    private WorkoutTrackerGUI application;

    // MODIFIES: this
    // EFFECTS: instantiates the home card
    public HomeCard(WorkoutTrackerGUI application) {
        this.application = application;
        setBackground(Styling.BACKGROUND_COLOR);
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Welcome", SwingConstants.CENTER);
        title.setFont(Styling.TITLE_FONT);
        add(title, BorderLayout.CENTER);
    }
}
