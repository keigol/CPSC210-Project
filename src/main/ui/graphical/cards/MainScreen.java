package ui.graphical.cards;

import javax.swing.*;
import java.awt.*;

// The main screen which contains different cards
public class MainScreen extends JPanel {
    private final String[] cardNames = {"Home", "My Program"};
    HomeCard homeCard;
    MyProgramCard myProgramCard;

    // MODIFIES: this
    // EFFECTS: represents the main screen and it's cards
    public MainScreen() {
        setLayout(new CardLayout());
        homeCard = new HomeCard();
        myProgramCard = new MyProgramCard();
        add(homeCard, cardNames[0]);
        add(myProgramCard, cardNames[1]);
    }

    public String[] getCardNames() {
        return cardNames;
    }
}
