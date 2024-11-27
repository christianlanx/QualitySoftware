package RegularExpressionMatching.mistralSmall.black;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    @Test
    public void testExample1() {
        Regular regular = new Regular();
        String s = "aa";
        String p = "a";
        assertFalse(regular.isMatch(s, p));
    }

    @Test
    public void testExample2() {
        Regular regular = new Regular();
        String s = "aa";
        String p = "a*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testExample3() {
        Regular regular = new Regular();
        String s = "ab";
        String p = ".*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testEmptyString() {
        Regular regular = new Regular();
        String s = "";
        String p = ".*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testAllCharsMatch() {
        Regular regular = new Regular();
        String s = "aaa";
        String p = "a*a*a*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testNoMatch() {
        Regular regular = new Regular();
        String s = "aaa";
        String p = "b*";
        assertFalse(regular.isMatch(s, p));
    }

    @Test
    public void testSingleChar() {
        Regular regular = new Regular();
        String s = "a";
        String p = "a";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testSingleCharWithDot() {
        Regular regular = new Regular();
        String s = "a";
        String p = ".";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testSingleCharWithDotAndStar() {
        Regular regular = new Regular();
        String s = "a";
        String p = ".*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testMultipleCharsWithStar() {
        Regular regular = new Regular();
        String s = "aaa";
        String p = "a*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testMultipleCharsWithDotAndStar() {
        Regular regular = new Regular();
        String s = "abc";
        String p = ".*";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testEdgeCaseSingleChar() {
        Regular regular = new Regular();
        String s = "a";
        String p = "a";
        assertTrue(regular.isMatch(s, p));
    }

    @Test
    public void testEdgeCaseEmptyPattern() {
        Regular regular = new Regular();
        String s = "a";
        String p = "";
        assertFalse(regular.isMatch(s, p));
    }

    @Test
    public void testEdgeCaseEmptyStringAndPattern() {
        Regular regular = new Regular();
        String s = "";
        String p = "";
        assertTrue(regular.isMatch(s, p));
    }
}