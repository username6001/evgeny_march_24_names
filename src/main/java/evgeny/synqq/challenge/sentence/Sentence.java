package evgeny.synqq.challenge.sentence;

import evgeny.synqq.challenge.utils.Utils;
import evgeny.synqq.challenge.people.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sentence {


    private List<ISentencePart> parts;

    private Set<SentenceName> unresolvedNames;

    private Set<Person> assignedPeople = new HashSet<>();

    public Sentence(String sentence) {
        String[] split = sentence.split("(?=\\b)");
        parts = Stream.of(split)
                .filter(s -> !s.isEmpty())
                .map(s -> {
                    if (Utils.isName(s)) {
                        return new SentenceName(this, s);
                    } else {
                        return new SentenceNotName(s);
                    }
                })
                .collect(Collectors.toList());
        IntStream.range(0, parts.size() - 2)
                .forEach(i -> {
                    ISentencePart currentPart = parts.get(i);
                    ISentencePart possiblePair = parts.get(i + 2);
                    if (currentPart.isName()
                            && !parts.get(i + 1).isName()
                            && possiblePair.isName()) {
                        SentenceName name = (SentenceName) currentPart;
                        name.setRight((SentenceName) possiblePair);
                    }
                });
        unresolvedNames = parts.stream()
                .filter(ISentencePart::isName)
                .map(SentenceName.class::cast)
                .collect(Collectors.toSet());

    }

    public boolean isResolved() {
        return getUnresolvedNames().isEmpty();
    }

    public List<ISentencePart> getParts() {
        return parts;
    }

    public void setParts(List<ISentencePart> parts) {
        this.parts = parts;
    }

    public Set<SentenceName> getUnresolvedNames() {
        return unresolvedNames;
    }

    public void setUnresolvedNames(Set<SentenceName> unresolvedNames) {
        this.unresolvedNames = unresolvedNames;
    }

    public Set<Person> getAssignedPeople() {
        return assignedPeople;
    }

    public void setAssignedPeople(Set<Person> assignedPeople) {
        this.assignedPeople = assignedPeople;
    }

    @Override
    public String toString() {
        List<String> parts = getParts().stream().map(Object::toString).collect(Collectors.toList());
        return String.join("", parts);
    }
}
