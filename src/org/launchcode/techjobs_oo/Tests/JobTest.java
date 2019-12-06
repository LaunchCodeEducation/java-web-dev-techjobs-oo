package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class JobTest{
    Job test_JobA;
    Job test_JobsB;
    Job demoJobA;
    Job demoJobB;
    Job demoJobC;
    Job demoJobD;

    @Before
    public void setUp(){
        test_JobA = new Job();

        test_JobsB = new Job();

        demoJobA = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        demoJobB = new Job("Product Tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        demoJobC = new Job("", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        demoJobD = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
    }

    @Test()
    public void testSettingJobId() {
        assertEquals(test_JobA.getId(), test_JobsB.getId(), 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue( demoJobA instanceof Job);
        assertTrue(demoJobA.getName() instanceof String);
        assertTrue(demoJobA.getEmployer() instanceof Employer);
        assertTrue(demoJobA.getLocation() instanceof Location);
        assertTrue(demoJobA.getPositionType() instanceof PositionType);
        assertTrue(demoJobA.getCoreCompetency() instanceof CoreCompetency);

        //Testing for Field Values
        assertThat("Product Tester", is(demoJobA.getName()));
        assertThat("ACME", is(demoJobA.getEmployer().getValue()));
        assertThat("Desert", is(demoJobA.getLocation().getValue()));
        assertThat("Quality Control", is(demoJobA.getPositionType().getValue()));
        assertThat("Persistence", is(demoJobA.getCoreCompetency().getValue()));

    }

    @Test
    public void testEquals() {
        assertFalse(demoJobA.equals(demoJobB));
    }


    @Test
    public void testToString() {
        assertThat("\n" +
                "ID: " + demoJobB.getId() + "\n" +
                "Name: " + demoJobB.getName() + "\n" +
                "Employer: " + demoJobB.getEmployer() + "\n" +
                "Location: " + demoJobB.getLocation()+ "\n" +
                "Position Type: " + demoJobB.getPositionType().getValue() + "\n" +
                "Core Competency: " + demoJobB.getCoreCompetency() + "\n",is(demoJobB.toString())
        );

        assertThat("\n" +
                "ID: " + demoJobC.getId() + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + demoJobC.getEmployer() + "\n" +
                "Location: " + demoJobC.getLocation()+ "\n" +
                "Position Type: " + demoJobC.getPositionType().getValue() + "\n" +
                "Core Competency: " + demoJobC.getCoreCompetency() + "\n",
                is(demoJobC.toString()));

    }
}
