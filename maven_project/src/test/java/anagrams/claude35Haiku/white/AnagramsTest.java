package anagrams.claude35Haiku.white;
import anagrams.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    private Anagrams anagrams;

    @BeforeEach
    void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    void testGroupAnagrams_emptyArray() {
        String[] input = {};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertTrue(result.isEmpty(), "Result should be an empty list");
    }

    @Test
    void testGroupAnagrams_singleWord() {
        String[] input = {"hello"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(1, result.size(), "Should have one group");
        assertEquals(1, result.get(0).size(), "Group should contain one word");
        assertTrue(result.get(0).contains("hello"), "Group should contain 'hello'");
    }

    @Test
    void testGroupAnagrams_multipleAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size(), "Should have three groups");
        
        // Check anagram groups
        boolean foundEatGroup = result.stream()
            .anyMatch(group -> group.containsAll(List.of("eat", "tea", "ate")));
        boolean foundTanGroup = result.stream()
            .anyMatch(group -> group.containsAll(List.of("tan", "nat")));
        boolean foundBatGroup = result.stream()
            .anyMatch(group -> group.contains("bat"));
        
        assertTrue(foundEatGroup, "Should have anagram group for 'eat', 'tea', 'ate'");
        assertTrue(foundTanGroup, "Should have anagram group for 'tan', 'nat'");
        assertTrue(foundBatGroup, "Should have group for 'bat'");
    }

    @Test
    void testGroupAnagrams_wordsWithDifferentCases() {
        String[] input = {"Eat", "tea", "Ate"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        // Case-sensitive comparison
        assertEquals(3, result.size(), "Should have three separate groups due to case sensitivity");
    }

    @Test
    void testGroupAnagrams_duplicateWords() {
        String[] input = {"eat", "eat", "tea"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size(), "Should have one group");
        assertEquals(3, result.get(0).size(), "Group should contain all three words");
    }

    @Test
    void testGroupAnagrams_nullInput() {
        assertThrows(NullPointerException.class, () -> {
            anagrams.groupAnagrams(null);
        }, "Should throw NullPointerException for null input");
    }
}