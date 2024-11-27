package RegularExpressionMatching.ai21Jamba15Large.white;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularTest {

    private Regular regular = new Regular();

    @Test
    public void testEmptyStringAndPattern() {
        assertEquals(true, regular.isMatch("", ""));
    }

    @Test
    public void testEmptyPattern() {
        assertEquals(false, regular.isMatch("a", ""));
    }

    @Test
    public void testSingleCharacterPattern() {
        assertEquals(true, regular.isMatch("a", "a"));
        assertEquals(false, regular.isMatch("a", "b"));
    }

    @Test
    public void testMultipleCharacterPattern() {
        assertEquals(true, regular.isMatch("aa", "aa"));
        assertEquals(false, regular.isMatch("aa", "ab"));
    }

    @Test
    public void testPatternWithDot() {
        assertEquals(true, regular.isMatch("a", "."));
        assertEquals(true, regular.isMatch("ab", "a."));
    }

    @Test
    public void testPatternWithAsterisk() {
        assertEquals(true, regular.isMatch("aa", "a*"));
        assertEquals(true, regular.isMatch("ab", "a*b*"));
        assertEquals(true, regular.isMatch("aa", ".*"));
        assertEquals(true, regular.isMatch("aaa", "a*a"));
    }

    @Test
    public void testComplexPattern() {
        assertEquals(true, regular.isMatch("ab", ".*.."));
        assertEquals(false, regular.isMatch("abc", ".*.."));
    }

    @Test
    public void testPatternEndingWithAsterisk() {
        assertEquals(true, regular.isMatch("ab", "ab*"));
        assertEquals(true, regular.isMatch("a", "a*"));
    }

    @Test
    public void testPatternWithConsecutiveAsterisks() {
        assertEquals(true, regular.isMatch("ab", "a**"));
        assertEquals(true, regular.isMatch("aa", "a***"));
    }
}