package anagrams.claude35Haiku.white;

import anagrams.Anagrams;
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
    void testGroupAnagrams_EmptyArray() {
        String[] input = {};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertTrue(result.isEmpty(), "Result should be empty for empty input");
    }

    @Test
    void testGroupAnagrams_NoAnagrams() {
        String[] input = {"cat", "dog", "bird"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(3, result.size(), "Each word should be in its own group");
        result.forEach(group -> assertEquals(1, group.size(), "Each group should contain one word"));
    }

    @Test
    void testGroupAnagrams_WithAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size(), "Should have 3 groups of anagrams");
        
        boolean hasEatGroup = result.stream()
            .anyMatch(group -> group.containsAll(List.of("eat", "tea", "ate")));
        
        boolean hasTanGroup = result.stream()
            .anyMatch(group -> group.containsAll(List.of("tan", "nat")));
        
        boolean hasBatGroup = result.stream()
            .anyMatch(group -> group.contains("bat"));
        
        assertTrue(hasEatGroup, "Should have a group with eat, tea, ate");
        assertTrue(hasTanGroup, "Should have a group with tan, nat");
        assertTrue(hasBatGroup, "Should have a group with bat");
    }

    @Test
    void testGroupAnagrams_SingleCharacterWords() {
        String[] input = {"a", "b", "c", "a"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size(), "Should have 3 groups");
        
        result.forEach(group -> {
            assertTrue(group.size() == 1 || group.size() == 2, 
                "Each group should have 1 or 2 elements");
        });
    }

    @Test
    void testGroupAnagrams_CaseSensitivity() {
        String[] input = {"Eat", "eat", "Tea", "tea"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(4, result.size(), "Should treat uppercase and lowercase as different");
        result.forEach(group -> assertEquals(1, group.size(), "Each group should have one word"));
    }
}