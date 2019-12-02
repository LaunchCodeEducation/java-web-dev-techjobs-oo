package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class JobTest extends Job {
    Job test_JobA;
    Job test_JobsB;
    Job demoJobA;
    Job demoJobB;

    @Before
    public void setUp(){
        test_JobA = new Job();
        test_JobsB = new Job();
        demoJobA = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        demoJobB = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));

    }

    @Test()
    public void testSettingJobId() {
        assertEquals(test_JobA.getId(), test_JobsB.getId(), 1);
        assertThat("Job IDs are NOT equal", test_JobA.getId(),is(not(test_JobsB.getId())));
        System.out.println(test_JobA.getId());
        System.out.println(test_JobsB.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(true, demoJobA instanceof Job);
    }

    @Test
    public void testEquals() {
       assertFalse(demoJobA.equals(demoJobB));
    }
}
