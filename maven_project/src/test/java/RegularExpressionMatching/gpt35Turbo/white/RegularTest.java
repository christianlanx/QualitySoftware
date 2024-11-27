package RegularExpressionMatching.gpt35Turbo.white;
import RegularExpressionMatching.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegularTest {

    @Test
    void testIsMatch() {
        Regular regular = new Regular();

        assertTrue(regular.isMatch("aa", "a"));
        assertFalse(regular.isMatch("aa", "a*"));
        assertTrue(regular.isMatch("ab", ".*"));
        assertTrue(regular.isMatch("aab", "c*a*b"));
        assertFalse(regular.isMatch("mississippi", "mis*is*p*."));
    }
}