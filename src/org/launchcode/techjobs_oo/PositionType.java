package org.launchcode.techjobs_oo;

import java.util.Objects;

public class PositionType extends JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    public PositionType(String value) {
        super(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionType)) return false;
        PositionType that = (PositionType) o;
        return id == that.id && Objects.equals(value, that.value);
    }
}
