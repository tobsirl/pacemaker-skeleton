package controllers;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static models.Fixtures.users;
import static org.junit.Assert.assertEquals;

public class UserTest {

    PacemakerAPI pacemaker = new PacemakerAPI("https://pacific-castle-57153.herokuapp.com/");
    User homer = new User("homer", "simpson", "homer@simpson.com", "secret");

    @Before
    public void setup() {
        pacemaker.deleteUsers();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateUser() {
        User user = pacemaker.createUser(homer.firstname, homer.lastname, homer.email, homer.password);
        assertEquals(user, homer);
        User user2 = pacemaker.getUserByEmail(homer.email);
        assertEquals(user2, homer);
    }

    @Test
    public void testCreateUsers() {
        users.forEach(
                user -> pacemaker.createUser(user.firstname, user.lastname, user.email, user.password));
        Collection<User> returnedUsers = pacemaker.getUsers();
        assertEquals(users.size(), returnedUsers.size());
    }

    @Test
    public User testGetUserByEmail(String email) {
        return User;
    }

    @Test
    public User testGetUser(String id) {
        return User;
    }

    @Test
    public void testDeleteUsers() {

    }
    @Test
    public User testDeleteUser(String id) {
        return User;
    }

    @Test
    public void testToString() {
        assertEquals("User{" + homer.id + ", homer, simpson, secret, homer@simpson.com}",
                homer.toString());
    }
}