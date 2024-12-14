package anagrams.ai21Jamba15Large.black;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import anagrams.Anagrams;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AnagramsTest {

    private Anagrams anagrams;

    @Test
    void testGroupAnagramsExample1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutput = List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"));
        assertEquals(expectedOutput, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsExample2() {
        String[] input = {""};
        List<List<String>> expectedOutput = List.of(List.of(""));
        assertEquals(expectedOutput, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsExample3() {
        String[] input = {"a"};
        List<List<String>> expectedOutput = List.of(List.of("a"));
        assertEquals(expectedOutput, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsWithMultipleGroups() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat", "act", "cat", "tac"};
        List<List<String>> expectedOutput = List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"), List.of("act", "cat", "tac"));
        assertEquals(expectedOutput, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsWithEmptyInput() {
        String[] input = {};
        List<List<String>> expectedOutput = List.of();
        assertEquals(expectedOutput, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsWithSingleGroup() {
        String[] input = {"cat", "act", "tac"};
        List<List<String>> expectedOutput = List.of(List.of("cat", "act", "tac"));
        assertEquals(expectedOutput, anagrams.groupAnagrams(input));
    }
}