package anagrams.claude35Sonnet.black;
import anagrams.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
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
        Set<Set<String>> resultSet = convertToSetOfSets(result);
        Set<Set<String>> expectedSet = new HashSet<>();
        expectedSet.add(new HashSet<>(Arrays.asList("eat", "tea", "ate")));
        expectedSet.add(new HashSet<>(Arrays.asList("tan", "nat")));
        expectedSet.add(new HashSet<>(Arrays.asList("bat")));
        
        assertEquals(expectedSet, resultSet);
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
        assertTrue(result.stream().allMatch(list -> list.size() == 1));
    }

    @Test
    void testAllSameAnagrams() {
        String[] input = {"abc", "bca", "cab", "acb"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(4, result.get(0).size());
    }

    @Test
    void testWithSpecialCases() {
        String[] input = {"", "b", ""};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(list -> 
            list.size() == 2 && list.get(0).equals("")));
        assertTrue(result.stream().anyMatch(list -> 
            list.size() == 1 && list.get(0).equals("b")));
    }

    @Test
    void testConstraints() {
        // Test maximum length constraint
        String[] input = new String[10000]; // Testing upper bound of constraint
        Arrays.fill(input, "a");
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(10000, result.get(0).size());
    }

    // Helper method to convert List<List<String>> to Set<Set<String>> for easier comparison
    private Set<Set<String>> convertToSetOfSets(List<List<String>> lists) {
        Set<Set<String>> setOfSets = new HashSet<>();
        for (List<String> list : lists) {
            setOfSets.add(new HashSet<>(list));
        }
        return setOfSets;
    }
}