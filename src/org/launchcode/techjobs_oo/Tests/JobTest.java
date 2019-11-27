package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class JobTest {
    Job testJobOne;
    Job testJobTwo;
    Job testJobThree;
    Employer testEmployer;
    Location testLocation;
    PositionType testPositionType;
    CoreCompetency testCoreCompetency;


    @Before
    public void createJobObject() {
        testJobOne = new Job();
        testJobTwo = new Job();
        testJobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    }

    @Test
    //checks to see if the Id for the next Job is one more than the Id for the first Job
    public void testSettingJobId() {
        assertTrue(testJobOne.getId()==(testJobTwo.getId()-1));
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
}
