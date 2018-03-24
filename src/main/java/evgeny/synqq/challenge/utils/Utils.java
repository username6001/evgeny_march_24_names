package evgeny.synqq.challenge.utils;

import org.apache.commons.text.similarity.JaroWinklerDistance;

public class Utils {

    private Utils() {}

    public static boolean isName(String s) {
        return Character.isUpperCase(s.charAt(0)) && !"I".equals(s);
    }

    public static double getDistance(String left, String right) {
        return new JaroWinklerDistance().apply(left, right);
    }
}
