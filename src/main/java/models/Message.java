package models;

import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Message implements Serializable{

    public String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Message) {
            final Message other = (Message) obj;
            return Objects.equal(message, other.message);

        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return toStringHelper(this).addValue(message)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.message);
    }

}
