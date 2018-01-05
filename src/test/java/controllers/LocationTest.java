package controllers;

import models.Location;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {

    PacemakerAPI pacemaker = new PacemakerAPI("https://pacific-castle-57153.herokuapp.com/");
    User homer = new User("homer", "simpson", "homer@simpson.com", "secret");

    @Before
    public void setup() {
        pacemaker.deleteUsers();
        homer = pacemaker.createUser(homer.firstname, homer.lastname, homer.email, homer.password);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestAddLocation(String id, String activityId, double latitude, double longitude) {
        Location location = new Location(12.0, 33.0);
    }

}
