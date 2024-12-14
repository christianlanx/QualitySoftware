package anagrams.claude35Haiku.black;

import anagrams.Anagrams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {
    private Anagrams anagrams;

    @BeforeEach
    void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    void testGroupAnagrams_BasicScenario() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(group -> 
            group.containsAll(Arrays.asList("eat", "tea", "ate"))));
        assertTrue(result.stream().anyMatch(group -> 
            group.containsAll(Arrays.asList("nat", "tan"))));
        assertTrue(result.stream().anyMatch(group -> 
            group.contains("bat")));
    }

    @Test
    void testGroupAnagrams_EmptyStringArray() {
        String[] input = {""};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertTrue(result.get(0).contains(""));
    }

    @Test
    void testGroupAnagrams_SingleCharArray() {
        String[] input = {"a"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertTrue(result.get(0).contains("a"));
    }

    @Test
    void testGroupAnagrams_NoAnagrams() {
        String[] input = {"cat", "dog", "bird"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(group -> group.size() == 1));
    }

    @Test
    void testGroupAnagrams_MultipleAnagramGroups() {
        String[] input = {"abc", "cba", "bca", "xyz", "zyx"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(group -> 
            group.containsAll(Arrays.asList("abc", "cba", "bca"))));
        assertTrue(result.stream().anyMatch(group -> 
            group.containsAll(Arrays.asList("xyz", "zyx"))));
    }

    @Test
    void testGroupAnagrams_LargeInput() {
        String[] input = new String[10000];
        Arrays.fill(input, "a");
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(10000, result.get(0).size());
    }

    @Test
    void testGroupAnagrams_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            anagrams.groupAnagrams(null);
        });
    }
}