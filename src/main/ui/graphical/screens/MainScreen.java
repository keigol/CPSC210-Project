package ui.graphical.screens;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel {
    HomeScreen homeScreen;
    MyProgramScreen myProgramScreen;

    public MainScreen() {
        setLayout(new CardLayout());
        homeScreen = new HomeScreen();
        myProgramScreen = new MyProgramScreen();
        add(homeScreen);
        add(myProgramScreen);
    }
}
