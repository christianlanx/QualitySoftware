package anagrams.gpt4oMini.black;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AnagramsTest {
    
    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testGroupAnagramsEmptyInput() {
        String[] input = {};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(0, result.size());
    }

    @Test
    public void testGroupAnagramsSingleEmptyString() {
        String[] input = {""};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(1, result.size());
        assertEquals(List.of(""), result.get(0));
    }

    @Test
    public void testGroupAnagramsSingleCharacter() {
        String[] input = {"a"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(1, result.size());
        assertEquals(List.of("a"), result.get(0));
    }

    @Test
    public void testGroupAnagramsMultipleAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(3, result.size());
        
        // Check if "eat", "tea", and "ate" are together
        assertTrue(result.stream().anyMatch(group -> group.contains("eat") && group.contains("tea") && group.contains("ate")));
        
        // Check if "nat" and "tan" are together
        assertTrue(result.stream().anyMatch(group -> group.contains("nat") && group.contains("tan")));
        
        // Check if "bat" is alone
        assertTrue(result.stream().anyMatch(group -> group.contains("bat") && group.size() == 1));
    }

    @Test
    public void testGroupAnagramsSameCharactersDifferentOrder() {
        String[] input = {"abc", "bca", "cab", "cba", "bac"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(1, result.size());
        assertTrue(result.get(0).containsAll(List.of("abc", "bca", "cab", "cba", "bac")));
    }

    @Test
    public void testGroupAnagramsNoAnagrams() {
        String[] input = {"abcd", "efgh", "ijkl"};
        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(group -> group.contains("abcd") && group.size() == 1));
        assertTrue(result.stream().anyMatch(group -> group.contains("efgh") && group.size() == 1));
        assertTrue(result.stream().anyMatch(group -> group.contains("ijkl") && group.size() == 1));
    }
    
    @Test
    public void testGroupAnagramsLargeInput() {
        String[] input = new String[10000];
        for (int i = 0; i < 10000; i++) {
            input[i] = i % 2 == 0 ? "abc" : "cba"; // 5000 anagrams and 5000 non-anagrams
        }
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(2, result.size());
        assertEquals(5000, result.get(0).size()); // Check the count of anagrams
    }
}