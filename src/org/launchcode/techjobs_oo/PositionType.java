package org.launchcode.techjobs_oo;

import java.util.Objects;

public class PositionType extends JobField {

    public PositionType(String value) {
        super(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionType)) return false;
        PositionType that = (PositionType) o;
        return getId() == that.getId() && Objects.equals(getValue(), that.getValue());
    }
}
