package anagrams.ai21Jamba15Mini.black;
import anagrams.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramsTest {

    @Test
    void testEmptyInput() {
        Anagrams anagrams = new Anagrams();
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        assertEquals(expected, anagrams.groupAnagrams(new String[]{""}));
    }

    @Test
    void testSingleElementInput() {
        Anagrams anagrams = new Anagrams();
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList("a")));
        assertEquals(expected, anagrams.groupAnagrams(new String[]{"a"}));
    }

    @Test
    void testExample1() {
        Anagrams anagrams = new Anagrams();
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList("bat")));
        expected.add(new ArrayList<>(Arrays.asList("nat", "tan")));
        expected.add(new ArrayList<>(Arrays.asList("ate", "eat", "tea")));
        assertEquals(expected, anagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    @Test
    void testDuplicateAnagrams() {
        Anagrams anagrams = new Anagrams();
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList("a", "a")));
        assertEquals(expected, anagrams.groupAnagrams(new String[]{"a", "a"}));
    }

    @Test
    void testNoAnagrams() {
        Anagrams anagrams = new Anagrams();
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList("a")));
        expected.add(new ArrayList<>(Arrays.asList("b")));
        assertEquals(expected, anagrams.groupAnagrams(new String[]{"a", "b"}));
    }
}
