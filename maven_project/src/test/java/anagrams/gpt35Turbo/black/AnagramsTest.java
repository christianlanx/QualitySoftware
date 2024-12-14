package anagrams.gpt35Turbo.black;

import anagrams.Anagrams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsTest {

    private Anagrams anagrams;

    @BeforeEach
    void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    void testGroupAnagramsExample1() {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expected = List.of(
                List.of("bat"),
                List.of("nat","tan"),
                List.of("ate","eat","tea")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(expected, actual);
    }

    @Test
    void testGroupAnagramsExample2() {
        String[] input = {""};
        List<List<String>> expected = List.of(List.of(""));
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(expected, actual);
    }

    @Test
    void testGroupAnagramsExample3() {
        String[] input = {"a"};
        List<List<String>> expected = List.of(List.of("a"));
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(expected, actual);
    }
}