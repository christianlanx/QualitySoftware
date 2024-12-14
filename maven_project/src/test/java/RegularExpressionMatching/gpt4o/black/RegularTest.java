package RegularExpressionMatching.gpt4o.black;

import RegularExpressionMatching.Regular;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegularTest {

    private Regular regular;

    @BeforeEach
    public void setUp() {
        regular = new Regular();
    }

    @Test
    public void testSimpleNoMatch() {
        String s = "aa";
        String p = "a";
        assertFalse(regular.isMatch(s, p), "Expect 'a' not to match 'aa'");
    }

    @Test
    public void testSimpleMatchWithStar() {
        String s = "aa";
        String p = "a*";
        assertTrue(regular.isMatch(s, p), "Expect 'a*' to match 'aa'");
    }

    @Test
    public void testDotStarMatch() {
        String s = "ab";
        String p = ".*";
        assertTrue(regular.isMatch(s, p), "Expect '.*' to match 'ab'");
    }

    @Test
    public void testComplexMatch() {
        String s = "aab";
        String p = "c*a*b";
        assertTrue(regular.isMatch(s, p), "Expect 'c*a*b' to match 'aab'");
    }

    @Test
    public void testExactMatch() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        assertFalse(regular.isMatch(s, p), "Expect 'mis*is*p*.' not to match 'mississippi'");
    }

    @Test
    public void testPatternWithDotCharOnly() {
        String s = "abcd";
        String p = "....";
        assertTrue(regular.isMatch(s, p), "Expect '....' to match 'abcd'");
    }

    @Test
    public void testPatternWithMultipleStars() {
        String s = "aaa";
        String p = "a*a";
        assertTrue(regular.isMatch(s, p), "Expect 'a*a' to match 'aaa'");
    }

    @Test
    public void testZeroOccurrenceWithStar() {
        String s = "ab";
        String p = ".*c";
        assertFalse(regular.isMatch(s, p), "Expect '.*c' not to match 'ab'");
    }

    @Test
    public void testEmptyStringWithStarPattern() {
        String s = "";
        String p = ".*";
        assertTrue(regular.isMatch(s, p), "Expect '.*' to match empty string");
    }

    @Test
    public void testEmptyStringWithEmptyPattern() {
        String s = "";
        String p = "";
        assertTrue(regular.isMatch(s, p), "Expect empty pattern to match empty string");
    }

    @Test
    public void testSingleCharacter() {
        String s = "a";
        String p = ".";
        assertTrue(regular.isMatch(s, p), "Expect '.' to match 'a'");
    }

    @Test
    public void testLongStringMatch() {
        String s = "mississippi";
        String p = "mis*is*ip*.";
        assertTrue(regular.isMatch(s, p), "Expect 'mis*is*ip*.' to match 'mississippi'");
    }
}