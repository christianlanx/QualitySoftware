package anagrams.chatGPT4o.prompt0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import anagrams.Anagrams;

public class AnagramsChatGPT4o {
    @Test
    public void testGroupAnagrams_typicalCase() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        // Expected output contains groups of anagrams
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("eat", "tea", "ate"),
            Arrays.asList("tan", "nat"),
            Arrays.asList("bat")
        );

        assertTrue(containsAllGroups(expected, result));
    }

    @Test
    public void testGroupAnagrams_singleWord() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"hello"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("hello")
        );

        assertEquals(expected, result);
    }

    @Test
    public void testGroupAnagrams_emptyArray() {
        Anagrams anagrams = new Anagrams();
        String[] input = {};
        List<List<String>> result = anagrams.groupAnagrams(input);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGroupAnagrams_noAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("def"),
            Arrays.asList("ghi")
        );

        assertTrue(containsAllGroups(expected, result));
    }

    @Test
    public void testGroupAnagrams_duplicates() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc", "bca", "cab", "abc"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc", "bca", "cab", "abc")
        );

        assertTrue(containsAllGroups(expected, result));
    }

    // Helper method to check if result contains all expected groups
    private boolean containsAllGroups(List<List<String>> expected, List<List<String>> result) {
        for (List<String> group : expected) {
            boolean found = false;
            for (List<String> resGroup : result) {
                if (resGroup.size() == group.size() && resGroup.containsAll(group)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
