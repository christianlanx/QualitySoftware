package RegularExpressionMatching.ai21Jamba.prompt1;
import RegularExpressionMatching.Regular;

import org.junit.Assert;
import org.junit.Test;

public class RegularTest {

    private Regular regular = new Regular();

    @Test
    public void testExample1() {
        Assert.assertFalse(regular.isMatch("aa", "a"));
    }

    @Test
    public void testExample2() {
        Assert.assertTrue(regular.isMatch("aa", "a*"));
    }

    @Test
    public void testExample3() {
        Assert.assertTrue(regular.isMatch("ab", ".*"));
    }

    @Test
    public void testSingleCharacterMatch() {
        Assert.assertTrue(regular.isMatch("a", "a"));
    }

    @Test
    public void testSingleCharacterMismatch() {
        Assert.assertFalse(regular.isMatch("a", "b"));
    }

    @Test
    public void testEmptyString() {
        Assert.assertTrue(regular.isMatch("", ""));
    }

    @Test
    public void testEmptyPattern() {
        Assert.assertFalse(regular.isMatch("a", ""));
    }

    @Test
    public void testEmptyStringWithAsterisk() {
        Assert.assertTrue(regular.isMatch("", ".*"));
    }

    @Test
    public void testAsteriskAtStart() {
        Assert.assertTrue(regular.isMatch("a", ".*"));
    }

    @Test
    public void testAsteriskAtEnd() {
        Assert.assertTrue(regular.isMatch("aa", "a*"));
    }

    @Test
    public void testMultipleAsterisks() {
        Assert.assertTrue(regular.isMatch("aaa", "a*a*"));
    }

    @Test
    public void testComplexPattern() {
        Assert.assertTrue(regular.isMatch("abbb", "a*b*"));
    }

    @Test
    public void testDotAndAsterisk() {
        Assert.assertTrue(regular.isMatch("aab", "c*a*b"));
    }

    @Test
    public void testDotMatchesAnyCharacter() {
        Assert.assertTrue(regular.isMatch("adceb", ".*a*b"));
    }

    @Test
    public void testAsteriskMatchesZeroCharacters() {
        Assert.assertTrue(regular.isMatch("acdcb", "a*c.*b"));
    }

    @Test
    public void testComplexPatternWithMismatch() {
        Assert.assertFalse(regular.isMatch("aa", ".*a"));
    }

    @Test
    public void testPatternLongerThanString() {
        Assert.assertFalse(regular.isMatch("a", "ab*a"));
    }

    @Test
    public void testPatternWithMultipleAsterisks() {
        Assert.assertTrue(regular.isMatch("a", "a*a*"));
    }

    @Test
    public void testPatternWithConsecutiveDots() {
        Assert.assertTrue(regular.isMatch("a", ".*.*"));
    }

    @Test
    public void testPatternWithLeadingDot() {
        Assert.assertTrue(regular.isMatch("a", ".a"));
    }

    @Test
    public void testPatternWithTrailingDot() {
        Assert.assertTrue(regular.isMatch("a", "a."));
    }
}