package anagrams.claude35Haiku.black;
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
    void testGroupAnagramsWithMixedAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(group -> 
            group.containsAll(List.of("eat", "tea", "ate"))));
        assertTrue(result.stream().anyMatch(group -> 
            group.containsAll(List.of("nat", "tan"))));
        assertTrue(result.stream().anyMatch(group -> 
            group.contains("bat")));
    }

    @Test
    void testGroupAnagramsWithEmptyString() {
        String[] input = {""};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertTrue(result.get(0).contains(""));
    }

    @Test
    void testGroupAnagramsWithSingleCharacter() {
        String[] input = {"a"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertTrue(result.get(0).contains("a"));
    }

    @Test
    void testGroupAnagramsWithNoAnagrams() {
        String[] input = {"cat", "dog", "bird"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(group -> group.size() == 1));
    }

    @Test
    void testGroupAnagramsWithEmptyInput() {
        String[] input = {};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertTrue(result.isEmpty());
    }

    @Test
    void testGroupAnagramsWithMultipleAnagramGroups() {
        String[] input = {"abc", "bca", "cab", "def", "fed"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(group -> 
            group.containsAll(List.of("abc", "bca", "cab"))));
        assertTrue(result.stream().anyMatch(group -> 
            group.containsAll(List.of("def", "fed"))));
    }

    @Test
    void testGroupAnagramsWithLongStrings() {
        String[] input = {"listen", "silent", "enlist"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(1, result.size());
        assertTrue(result.get(0).containsAll(List.of("listen", "silent", "enlist")));
    }
}