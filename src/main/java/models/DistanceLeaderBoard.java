package models;

import com.google.common.base.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class DistanceLeaderBoard {

    public String name;
    public double distance;

    public DistanceLeaderBoard(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return toStringHelper(this).addValue(name)
                .addValue(distance)
                .toString();
    }
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof DistanceLeaderBoard) {
            final DistanceLeaderBoard other = (DistanceLeaderBoard) obj;
            return Objects.equal(name, other.name)
                    && Objects.equal(distance, other.distance);

        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.distance);
    }

}
