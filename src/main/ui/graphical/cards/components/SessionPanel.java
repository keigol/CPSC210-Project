package ui.graphical.cards.components;

import model.ExerciseContainer;
import model.Session;
import ui.graphical.Styling;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class SessionPanel extends JPanel {

    public SessionPanel(Session session) {
        setLayout(new GridLayout(0,1));
        setBackground(Styling.ACCENT_COLOR);
        setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));

        JLabel sessionName = new JLabel(session.getName());
        sessionName.setFont(Styling.SUBTITLE_FONT);
        add(sessionName);

        for (ExerciseContainer ex : session.getExercises()) {
            JLabel exercise = new JLabel(ex.toString());
            exercise.setFont(Styling.FONT);
            add(exercise);
        }
    }
}
