package model;

// Represents an exercise having a name and description
public class Exercise {
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
}
