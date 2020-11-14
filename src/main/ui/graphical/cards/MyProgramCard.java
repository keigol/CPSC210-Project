package ui.graphical.cards;

import model.Exercise;
import model.Session;
import ui.graphical.Styling;
import ui.graphical.WorkoutTrackerGUI;
import ui.graphical.cards.components.SessionPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

// Displays the workoutProgram overview
public class MyProgramCard extends JPanel implements Card, ActionListener {
    public static final String TITLE = "My Workout Program";
    private WorkoutTrackerGUI application;

    // MODIFIES: this
    // EFFECTS: instantiates the my workoutProgram card
    public MyProgramCard(WorkoutTrackerGUI application) {
        this.application = application;
        setBackground(Styling.BACKGROUND_COLOR);

        setLayout(new GridBagLayout());

        initializeTitle();
        initializeSessions();
        initializeAddSessionButton();
    }

    private void initializeTitle() {
        JLabel title = new JLabel(application.getWorkoutProgram().getName());
        title.setFont(Styling.TITLE_FONT);
        add(title, createTitleConstraints());
    }

    private GridBagConstraints createTitleConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(30, 30, 23, 10);
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
        SessionPanel sessionPanel = new SessionPanel(this, session);
        add(sessionPanel, createSessionPanelConstraints(i));
    }

    private GridBagConstraints createSessionPanelConstraints(int i) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(7, 40, 7, 40);
        c.gridx = 0;
        c.gridy = i + 1;
        c.weightx = 0.5;
        c.weighty = 0;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        return c;
    }

    private void initializeAddSessionButton() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(7, 40, 7, 40);
        c.gridx = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.SOUTHEAST;

        JButton addSessionButton = new JButton("Add Session");
        addSessionButton.addActionListener(this);

        add(addSessionButton, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        SessionPanel sessionPanel;
        switch (e.getActionCommand()) {
            case "Add Exercise":
                sessionPanel = (SessionPanel) button.getParent();
                addExerciseAction(sessionPanel);
                break;
            case "Delete Session":
                sessionPanel = (SessionPanel) button.getParent();
                deleteSessionAction(sessionPanel);
                break;
            case "Add Session":
                addSessionAction();
                break;
            default:
                break;
        }
    }

    private void deleteSessionAction(SessionPanel sessionPanel) {
        application.getWorkoutProgram().removeSession(sessionPanel.getSession());
        remove(sessionPanel);
        revalidate();
        repaint();
    }

    private void addExerciseAction(SessionPanel sessionPanel) {
        Optional<String[]> response = addExerciseDialog();
        if (response.isPresent()) {
            if (!isValidExercise(response.get())) {
                JOptionPane.showMessageDialog(this,
                        "Name must not be empty. Sets and reps must be integers.",
                        "Input error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String name = response.get()[0];
            int sets = Integer.parseInt(response.get()[1]);
            int reps = Integer.parseInt(response.get()[2]);
            String description = response.get()[3];

            sessionPanel.getSession().addExercise(new Exercise(name, description), sets, reps);

            refreshAllComponents();
            revalidate();
            repaint();
        }
    }

    private Optional<String[]> addExerciseDialog() {
        JTextField name = new JTextField();
        JTextField sets = new JTextField();
        JTextField reps = new JTextField();
        JTextField description = new JTextField();

        JPanel labelAndText = new JPanel();
        labelAndText.setLayout(new GridLayout(0, 2));
        labelAndText.add(new JLabel("Name: "));
        labelAndText.add(name);
        labelAndText.add(new JLabel("Sets: "));
        labelAndText.add(sets);
        labelAndText.add(new JLabel("Reps: "));
        labelAndText.add(reps);
        labelAndText.add(new JLabel("Description: "));
        labelAndText.add(description);

        int result = JOptionPane.showConfirmDialog(this, labelAndText,
                "Add Exercise", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return Optional.of(new String[]{name.getText(), sets.getText(), reps.getText(), description.getText()});
        }

        return Optional.empty();
    }

    private boolean isValidExercise(String[] response) {
        try {
            Integer.parseInt(response[1]);
            Integer.parseInt(response[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        return !response[0].isEmpty();
    }

    private void addSessionAction() {
        Optional<String> response = addSessionDialog();
        if (response.isPresent()) {
            String name = response.get();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Name must not be empty.",
                        "Input error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            application.getWorkoutProgram().addSession(new Session(name));

            refreshAllComponents();
            revalidate();
            repaint();
        }
    }

    private Optional<String> addSessionDialog() {
        JTextField name = new JTextField();

        JPanel labelAndText = new JPanel();
        labelAndText.setLayout(new GridLayout(0, 2));
        labelAndText.add(new JLabel("Name: "));
        labelAndText.add(name);

        int result = JOptionPane.showConfirmDialog(this, labelAndText,
                "Add Exercise", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return Optional.of(name.getText());
        }

        return Optional.empty();
    }

    public void refreshAllComponents() {
        removeAll();
        initializeTitle();
        initializeSessions();
        initializeAddSessionButton();
    }
}
