package model;

// Represents a container for an exercise, and its sets and reps.
// note: not a subtype of Exercise
public class ExerciseContainer {

    private Exercise exercise;
    private int sets; // number of cycles of reps
    private int reps; // number of repetitions to do exercise

    // REQUIRES: sets and reps > 0
    // MODIFIES: this
    // EFFECTS: sets the field values of this object
    public ExerciseContainer(Exercise exercise, int sets, int reps) {
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public int getSets() {
        return sets;
    }

    // REQUIRES: sets > 0
    // MODIFIES: this
    // EFFECTS: sets the number of sets
    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    // REQUIRES: reps > 0
    // MODIFIES: this
    // EFFECTS: sets the number of reps
    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    // EFFECTS: returns string representation of object
    public String toString() {
        return exercise.getName() + " " + sets + "x" + reps;
    }
}
