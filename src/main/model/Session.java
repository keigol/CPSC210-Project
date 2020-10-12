package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Represents a group of exercises
public class Session {
    private String name;
    private List<ExerciseContainer> exercises;

    // MODIFIES: this
    // EFFECTS: create a Session object with an empty list of exercises
    public Session(String name) {
        this.name = name;
        this.exercises = new ArrayList<>();
    }

    // REQUIRES: sets and reps are > 0
    // MODIFIES: this
    // EFFECTS: adds exercise with sets and reps to exercises
    public void addExercise(Exercise exercise, int sets, int reps) {
        exercises.add(new ExerciseContainer(exercise, sets, reps));
    }

    // REQUIRES: exercises exists in exercises
    // MODIFIES: this
    // EFFECTS: removes exercise from exercises
    public void removeExercise(ExerciseContainer exercise) {
        exercises.remove(exercise);
    }

    // REQUIRES: i is in range of exercises length
    // MODIFIES: this
    // EFFECTS: remove ith element from exercises
    public void removeExercise(int i) {
        exercises.remove(i);
    }

    // REQUIRES: i is in range of exercises length
    // EFFECTS: returns exercise by given index
    public ExerciseContainer getExercise(int i) {
        return exercises.get(i);
    }

    public List<ExerciseContainer> getExercises() {
        return exercises;
    }

    // EFFECTS: returns an optional ExerciseContainer
    public Optional<ExerciseContainer> getExerciseByName(String name) {
        Optional<ExerciseContainer> exerciseContainer = Optional.empty();
        for (ExerciseContainer ex : exercises) {
            if (ex.getExercise().getName().equals(name)) {
                exerciseContainer = Optional.of(ex);
            }
        }
        return exerciseContainer;
    }

    // EFFECTS: returns size of exercises
    public int numberOfExercises() {
        return exercises.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    // EFFECTS: returns string representation of Session
    public String toString() {
        return name;
    }
}
