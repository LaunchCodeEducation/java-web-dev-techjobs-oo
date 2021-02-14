package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import java.util.Objects;

import static org.junit.Assert.*;

public class JobTest {
    Job myTestJob ;
    Job myTestJob2 ;

    @Before
    public void createJobs() {
        myTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        myTestJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String.valueOf(myTestJob);
    }

    @Test
 public void testSettingJobId() {
        assertEquals(1, myTestJob2.getId() - myTestJob.getId(),.001);

    }
    @Test
    public void testJobConstructorSetsAllFields(){
        myTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(myTestJob instanceof org.launchcode.techjobs_oo.Job);
        assertEquals("ACME",String.valueOf(myTestJob.getEmployer()));
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(myTestJob.equals(myTestJob2));

    }
    @Test
    public void testJobToStringStartsWithSpace(){
        assertEquals(" ", myTestJob.toString().substring(0,1));
    }
    @Test
    public void testJobToString(){
               assertEquals(" \n" +
                "id: 8\n" +
                "name: 'Product tester'\n" +
                "employer: ACME\n" +
                "location: Desert\n" +
                "positionType: PositionTypes:{value: Quality control'}\n" +
                "coreCompetency: Persistence " +
                "\n",String.valueOf(myTestJob));
    }
    @Test
    public void testJobToStringEmptyField(){
        myTestJob = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String.valueOf(myTestJob);
        String myTestJobName = myTestJob.toString().substring(myTestJob.toString().indexOf("name: "), myTestJob.toString().indexOf("employer: ")-1);
        assertEquals("name: 'Data not available'", myTestJobName);

    }

}
