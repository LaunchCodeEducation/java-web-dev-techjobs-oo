package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job test_JobA = new Job();
    Job test_JobsB = new Job();

    @Before
    public void setUp(){
        this.test_JobA = new Job();
        this.test_JobsB = new Job();
    }

    @Test()
    public void testSettingJobId() {
        assertEquals(test_JobA.getId(), test_JobsB.getId(), 1);
        System.out.println(test_JobA.getId());
        System.out.println(test_JobsB.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job demoJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals(true, demoJob instanceof Job);
    }
}
