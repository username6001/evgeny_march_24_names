package evgeny.synqq.challenge;

import evgeny.synqq.challenge.people.Name;
import evgeny.synqq.challenge.people.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Context {

    private final List<Person> people;
    private final List<Name> names;

    public Context(String context) {
        people = Stream.of(context.split("\n"))
                .map(Person::new)
                .collect(Collectors.toList());
        names = people.stream()
                .flatMap(p -> p.getSecondName() != null ? Arrays.asList(p.getFirstName(), p.getSecondName()).stream()
                        : Arrays.asList(p.getFirstName()).stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public Context(List<Person> people, List<Name> names) {
        this.people = people;
        this.names = names;
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Name> getNames() {
        return names;
    }
}
