package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/*
Assignment 2 for LC101-Jan 2021
**by  Claire Patterson
**Due May 24th, 2021
 */


public class JobTest {

    //Test 1--check to see that the constructor sets each job a unique id.
    //create 2 instances of the Job class to test it's id method.
    //Test that they are sequential integers (one value between them) and they are not the same.
    // (if not 0, they are not the same number)

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertEquals(1,job2.getId()-job1.getId());
    }

    //Test 2-check to see that the full constructor sets the six job fields
    //correctly.
    @Test
    public void testJobConstructorSetsAllFields() {
        Job allFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester",allFields.getName());
        assertEquals("ACME", allFields.getEmployer().getValue());
        assertEquals("Desert", allFields.getLocation().getValue());
        assertEquals("Quality control", allFields.getPositionType().getValue());
        assertEquals("Persistence", allFields.getCoreCompetency().getValue());

    }

    //Test 3-test that two jobs created have identical fields
    //except for id. Test that the equals method returns false.
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.equals(job2.getId()));
    }

}


