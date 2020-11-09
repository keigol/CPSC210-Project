package ui.graphical.cards;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import model.Program;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

// The main screen which contains different cards
public class MainScreen extends JPanel {
    private Map<String, JPanel> cards;

    // MODIFIES: this
    // EFFECTS: represents the main screen and it's cards
    public MainScreen(Program program) {
        cards = new HashMap<>();
        setLayout(new CardLayout());
        initializeCards(program);
    }

    private void initializeCards(Program program) {
        HomeCard homeCard = new HomeCard(program);
        MyProgramCard myProgramCard = new MyProgramCard(program);

        cards.put(homeCard.getTitle(), homeCard);
        cards.put(myProgramCard.getTitle(), myProgramCard);

        add(homeCard, homeCard.getTitle());
        add(myProgramCard, myProgramCard.getTitle());
    }

    public Map<String, JPanel> getCards() {
        return cards;
    }
}
