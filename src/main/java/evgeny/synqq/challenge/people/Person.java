package evgeny.synqq.challenge.people;

public class Person {

    private Name firstName;
    private Name secondName;

    public Person(String name) {
        String[] split = name.split(" ");
        firstName = new Name(split[0]);
        if (split.length > 1) {
            secondName = new Name(split[1]);
        }
    }

    public Person(Name firstName, Name secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Name getFirstName() {
        return firstName;
    }

    public void setFirstName(Name firstName) {
        this.firstName = firstName;
    }

    public Name getSecondName() {
        return secondName;
    }

    public void setSecondName(Name secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        if (getSecondName() == null) {
            return getFirstName().toString();
        } else {
            return getFirstName() + " " + getSecondName();
        }
    }
}
