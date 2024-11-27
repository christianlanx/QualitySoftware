package anagrams.gpto1Mini.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import anagrams.Anagrams;

import java.util.*;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    void testEmptyArray() {
        String[] input = {};
        List<List<String>> expected = new ArrayList<>();
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected, result, "Expected empty list for empty input");
    }

    @Test
    void testSingleElement() {
        String[] input = {"test"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("test"));
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected, result, "Expected single group with the single element");
    }

    @Test
    void testMultipleAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("eat", "tea", "ate"),
                Arrays.asList("tan", "nat"),
                Arrays.asList("bat")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), result.size(), "Number of groups mismatch");

        for (List<String> group : expected) {
            assertTrue(containsGroup(result, group), "Expected group not found: " + group);
        }
    }

    @Test
    void testNoAnagrams() {
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("abc"),
                Arrays.asList("def"),
                Arrays.asList("ghi")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), result.size(), "Number of groups mismatch");

        for (List<String> group : expected) {
            assertTrue(containsGroup(result, group), "Expected group not found: " + group);
        }
    }

    @Test
    void testAllAnagrams() {
        String[] input = {"listen", "silent", "enlist", "inlets"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("listen", "silent", "enlist", "inlets")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), result.size(), "Number of groups mismatch");
        assertTrue(containsGroup(result, expected.get(0)), "All anagrams should be in one group");
    }

    @Test
    void testWithEmptyStrings() {
        String[] input = {"", "", "a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("", ""),
                Arrays.asList("a")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), result.size(), "Number of groups mismatch");

        for (List<String> group : expected) {
            assertTrue(containsGroup(result, group), "Expected group not found: " + group);
        }
    }

    @Test
    void testWithUpperCase() {
        String[] input = {"bAt", "tab", "Bat"};
        // Assuming case-sensitive grouping
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bAt"),
                Arrays.asList("tab"),
                Arrays.asList("Bat")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), result.size(), "Number of groups mismatch");

        for (List<String> group : expected) {
            assertTrue(containsGroup(result, group), "Expected group not found: " + group);
        }
    }

    @Test
    void testNullInput() {
        String[] input = null;
        assertThrows(NullPointerException.class, () -> {
            anagrams.groupAnagrams(input);
        }, "Expected NullPointerException for null input");
    }

    private boolean containsGroup(List<List<String>> actual, List<String> expectedGroup) {
        for (List<String> group : actual) {
            if (group.size() == expectedGroup.size() && group.containsAll(expectedGroup)) {
                return true;
            }
        }
        return false;
    }
}