package persistence;


import model.Exercise;
import model.Program;
import model.Session;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// referenced JsonSerializationDemo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Program p = new Program("My Program");
            JsonWriter writer = new JsonWriter("./data/tests/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyProgram() {
        try {
            Program p = new Program("My Program");
            JsonWriter writer = new JsonWriter("./data/tests/testWriterEmptyProgram.json");
            writer.open();
            writer.write(p);
            writer.close();

            JsonReader reader = new JsonReader("./data/tests/testWriterEmptyProgram.json");
            p = reader.read();
            assertEquals("My Program", p.getName());
            assertEquals(0, p.numberOfSessions());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralProgram() {
        try {
            Program p = new Program("My Program");
            Session a = new Session("A");
            Session b = new Session("B");
            p.addSession(a);
            p.addSession(b);
            a.addExercise(new Exercise("pushup"), 3, 12);

            JsonWriter writer = new JsonWriter("./data/tests/testWriterGeneralProgram.json");
            writer.open();
            writer.write(p);
            writer.close();

            JsonReader reader = new JsonReader("./data/tests/testWriterGeneralProgram.json");
            p = reader.read();
            assertEquals("My Program", p.getName());
            List<Session> sessions = p.getSessions();
            assertEquals(2, sessions.size());
            checkSession(a.getName(), a.getExercises(), sessions.get(0));
            checkSession(b.getName(), b.getExercises(), sessions.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
