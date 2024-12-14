package anagrams.gpt4o.white;

import org.junit.jupiter.api.Test;
import anagrams.Anagrams;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testEmptyArray() {
        String[] strs = {};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleWord() {
        String[] strs = {"word"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("word"), result.get(0));
    }

    @Test
    public void testNoAnagrams() {
        String[] strs = {"cat", "dog", "bird"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(3, result.size());
    }

    @Test
    public void testAnagrams() {
        String[] strs = {"bat", "tab", "eat", "tea", "tan", "nat"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(3, result.size());

        result.forEach(group -> {
            group.sort(String::compareTo); // Sort each group for easy comparison
        });

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("bat", "tab"),
            Arrays.asList("eat", "tea"),
            Arrays.asList("tan", "nat")
        );

        expected.forEach(group -> {
            group.sort(String::compareTo); // Sort each group for easy comparison
        });

        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testIdenticalWords() {
        String[] strs = {"see", "see", "ese"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(2, result.size());

        result.forEach(group -> {
            group.sort(String::compareTo); // Sort each group for easy comparison
        });

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("see", "see"),
            Arrays.asList("ese")
        );

        expected.forEach(group -> {
            group.sort(String::compareTo); // Sort each group for easy comparison
        });

        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }
    
}