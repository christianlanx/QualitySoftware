package anagrams.mistralSmall.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    void testGroupAnagramsEmptyArray() {
        String[] strs = {};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(0, result.size());
    }

    @Test
    void testGroupAnagramsSingleWord() {
        String[] strs = {"listen"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals("listen", result.get(0).get(0));
    }

    @ParameterizedTest
    @CsvSource({
        "\"cat, dog, god, act, tac\"",
        "\"foo, bar, car, tar, rat\"",
        "\"abc, bca, cab\"",
        "\"hello, world, drowl, llohe\"",
        "\"debit card, bad credit, elvis, lives\"",
        "\"joy, oy, oy, joy, joy, oy, oy, jy, oy\"",
        "\"restful, fluster, wolves, wolfes, elvis, lives\"",
        "\"listen, silent, enlist, google, gooegl, gooelg, goggle, elgoog\"",
        "\"abc, abc, abc, abc, abc\"",
        "\"a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z\"",
        "\"\" "
    })
    void testGroupAnagrams(String input) {
        String[] strs = input.split(",\\s*");
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(strs.length, result.stream().mapToInt(List::size).sum());
    }
}