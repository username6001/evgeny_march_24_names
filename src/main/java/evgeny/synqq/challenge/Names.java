package evgeny.synqq.challenge;

import evgeny.synqq.challenge.people.Person;
import evgeny.synqq.challenge.sentence.Sentence;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {

    public static void main(String[] args) {
        String context = "" +
                "John Wayne\n" +
                "Tom Hanks\n" +
                "Tom Cruise\n" +
                "Clint Eastwood\n" +
                "Jon Hamm\n" +
                "John Nolan\n" +
                "William\n" +
                "Fitcher";
        String task = "tomorrow I have a meeting with Tim Hanks Tom Crus and Eastwud";
        Sentence sentence = new Sentence(task);
        new Solver().solve(sentence, new Context(context));
        System.out.println(sentence.toString());
    }
}
