package RegularExpressionMatching.ai21Jamba15Mini.black;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    @Test
    void testMatchTrue() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aa", "a*"));
    }

    @Test
    void testMatchFalse() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("aa", "a"));
    }

    @Test
    void testMatchWildcard() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("ab", ".*"));
    }

    @Test
    void testMatchEmptyString() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("", ""));
    }

    @Test
    void testMatchEmptyPattern() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("a", ""));
    }

    @Test
    void testMatchMultipleCharacters() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aaab", "a*b"));
    }

    @Test
    void testMatchZeroRepetition() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aa", "a*"));
    }

    @Test
    void testMatchSingleCharacter() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("a", "a"));
    }

    @Test
    void testMatchDot() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("ab", "a."));
    }
}