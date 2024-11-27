package anagrams.metaAI.prompt0;
import anagrams.Anagrams;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class AnagramsTest {

    Anagrams anagrams = new Anagrams();

    // Test empty input
    @Test
    public void testEmptyInput() {
        String[] input = {};
        List<List<String>> expected = new ArrayList<>();
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    // Test single anagram group
    @Test
    public void testSingleAnagramGroup() {
        String[] input = {"eat", "tea", "ate"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("eat", "tea", "ate")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    // Test multiple anagram groups
    @Test
    public void testMultipleAnagramGroups() {
        String[] input = {"eat", "tea", "ate", "tan", "nat"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("eat", "tea", "ate"),
            Arrays.asList("tan", "nat")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    // Test no anagrams
    @Test
    public void testNoAnagrams() {
        String[] input = {"hello", "world", "java"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("hello"),
            Arrays.asList("world"),
            Arrays.asList("java")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    // Test large input
    @Test
    public void testLargeInput() {
        String[] input = {"apple", "papel", "banana", "ananaB", "orange"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("apple", "papel"),
            Arrays.asList("banana", "ananaB"),
            Arrays.asList("orange")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    // Test duplicate words
    @Test
    public void testDuplicateWords() {
        String[] input = {"eat", "tea", "eat", "ate"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("eat", "tea", "eat", "ate")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }
}