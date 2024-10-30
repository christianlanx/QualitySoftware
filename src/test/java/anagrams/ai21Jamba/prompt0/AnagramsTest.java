package anagrams.ai21Jamba.prompt0;
import anagrams.Anagrams;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Arrays;

import org.junit.Test;

public class AnagramsTest {

    @Test
    public void testGroupAnagrams() {
        Anagrams anagrams = new Anagrams();

        // Test case 1: No anagrams
        String[] input1 = {"abc", "def", "ghi"};
        List<List<String>> expected1 = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("def"),
            Arrays.asList("ghi")
        );
        assertEquals(expected1, anagrams.groupAnagrams(input1));

        // Test case 2: Simple anagrams
        String[] input2 = {"eat", "tea", "ate", "nat", "tan"};
        List<List<String>> expected2 = Arrays.asList(
            Arrays.asList("eat", "tea", "ate"),
            Arrays.asList("nat", "tan")
        );
        assertEquals(expected2, anagrams.groupAnagrams(input2));

        // Test case 3: Mixed case
        String[] input3 = {"listen", "silent", "enlist", "google", "gooegl"};
        List<List<String>> expected3 = Arrays.asList(
            Arrays.asList("listen", "silent", "enlist"),
            Arrays.asList("google", "gooegl")
        );
        assertEquals(expected3, anagrams.groupAnagrams(input3));

        // Test case 4: Single word
        String[] input4 = {"apple"};
        List<List<String>> expected4 = Arrays.asList(
            Arrays.asList("apple")
        );
        assertEquals(expected4, anagrams.groupAnagrams(input4));

        // Test case 5: Empty input
        String[] input5 = {};
        List<List<String>> expected5 = Arrays.asList();
        assertEquals(expected5, anagrams.groupAnagrams(input5));

        // Test case 6: Duplicate words
        String[] input6 = {"hello", "world", "hello", "hello", "world", "world"};
        List<List<String>> expected6 = Arrays.asList(
            Arrays.asList("hello"),
            Arrays.asList("world")
        );
        assertEquals(expected6, anagrams.groupAnagrams(input6));
    }
}