package RegularExpressionMatching.mistralSmall.white;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    @Test
    public void testIsMatch_Empty() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("", ""));
        assertFalse(regular.isMatch("a", ""));
        assertFalse(regular.isMatch("", "a"));
    }

    @Test
    public void testIsMatch_SingleChar() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("a", "a"));
        assertFalse(regular.isMatch("a", "b"));
        assertTrue(regular.isMatch("a", "."));
    }

    @Test
    public void testIsMatch_MultipleChars() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("aa", "a*a*"));
        assertTrue(regular.isMatch("ab", ".*"));
        assertFalse(regular.isMatch("ab", ".*c"));
    }

    @Test
    public void testIsMatch_ComplexPatterns() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aab", "c*a*b"));
        assertFalse(regular.isMatch("mississippi", "mis*is*p*.*"));
        assertTrue(regular.isMatch("ab", ".*.."));
        assertFalse(regular.isMatch("a", ".*.."));
    }

    @Test
    public void testIsMatch_EdgeCases() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("", ".*"));
        assertTrue(regular.isMatch("a", ".*"));
        assertTrue(regular.isMatch("aa", "a*"));
        assertFalse(regular.isMatch("a", "a*"));
        assertTrue(regular.isMatch("ab", ".*c"));
        assertTrue(regular.isMatch("a", "a"));
        assertFalse(regular.isMatch("aa", "a"));
    }
}