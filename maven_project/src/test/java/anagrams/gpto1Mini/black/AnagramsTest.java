package anagrams.gpto1Mini.black;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import anagrams.Anagrams;
import java.util.*;

public class AnagramsTest {

    @Test
    @DisplayName("Test Example 1: Multiple Anagram Groups")
    public void testExample1() {
        Anagrams solution = new Anagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );
        List<List<String>> actual = solution.groupAnagrams(input);
        Assertions.assertTrue(areAnagramGroupsEqual(expected, actual), "The anagram groups do not match the expected output.");
    }

    @Test
    @DisplayName("Test Example 2: Single Empty String")
    public void testExample2() {
        Anagrams solution = new Anagrams();
        String[] input = {""};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("")
        );
        List<List<String>> actual = solution.groupAnagrams(input);
        Assertions.assertTrue(areAnagramGroupsEqual(expected, actual), "The anagram groups do not match the expected output for single empty string.");
    }

    @Test
    @DisplayName("Test Example 3: Single Character String")
    public void testExample3() {
        Anagrams solution = new Anagrams();
        String[] input = {"a"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a")
        );
        List<List<String>> actual = solution.groupAnagrams(input);
        Assertions.assertTrue(areAnagramGroupsEqual(expected, actual), "The anagram groups do not match the expected output for single character string.");
    }

    @Test
    @DisplayName("Test with No Anagrams")
    public void testNoAnagrams() {
        Anagrams solution = new Anagrams();
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("def"),
            Arrays.asList("ghi")
        );
        List<List<String>> actual = solution.groupAnagrams(input);
        Assertions.assertTrue(areAnagramGroupsEqual(expected, actual), "The anagram groups should contain only individual strings.");
    }

    @Test
    @DisplayName("Test with All Strings Being Anagrams")
    public void testAllAnagrams() {
        Anagrams solution = new Anagrams();
        String[] input = {"listen", "silent", "enlist", "inlets"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("listen", "silent", "enlist", "inlets")
        );
        List<List<String>> actual = solution.groupAnagrams(input);
        Assertions.assertTrue(areAnagramGroupsEqual(expected, actual), "All strings should be grouped into a single anagram group.");
    }

    @Test
    @DisplayName("Test with Mixed Case and Empty Strings")
    public void testMixedCaseAndEmptyStrings() {
        Anagrams solution = new Anagrams();
        String[] input = {"", "a", "A"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(""),
            Arrays.asList("a"),
            Arrays.asList("A")
        );
        List<List<String>> actual = solution.groupAnagrams(input);
        Assertions.assertTrue(areAnagramGroupsEqual(expected, actual), "The anagram groups should correctly handle empty strings and case sensitivity.");
    }

    /**
     * Helper method to determine if two lists of anagram groups are equal regardless of order.
     *
     * @param expected The expected list of anagram groups.
     * @param actual The actual list of anagram groups returned by the method.
     * @return true if both lists contain the same groups of anagrams, false otherwise.
     */
    private boolean areAnagramGroupsEqual(List<List<String>> expected, List<List<String>> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }

        // Create copies to avoid modifying the original lists
        List<Set<String>> expectedGroups = new ArrayList<>();
        for (List<String> group : expected) {
            expectedGroups.add(new HashSet<>(group));
        }

        List<Set<String>> actualGroups = new ArrayList<>();
        for (List<String> group : actual) {
            actualGroups.add(new HashSet<>(group));
        }

        // Check that each expected group is present in the actual groups
        for (Set<String> expectedGroup : expectedGroups) {
            boolean found = false;
            for (Set<String> actualGroup : actualGroups) {
                if (actualGroup.equals(expectedGroup)) {
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