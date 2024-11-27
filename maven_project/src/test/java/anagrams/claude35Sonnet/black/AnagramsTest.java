package anagrams.claude35Sonnet.black;
import anagrams.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class AnagramsTest {
    private Anagrams anagrams;

    @BeforeEach
    void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    void testBasicAnagramGrouping() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size());
        
        // Convert to sets for easier comparison regardless of order
        Set<Set<String>> resultSets = convertToSetOfSets(result);
        
        assertTrue(resultSets.contains(new HashSet<>(Arrays.asList("eat", "tea", "ate"))));
        assertTrue(resultSets.contains(new HashSet<>(Arrays.asList("tan", "nat"))));
        assertTrue(resultSets.contains(new HashSet<>(Arrays.asList("bat"))));
    }

    @Test
    void testEmptyString() {
        String[] input = {""};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals("", result.get(0).get(0));
    }

    @Test
    void testSingleCharacter() {
        String[] input = {"a"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals("a", result.get(0).get(0));
    }

    @Test
    void testNoAnagrams() {
        String[] input = {"cat", "dog", "pig"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size());
        for (List<String> group : result) {
            assertEquals(1, group.size());
        }
    }

    @Test
    void testAllAnagrams() {
        String[] input = {"abc", "bca", "cab", "acb"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(4, result.get(0).size());
        
        Set<String> resultSet = new HashSet<>(result.get(0));
        assertEquals(new HashSet<>(Arrays.asList("abc", "bca", "cab", "acb")), resultSet);
    }

    @Test
    void testWithSpaceConstraints() {
        String[] input = {"a", "", "ab", "ba"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size());
        
        Set<Set<String>> resultSets = convertToSetOfSets(result);
        assertTrue(resultSets.contains(new HashSet<>(Arrays.asList("ab", "ba"))));
        assertTrue(resultSets.contains(new HashSet<>(Arrays.asList("a"))));
        assertTrue(resultSets.contains(new HashSet<>(Arrays.asList(""))));
    }

    // Helper method to convert List<List<String>> to Set<Set<String>> for easier comparison
    private Set<Set<String>> convertToSetOfSets(List<List<String>> lists) {
        Set<Set<String>> sets = new HashSet<>();
        for (List<String> list : lists) {
            sets.add(new HashSet<>(list));
        }