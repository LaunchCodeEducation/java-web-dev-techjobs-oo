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
        assertThat("Job IDs are equal", test_JobA.getId(),is(not(test_JobsB.getId())));
        System.out.println(test_JobA.getId());
        System.out.println(test_JobsB.getId());
    }

    @Test
    //Shouldn't the setters also be tested here as well?? Or is this test testing both the getters and setters?
    public void testJobConstructorSetsAllFields() {
        assertTrue( demoJobA instanceof Job);
        assertTrue(demoJobA.getName() instanceof String);
        assertTrue(demoJobA.getEmployer() instanceof Employer);
        assertTrue(demoJobA.getLocation() instanceof Location);
        assertTrue(demoJobA.getPositionType() instanceof PositionType);
        assertTrue(demoJobA.getCoreCompetency() instanceof CoreCompetency);



    }

    @Test
    //Why does this test even exist, isn't it pretty much the same as "testSettingJobId()"????
    public void testEquals() {
        int demoA_ID = demoJobA.getId();
        int demoB_ID = demoJobB.getId();
        assertThat("Should not be equal",demoA_ID,is(not(demoB_ID)));

        //*Just want clarification on the three test in this block*
        //assertFalse(!(demoA_ID != demoB_ID));
        //assertFalse(demoA_ID == demoB_ID);
    }
}
