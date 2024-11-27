package anagrams.claudeSonnet.prompt1;

import org.junit.Test;
import anagrams.Anagrams;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

public class anagramsclaudeSonnetTest {
    private Anagrams solution;

    @Before
    public void setUp() {
        solution = new Anagrams();
    }

    @Test
    public void testBasicAnagramGrouping() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(input);
        
        // Expected groups
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );
        
        assertAnagramGroupsEqual(expected, result);
    }

    @Test
    public void testEmptyString() {
        String[] input = {""};
        List<List<String>> result = solution.groupAnagrams(input);
        
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("")
        );
        
        assertAnagramGroupsEqual(expected, result);
    }

    @Test
    public void testSingleCharacter() {
        String[] input = {"a"};
        List<List<String>> result = solution.groupAnagrams(input);
        
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a")
        );
        
        assertAnagramGroupsEqual(expected, result);
    }

    @Test
    public void testAllDistinct() {
        String[] input = {"cat", "dog", "bird"};
        List<List<String>> result = solution.groupAnagrams(input);
        
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("cat"),
            Arrays.asList("dog"),
            Arrays.asList("bird")
        );
        
        assertAnagramGroupsEqual(expected, result);
    }

    @Test
    public void testAllSameAnagram() {
        String[] input = {"pat", "tap", "apt", "pat"};
        List<List<String>> result = solution.groupAnagrams(input);
        
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("pat", "tap", "apt", "pat")
        );
        
        assertAnagramGroupsEqual(expected, result);
    }

    @Test
    public void testEmptyArray() {
        String[] input = new String[0];
        List<List<String>> result = solution.groupAnagrams(input);
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void testWithSpecialCases() {
        String[] input = {"", "b", "", "b"};
        List<List<String>> result = solution.groupAnagrams(input);
        
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("", ""),
            Arrays.asList("b", "b")
        );
        
        assertAnagramGroupsEqual(expected, result);
    }

    @Test
    public void testLongStrings() {
        String[] input = {
            "pneumonoultramicroscopicsilicovolcanoconiosis",
            "pneumonoultramicroscopicsilicovolcanoconiosis"
        };
        List<List<String>> result = solution.groupAnagrams(input);
        
        List<List<String>> expected = Arrays.asList(
            Arrays.asList(
                "pneumonoultramicroscopicsilicovolcanoconiosis",
                "pneumonoultramicroscopicsilicovolcanoconiosis"
            )
        );
        
        assertAnagramGroupsEqual(expected, result);
    }

    /**
     * Helper method to compare two lists of anagram groups, considering that
     * both the groups and the strings within groups can be in any order
     */
    private void assertAnagramGroupsEqual(List<List<String>> expected, List<List<String>> actual) {
        assertEquals("Number of groups doesn't match", expected.size(), actual.size());
        
        // Convert both lists to a format that can be easily compared regardless of order
        Set<Set<String>> expectedSet = new HashSet<>();
        Set<Set<String>> actualSet = new HashSet<>();
        
        for (List<String> group : expected) {
            expectedSet.add(new HashSet<>(group));
        }
        
        for (List<String> group : actual) {
            actualSet.add(new HashSet<>(group));
        }
        
        assertEquals("Anagram groups don't match", expectedSet, actualSet);
    }
}