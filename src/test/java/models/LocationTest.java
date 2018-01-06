package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static models.Fixtures.locations;

public class LocationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreate() {
        assertEquals(0.01, 23.3, locations.get(0).latitude);
        assertEquals(0.01, 33.3, locations.get(0).longitude);
    }

    @Test
    public void getId() {
    }

    @Test
    public void getLongitude() {
    }

    @Test
    public void getLatitude() {
    }

    @Test
    public void equals() {
    }

    @Test
    public void testToString() {
        assertEquals("Location{" + locations.get(0).id + ", 23.3, 33.3}", locations.get(0).toString());
    }
    /*
    @Test
    public void hashCode() {
    }
    */
}