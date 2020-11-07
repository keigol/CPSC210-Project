package ui.console.views;

import model.Program;
import model.Session;
import ui.console.Command;
import ui.console.views.SessionView;
import ui.console.views.View;
import ui.console.WorkoutTrackerApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// The starting view
public class ProgramView extends View {
    private Program program;
    private static final List<Command> COMMANDS;

    // MODIFIES: this
    // EFFECTS: instantiates commands
    static {
        COMMANDS = new ArrayList<>();
        COMMANDS.add(new Command("display", "displays program overview"));
        COMMANDS.add(new Command("select", "select a session"));
        COMMANDS.add(new Command("add", "add a new session"));
        COMMANDS.add(new Command("delete", "permanently delete a session"));
        COMMANDS.add(new Command("quit", "save and exit application"));
    }

    // MODIFIES: this
    // EFFECTS: creates a ProgramView instance
    public ProgramView(WorkoutTrackerApplication app) {
        super(app);
        program = app.getProgram();
    }

    @Override
    public List<Command> getCommands() {
        return COMMANDS;
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
            default:
                System.out.println("Invalid command");
        }

        System.out.println();
    }

    @Override
    public void display() {
        int n = program.numberOfSessions();

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
