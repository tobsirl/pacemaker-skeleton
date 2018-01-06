package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActivityTest {

    Activity test = new Activity("walk", "fridge", 0.001);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreate() {
        assertEquals("walk", test.type);
        assertEquals("fridge", test.location);
        assertEquals(0.0001, 0.001, test.distance);
    }

    @Test
    public void getType() {
    }

    @Test
    public void getLocation() {
    }

    @Test
    public void getDistance() {
    }
}