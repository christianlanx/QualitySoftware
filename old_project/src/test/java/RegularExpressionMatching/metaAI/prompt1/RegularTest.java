package RegularExpressionMatching.metaAI.prompt1;
import RegularExpressionMatching.Regular;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegularTest {

    Regular regular = new Regular();

    @Test
    public void testExample1() {
        String s = "aa";
        String p = "a";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    public void testExample2() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    public void testExample3() {
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    public void testSimpleMatch() {
        String s = "a";
        String p = "a";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    public void testNoMatch() {
        String s = "a";
        String p = "b";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    public void testDotMatch() {
        String s = "a";
        String p = ".";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    public void testStarMatch() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @Test
    public void testComplexMatch() {
        String s = "aab";
        String p = "a*b";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }
}