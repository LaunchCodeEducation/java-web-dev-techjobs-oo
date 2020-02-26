package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

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

    @Override
    public String toString(){

        if(this.name.isEmpty()){
            return "ID: " + this.id + " \n" +
                    "Name: Data not available \n" +
                    "Employer: " + this.employer + " \n" +
                    "Location: " + this.location + " \n" +
                    "Position Type: " + this.positionType + " \n" +
                    "Core Competency: " + this.coreCompetency + " ";
        } else if(this.employer.getValue().isEmpty()){
            return "ID: " + this.id + " \n" +
                    "Name: " + this.name + " \n" +
                    "Employer: Data not available \n" +
                    "Location: " + this.location + " \n" +
                    "Position Type: " + this.positionType + " \n" +
                    "Core Competency: " + this.coreCompetency + " ";
        } else if(this.location.getValue().isEmpty()){
            return "ID: " + this.id + " \n" +
                    "Name: " + this.name + " \n" +
                    "Employer: " + this.employer + " \n" +
                    "Location: Data not available \n" +
                    "Position Type: " + this.positionType + " \n" +
                    "Core Competency: " + this.coreCompetency + " ";
        } else if(this.positionType.getValue().isEmpty()){
            return "ID: " + this.id + " \n" +
                    "Name: " + this.name + " \n" +
                    "Employer: " + this.employer + " \n" +
                    "Location: " + this.location + " \n" +
                    "Position Type: Data not available \n" +
                    "Core Competency: " + this.coreCompetency + " ";
        } else if(this.coreCompetency.getValue().isEmpty()){
            return "ID: " + this.id + " \n" +
                    "Name: " + this.name + " \n" +
                    "Employer: " + this.employer + " \n" +
                    "Location: " + this.location + " \n" +
                    "Position Type: " + this.positionType + " \n" +
                    "Core Competency: Data not available ";
        } else {
            return "ID: " + this.id + " \n" +
                    "Name: " + this.name + " \n" +
                    "Employer: " + this.employer + " \n" +
                    "Location: " + this.location + " \n" +
                    "Position Type: " + this.positionType + " \n" +
                    "Core Competency: " + this.coreCompetency + " ";
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
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

    public int getId() {
        return id;
    }
}
