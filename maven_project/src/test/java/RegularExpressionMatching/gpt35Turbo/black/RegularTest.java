package RegularExpressionMatching.gpt35Turbo.black;
import RegularExpressionMatching.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RegularTest {

    @Test
    void testExample1() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("aa", "a"));
    }

    @Test
    void testExample2() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aa", "a*"));
    }

    @Test
    void testExample3() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("ab", ".*"));
    }

    @Test
    void testCustom1() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    void testCustom2() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aab", "c*a*b"));
    }
}