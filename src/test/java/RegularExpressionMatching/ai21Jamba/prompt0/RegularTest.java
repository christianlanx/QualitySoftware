package RegularExpressionMatching.ai21Jamba.prompt0;
import RegularExpressionMatching.Regular;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegularTest {

    @Test
    public void testIsMatch() {
        Regular regular = new Regular();

        // Test case 1: Simple match
        assertTrue(regular.isMatch("aa", "a*"));

        // Test case 2: Simple non-match
        assertFalse(regular.isMatch("aa", "a"));

        // Test case 3: Match with wildcard
        assertTrue(regular.isMatch("aa", ".*"));

        // Test case 4: Match with multiple characters
        assertTrue(regular.isMatch("aaa", "a*a"));

        // Test case 5: Match with literal character
        assertTrue(regular.isMatch("aaa", "ab*a"));

        // Test case 6: Non-match with literal character
        assertFalse(regular.isMatch("aaa", "ba*a"));

        // Test case 7: Match with character class
        assertTrue(regular.isMatch("aab", "c*a*b"));

        // Test case 8: Non-match with character class
        assertFalse(regular.isMatch("aab", "c*a*d"));

        // Test case 9: Match with multiple wildcards
        assertTrue(regular.isMatch("mississippi", "mis*is*p*"));

        // Test case 10: Non-match with multiple wildcards
        assertFalse(regular.isMatch("mississippi", "mis*is*ip*"));

        // Test case 11: Match with complex pattern
        assertTrue(regular.isMatch("ab", ".*c*a*b"));

        // Test case 12: Non-match with complex pattern
        assertFalse(regular.isMatch("ab", ".*c*a*d"));

        // Test case 13: Match with single character pattern
        assertTrue(regular.isMatch("a", "a"));

        // Test case 14: Non-match with single character pattern
        assertFalse(regular.isMatch("a", "b"));

        // Test case 15: Match with empty string
        assertTrue(regular.isMatch("", ""));

        // Test case 16: Non-match with empty string and pattern
        assertFalse(regular.isMatch("", "a"));
    }
}