package RegularExpressionMatching.gpto1Mini.black;
import RegularExpressionMatching.*;

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
    public void testExample1() {
        String s = "aa";
        String p = "a";
        assertFalse(regular.isMatch(s, p), "Expected false for s=\"aa\", p=\"a\"");
    }

    @Test
    public void testExample2() {
        String s = "aa";
        String p = "a*";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"aa\", p=\"a*\"");
    }

    @Test
    public void testExample3() {
        String s = "ab";
        String p = ".*";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"ab\", p=\".*\"");
    }
    
    @Test
    public void testEmptyStringWithPattern() {
        String s = "";
        String p = "a*";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"\", p=\"a*\"");
    }
    
    @Test
    public void testSingleCharacterDot() {
        String s = "a";
        String p = ".";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"a\", p=\".\"");
    }
    
    @Test
    public void testMultipleStars() {
        String s = "aaabbb";
        String p = "a*b*";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"aaabbb\", p=\"a*b*\"");
    }
    
    @Test
    public void testStarWithDot() {
        String s = "abbbb";
        String p = "ab*";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"abbbb\", p=\"ab*\"");
    }
    
    @Test
    public void testNoMatchDueToExtraCharacters() {
        String s = "aab";
        String p = "c*a*b";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"aab\", p=\"c*a*b\"");
        
        String s2 = "mississippi";
        String p2 = "mis*is*p*.";
        assertFalse(regular.isMatch(s2, p2), "Expected false for s=\"mississippi\", p=\"mis*is*p*.\"");
    }
    
    @Test
    public void testFullMatchWithComplexPattern() {
        String s = "abcd";
        String p = ".*d";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"abcd\", p=\".*d\"");
    }
    
    @Test
    public void testPatternWithMultipleWildcards() {
        String s = "aab";
        String p = "c*a*b";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"aab\", p=\"c*a*b\"");
    }
    
    @Test
    public void testPatternEndingWithStar() {
        String s = "aaa";
        String p = "a*a";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"aaa\", p=\"a*a\"");
    }
    
    @Test
    public void testPatternMismatch() {
        String s = "abc";
        String p = "abd";
        assertFalse(regular.isMatch(s, p), "Expected false for s=\"abc\", p=\"abd\"");
    }
    
    @Test
    public void testOnlyWildcards() {
        String s = "abcdef";
        String p = ".*";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"abcdef\", p=\".*\"");
    }
    
    @Test
    public void testSingleCharacterMismatch() {
        String s = "a";
        String p = "b";
        assertFalse(regular.isMatch(s, p), "Expected false for s=\"a\", p=\"b\"");
    }
    
    @Test
    public void testEmptyPattern() {
        String s = "a";
        String p = "";
        assertFalse(regular.isMatch(s, p), "Expected false for s=\"a\", p=\"\"");
    }
    
    @Test
    public void testBothEmpty() {
        String s = "";
        String p = "";
        assertTrue(regular.isMatch(s, p), "Expected true for s=\"\", p=\"\"");
    }
}