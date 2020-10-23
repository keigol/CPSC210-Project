package ui.views;

import model.Exercise;
import model.ExerciseContainer;
import model.Session;
import ui.Command;
import ui.WorkoutTrackerApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// View for individual workout sessions
public class SessionView extends View {
    private Session session;
    private static final List<Command> COMMANDS;

    // MODIFIES: this
    // EFFECTS: initializes commands
    static {
        COMMANDS = new ArrayList<>();
        //COMMANDS.add(new Command("workout", "start this workout session!"));
        COMMANDS.add(new Command("display", "displays session overview"));
        COMMANDS.add(new Command("back", "go to previous menu"));
        COMMANDS.add(new Command("add", "add a new exercise"));
        COMMANDS.add(new Command("delete", "permanently delete an exercise"));
        COMMANDS.add(new Command("quit", "save and exit application"));
    }

    // MODIFIES: this
    // EFFECTS: creates SessionView with app and session
    public SessionView(WorkoutTrackerApplication app, Session session) {
        super(app);
        this.session = session;
    }


    @Override
    public void processCommand(String command) {
        switch (command) {
            case "display":
                display();
                break;
            case "back":
                changeView();
                break;
            case "add":
                addExercise();
                break;
            case "delete":
                deleteExercise();
                break;
            default:
                System.out.println("Invalid command");
        }

        System.out.println();
    }

    @Override
    public void display() {
        int n = session.numberOfExercises();

        System.out.println(session.getName());

        if (n == 0) {
            System.out.println("\t No exercises available");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println("\t" + (i + 1) + ".) " + session.getExercises().get(i));
            }
        }
    }

    @Override
    public List<Command> getCommands() {
        return COMMANDS;
    }

    @Override
    // MODIFIES: app
    // EFFECTS: changes app's view to program view
    public void changeView() {
        app.setView(new ProgramView(app));
    }

    // REQUIRES: input is properly formatted // TODO check if properly formatted
    // MODIFIES: session
    // EFFECTS: adds exercise to session
    private void addExercise() {
        System.out.println("Enter name, sets, and reps separated by commas:");
        String input = app.getScanner().nextLine();
        String[] inputs = input.split(",");

        String name = inputs[0].trim();
        int sets = Integer.parseInt(inputs[1].trim());
        int reps = Integer.parseInt(inputs[2].trim());

        Exercise exercise = new Exercise(name);
        session.addExercise(exercise, sets, reps);
    }

    // MODIFIES: session
    // EFFECTS: deletes exercise from session
    private void deleteExercise() {
        System.out.print("Enter name of exercise to delete: ");
        String name = app.getScanner().nextLine();
        Optional<ExerciseContainer> searchedExercise = session.getExerciseByName(name);

        if (searchedExercise.isPresent()) {
            session.removeExercise(searchedExercise.get());
        } else {
            System.out.println("Invalid name");
        }
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
