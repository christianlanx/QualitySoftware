package RegularExpressionMatching.ai21Jamba15Large.black;

import static org.junit.jupiter.api.Assertions.assertEquals;

import RegularExpressionMatching.Regular;

public class RegularTest {
    private Regular regular = new Regular();

    @org.junit.jupiter.api.Test
    public void testExample1() {
        String s = "aa";
        String p = "a";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @org.junit.jupiter.api.Test
    public void testExample2() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @org.junit.jupiter.api.Test
    public void testExample3() {
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @org.junit.jupiter.api.Test
    public void testEdgeCase1() {
        String s = "";
        String p = "";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @org.junit.jupiter.api.Test
    public void testEdgeCase2() {
        String s = "a";
        String p = "";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @org.junit.jupiter.api.Test
    public void testComplexCase1() {
        String s = "aab";
        String p = "c*a*b";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @org.junit.jupiter.api.Test
    public void testComplexCase2() {
        String s = "aaa";
        String p = "a*a";
        boolean expected = true;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @org.junit.jupiter.api.Test
    public void testComplexCase3() {
        String s = "a";
        String p = ".*..a*";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }

    @org.junit.jupiter.api.Test
    public void testComplexCase4() {
        String s = "ab";
        String p = ".*c";
        boolean expected = false;
        assertEquals(expected, regular.isMatch(s, p));
    }
}