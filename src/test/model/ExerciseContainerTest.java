package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ExerciseContainerTest {
    private Exercise exercise;
    private ExerciseContainer container;

    @BeforeEach
    public void setup() {
        exercise = new Exercise("jump", "cardio");
        container = new ExerciseContainer(exercise, 1 ,1);
    }

    @Test
    public void testExerciseContainerSettersAndGetters() {
        assertEquals("jump", exercise.getName());
        assertEquals("cardio", exercise.getDescription());
        assertEquals(1, container.getReps());
        assertEquals(1, container.getSets());


        exercise.setName("bench press");
        exercise.setDescription("weightlifting");
        container.setReps(8);
        container.setSets(3);

        assertEquals("bench press", exercise.getName());
        assertEquals("weightlifting", exercise.getDescription());
        assertEquals(8, container.getReps());
        assertEquals(3, container.getSets());
    }

    @Test
    public void testToString() {
        assertEquals("jump 1x1", container.toString());
    }

    @Test
    public void testEquals() {
        Exercise exercise2 = new Exercise("jump", "cardio");
        ExerciseContainer container2 = new ExerciseContainer(exercise, 1 ,1);

        assertTrue(exercise2.equals(exercise));
        assertTrue(container2.equals(container));
        assertFalse(exercise.equals(null));
        assertFalse(container.equals(null));
    }

    @Test
    public void testHashCode() {
        Exercise exercise2 = new Exercise("jump", "cardio");
        ExerciseContainer container2 = new ExerciseContainer(exercise, 1 ,1);

        assertEquals(exercise.hashCode(), exercise2.hashCode());
        assertEquals(container.hashCode(), container2.hashCode());
    }
}
