package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

/*
Assignment 2 for LC101-Jan 2021
Turning TechJobsConsole into an OOP project in Java
**by  Claire Patterson
 */


public class JobTest {
//    Job testJob;
//    @Before
//    public void createJob(){
//        Job job1 = new Job();
//        Job allFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
//            new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
//                new PositionType("Quality control"), new CoreCompetency("Persistence"));
//    };

    //Test 1--Check to see that the constructor sets each job a unique id.
    //Create 2 instances of the Job class to test it's id method.
    //Test that the id's created are sequential integers(one value between them)and that they are
    //not the same integer.If subtracting one integer from the other = 0, it means the id's are
    //the same. If they are not the same number, and sequential,the expected result is 1 and the id
    //method correctly sets a unique id.
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertEquals(1, job2.getId() - job1.getId());
    }

    //Test 2-check to see that the full constructor sets the six job fields
    //correctly.Create a Job object and test that each value is set equal
    //to the given parameters.We have to test each value individually.
    @Test
    public void testJobConstructorSetsAllFields() {
        Job allFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(allFields instanceof Job);//test that allFields has been created as an instance of Job class? necessary?
        assertEquals("Product tester", allFields.getName());
        assertEquals("ACME", allFields.getEmployer().getValue());
        assertEquals("Desert", allFields.getLocation().getValue());
        assertEquals("Quality control", allFields.getPositionType().getValue());
        assertEquals("Persistence", allFields.getCoreCompetency().getValue());

    }

    //Test that the equals method returns false because the two jobs created should
    //have different ids,even though the other fields are identical, but that is irrelevant:p
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
               new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    //Test that the toString() method will take in a Job object
    //and return a blank line before and after the job information.
    @Test
    public void firstToStringTest() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testOutput = job1.toString();
        assertEquals('\n', testOutput.charAt(0));
        assertEquals('\n', testOutput.charAt(testOutput.length() - 1));

    }

    //In addition to a blank line above and below the information,the toString()
    //method should also create a label for each field, followed by the data
    //stored in that field. Each field should be on its own line.
    @Test
    public void secondToStringTest() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n' + "ID: " + job1.getId() + '\n' + "Job Name: " + job1.getName() + '\n'
                + "Employer: " + job1.getEmployer() + '\n' + "Location: " + job1.getLocation() +
                '\n' + "Position Type: " + job1.getPositionType() + '\n' + "Core Competency: "
                + job1.getCoreCompetency() + '\n', job1.toString());
    }

    //If a field is empty the toString() method should add "Data not available"
    //after the label.
    @Test
    public void thirdToStringTest() {
        Job job1 = new Job();
        String output = job1.toString();
        String test3 = job1.getName();
        assertTrue(output.contains("Data not available"));
        assertEquals(null,test3);
        assertEquals('\n'+"ID: 4"+'\n'+"Job Name: Data not available"+'\n'+"Employer: Data not available"+'\n'+
                "Location: Data not available"+'\n'+"PositionType: Data not available"+'\n'+
                "CoreCompetency: Data not available"+'\n',output);
    }


















































}


