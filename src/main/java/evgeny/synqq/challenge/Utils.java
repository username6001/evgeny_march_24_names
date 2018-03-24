package evgeny.synqq.challenge;

public class Utils {

    private Utils() {}

    public static boolean isName(String s) {
        return Character.isUpperCase(s.charAt(0)) && !"I".equals(s);
    }
}
