package org.launchcode.TechJobsOO.Data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.launchcode.TechJobsOO.*;

import java.io.*;
import java.util.List;

public class JobDataImport {
    private static final String DATA_FILE = "resources/job_data.csv";
    private static boolean isDataLoaded = false;

    /**
     * Read in data from a CSV file and store it in a list
     */
    static void loadData(JobData jobData) {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Reader in = new FileReader(DATA_FILE);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            // Put the records into a more friendly format
            for (CSVRecord record : records) {

                String empStr = record.get("employer");
                String locStr = record.get("location");
                String coreCompStr = record.get("core competency");
                String posTypeStr = record.get("position type");

                Employer emp = jobData.getEmployers().findByValue(empStr);
                if (emp == null) {
                    emp = new Employer(empStr);
                    jobData.getEmployers().add(emp);
                }

                Location loc = jobData.getLocations().findByValue(locStr);
                if (loc == null) {
                    loc = new Location(locStr);
                    jobData.getLocations().add(loc);
                }

                PositionType posType = jobData.getPositionTypes().findByValue(posTypeStr);
                if (posType == null) {
                    posType = new PositionType(posTypeStr);
                    jobData.getPositionTypes().add(posType);
                }

                CoreCompetency coreComp = jobData.getCoreCompetencies().findByValue(coreCompStr);
                if (coreComp == null) {
                    coreComp = new CoreCompetency(coreCompStr);
                    jobData.getCoreCompetencies().add(coreComp);
                }

                Job newJob = new Job(record.get("name"), emp, loc, posType, coreComp);

                jobData.add(newJob);
            }

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load job data");
            e.printStackTrace();
        }
    }

}
