package org.launchcode.TechJobsOO.Data;

import org.launchcode.TechJobsOO.*;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobData {

    private ArrayList<Job> jobs = new ArrayList<>();
    private static JobData instance;

    private JobFieldData<Employer> employers = new JobFieldData<>();
    private JobFieldData<Location> locations = new JobFieldData<>();
    private JobFieldData<CoreCompetency> coreCompetencies = new JobFieldData<>();
    private JobFieldData<PositionType> positionTypes = new JobFieldData<>();


    private JobData() {
        JobDataImport.loadData(this);
    }


    public static JobData getInstance() {
        if (instance == null) {
            instance = new JobData();
        }
        return instance;
    }

    public Job findById(int id) {
        for (Job job : jobs) {
            if (job.getId() == id)
                return job;
        }

        return null;
    }

    public ArrayList<Job> findAll() {
        return jobs;
    }

    public void printAllJobs(){
        for (Job job : jobs){
            System.out.println(job);
        }
    }

//    public ArrayList<Job> findByColumnAndValue(JobFieldType column, String value) {
//
//        ArrayList<Job> matchingJobs = new ArrayList<>();
//
//        for (Job job : jobs) {
//            if (getFieldByType(job, column).contains(value))
//                matchingJobs.add(job);
//        }
//
//        return matchingJobs;
//    }


//    public ArrayList<Job> findByValue(String value) {
//
//        ArrayList<Job> matchingJobs = new ArrayList<>();
//
//        for (Job job : jobs) {
//
//            if (job.getName().toLowerCase().contains(value)) {
//                matchingJobs.add(job);
//                continue;
//            }
//
//            for (JobFieldType column : JobFieldType.values()) {
//                if (column != JobFieldType.ALL && getFieldByType(job, column).contains(value)) {
//                    matchingJobs.add(job);
//                    break;
//                }
//            }
//        }
//
//        return matchingJobs;
//    }


    public void add(Job job) {
        jobs.add(job);
    }


//    private static JobField getFieldByType(Job job, JobFieldType type) {
//        switch(type) {
//            case EMPLOYER:
//                return job.getEmployer();
//            case LOCATION:
//                return job.getLocation();
//            case CORE_COMPETENCY:
//                return job.getCoreCompetency();
//            case POSITION_TYPE:
//                return job.getPositionType();
//        }
//
//        throw new IllegalArgumentException("Cannot get field of type " + type);
//    }

    public JobFieldData<Employer> getEmployers() {
        return employers;
    }

    public JobFieldData<Location> getLocations() {
        return locations;
    }

    public JobFieldData<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public JobFieldData<PositionType> getPositionTypes() {
        return positionTypes;
    }
}
