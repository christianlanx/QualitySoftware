package anagrams.ai21Jamba15Large.white;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import anagrams.Anagrams;

public class AnagramsTest {

    @Test
    void testGroupAnagrams() {
        Anagrams anagrams = new Anagrams();

        // Test case 1: No anagrams
        String[] strs1 = {"abc", "def", "ghi"};
        List<List<String>> expected1 = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("def"),
            Arrays.asList("ghi")
        );
        assertEquals(expected1, anagrams.groupAnagrams(strs1));

        // Test case 2: Simple anagrams
        String[] strs2 = {"eat", "tea", "ate", "nat", "tan"};
        List<List<String>> expected2 = Arrays.asList(
            Arrays.asList("eat", "tea", "ate"),
            Arrays.asList("nat", "tan")
        );
        assertEquals(expected2, anagrams.groupAnagrams(strs2));

        // Test case 3: Multiple anagrams
        String[] strs3 = {"listen", "silent", "enlist", "google", "gooegl"};
        List<List<String>> expected3 = Arrays.asList(
            Arrays.asList("listen", "silent", "enlist"),
            Arrays.asList("google", "gooegl")
        );
        assertEquals(expected3, anagrams.groupAnagrams(strs3));

        // Test case 4: Empty input
        String[] strs4 = {};
        List<List<String>> expected4 = new ArrayList<>();
        assertEquals(expected4, anagrams.groupAnagrams(strs4));

        // Test case 5: Single word input
        String[] strs5 = {"apple"};
        List<List<String>> expected5 = Arrays.asList(
            Arrays.asList("apple")
        );
        assertEquals(expected5, anagrams.groupAnagrams(strs5));
    }
}