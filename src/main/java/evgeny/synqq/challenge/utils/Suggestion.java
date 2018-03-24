package evgeny.synqq.challenge.utils;

import evgeny.synqq.challenge.people.Person;

public class Suggestion {

    private final double distance;
    private final Person person;

    public Suggestion(double distance, Person person) {
        this.distance = distance;
        this.person = person;
    }

    public double getDistance() {
        return distance;
    }

    public Person getPerson() {
        return person;
    }
}
