package evgeny.synqq.challenge.sentence;

import evgeny.synqq.challenge.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sentence {


    private List<ISentencePart> parts;

    private List<SentenceName> unresolvedNames;

    public Sentence(String sentence) {
        String[] split = sentence.split("(?=\\b)");
        parts = new ArrayList<>(Stream.of(split)
                .filter(s -> !s.isEmpty())
                .map(s -> {
                    if (Utils.isName(s)) {
                        return new SentenceName(this, s);
                    } else {
                        return new SentenceNotName(s);
                    }
                })
                .collect(Collectors.toList()));
        unresolvedNames = new ArrayList<>(parts.stream()
                .filter(ISentencePart::isName)
                .map(SentenceName.class::cast)
                .collect(Collectors.toList()));

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

    public List<SentenceName> getUnresolvedNames() {
        return unresolvedNames;
    }

    public void setUnresolvedNames(List<SentenceName> unresolvedNames) {
        this.unresolvedNames = unresolvedNames;
    }

    @Override
    public String toString() {
        List<String> parts = getParts().stream().map(Object::toString).collect(Collectors.toList());
        return String.join("", parts);
    }
}
