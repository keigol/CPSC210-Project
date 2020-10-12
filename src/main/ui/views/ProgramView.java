package ui.views;

import model.Program;
import model.Session;
import ui.Command;
import ui.WorkoutTrackerApplication;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// The starting view
public class ProgramView implements View {
    private WorkoutTrackerApplication app;
    private Program program;
    private static final List<Command> commands;

    // MODIFIES: this
    // EFFECTS: instantiates commands
    static {
        commands = new ArrayList<>();
        commands.add(new Command("display", "displays program overview"));
        commands.add(new Command("select", "select a session"));
        commands.add(new Command("add", "add a new session"));
        commands.add(new Command("delete", "permanently delete a session"));
        commands.add(new Command("quit", "exit application"));

    }

    // MODIFIES: this
    // EFFECTS: creates a ProgramView instance
    public ProgramView(WorkoutTrackerApplication app) {
        this.app = app;
        program = app.getProgram();
    }

    @Override
    public void displayMenu() {
        System.out.println("Commands:");

        for (Command c : commands) {
            System.out.println(c);
        }

        System.out.println();
    }

    @Override
    public void processCommand(String command) {
        switch (command) {
            case "display":
                display();
                break;
            case "select":
                changeView();
                break;
            case "add":
                addSession();
                break;
            case "delete":
                deleteSession();
                break;
            case "quit":
                break;
            default:
                System.out.println("Invalid command");
        }

        System.out.println();
    }

    @Override
    public void display() {
        int n  = program.numberOfSessions();

        System.out.println(program.getName());

        if (n == 0) {
            System.out.println("\t No workout sessions available");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println("\t" + (i + 1) + ".) " + program.getSessions().get(i));
            }
        }
    }

    @Override
    // MODIFIES: app
    // EFFECTS: changes app's view to session view
    public void changeView() {
        System.out.print("Enter name of session to view: ");
        String name = app.getScanner().nextLine();
        Optional<Session> searchedSession = program.getSessionByName(name);

        if (searchedSession.isPresent()) {
            app.setView(new SessionView(app, searchedSession.get()));
        } else {
            System.out.println("Invalid name");
        }
    }

    // MODIFIES: program
    // EFFECTS: add session to program
    private void addSession() {
        System.out.println("Enter name for session to create: ");
        String name = app.getScanner().nextLine();
        program.addSession(new Session(name));
    }

    // MODIFIES: program
    // EFFECTS: delete session from program
    private void deleteSession() {
        System.out.print("Enter name of session to delete: ");
        String name = app.getScanner().nextLine();
        Optional<Session> searchedSession = program.getSessionByName(name);

        if (searchedSession.isPresent()) {
            program.removeSession(searchedSession.get());
        } else {
            System.out.println("Invalid name");
        }
    }
}
