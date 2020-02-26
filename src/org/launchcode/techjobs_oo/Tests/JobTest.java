package org.launchcode.techjobs_oo.Tests;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job test_job1;
    Job test_job2;

    @Before
    public void createJobObject1(){
        test_job1 = new Job("Developer", new Employer("Capacity"), new Location("St. Louis"), new PositionType("Backend Developer"),  new CoreCompetency("Python"));
    }

    @Before
    public void createJobObject2(){
        test_job2 = new Job("Developer", new Employer("Capacity"), new Location("St. Louis"), new PositionType("Frontend Developer"),  new CoreCompetency("Python"));
    }

    @Test
    public void testSettingJobId(){
        assertNotEquals(test_job1, test_job2);
        assertEquals(1, test_job1.getId() - test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", productTester.getName());
        assertEquals("ACME", productTester.getEmployer().getValue());
        assertEquals("Desert", productTester.getLocation().getValue());
        assertEquals("Quality control", productTester.getPositionType().getValue());
        assertEquals("Persistence", productTester.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job designer = new Job("Designer", new Employer("Atomic Dust"), new Location("St. Louis"), new PositionType("Creative"), new CoreCompetency("Good eye"));
        Job designer2 = new Job("Designer", new Employer("Atomic Dust"), new Location("St. Louis"), new PositionType("Creative"), new CoreCompetency("Good eye"));

        assertNotEquals(designer.getId(), designer2.getId());
    }

    @Test
    public void testToStringMethodStartsWithSpace(){
        String jobString = test_job1.toString();
        int indexBeforeName = jobString.indexOf(test_job1.getName()) - 1;

        assertTrue(Character.isWhitespace(indexBeforeName));
    }

    @Test
    public void testToStringMethodEndsWithSpace(){
        String jobString = test_job1.toString();
        char[] jobChars = jobString.toCharArray();
        int lastIndex = jobChars.length-1;

        assertTrue(Character.isWhitespace(jobChars[lastIndex]));
    }

    @Test
    public void testToStringMethodForLabel(){
        String jobString = test_job1.toString();
        int count = StringUtils.countMatches(jobString, ":");

        assertEquals(6, count);
    }

    @Test
    public void testToStringMethodForNewLine(){
        String jobString = test_job1.toString();
        int count = StringUtils.countMatches(jobString, "\n");

        assertEquals(5, count);
    }

    @Test
    public void testToStringDataNotAvailable(){
        Job designer3 = new Job("", new Employer("Atomic Dust"), new Location("St. Louis"), new PositionType("Creative"), new CoreCompetency("Good eye"));
        String jobString = designer3.toString();

        assertTrue(jobString.contains("Name: Data not available "));
    }

}
