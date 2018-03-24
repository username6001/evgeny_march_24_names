package evgeny.synqq.challenge.sentence;

public class SentenceNotName implements ISentencePart {

    private String string;

    public SentenceNotName(String string) {
        this.string = string;
    }

    public boolean isName() {
        return false;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return getString();
    }
}
