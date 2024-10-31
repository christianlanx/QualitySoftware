package RegularExpressionMatching.chatGPTo1Preview.prompt0;

import RegularExpressionMatching.Regular;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegularTest {

    @Test
    public void testEmptyStrings() {
        Regular regular = new Regular();
        String s = "";
        String p = "";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyStringWithPatternDotStar() {
        Regular regular = new Regular();
        String s = "";
        String p = ".*";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyStringWithPatternAsterisk() {
        Regular regular = new Regular();
        String s = "";
        String p = "a*";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testSimpleMatch() {
        Regular regular = new Regular();
        String s = "abc";
        String p = "abc";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testSimpleMismatch() {
        Regular regular = new Regular();
        String s = "abc";
        String p = "abd";
        boolean expected = false;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testDotCharacter() {
        Regular regular = new Regular();
        String s = "abc";
        String p = "a.c";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testAsteriskZeroOccurrence() {
        Regular regular = new Regular();
        String s = "ab";
        String p = "a*b";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testAsteriskMultipleOccurrences() {
        Regular regular = new Regular();
        String s = "aaab";
        String p = "a*b";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testComplexPattern1() {
        Regular regular = new Regular();
        String s = "aab";
        String p = "c*a*b";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testComplexPattern2() {
        Regular regular = new Regular();
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean expected = false;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testComplexPattern3() {
        Regular regular = new Regular();
        String s = "mississippi";
        String p = "mis*is*ip*.";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testPatternEndingWithAsterisk() {
        Regular regular = new Regular();
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testPatternWithDotAndAsterisk() {
        Regular regular = new Regular();
        String s = "abc";
        String p = ".*";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testPatternWithMultipleAsterisks() {
        Regular regular = new Regular();
        String s = "ab";
        String p = ".*c";
        boolean expected = false;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testPatternWithComplexAsterisks() {
        Regular regular = new Regular();
        String s = "aaa";
        String p = "a*a";
        boolean expected = true;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testPatternWithLeadingAsterisk() {
        Regular regular = new Regular();
        String s = "ab";
        String p = "*ab";
        boolean expected = false;
        boolean result = regular.isMatch(s, p);
        assertEquals(expected, result);
    }
}

