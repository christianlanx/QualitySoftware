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
    void testEmptyArray() {
        String[] input = new String[]{};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSingleWord() {
        String[] input = new String[]{"hello"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("hello"), result.get(0));
    }

    @Test
    void testNoAnagrams() {
        String[] input = new String[]{"cat", "dog", "pig"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(3, result.size());
        assertTrue(result.contains(Arrays.asList("cat")));
        assertTrue(result.contains(Arrays.asList("dog")));
        assertTrue(result.contains(Arrays.asList("pig")));
    }

    @Test
    void testSimpleAnagrams() {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(3, result.size());
        assertTrue(result.contains(Arrays.asList("eat", "tea", "ate")));
        assertTrue(result.contains(Arrays.asList("tan", "nat")));
        assertTrue(result.contains(Arrays.asList("bat")));
    }

    @Test
    void testWithEmptyString() {
        String[] input = new String[]{""};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(""), result.get(0));
    }

    @Test
    void testMultipleEmptyStrings() {
        String[] input = new String[]{"", ""};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("", ""), result.get(0));
    }

    @Test
    void testWithSpaces() {
        String[] input = new String[]{"a b", "b a"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList("a b", "b a")));
    }

    @Test
    void testCaseSensitive() {
        String[] input = new String[]{"Eat", "eat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList("Eat")));
        assertTrue(result.contains(Arrays.asList("eat")));
    }
}