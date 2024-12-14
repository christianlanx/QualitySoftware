package RegularExpressionMatching.gpt4o.white;

import RegularExpressionMatching.Regular;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class RegularTest {
    
    @Test
    public void testExactMatch() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("abc", "abc"), "Exact match failed.");
    }
    
    @Test
    public void testSingleCharacterWildcard() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("abc", "a.c"), "Single character wildcard failed.");
    }
    
    @Test
    public void testZeroOrMoreWildcard() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aa", "a*"), "Zero or more wildcard failed.");
        assertTrue(regular.isMatch("aaaa", "a*"), "Zero or more wildcard with multiple characters failed.");
        assertTrue(regular.isMatch("", "c*"), "Zero or more wildcard with empty string failed.");
    }
    
    @Test
    public void testComplexPattern() {
        Regular regular = new Regular();
        assertTrue(regular.isMatch("aab", "c*a*b"), "Complex pattern matching failed.");
    }
    
    @Test
    public void testNonMatching() {
        Regular regular = new Regular();
        assertFalse(regular.isMatch("abc", "ab"), "Non-matching test failed.");
        assertFalse(regular.isMatch("abcd", "d*"), "Non-matching pattern with zero or more wildcard failed.");
    }
}