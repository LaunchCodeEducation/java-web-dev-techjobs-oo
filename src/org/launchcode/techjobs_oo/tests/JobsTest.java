package org.launchcode.techjobs_oo.tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;


import static org.junit.Assert.*;

public class JobsTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertEquals(job2.getId(), job1.getId() + 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(newJob.getName(), "Product tester");
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(newJob1.equals(newJob));
    }

   @Test
    public void testToString(){
        Job newJob = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJob1 = new Job ("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJob2 = new Job (null, new Employer(null), new Location(null), new PositionType(null), new CoreCompetency(null));
        assertTrue(newJob.toString().startsWith("\n"));
        assertTrue(newJob.toString().endsWith("\n"));
        assertEquals(newJob1.toString(), "\n" +
                    "\n" + "ID: " + newJob1.getId() +
                    "\n" + "Name: " + newJob1.getName() +
                    "\n" + "Employer: " + "Data not available" +
                    "\n" + "Location: " + newJob1.getLocation() +
                    "\n" + "PositionType: " + newJob1.getPositionType() +
                    "\n" + "CoreCompetency: " + newJob1.getCoreCompetency() + "\n");
        assertEquals(newJob2.toString(), "OOPS! This job does not seem to exist.");
   }

}

