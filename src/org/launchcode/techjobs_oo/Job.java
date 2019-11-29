package org.launchcode.techjobs_oo;

import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // Added two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor also calls the first in order to initialize
    //  the 'id' field.
    public Job () {
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

    // Added custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // Added getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

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
//Custom toString method
    @Override
    public String toString() {
        ArrayList<Object> jobInfo = new ArrayList<Object>();
        jobInfo.add(this.getEmployer().getValue());
        jobInfo.add(this.getLocation().getValue());
        jobInfo.add(this.getPositionType().getValue());
        jobInfo.add(this.getCoreCompetency().getValue());

        ArrayList<String> fieldLabels = new ArrayList<String>();
        fieldLabels.add("\n Employer: ");
        fieldLabels.add("\n Location: ");
        fieldLabels.add("\n Position Type: ");
        fieldLabels.add("\n Core Competency: ");

        String jobListing = "\n ID: " + this.getId() +
                "\n Name: " + this.getName();

//iterates through both ArrayLists to return correct label and value
        for (int i = 0; i <fieldLabels.size(); i++) {
            if (!(jobInfo.get(i) == "")) {
                jobListing += fieldLabels.get(i) + jobInfo.get(i);
            } else {
                jobListing += fieldLabels.get(i) + "Data not available";
            }
        }
        return jobListing + '\n';
    }
}
