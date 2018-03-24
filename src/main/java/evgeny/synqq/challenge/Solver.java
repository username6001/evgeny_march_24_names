package evgeny.synqq.challenge;

import evgeny.synqq.challenge.people.Name;
import evgeny.synqq.challenge.people.Person;
import evgeny.synqq.challenge.sentence.Sentence;
import evgeny.synqq.challenge.sentence.SentenceName;
import evgeny.synqq.challenge.utils.*;

import java.util.*;
import java.util.stream.Collectors;

public class Solver {

    public void solve(Sentence sentence, Context context) {

        double threshold = 0.9;

        List<Person> people = context.getPeople();
        List<NameToSuggestionsPerson> fullnamesToSuggestions = sentence.getUnresolvedNames().stream()
                .filter(n -> n.getRight() != null)
                .map(n ->
                        new NameToSuggestionsPerson(n, people.stream()
                                .map(p -> new SuggestionPerson(Utils.getDistance(p.toString(), n + " " + n.getRight()), p))
                                .sorted(Collections.reverseOrder(Comparator.comparingDouble(SuggestionPerson::getDistance)))
                                .collect(Collectors.toList()))
                )
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(p -> p.getSuggestionPeople().get(0).getDistance())))
                .collect(Collectors.toList());

        while (fullnamesToSuggestions.size() > 0) {
            NameToSuggestionsPerson nameToSuggestionsPerson = fullnamesToSuggestions.get(0);
            SuggestionPerson suggestionPerson = nameToSuggestionsPerson.getSuggestionPeople().get(0);
            double distance = suggestionPerson.getDistance();
            if (!sentence.getAssignedPeople().contains(suggestionPerson.getPerson())) {
                if (distance > threshold) {
                    SentenceName sentenceName = nameToSuggestionsPerson.getSentenceName();
                    sentenceName.setName(suggestionPerson.getPerson().getFirstName().getName());
                    SentenceName secondName = sentenceName.getRight();
                    secondName.setName(suggestionPerson.getPerson().getSecondName().getName());
                    sentence.getUnresolvedNames().remove(sentenceName);
                    sentence.getUnresolvedNames().remove(secondName);
                    sentence.getAssignedPeople().add(suggestionPerson.getPerson());
                }
                fullnamesToSuggestions.remove(0);
            } else {
                nameToSuggestionsPerson.getSuggestionPeople().remove(0);
            }
        }

        List<Name> names = context.getNames();

        List<NameToSuggestionsName> nameToSuggestionPeople = sentence.getUnresolvedNames().stream()
                .map(un -> new NameToSuggestionsName(un,
                        names.stream()
                                .filter(n -> !sentence.getAssignedPeople().contains(n.getPerson()))
                                .map(n -> new SuggestionName(Utils.getDistance(n.getName(), un.getName()), n))
                                .sorted(Collections.reverseOrder(Comparator.comparingDouble(SuggestionName::getDistance)))
                                .collect(Collectors.toList()))
                )
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(p -> p.getSuggestionNames().get(0).getDistance())))
                .collect(Collectors.toList());

        while (nameToSuggestionPeople.size() > 0) {
            NameToSuggestionsName firstNameToSuggestionsPerson = nameToSuggestionPeople.get(0);
            SuggestionName suggestionPerson = firstNameToSuggestionsPerson.getSuggestionNames().get(0);
            double distance = suggestionPerson.getDistance();
            if (!sentence.getAssignedPeople().contains(suggestionPerson.getName())) {
                if (distance > threshold) {
                    SentenceName sentenceName = firstNameToSuggestionsPerson.getSentenceName();
                    sentenceName.setName(suggestionPerson.getName().getName());
                    sentence.getUnresolvedNames().remove(sentenceName);
                    sentence.getAssignedPeople().add(suggestionPerson.getName().getPerson());
                }
                nameToSuggestionPeople.remove(0);
            } else {
                firstNameToSuggestionsPerson.getSuggestionNames().remove(0);
            }
        }
    }
}
