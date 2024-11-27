package RegularExpressionMatching.claude35Sonnet.black;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class RegularTest {
    
    private Regular regular;
    
    @BeforeEach
    void setUp() {
        regular = new Regular();
    }
    
    @ParameterizedTest
    @CsvSource({
        "aa, a, false",
        "aa, a*, true",
        "ab, .*, true",
        "mississippi, mis*is*p*., false",
        "aab, c*a*b, true",
        "ab, .*c, false",
        "aaa, a*a, true",
        "aaa, ab*a*, true",
        "a, ab*, true",
        "bbbba, .*a*, true"
    })
    void testIsMatchWithVariousPatterns(String s, String p, boolean expected) {
        assertEquals(expected, regular.isMatch(s, p));
    }
    
    @Test
    void testEmptyStringAndPattern() {
        assertTrue(regular.isMatch("", ""));
    }
    
    @Test
    void testEmptyStringWithPattern() {
        assertTrue(regular.isMatch("", "a*"));
        assertTrue(regular.isMatch("", ".*"));
        assertFalse(regular.isMatch("", "a"));
    }
    
    @Test
    void testSingleCharacterMatching() {
        assertTrue(regular.isMatch("a", "."));
        assertTrue(regular.isMatch("b", "."));
        assertFalse(regular.isMatch("aa", "."));
    }
    
    @Test
    void testMultipleWildcards() {
        assertTrue(regular.isMatch("aaa", "a*a*a*"));
        assertTrue(regular.isMatch("aaaa", "a*a*"));
    }
    
    @Test
    void testComplexPatterns() {
        assertTrue(regular.isMatch("abcabc", ".*abc"));
        assertTrue(regular.isMatch("abcabc", "a.*bc"));
        assertFalse(regular.isMatch("abcabcd", ".*abc"));
    }
    
    @Test
    void testEdgeCases() {
        assertFalse(regular.isMatch("aa", ""));
        assertFalse(regular.isMatch("a", ""));
        assertTrue(regular.isMatch("a", "ab*"));
    }
    
    @Test
    void testConsecutiveStars() {
        assertTrue(regular.isMatch("aaa", "a*a*a"));
        assertTrue(regular.isMatch("aaaa", "a*a*a*a"));
    }
    
    @Test
    void testDotsAndStars() {
        assertTrue(regular.isMatch("abcdef", ".*"));
        assertTrue(regular.isMatch("abcdef", "a.*f"));
        assertFalse(regular.isMatch("abcdef", "a.*e"));
    }
    
    @Test
    void testConstraints() {
        // Test string length constraints
        String longString = "aaaaaaaaaaaaaaaaaaaa"; // 20 characters
        String longPattern = "a*a*a*a*a*a*a*a*a*a*"; // 20 characters
        assertTrue(regular.isMatch(longString, longPattern));
        
        // Test pattern with valid '*' usage
        assertTrue(regular.isMatch("a", "a*"));
        assertTrue(regular.isMatch("", "a*"));
    }
}