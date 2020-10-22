package persistence;

import model.Exercise;
import model.ExerciseContainer;
import model.Program;
import model.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// A reader that reads Program from JSON data stored in file
// referenced JSONSerializationDemo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads program from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Program read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseProgram(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses program from JSON object and returns it
    private Program parseProgram(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Program p = new Program(name);
        addSessions(p, jsonObject);
        return p;
    }

    // MODIFIES: p
    // EFFECTS: parses sessions from JSON object and adds them to the program
    private void addSessions(Program p, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("sessions");
        for (Object json : jsonArray) {
            JSONObject nextSession = (JSONObject) json;
            addSession(p, nextSession);
        }
    }

    // MODIFIES: p
    // EFFECTS: parses session from JSON Object and adds it to program
    private void addSession(Program p, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Session s = new Session(name);
        addExerciseContainers(s, jsonObject);
        p.addSession(s);
    }

    // MODIFIES: s
    // EFFECTS: parses ExerciseContainers from JSON object and adds them to the session
    private void addExerciseContainers(Session s, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExerciseContainer(s, nextExercise);
        }
    }

    // MODIFIES: s
    // EFFECTS: parses ExerciseContainer from JSON object and adds it to session
    private void addExerciseContainer(Session s, JSONObject jsonObject) {
        Exercise exercise = getExercise(jsonObject);
        int sets = jsonObject.getInt("sets");
        int reps = jsonObject.getInt("reps");

        s.addExercise(exercise, sets, reps);
    }

    // EFFECTS: parses Exercise from JSON object and returns it
    private Exercise getExercise(JSONObject jsonObject) {
        JSONObject exercise = jsonObject.getJSONObject("exercise");

        String name = exercise.getString("name");
        String description = exercise.getString("description");
        return new Exercise(name, description);
    }
}
