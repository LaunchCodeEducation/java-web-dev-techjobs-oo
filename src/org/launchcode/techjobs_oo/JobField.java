package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {
    // Class fields
    private int id;
    private static int nextId = 1;
    private String value;

   // Class constructors
    public JobField() {
        id = nextId;
        nextId++;
    }
    public JobField(String Value) {
        this();
        this.value = Value;
    }

    //Custom Override Methods
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
