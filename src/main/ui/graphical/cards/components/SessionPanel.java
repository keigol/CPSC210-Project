package ui.graphical.cards.components;

import model.ExerciseContainer;
import model.Session;
import ui.graphical.Styling;
import ui.graphical.cards.MyProgramCard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class SessionPanel extends JPanel {
    MyProgramCard myProgramCard;
    Session session;

    public SessionPanel(MyProgramCard myProgramCard, Session session) {
        this.myProgramCard = myProgramCard;
        this.session = session;

        setLayout(new GridLayout(0,1));
        setBackground(Styling.ACCENT_COLOR);

        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));


        JLabel sessionName = new JLabel(session.getName());
        sessionName.setFont(Styling.SUBTITLE_FONT);
        add(sessionName);

        for (ExerciseContainer ex : session.getExercises()) {
            JLabel exercise = new JLabel(ex.toString());
            exercise.setFont(Styling.FONT);
            add(exercise);
        }

        initializeButtons();
    }

    private void initializeButtons() {
        JButton addExerciseButton = new JButton("Add Exercise");
        JButton deleteSessionButton = new JButton("Delete Session");

        addExerciseButton.addActionListener(myProgramCard);
        deleteSessionButton.addActionListener(myProgramCard);

        addExerciseButton.putClientProperty("session", session);
        deleteSessionButton.putClientProperty("session", session);

        add(addExerciseButton);
        add(deleteSessionButton);
    }

    public Session getSession() {
        return session;
    }
}
