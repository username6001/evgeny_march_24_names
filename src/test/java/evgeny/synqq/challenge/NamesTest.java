package evgeny.synqq.challenge;

import evgeny.synqq.challenge.sentence.Sentence;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NamesTest {

    String context = "" +
            "John Wayne\n" +
            "Tom Hanks\n" +
            "Tom Cruise\n" +
            "Clint Eastwood\n" +
            "Jon Hamm\n" +
            "John Nolan\n" +
            "William\n" +
            "Fitcher";

    private String getAnswer(String task) {
        Sentence sentence = new Sentence(task);
        new Solver().solve(sentence, new Context(context));
        return sentence.toString();
    }

    @Test
    public void test1() {
        assertEquals("tomorrow I have a meeting with Tom Hanks Tom Cruise and Eastwood",
                getAnswer("tomorrow I have a meeting with Tim Hanks Tom Crus and Eastwud"));

    }

    @Test
    public void test2() {
        assertEquals("Michael likes movies with John Wayne and Clint Eastwood",
                getAnswer("Michael likes movies with Jon Way and Client East"));

    }

    @Test
    public void test3() {
        assertEquals("John invited me Jon Hamm and John Wayne, over for a lunch",
                getAnswer("John invited me Jon Ham and Jon Wane, over for a lunch"));

    }

}
