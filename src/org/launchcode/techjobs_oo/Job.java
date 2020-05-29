package org.launchcode.techjobs_oo;

import org.junit.Test;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // (done) (TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

     //(done) TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public String toString() {
        String aName = name;
        String aEmployer = this.employer.getValue();
        String aLocation = this.location.getValue();
        String aPositionType = this.positionType.getValue();
        String aCoreCompetency = this.coreCompetency.getValue();
        String noData = "Data not available";

        if (aName == " " || aName == null){
            aName = noData;
        }

        if (aEmployer == " " || aEmployer == null){
            aEmployer = noData;
        }

        if (aLocation == " " || aLocation == null){
            aLocation = noData;
        }

        if (aPositionType == " " || aPositionType == null){
            aPositionType = noData;
        }

        if (aCoreCompetency == " " || aCoreCompetency == null){
            aCoreCompetency = noData;
        }

        return "\n" + "ID: " + this.getId() +
                "\n" + "Name: " + aName +
                "\n" + "Employer: " + aEmployer +
                "\n" + "Location: " + aLocation +
                "\n" + "PositionType: " + aPositionType +
                "\n" + "CoreCompetency: " + aCoreCompetency + "\n";
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId() &&
                Objects.equals(getName(),job.getName()) &&
                Objects.equals(getEmployer(),job.getEmployer()) &&
                Objects.equals(getLocation(),job.getLocation()) &&
                Objects.equals(getPositionType(), job.getPositionType()) &&
                Objects.equals(getCoreCompetency(), job.getCoreCompetency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getName(), getEmployer(), getLocation(), getPositionType(), getCoreCompetency());
    }



    // (done) TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

}
