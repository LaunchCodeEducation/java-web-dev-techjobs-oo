package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;

import org.junit.Test;
import org.launchcode.techjobs_oo.Job;

import static org.junit.Assert.*;

public class JobTest extends Job {
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

}
