package ui.graphical.cards;

import model.Program;

import javax.swing.*;
import java.awt.*;

// Displays the home page
public class HomeCard extends JPanel {
    private final String title = "Home";
    private Program program;

    // MODIFIES: this
    // EFFECTS: instantiates the home card
    public HomeCard(Program program) {
        this.program = program;
        setBackground(Color.decode("#F1F7F7"));
    }

    public String getTitle() {
        return title;
    }
}
