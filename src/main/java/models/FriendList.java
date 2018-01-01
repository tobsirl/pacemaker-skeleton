package models;

import com.google.common.base.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class FriendList extends User {

    public String messages;

    public FriendList(String firstName, String lastName, String email, String password, String messages) {
        super(firstName, lastName, email, password);
        this.messages = messages;
    }

    @Override
    public String toString() {
        return toStringHelper(this).addValue(id)
                .addValue(firstname)
                .addValue(lastname)
                .addValue(password)
                .addValue(email)
                .addValue(messages)
                .toString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof FriendList) {
            final FriendList other = (FriendList) obj;
            return Objects.equal(email, other.email);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.email);
    }
}
