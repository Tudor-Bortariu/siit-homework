package siit.homework06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInputFormat {
    /**
     * We use this method to check if the equation's format is usable for the calculator method we have. In this case we check to see if the
     * pattern is Digit(s)\whitespace\letter(s)\whitespace\operand... and the pattern just repeats itself from there.
     * @param input is the equation you need a result for.
     * @return returns true if the string pattern matches the one given to the Pattern.
     */
    public boolean checkInput(String input) {
        Pattern pattern = Pattern.compile("(\\d+\\s\\w+\\s[+-]\\s\\d+\\s\\w+(\\s?(\\+|-)?\\s?\\d+\\s\\w+\\s?)*)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}