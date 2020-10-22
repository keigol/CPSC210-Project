package persistence;

import model.Exercise;
import model.ExerciseContainer;
import model.Session;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// referenced JsonSerializationDemo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class JsonTest {
    protected void checkSession(String name, List<ExerciseContainer> exercises, Session session) {
        assertEquals(name, session.getName());
        assertEquals(exercises, session.getExercises());
    }
    private void checkExercise() {

    }
}
