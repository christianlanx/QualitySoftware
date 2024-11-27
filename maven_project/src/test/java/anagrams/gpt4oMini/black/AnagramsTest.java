package anagrams.gpt4oMini.black;
import anagrams.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testGroupAnagramsWithMultipleGroups() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void testGroupAnagramsWithEmptyString() {
        String[] input = {""};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("")
        );
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGroupAnagramsWithSingleCharacter() {
        String[] input = {"a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGroupAnagramsWithNoAnagrams() {
        String[] input = {"hello", "world", "java"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("hello"),
                Arrays.asList("world"),
                Arrays.asList("java")
        );
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void testGroupAnagramsWithAllAnagrams() {
        String[] input = {"abc", "bca", "cab", "cba"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("abc", "bca", "cab", "cba")
        );
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(1, result.size());
        assertEquals(expected.get(0).size(), result.get(0).size());
    }

    // Add more tests as necessary to cover edge cases
}