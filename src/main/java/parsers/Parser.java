package parsers;

import models.Activity;
import models.FriendList;
import models.Location;
import models.User;

import java.util.Collection;
import java.util.List;

public class Parser {

    public void println(String s) {
        System.out.println(s);
    }

    public void renderUser(User user) {
        System.out.println(user.toString());
    }

    public void renderUsers(Collection<User> users) {
        System.out.println(users.toString());
    }

    public void renderActivity(Activity activities) {
        System.out.println(activities.toString());
    }

    public void renderActivities(Collection<Activity> activities) {
        System.out.println(activities.toString());
    }

    public void renderLocations(List<Location> locations) {
        System.out.println(locations.toString());
    }

    //render friends
    public void renderFriends(List<FriendList> friendLists) {
        System.out.println(friendLists.toString());
    }
}
