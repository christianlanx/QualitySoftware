package RegularExpressionMatching.mistralLarge.black;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    @Test
    public void testIsMatchExample1() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("aa", "a"));
    }

    @Test
    public void testIsMatchExample2() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aa", "a*"));
    }

    @Test
    public void testIsMatchExample3() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("ab", ".*"));
    }

    @Test
    public void testIsMatchSingleCharacter() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("a", "a"));
    }

    @Test
    public void testIsMatchSingleCharacterWithDot() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("a", "."));
    }

    @Test
    public void testIsMatchSingleCharacterWithStar() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("a", "a*"));
    }

    @Test
    public void testIsMatchMultipleCharactersWithStar() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aaa", "a*"));
    }

    @Test
    public void testIsMatchMultipleCharactersWithDotStar() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("abc", ".*"));
    }

    @Test
    public void testIsMatchMixedPattern() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aab", "c*a*b"));
    }

    @Test
    public void testIsMatchNoMatch() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    public void testIsMatchComplexPattern() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("abcd", "a.*d"));
    }

    @Test
    public void testIsMatchEdgeCase() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("a", "ab*"));
    }

    @Test
    public void testIsMatchEmptyPattern() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("a", ""));
    }

    @Test
    public void testIsMatchEmptyString() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("", ".*"));
    }
}