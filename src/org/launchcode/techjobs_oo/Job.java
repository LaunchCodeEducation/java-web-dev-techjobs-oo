package org.launchcode.techjobs_oo;

import java.util.*;

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
        //creates HashMap with labels and values
        LinkedHashMap<String, Object> jobInfo = new LinkedHashMap<>();
        jobInfo.put("\n Employer: ", this.getEmployer().getValue());
        jobInfo.put("\n Location: ", this.getLocation().getValue());
        jobInfo.put("\n Position Type: ", this.getPositionType().getValue());
        jobInfo.put("\n Core Competency: ", this.getCoreCompetency().getValue());

        //initiates what will eventually be printed as the complete job listing
        String jobListing = "\n ID: " + this.getId() +
                "\n Name: " + this.getName();

//iterates through HashMap to return correct label and value
        for (Map.Entry<String, Object> aJob : jobInfo.entrySet()) {
            if (!(aJob.getValue() == "")) {
                jobListing += aJob.getKey() + aJob.getValue();
            } else {
                jobListing += aJob.getKey() + "Data not available";
            }
        }
        return jobListing + '\n';
    }
}
