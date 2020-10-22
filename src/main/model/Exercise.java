package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

// Represents an exercise having a name and description
// referenced JsonSerializationDemo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class Exercise implements Writable {
    private String name;
    private String description;

    // REQUIRES: name is non-empty
    // MODIFIES: this
    // EFFECTS: sets field values for name and description
    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // REQUIRES: name is non-empty
    // MODIFIES: this
    // EFFECTS: sets field values for name
    public Exercise(String name) {
        this.name = name;
        this.description = "";
    }

    public String getName() {
        return name;
    }

    // REQUIRES: name is non-empty
    // MODIFIES: this
    // EFFECTS: sets name value
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("description", description);
        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Exercise exercise = (Exercise) o;
        return name.equals(exercise.name)
                && description.equals(exercise.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
