package ui.graphical.cards;

import ui.graphical.WorkoutTrackerGUI;

import javax.swing.*;
import java.awt.*;
import java.util.*;

// The main screen which contains different cards
public class MainScreen extends JPanel {
    private WorkoutTrackerGUI application;
    private Map<String, Card> cards;

    // MODIFIES: this
    // EFFECTS: represents the main screen and it's cards
    public MainScreen(WorkoutTrackerGUI application) {
        this.application = application;
        cards = new HashMap<>();
        setLayout(new CardLayout());
        initializeCards();

    }

    private void initializeCards() {
        HomeCard homeCard = new HomeCard(application);
        MyProgramCard myProgramCard = new MyProgramCard(application);

        cards.put(HomeCard.TITLE, homeCard);
        cards.put(MyProgramCard.TITLE, myProgramCard);

        add(homeCard, HomeCard.TITLE);
        add(myProgramCard, MyProgramCard.TITLE);
    }

    public Map<String, Card> getCards() {
        return cards;
    }
}
