package anagrams.gpt4oMini.white;

import anagrams.Anagrams;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testEmptyInput() {
        String[] input = {};
        List<List<String>> expected = Arrays.asList();
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    public void testSingleWord() {
        String[] input = {"test"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("test"));
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    public void testMultipleIdenticalWords() {
        String[] input = {"same", "same", "same"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("same", "same", "same"));
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    public void testDifferentAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    public void testNoAnagrams() {
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("def"),
            Arrays.asList("ghi")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    public void testMixedAnagramsAndNonAnagrams() {
        String[] input = {"listen", "silent", "enlist", "abc", "cba", "bca"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc", "cba", "bca"),
            Arrays.asList("listen", "silent", "enlist")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    public void testInputWithCapitalLetters() {
        String[] input = {"Listen", "Silent", "enlist"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("Listen", "Silent", "enlist")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }
}