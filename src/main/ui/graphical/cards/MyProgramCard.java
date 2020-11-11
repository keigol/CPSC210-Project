package ui.graphical.cards;

import model.ExerciseContainer;
import model.Session;
import ui.graphical.Styling;
import ui.graphical.WorkoutTrackerGUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//test
// Displays the workoutProgram overview
public class MyProgramCard extends JPanel implements Card {
    public static final String TITLE = "My Workout Program";
    private WorkoutTrackerGUI application;

    // MODIFIES: this
    // EFFECTS: instantiates the my workoutProgram card
    public MyProgramCard(WorkoutTrackerGUI application) {
        this.application = application;
        setBackground(Color.decode("#F1F7F7"));

        setLayout(new GridBagLayout());

        initializeTitle();
        initializeSessions();
    }

    private void initializeTitle() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(100, 20, 100, 20);
        c.gridx = 0;
        c.gridy = 0;

        JLabel title = new JLabel(application.getWorkoutProgram().getName());
        title.setFont(Styling.TITLE_FONT);
        add(title, c);
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
        sessionPanel.setBackground(Color.WHITE);

        JLabel subtitle = new JLabel(session.getName());
        subtitle.setFont(Styling.SUBTITLE_FONT);
        sessionPanel.add(subtitle);

        for (ExerciseContainer exercise : session.getExercises()) {
            JLabel exerciseLabel = new JLabel(exercise.toString());
            exerciseLabel.setFont(Styling.FONT);
            sessionPanel.add(exerciseLabel);
        }

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 10, 20, 10);
        c.gridx = 0;
        c.gridy = i + 1;
        c.gridwidth = 3;
        c.ipady = 100;
        add(sessionPanel, c);
    }
}
