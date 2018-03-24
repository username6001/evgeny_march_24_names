package evgeny.synqq.challenge;

import evgeny.synqq.challenge.people.Name;
import evgeny.synqq.challenge.people.Person;
import evgeny.synqq.challenge.sentence.Sentence;
import evgeny.synqq.challenge.sentence.SentenceName;
import evgeny.synqq.challenge.utils.Suggestion;
import evgeny.synqq.challenge.utils.Utils;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.*;
import java.util.stream.Collectors;

public class Solver {

    public void solve(Sentence sentence, Context context) {
        double threshold = 0.9;
        List<Person> people = context.getPeople();
        List<ImmutablePair<SentenceName, List<Suggestion>>> fullnamesToSuggestions = sentence.getUnresolvedNames().stream()
                .filter(n -> n.getRight() != null)
                .map(n ->
                        new ImmutablePair<>(n, people.stream()
                                .map(p -> new Suggestion(Utils.getDistance(p.toString(), n + " " + n.getRight()), p))
                                .sorted(Collections.reverseOrder(Comparator.comparingDouble(Suggestion::getDistance)))
                                .collect(Collectors.toList()))
                )
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(p -> p.getRight().get(0).getDistance())))
                .collect(Collectors.toList());

        while (fullnamesToSuggestions.size() > 0) {
            ImmutablePair<SentenceName, List<Suggestion>> nameToSuggestions = fullnamesToSuggestions.get(0);
            Suggestion suggestion = nameToSuggestions.getRight().get(0);
            double distance = suggestion.getDistance();
            if (!sentence.getAssignedPeople().contains(suggestion.getPerson())) {
                if (distance > threshold) {
                    SentenceName name = nameToSuggestions.getLeft();
                    name.setName(suggestion.getPerson().getFirstName().getName());
                    SentenceName secondName = name.getRight();
                    secondName.setName(suggestion.getPerson().getSecondName().getName());
                    sentence.getUnresolvedNames().remove(name);
                    sentence.getUnresolvedNames().remove(secondName);
                    sentence.getAssignedPeople().add(suggestion.getPerson());
                }
                fullnamesToSuggestions.remove(0);
            } else {
                nameToSuggestions.getRight().remove(0);
            }
        }

        List<Name> names = context.getNames();

    }
}
