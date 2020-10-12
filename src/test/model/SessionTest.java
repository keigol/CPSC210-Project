package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SessionTest {
    private Session session;

    @BeforeEach
    public void setup() {
        session = new Session("A");
    }

    @Test
    public void testAddExercise() {
        Exercise pushups = new Exercise("pushups", "builds chest muscles");

        session.addExercise(pushups, 3, 20);

        assertEquals(1, session.numberOfExercises());
        assertEquals("pushups", session.getExercises().get(0).getExercise().getName());
    }

    @Test
    public void testRemoveExerciseByIndex() {
        Exercise squats = new Exercise("squats");
        session.addExercise(squats, 3, 5);

        assertEquals(1, session.numberOfExercises());

        session.removeExercise(0);

        assertEquals(0, session.numberOfExercises());
    }

    @Test
    public void testRemoveExerciseByExercise() {
        Exercise squats = new Exercise("squats", "build leg muscles");
        session.addExercise(squats, 3, 5);

        assertEquals(1, session.numberOfExercises());

        session.removeExercise(session.getExercise(0));

        assertEquals(0, session.numberOfExercises());
    }

    @Test
    public void testName() {
        session.setName("B");

        assertEquals("B", session.getName());
    }

    @Test
    public void testToString() {
        assertEquals(session.getName(), session.toString());
    }

    @Test
    public void testGetSessionByName() {
        Exercise pushups = new Exercise("pushups", "builds chest muscles");

        session.addExercise(pushups, 3, 20);

        assertTrue(session.getExerciseByName("pushups").isPresent());
        assertEquals(session.getExercise(0), session.getExerciseByName("pushups").get());
        assertFalse(session.getExerciseByName("Fake exercise").isPresent());
    }
}
