package org.launchcode.techjobs_oo.Tests;

import org.junit.After;
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

    //TODO: Remove before merging to master.
    @After
    public void done() {
        System.out.println("Test completed!");
    }

    @Test()
    public void testSettingJobId() {
        assertEquals(test_JobA.getId(), test_JobsB.getId(), 1);

        //TODO Take out before merging to master
//        assertThat("Job IDs are equal", test_JobA.getId(),is(not(test_JobsB.getId())));

        //TODO Take out before merging to master
        //System.out.println(test_JobA.getId());

        //TODO Take out before merging to master
        //System.out.println(test_JobsB.getId());
    }

    @Test
    //TODO: Shouldn't the setters also be tested here as well?? Or is this test testing both the getters and setters?

    //TODO: Why not just use assertNotNull statements instead of assertTrue statements?
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
        int demoA_ID = demoJobA.getId();
        int demoB_ID = demoJobB.getId();
        assertThat("Should not be equal",demoA_ID,is(not(demoB_ID)));

        //TODO Take out before merging to master. Ask questions first
        //*Just want clarification on the three test below as far as if and how each differs from one another*

        //assertThat("Should not be equal",demoA_ID,is(not(demoB_ID)));

        /*What does the ! mean in this line below? IntelliJ generated this for me, and got me curious*/
        //assertFalse(!(demoA_ID != demoB_ID));

        //assertFalse(demoA_ID == demoB_ID);
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

        //TODO: Why is it the test below pass only when there's a print statement above it?
        //TODO: Is this how it's suppose to be, or did I do something wrong in the test or toString() in Jobs.java?
        System.out.println(demoJobC);

        assertThat("\n" +
                "ID: " + demoJobC.getId() + "\n" +
                "Name: " + demoJobC + "\n" +
                "Employer: " + demoJobC.getEmployer() + "\n" +
                "Location: " + demoJobC.getLocation()+ "\n" +
                "Position Type: " + demoJobC.getPositionType().getValue() + "\n" +
                "Core Competency: " + demoJobC.getCoreCompetency() + "\n",
                containsString("Data not available"));

//
//                assertEquals("\n" +
//                "ID: " + demoJobC.getId() + "\n" +
//                "Name: " + demoJobC.getName() + "\n" +
//                "Employer: " + demoJobC.getEmployer().getValue() + "\n" +
//                "Location: " + demoJobC.getLocation().getValue() + "\n" +
//                "Position Type: " + demoJobC.getPositionType().getValue() + "\n" +
//                "Core Competency: " + demoJobC.getCoreCompetency().getValue() + "\n",
//                demoJobC.toString()
//        );

        //TODO: Attempt bonus one lat time before merge to master.
        /*For Bonus, but can't figure out how to make my conditionals work to return "OOPS! This job does not exist."
        Instead conditionals just force "Data not available for all fields. Attempted to loop w/conditional, and failed
         */
//        assertEquals("\n" +
//                        "ID: " + demoJobD.getId() + "\n" +
//                        "Name: " + demoJobD.getName() + "\n" +
//                        "Employer: " + demoJobD.getEmployer().getValue() + "\n" +
//                        "Location: " + demoJobD.getLocation().getValue() + "\n" +
//                        "Position Type: " + demoJobD.getPositionType() + "\n" +
//                        "Core Competency: " + demoJobD.getCoreCompetency().getValue() + "\n",
//                        demoJobD.toString().equals("Data not available")
//        );
    }
}
