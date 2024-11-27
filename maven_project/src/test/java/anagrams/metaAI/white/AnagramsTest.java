package anagrams.metaAI.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class AnagramsTest {

    private Anagrams anagrams = new Anagrams();

    @Test
    public void testGroupAnagrams_MultipleAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("eat", "tea", "ate"),
                Arrays.asList("tan", "nat"),
                Arrays.asList("bat")
        );
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testGroupAnagrams_SingleAnagram() {
        String[] strs = {"listen", "silent", "enlist", "inlets"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("listen", "silent", "enlist", "inlets")
        );
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testGroupAnagrams_NoAnagrams() {
        String[] strs = {"hello", "world", "java"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("hello"),
                Arrays.asList("world"),
                Arrays.asList("java")
        );
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testGroupAnagrams_EmptyArray() {
        String[] strs = {};
        List<List<String>> expected = Arrays.asList();
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testGroupAnagrams_SingleElementArray() {
        String[] strs = {"hello"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("hello"));
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }
}