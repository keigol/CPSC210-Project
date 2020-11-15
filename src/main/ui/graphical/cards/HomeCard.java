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
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Styling.BACKGROUND_COLOR);
        northPanel.setPreferredSize(new Dimension(0, 200));
        add(northPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Styling.BACKGROUND_COLOR);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Welcome", SwingConstants.CENTER);
        title.setFont(Styling.TITLE_FONT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(title);

        JLabel graphic = new JLabel();
        graphic.setIcon(new ImageIcon("./data/workoutLogo.png"));
        graphic.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(graphic);

        add(centerPanel, BorderLayout.CENTER);
    }
}
