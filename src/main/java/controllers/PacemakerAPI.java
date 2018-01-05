package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.util.Collection;
import java.util.List;

interface PacemakerInterface
{
    @GET("/users")
    Call<List<User>> getUsers();

    @POST("/users")
    Call<User> registerUser(@Body User User);

    @GET("/users/{id}/activities")
    Call<List<Activity>> getActivities(@Path("id") String id);

    @POST("/users/{id}/activities")
    Call<Activity> addActivity(@Path("id") String id, @Body Activity activity);

    @GET("/users/{id}/activities/{activityId}")
    Call<Activity> getActivity(@Path("id") String id, @Path("activityId") String activityId);

    @POST("/users/{id}/activities/{activityId}/locations")
    Call<Location> addLocation(@Path("id") String id, @Path("activityId") String activityId, @Body Location location);

    @DELETE("/users")
    Call<User> deleteUsers();

    @DELETE("/users/{id}")
    Call<User> deleteUser(@Path("id") String id);

    //
    @GET("/users/{id}")
    Call<User> getUser(@Path("id") String id);

    @DELETE("/users/{id}/activities")
    Call<String> deleteActivities(@Path("id") String id);

    @GET("/users/{id}/activities/{activityId}/locations")
    Call<List<Location>> getLocations(@Path("id") String id, @Path("activityId") String activityId);

    //friendlist commands
    @POST("/users/{id}/friendlist/{email}")
    Call<FriendList> addFriend(@Path("email") String email);

    @DELETE("/users/{id}/friendlist/{email}")
    Call<FriendList> unfollowFriend(@Path("email") String email);

    @GET("/users/{id}/friendlist/{email}")
    Call<List<FriendList>> getFriendsList(@Path("email") String email);

    //messages
    @GET("/users/{id}/friendlist/{email}/message")
    Call<List<Message>> getMessages(@Path("id") String email);

    //@GET("/users/{id}/messages/")
    //Call<List<FriendList>> listMessages(@Path("id") String id);

    //Send a message to a friend
    @POST("/users/{id}/friendlist/{email}/message")
    Call<Message> messageFriend(@Path("email") String email, @Path("message") String message);

}


public class PacemakerAPI {

    PacemakerInterface pacemakerInterface;

    public PacemakerAPI(String url) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        pacemakerInterface = retrofit.create(PacemakerInterface.class);
    }

    public Collection<User> getUsers() {
        Collection<User> users = null;
        try {
            Call<List<User>> call = pacemakerInterface.getUsers();
            Response<List<User>> response = call.execute();
            users = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }


    public User createUser(String firstName, String lastName, String email, String password) {
        User returnedUser = null;
        try {
            Call<User> call = pacemakerInterface.registerUser(new User(firstName, lastName, email, password));
            Response<User> response = call.execute();
            returnedUser = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return returnedUser;
    }

    public Activity createActivity(String id, String type, String location, double distance) {
        Activity returnedActivity = null;
        try {
            Call<Activity> call = pacemakerInterface.addActivity(id, new Activity(type, location, distance));
            Response<Activity> response = call.execute();
            returnedActivity = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return returnedActivity;
    }

    public Activity getActivity(String userId, String activityId) {
        Activity activity = null;
        try {
            Call<Activity> call = pacemakerInterface.getActivity(userId, activityId);
            Response<Activity> response = call.execute();
            activity = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return activity;
    }

    public Collection<Activity> getActivities(String id) {
        Collection<Activity> activities = null;
        try {
            Call<List<Activity>> call = pacemakerInterface.getActivities(id);
            Response<List<Activity>> response = call.execute();
            activities = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return activities;
    }
    /*
    public List<Activity> listActivities(String userId, String sortBy) {
    List<Activity> activities = new ArrayList<>();
    activities.addAll(userIndex.get(userId).activities.values());
    switch (sortBy) {
      case "type":
        activities.sort((a1, a2) -> a1.type.compareTo(a2.type));
        break;
      case "location":
        activities.sort((a1, a2) -> a1.location.compareTo(a2.location));
        break;
      case "distance":
        activities.sort((a1, a2) -> Double.compare(a1.distance, a2.distance));
        break;
    }
    return activities;
  }
     */
    public Collection<Activity> listActivities(String userId, String sortBy) {
        Collection<Activity> activities = null;
        activities.addAll((Collection<? extends Activity>) pacemakerInterface.getActivities(userId));
        try {
            switch (sortBy) { //fix sorting
                case "type":
                    //activities.sort((a1, a2) -> a1.type.)
                    break;
                case "location":
                    //activities.
                    break;
                case "distance":
                    //activities.
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return activities;
    }

    public void addLocation(String id, String activityId, double latitude, double longitude) {
        try {
            Call<Location> call = pacemakerInterface.addLocation(id, activityId, new Location(latitude, longitude));
            call.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public User getUserByEmail(String email) {
        Collection<User> users = getUsers();
        User foundUser = null;
        for (User user : users) {
            if (user.email.equals(email)) {
                foundUser = user;
            }
        }
        return foundUser;
    }

    public User getUser(String id) {
        User user = null;
        try {
            Call<User> call = pacemakerInterface.getUser(id);
            Response<User> response = call.execute();
            user = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public void deleteUsers() {
        try {
            Call<User> call = pacemakerInterface.deleteUsers();
            call.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public User deleteUser(String id) {
        User user = null;
        try {
            Call<User> call = pacemakerInterface.deleteUser(id);
            Response<User> response = call.execute();
            user = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public void deleteActivities(String id) {
        try {
            Call<String> call = pacemakerInterface.deleteActivities(id);
            call.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Location> getLocations(String id, String activityId) {
        List<Location> locations = null;
        try {
            Call<List<Location>> call = pacemakerInterface.getLocations(id, activityId);
            Response<List<Location>> response = call.execute();
            locations = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return locations;
    }

    //Friend functionality
    //Follow friend
    /*
    public void addLocation(String id, String activityId, double latitude, double longitude) {
        try {
            Call<Location> call = pacemakerInterface.addLocation(id, activityId, new Location(latitude, longitude));
            call.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    */
    public void addFriend(String email) {
        try {
            Call<FriendList> call = pacemakerInterface.addFriend(email);
            Response<FriendList> response = call.execute();
            response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void unfollowFriend(String email) {
        try {
            Call<FriendList> call = pacemakerInterface.unfollowFriend(email);
            Response<FriendList> response = call.execute();
            response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /*
    public Collection<Activity> getActivities(String id) {
        Collection<Activity> activities = null;
        try {
            Call<List<Activity>> call = pacemakerInterface.getActivities(id);
            Response<List<Activity>> response = call.execute();
            activities = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return activities;
    }
    */
    //method to get friends list
    public Collection<FriendList> getFriendsList(String email) {
        Collection<FriendList> friends = null;
        try {
            Call<List<FriendList>> call = pacemakerInterface.getFriendsList(email);
            Response<List<FriendList>> response = call.execute();
            friends = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return friends;
    }

    //message commands
    //get messages
    public Collection<Message> getMessages(String email) {
        Collection<Message> messages = null;
        try {
            Call<List<Message>> call = pacemakerInterface.getMessages(email);
            Response<List<Message>> response = call.execute();
            messages = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return messages;
    }

    //message a friend
    public void messageFriend(String email, String message) {
        try {
            Call<Message> call = pacemakerInterface.messageFriend(email, message);
            call.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Activity reports
}

