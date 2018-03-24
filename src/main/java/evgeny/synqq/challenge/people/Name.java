package evgeny.synqq.challenge.people;

public class Name {

    private final String name;
    private final Person person;

    public Name(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return getName();
    }
}
