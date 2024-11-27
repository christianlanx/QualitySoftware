package RegularExpressionMatching.ai21Jamba15Mini.white;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    Regular regular = new Regular();

    @Test
    void testIsMatchEmptyStringEmptyPattern() {
        assertTrue(regular.isMatch("", ""));
    }

    @Test
    void testIsMatchEmptyStringPatternWithStar() {
        assertFalse(regular.isMatch("", "a*"));
    }

    @Test
    void testIsMatchPatternWithStarMatching() {
        assertTrue(regular.isMatch("aa", "a*"));
    }

    @Test
    void testIsMatchPatternWithStarNotMatching() {
        assertFalse(regular.isMatch("ab", "a*"));
    }

    @Test
    void testIsMatchPatternWithQuestionMarkMatching() {
        assertTrue(regular.isMatch("ab", "?"));
    }

    @Test
    void testIsMatchPatternWithQuestionMarkNotMatching() {
        assertFalse(regular.isMatch("abc", "?"));
    }

    @Test
    void testIsMatchComplexPatternMatching() {
        assertTrue(regular.isMatch("aaab", "a*a*b"));
    }

    @Test
    void testIsMatchComplexPatternNotMatching() {
        assertFalse(regular.isMatch("aaab", "a*b"));
    }
}