package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {
    private Program program;
    private Session session1;
    private Session session2;
    private Session session3;

    @BeforeEach
    public void setup() {
        program = new Program("program");
        session1 = new Session("A");
        session2 = new Session("B");
        session3 = new Session("C");

        program.addSession(session1);
        program.addSession(session2);
        program.addSession(session3);
    }

    @Test
    public void testAddSession() {
        assertEquals(3, program.numberOfSessions());
    }

    @Test
    public void testRemoveSessionBySession() {
        assertEquals(3, program.numberOfSessions());

        program.removeSession(session2);

        assertEquals(session3, program.getSession(1));
        assertEquals(2, program.numberOfSessions());
        assertFalse(program.getSessions().contains(session2));
    }

    @Test
    public void testRemoveSessionByIndex() {
        assertEquals(3, program.numberOfSessions());

        program.removeSession(1);

        assertEquals(2, program.numberOfSessions());
        assertFalse(program.getSessions().contains(session2));
    }

    @Test
    public void testName() {
        program.setName("My program");

        assertEquals("My program", program.getName());
    }

    @Test
    public void testGetSessionByName() {
        assertTrue(program.getSessionByName("B").isPresent());
        assertEquals(session2, program.getSessionByName("B").get());
        assertFalse(program.getSessionByName("Fake session").isPresent());
    }
}
