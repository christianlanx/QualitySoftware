package RegularExpressionMatching.metaAI.prompt0;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import RegularExpressionMatching.Regular;

public class RegularTest {

    Regular regular = new Regular();

    // Test exact matches
    @Test
    public void testExactMatches() {
        assertTrue(regular.isMatch("abc", "abc"));
        assertTrue(regular.isMatch("", ""));
    }

    // Test dot (.) matches
    @Test
    public void testDotMatches() {
        assertTrue(regular.isMatch("abc", "a.c"));
        assertTrue(regular.isMatch("abc", ".bc"));
        assertTrue(regular.isMatch("abc", "ab."));
    }

    // Test star (*) matches
    @Test
    public void testStarMatches() {
        assertTrue(regular.isMatch("aaa", "a*"));
        assertTrue(regular.isMatch("", "a*"));
        assertTrue(regular.isMatch("abc", "a*bc"));
        assertTrue(regular.isMatch("aabbc", "a*bb*c"));
    }

    // Test combination of dot (.) and star (*)
    @Test
    public void testDotStarMatches() {
        assertTrue(regular.isMatch("aaa", ".*"));
        assertTrue(regular.isMatch("", ".*"));
        assertTrue(regular.isMatch("abc", ".*c"));
    }

    // Test invalid matches
    @Test
    public void testInvalidMatches() {
        assertFalse(regular.isMatch("abc", "abcd"));
        assertFalse(regular.isMatch("abc", "ab"));
        assertFalse(regular.isMatch("", "a"));
    }

    // Test edge cases
    @Test
    public void testEdgeCases() {
        assertTrue(regular.isMatch("", "a*"));
        assertFalse(regular.isMatch("a", "a*"));
        assertTrue(regular.isMatch("", ".*"));
    }
}