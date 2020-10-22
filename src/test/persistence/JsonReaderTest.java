package persistence;

import model.Exercise;
import model.ExerciseContainer;
import model.Program;
import model.Session;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// referenced JsonSerializationDemo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/tests/noSuchFile.json");
        try {
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/tests/testReaderEmptyProgram.json");
        try {
            Program p = reader.read();
            assertEquals("My Program", p.getName());
            assertEquals(0, p.numberOfSessions());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/tests/testReaderGeneralProgram.json");
        try {
            Program p = reader.read();
            assertEquals("My Program", p.getName());
            List<Session> sessions = p.getSessions();
            assertEquals(2, sessions.size());
            List<ExerciseContainer> exercisesA = new ArrayList<>();
            exercisesA.add(new ExerciseContainer(new Exercise("pushup"), 2, 1));
            exercisesA.add(new ExerciseContainer(new Exercise("jump"), 1,10));
            List<ExerciseContainer> exercisesB = new ArrayList<>();
            checkSession("A", exercisesA, sessions.get(0));
            checkSession("B", exercisesB, sessions.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
