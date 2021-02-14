package org.launchcode.techjobs_oo;

import java.util.Objects;

public class CoreCompetency extends JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    public CoreCompetency(String value) {
        super(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoreCompetency)) return false;
        CoreCompetency that = (CoreCompetency) o;
        return id == that.id;
    }
}


