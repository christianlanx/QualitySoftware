package anagrams;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class AnagramsTestClaude35Sonnet {
    private Anagrams anagrams;

    @Before
    public void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    public void testEmptyArray() {
        String[] input = {};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertTrue("Empty input should return empty result", result.isEmpty());
    }

    // @Test
    // public void testNullArray() {
    //     String[] input = {null};
    //     List<List<String>> result = anagrams.groupAnagrams(input);
    //     assertEquals("Array with null should return single group", 1, result.size());
    //     assertEquals("Group should contain null", Collections.singletonList(null), result.get(0));
    // }

    @Test
    public void testSingleWord() {
        String[] input = {"hello"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals("Single word should return single group", 1, result.size());
        assertEquals("Group should contain the word", Collections.singletonList("hello"), result.get(0));
    }

    @Test
    public void testNoAnagrams() {
        String[] input = {"cat", "dog", "bird"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals("Words with no anagrams should return same number of groups", 3, result.size());
        assertTrue("Each word should be in its own group", 
            result.stream().allMatch(group -> group.size() == 1));
    }

    @Test
    public void testBasicAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals("Should return correct number of groups", 3, result.size());
        
        // Find and verify each group
        for (List<String> group : result) {
            String firstWord = group.get(0);
            switch (sortString(firstWord)) {
                case "aet":
                    assertEquals("Should group 'eat', 'tea', 'ate' together", 
                        3, group.size());
                    assertTrue(group.containsAll(Arrays.asList("eat", "tea", "ate")));
                    break;
                case "ant":
                    assertEquals("Should group 'tan', 'nat' together", 
                        2, group.size());
                    assertTrue(group.containsAll(Arrays.asList("tan", "nat")));
                    break;
                case "abt":
                    assertEquals("Should have 'bat' in its own group", 
                        1, group.size());
                    assertTrue(group.contains("bat"));
                    break;
                default:
                    fail("Unexpected group found");
            }
        }
    }

    @Test
    public void testEmptyStrings() {
        String[] input = {"", "", "a"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals("Should return two groups", 2, result.size());
        
        boolean foundEmptyGroup = false;
        boolean foundSingleCharGroup = false;
        
        for (List<String> group : result) {
            if (group.get(0).isEmpty()) {
                assertEquals("Empty strings should be grouped together", 2, group.size());
                foundEmptyGroup = true;
            } else {
                assertEquals("Single character should be in its own group", 1, group.size());
                assertEquals("Should contain 'a'", "a", group.get(0));
                foundSingleCharGroup = true;
            }
        }
        
        assertTrue("Should find empty string group", foundEmptyGroup);
        assertTrue("Should find single character group", foundSingleCharGroup);
    }

    @Test
    public void testCaseSensitivity() {
        String[] input = {"cat", "Cat", "CAT"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals("Case-sensitive strings should be in different groups", 3, result.size());
        assertTrue("Each case variation should be in its own group", 
            result.stream().allMatch(group -> group.size() == 1));
    }

    @Test
    public void testSpecialCharacters() {
        String[] input = {"a!b", "b!a", "a@b", "b@a"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals("Should handle special characters correctly", 2, result.size());
        
        for (List<String> group : result) {
            assertEquals("Each special character group should have two items", 2, group.size());
            String firstChar = group.get(0).substring(1, 2);
            if (firstChar.equals("!")) {
                assertTrue(group.containsAll(Arrays.asList("a!b", "b!a")));
            } else {
                assertTrue(group.containsAll(Arrays.asList("a@b", "b@a")));
            }
        }
    }

    // Helper method to sort string characters
    private String sortString(String str) {
        if (str == null) return null;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}