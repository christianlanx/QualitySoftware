package anagrams.claude35Sonnet.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

class AnagramsTest {

    private Anagrams anagrams;

    @BeforeEach
    void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    void groupAnagrams_EmptyArray_ReturnsEmptyList() {
        String[] input = {};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertTrue(result.isEmpty());
    }

    @Test
    void groupAnagrams_SingleWord_ReturnsSingleGroupWithOneWord() {
        String[] input = {"hello"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("hello"), result.get(0));
    }

    @Test
    void groupAnagrams_NoAnagrams_ReturnsIndividualGroups() {
        String[] input = {"cat", "dog", "bird"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(list -> list.contains("cat")));
        assertTrue(result.stream().anyMatch(list -> list.contains("dog")));
        assertTrue(result.stream().anyMatch(list -> list.contains("bird")));
    }

    @Test
    void groupAnagrams_WithAnagrams_ReturnsCorrectGroups() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size());
        assertTrue(result.stream()
            .anyMatch(list -> list.containsAll(Arrays.asList("eat", "tea", "ate"))));
        assertTrue(result.stream()
            .anyMatch(list -> list.containsAll(Arrays.asList("tan", "nat"))));
        assertTrue(result.stream()
            .anyMatch(list -> list.containsAll(Arrays.asList("bat"))));
    }

    @Test
    void groupAnagrams_WithDuplicates_IncludesDuplicatesInSameGroup() {
        String[] input = {"cat", "cat", "tac"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).size());
        assertTrue(result.get(0).containsAll(Arrays.asList("cat", "cat", "tac")));
    }

    @Test
    void groupAnagrams_WithEmptyString_HandlesEmptyString() {
        String[] input = {"", ""};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(2, result.get(0).size());
        assertTrue(result.get(0).containsAll(Arrays.asList("", "")));
    }
}