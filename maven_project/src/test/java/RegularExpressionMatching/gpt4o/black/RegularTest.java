package RegularExpressionMatching.gpt4o.black;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    private final Regular regular = new Regular();

    @Test
    public void testExample1() {
        assertFalse(regular.isMatch("aa", "a"), "Pattern 'a' should not match string 'aa'.");
    }

    @Test
    public void testExample2() {
        assertTrue(regular.isMatch("aa", "a*"), "Pattern 'a*' should match string 'aa'.");
    }

    @Test
    public void testExample3() {
        assertTrue(regular.isMatch("ab", ".*"), "Pattern '.*' should match string 'ab'.");
    }

    @Test
    public void testSingleCharacterMatch() {
        assertTrue(regular.isMatch("a", "a"), "Pattern 'a' should match string 'a'.");
    }

    @Test
    public void testSingleCharacterNoMatch() {
        assertFalse(regular.isMatch("a", "b"), "Pattern 'b' should not match string 'a'.");
    }

    @Test
    public void testDotCharacter() {
        assertTrue(regular.isMatch("a", "."), "Pattern '.' should match string 'a'.");
    }

    @Test
    public void testStarWithMultipleChars() {
        assertTrue(regular.isMatch("aaa", "a*"), "Pattern 'a*' should match string 'aaa'.");
    }

    @Test
    public void testStarWithZeroPrecedingChar() {
        assertTrue(regular.isMatch("b", "a*b"), "Pattern 'a*b' should match string 'b'.");
    }

    @Test
    public void testDotAndStarCombination() {
        assertTrue(regular.isMatch("abc", ".*c"), "Pattern '.*c' should match string 'abc'.");
    }

    @Test
    public void testComplexPattern() {
        assertTrue(regular.isMatch("aab", "c*a*b"), "Pattern 'c*a*b' should match string 'aab'.");
    }

    @Test
    public void testNoMatchDueToExtraChar() {
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."), "Pattern 'mis*is*p*.' should not match string 'mississippi'.");
    }

    @Test
    public void testExactMatch() {
        assertTrue(regular.isMatch("abc", "abc"), "Pattern 'abc' should exactly match string 'abc'.");
    }

    @Test
    public void testPatternWithConsecutiveStars() {
        assertTrue(regular.isMatch("aaaa", "a*a"), "Pattern 'a*a' should match string 'aaaa'.");
    }

    @Test
    public void testEmptyStringWithEmptyPattern() {
        assertTrue(regular.isMatch("", ""), "Empty pattern should match empty string.");
    }

    @Test
    public void testEmptyStringWithPattern() {
        assertFalse(regular.isMatch("", "a*b*"), "Pattern 'a*b*' should match empty string due to zero occurrences rule.");
    }

    @Test
    public void testStringWithEmptyPattern() {
        assertFalse(regular.isMatch("a", ""), "Non-empty string should not match empty pattern.");
    }
}