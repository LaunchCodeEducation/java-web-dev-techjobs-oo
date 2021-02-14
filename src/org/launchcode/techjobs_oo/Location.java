package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Location extends JobField{

       public Location(String value){
        super(value);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId() == location.getId();
    }
}
