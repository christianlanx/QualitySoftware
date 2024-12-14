package anagrams.ai21Jamba15Large.grey;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import anagrams.Anagrams;

public class AnagramsTest {

    @Test
    void testGroupAnagramsWithVariousInputs() {
        Anagrams anagrams = new Anagrams();

        // Example 1
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected1 = List.of(
            List.of("bat"),
            List.of("nat", "tan"),
            List.of("ate", "eat", "tea")
        );
        assertEquals(expected1, anagrams.groupAnagrams(input1));

        // Example 2
        String[] input2 = {""};
        List<List<String>> expected2 = List.of(List.of(""));
        assertEquals(expected2, anagrams.groupAnagrams(input2));

        // Example 3
        String[] input3 = {"a"};
        List<List<String>> expected3 = List.of(List.of("a"));
        assertEquals(expected3, anagrams.groupAnagrams(input3));

        // Additional tests
        String[] input4 = {"hello", "llho", "world", "dlrow", "llho", "olleh"};
        List<List<String>> expected4 = List.of(
            List.of("hello", "llho", "olleh"),
            List.of("world", "dlrow")
        );
        assertEquals(expected4, anagrams.groupAnagrams(input4));

        String[] input5 = {"abc", "bca", "cba", "def", "fed", "efd"};
        List<List<String>> expected5 = List.of(
            List.of("abc", "bca", "cba"),
            List.of("def", "fed", "efd")
        );
        assertEquals(expected5, anagrams.groupAnagrams(input5));

        String[] input6 = {"xyz", "zyx", "xzy", "zyx", "xyz", "xzy"};
        List<List<String>> expected6 = List.of(
            List.of("xyz", "zyx", "xzy")
        );
        assertEquals(expected6, anagrams.groupAnagrams(input6));

        String[] input7 = {"ab", "ba", "cd", "dc", "ab", "ba", "cd", "dc"};
        List<List<String>> expected7 = List.of(
            List.of("ab", "ba"),
            List.of("cd", "dc")
        );
        assertEquals(expected7, anagrams.groupAnagrams(input7));
    }

    @Test
    void testGroupAnagramsWithEmptyInput() {
        Anagrams anagrams = new Anagrams();
        String[] input = {};
        List<List<String>> expected = List.of();
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsWithAllUniqueStrings() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> expected = List.of(
            List.of("abc"),
            List.of("def"),
            List.of("ghi")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsWithDuplicateStrings() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc", "abc", "abc"};
        List<List<String>> expected = List.of(
            List.of("abc", "abc", "abc")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }
}