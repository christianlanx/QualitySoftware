package anagrams.gpt35Turbo.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AnagramsTest {

    private Anagrams anagrams;

    @BeforeEach
    void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    void testGroupAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("bat"));
        expected.add(Arrays.asList("eat", "tea", "ate"));
        expected.add(Arrays.asList("tan", "nat"));

        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(expected.size(), result.size());
        for (List<String> group : expected) {
            assertTrue(result.contains(group));
        }
    }

    @Test
    void testGroupAnagramsEmptyInput() {
        String[] input = {};
        List<List<String>> expected = new ArrayList<>();

        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(expected.size(), result.size());
    }
}