package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;

public class JobTest {
    Job testJobOne;
    Job testJobTwo;
    Job testJobThree;
    Job testJobFour;
    Job testJobFive;
    Employer testEmployer;
    Location testLocation;
    PositionType testPositionType;
    CoreCompetency testCoreCompetency;


    @Before
    public void createJobObject() {
        testJobOne = new Job();
        testJobTwo = new Job();
        testJobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        testJobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        testJobFive = new Job("Guinea Pig", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency("Persistence"));
    }

    @Test
    //checks to see if the Id for the next Job is one more than the Id for the first Job
    public void testSettingJobId() {
        assertEquals(testJobOne.getId(), (testJobTwo.getId() - 1));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        //Tests to make sure classes are assigned correctly
        assertTrue(testJobThree.getEmployer()instanceof Employer);
        assertTrue(testJobThree.getLocation()instanceof Location);
        assertTrue(testJobThree.getPositionType()instanceof PositionType);
        assertTrue(testJobThree.getCoreCompetency()instanceof CoreCompetency);

        //Tests to make sure the values are set correctly
        assertEquals("Product tester", testJobThree.getName());
        assertEquals("ACME", testJobThree.getEmployer().getValue());
        assertEquals("Desert", testJobThree.getLocation().getValue());
        assertEquals("Quality Control", testJobThree.getPositionType().getValue());
        assertEquals("Persistence", testJobThree.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        //tests to make sure the Id numbers are different even though everything else is the same
        assertFalse(testJobThree==testJobFour);
    }

    @Test
    public void toStringHasBlankLines() {
        //tests that there is a blank line before and after job listing
        assertThat( testJobThree.toString(), containsString("\n ID: " + testJobThree.getId()));
        assertThat( testJobThree.toString(), containsString("Core Competency: " + testJobThree.getCoreCompetency().getValue() + "\n"));
    }

    @Test
    public void toStringReturnsJobInfo() {
        //tests to make sure the toString method returns a label and job info for each field
        String expectedString = "\n ID: " + testJobThree.getId() +
                "\n Name: " + testJobThree.getName() +
                "\n Employer: " + testJobThree.getEmployer().getValue() +
                "\n Location: " + testJobThree.getLocation().getValue() +
                "\n Position Type: " + testJobThree.getPositionType().getValue() +
                "\n Core Competency: " + testJobThree.getCoreCompetency().getValue() + "\n";
        assertEquals(expectedString, testJobThree.toString());
    }

    @Test
    public void emptyFieldTest() {
        //tests to see if “Data not available” is returned for empty fields
        assertThat(testJobFive.toString(), containsString("Data not available"));
    }
}
