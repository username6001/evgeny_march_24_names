package evgeny.synqq.challenge.utils;

import evgeny.synqq.challenge.people.Name;

public class SuggestionName {

    private final double distance;
    private final Name name;

    public SuggestionName(double distance, Name name) {
        this.distance = distance;
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public Name getName() {
        return name;
    }
}
