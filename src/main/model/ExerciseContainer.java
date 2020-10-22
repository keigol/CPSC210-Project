package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

// Represents a container for an exercise, and its sets and reps.
// referenced JsonSerializationDemo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
// note: For use as part of a session, not a subtype of Exercise
public class ExerciseContainer implements Writable {

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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("exercise", exercise.toJson());
        json.put("sets", sets);
        json.put("reps", reps);
        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExerciseContainer that = (ExerciseContainer) o;
        return sets == that.sets
                && reps == that.reps
                && exercise.equals(that.exercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exercise, sets, reps);
    }
}
