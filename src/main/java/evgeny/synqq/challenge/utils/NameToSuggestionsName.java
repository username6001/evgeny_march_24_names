package evgeny.synqq.challenge.utils;

import evgeny.synqq.challenge.sentence.SentenceName;

import java.util.List;

public class NameToSuggestionsName {

    private final SentenceName sentenceName;
    private final List<SuggestionName> suggestionNames;

    public NameToSuggestionsName(SentenceName sentenceName, List<SuggestionName> suggestionNames) {
        this.sentenceName = sentenceName;
        this.suggestionNames = suggestionNames;
    }

    public SentenceName getSentenceName() {
        return sentenceName;
    }

    public List<SuggestionName> getSuggestionNames() {
        return suggestionNames;
    }
}
