package evgeny.synqq.challenge;

import evgeny.synqq.challenge.sentence.Sentence;

public class Names {

    public static void main(String[] args) {
        String task = "tomorrow I have a meeting with Tim Hanks Tom Crus and Eastwud";
        Sentence sentence = new Sentence(task);
        System.out.println(sentence.toString());
    }
}
