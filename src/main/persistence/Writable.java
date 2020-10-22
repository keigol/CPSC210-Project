package persistence;

import org.json.JSONObject;

// referenced JsonSerializationDemo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public interface Writable {

    // EFFECTS: returns this as a JSON object
    JSONObject toJson();
}
