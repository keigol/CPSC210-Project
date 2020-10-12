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
}
