package evgeny.synqq.challenge.sentence;

public class SentenceName implements ISentencePart {

    private Sentence sentence;
    private String name;

    private SentenceName right;

    public SentenceName(Sentence sentence, String name) {
        this.sentence = sentence;
        this.name = name;
    }

    public boolean isName() {
        return true;
    }

    public String getName() {
        return name;
    }

    public Sentence getSentence() {
        return sentence;
    }

    public void setSentence(Sentence sentence) {
        this.sentence = sentence;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SentenceName getRight() {
        return right;
    }

    public void setRight(SentenceName right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return getName();
    }
}
