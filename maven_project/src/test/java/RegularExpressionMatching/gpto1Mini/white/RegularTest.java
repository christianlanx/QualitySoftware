package RegularExpressionMatching.gpto1Mini.white;
import RegularExpressionMatching.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    private final Regular regular = new Regular();

    @ParameterizedTest
    @CsvSource({
        "'','', true",
        "'','a*', true",
        "'','.*', true",
        "'a', 'a', true",
        "'a', '.', true",
        "'a', 'a*', true",
        "'a', '.*', true",
        "'aa', 'a', false",
        "'aa', 'a*', true",
        "'ab', 'a*', false",
        "'ab', '.*', true",
        "'aab', 'c*a*b', true",
        "'mississippi', 'mis*is*p*.', false",
        "'ab', '.*c', false",
        "'aaa', 'a*a', true",
        "'aaa', 'ab*a*c*a', true",
        "'bbbba', '.*a*a', true",
        "'', 'a', false",
        "'', 'ab*', false",
        "'abcd', 'd*', false",
        "'a', 'ab*', true",
        "'a', '.*..a*', false"
    })
    void testIsMatch(String s, String p, boolean expected) {
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result, "Failed for s: \"" + s + "\", p: \"" + p + "\"");
    }
}