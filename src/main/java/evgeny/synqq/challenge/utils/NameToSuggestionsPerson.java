package evgeny.synqq.challenge.utils;

import evgeny.synqq.challenge.sentence.SentenceName;

import java.util.List;

public class NameToSuggestionsPerson {

    private final SentenceName sentenceName;
    private final List<SuggestionPerson> suggestionPeople;

    public NameToSuggestionsPerson(SentenceName sentenceName, List<SuggestionPerson> suggestionPeople) {
        this.sentenceName = sentenceName;
        this.suggestionPeople = suggestionPeople;
    }

    public SentenceName getSentenceName() {
        return sentenceName;
    }

    public List<SuggestionPerson> getSuggestionPeople() {
        return suggestionPeople;
    }
}
