package ui.graphical.cards;

import model.ExerciseContainer;
import model.Session;
import ui.graphical.Styling;
import ui.graphical.WorkoutTrackerGUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.List;

// Displays the workoutProgram overview
public class MyProgramCard extends JPanel implements Card {
    public static final String TITLE = "My Workout Program";
    private WorkoutTrackerGUI application;

    // MODIFIES: this
    // EFFECTS: instantiates the my workoutProgram card
    public MyProgramCard(WorkoutTrackerGUI application) {
        this.application = application;
        setBackground(Styling.BACKGROUND_COLOR);

        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);

        initializeTitle();
        initializeSessions();
        addWhiteSpace();

    }

    private void initializeTitle() {
        JLabel title = new JLabel(application.getWorkoutProgram().getName());
        title.setFont(Styling.TITLE_FONT);
        add(title, createTitleRestraints());
    }

    private GridBagConstraints createTitleRestraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(30, 30, 40, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weightx = 0.5;
        c.weighty = 0;
        return c;
    }

    private void initializeSessions() {
        List<Session> sessions = application.getWorkoutProgram().getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            initializeSession(sessions.get(i), i);
        }
    }

    private void initializeSession(Session session, int i) {
        JPanel sessionPanel = new JPanel();
        sessionPanel.setLayout(new GridLayout(0,1));
        sessionPanel.setBackground(Styling.ACCENT_COLOR);
        sessionPanel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));

        JLabel sessionName = new JLabel(session.getName());
        sessionName.setFont(Styling.SUBTITLE_FONT);
        sessionPanel.add(sessionName);

        for (ExerciseContainer ex : session.getExercises()) {
            JLabel exercise = new JLabel(ex.toString());
            exercise.setFont(Styling.FONT);
            sessionPanel.add(exercise);
        }

        add(sessionPanel, createSessionPanelRestraints(i));
    }

    private GridBagConstraints createSessionPanelRestraints(int i) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(7, 30, 7, 10);
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = i + 1;
        c.weightx = 0.5;
        c.weighty = 0;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        return c;
    }

    private void addWhiteSpace() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.VERTICAL;
        JPanel p = new JPanel();
        p.setBackground(Styling.BACKGROUND_COLOR);
        add(p, c);
    }
}
