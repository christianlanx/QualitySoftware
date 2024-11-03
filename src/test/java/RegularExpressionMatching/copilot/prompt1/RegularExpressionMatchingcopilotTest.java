package RegularExpressionMatching.copilot.prompt1;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import RegularExpressionMatching.Regular;

public class RegularExpressionMatchingcopilotTest {

    @Test
    public void testIsMatch_Example1() {
        Regular solution = new Regular();
        String s = "aa";
        String p = "a";
        boolean expected = false;
        boolean result = solution.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testIsMatch_Example2() {
        Regular solution = new Regular();
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        boolean result = solution.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testIsMatch_Example3() {
        Regular solution = new Regular();
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        boolean result = solution.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testIsMatch_MultipleAsterisks() {
        Regular solution = new Regular();
        String s = "ab";
        String p = "a*b*";
        boolean expected = true;
        boolean result = solution.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testIsMatch_NoMatch() {
        Regular solution = new Regular();
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean expected = false;
        boolean result = solution.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testIsMatch_EmptyStrings() {
        Regular solution = new Regular();
        String s = "";
        String p = ".*";
        boolean expected = true;
        boolean result = solution.isMatch(s, p);
        assertEquals(expected, result);
    }

    @Test
    public void testIsMatch_SingleCharacter() {
        Regular solution = new Regular();
        String s = "a";
        String p = "ab*";
        boolean expected = true;
        boolean result = solution.isMatch(s, p);
        assertEquals(expected, result);
    }
}
