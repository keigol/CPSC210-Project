package ui.graphical.cards;

import model.Program;
import model.Session;

import javax.swing.*;
import java.awt.*;

// Displays the program overview
public class MyProgramCard extends JPanel {
    private final String title = "My Program";
    private Program program;

    // MODIFIES: this
    // EFFECTS: instantiates the my program card
    public MyProgramCard(Program program) {
        this.program = program;
        setBackground(Color.decode("#F1F7F7"));
        displaySessions();
    }

    public void displaySessions() {
        for (Session session : program.getSessions()) {

        }
    }

    public String getTitle() {
        return title;
    }
}
