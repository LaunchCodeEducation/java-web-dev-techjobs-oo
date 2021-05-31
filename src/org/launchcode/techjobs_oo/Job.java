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

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields.
    public Job() {
        id = nextId;
        nextId++;
    }
    public Job(String name,Employer employer,Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public String toString(){
        //Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
               //new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //Job job2 = new Job();
        //Job[] jobs = {job1,job2};
//        String testJobName = job1.getName();
//        String testEmployer = job1.getEmployer().getValue();
//        String testLocation = job1.getLocation().getValue();
//        String testPositionType = job1.getPositionType().getValue();
//        String testCoreCompetency = job1.getCoreCompetency().getValue();
        String output = "";
        if(name == null || name.isEmpty()) {
           output += '\n' + "ID: " + id + '\n' + "Job Name: " + "Data not available";
        }else{ output += '\n' + "ID: " + id + '\n'+ "Job Name: " + name ;}
        if(employer == null || employer.getValue().isEmpty()){
            output += '\n' + "Employer: " + "Data not available";
        }else{ output += '\n' + "Employer: " + employer.getValue() ;}
        if(location == null || location.getValue().isEmpty()){
            output += '\n' + "Location: " + "Data not available";
        }else{ output += '\n' + "Location: " + location.getValue();}
        if(positionType == null || positionType.getValue().isEmpty()){
            output += '\n' + "PositionType: " + "Data not available";
        }else{ output += '\n' + "Position Type: " + positionType.getValue();}
        if(coreCompetency == null || coreCompetency.getValue().isEmpty()){
            output += '\n' + "CoreCompetency: " + "Data not available" + '\n';
        }else{ output += '\n' + "Core Competency: " + coreCompetency.getValue() + '\n';}
        return output;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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
}
