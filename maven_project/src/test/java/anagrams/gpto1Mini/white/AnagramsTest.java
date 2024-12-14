package anagrams.gpto1Mini.white;

import anagrams.Anagrams;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testGroupAnagrams_withEmptyArray() {
        String[] input = {};
        List<List<String>> expected = new ArrayList<>();
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected, result, "Expected empty list for empty input");
    }

    @Test
    public void testGroupAnagrams_withSingleString() {
        String[] input = {"word"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("word"));
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected, result, "Expected single group with the single word");
    }

    @Test
    public void testGroupAnagrams_withMultipleAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(3, result.size(), "Expected three groups of anagrams");

        assertTrue(containsGroup(result, Arrays.asList("eat", "tea", "ate")),
                   "Expected group [eat, tea, ate]");
        assertTrue(containsGroup(result, Arrays.asList("tan", "nat")),
                   "Expected group [tan, nat]");
        assertTrue(containsGroup(result, Arrays.asList("bat")),
                   "Expected group [bat]");
    }

    @Test
    public void testGroupAnagrams_withNoAnagrams() {
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(3, result.size(), "Expected three groups with no anagrams");

        assertTrue(containsGroup(result, Arrays.asList("abc")),
                   "Expected group [abc]");
        assertTrue(containsGroup(result, Arrays.asList("def")),
                   "Expected group [def]");
        assertTrue(containsGroup(result, Arrays.asList("ghi")),
                   "Expected group [ghi]");
    }

    @Test
    public void testGroupAnagrams_withMixedCase() {
        String[] input = {"Listen", "Silent", "enlist", "inlets"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(2, result.size(), "Expected two groups of anagrams with mixed case");

        assertTrue(containsGroup(result, Arrays.asList("Listen")),
                   "Expected group [Listen]");
        assertTrue(containsGroup(result, Arrays.asList("Silent", "enlist", "inlets")),
                   "Expected group [Silent, enlist, inlets]");
    }

    @Test
    public void testGroupAnagrams_withSpecialCharacters() {
        String[] input = {"a!b", "b!a", "ab!", "!ba"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(2, result.size(), "Expected two groups of anagrams with special characters");

        assertTrue(containsGroup(result, Arrays.asList("a!b", "b!a")),
                   "Expected group [a!b, b!a]");
        assertTrue(containsGroup(result, Arrays.asList("ab!", "!ba")),
                   "Expected group [ab!, !ba]");
    }

    /**
     * Helper method to check if a list of lists contains a specific group, regardless of order.
     */
    private boolean containsGroup(List<List<String>> groups, List<String> targetGroup) {
        for (List<String> group : groups) {
            if (group.size() == targetGroup.size() && group.containsAll(targetGroup)) {
                return true;
            }
        }
        return false;
    }
}