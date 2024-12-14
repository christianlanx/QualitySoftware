package anagrams.gpt35Turbo.grey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import anagrams.Anagrams;

public class AnagramsTest {

    Anagrams anagrams;

    @BeforeEach
    void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    void testGroupAnagrams() {
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutput1 = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );
        List<List<String>> result1 = anagrams.groupAnagrams(input1);
        for (int i = 0; i < expectedOutput1.size(); i++) {
            assertTrue(result1.containsAll(expectedOutput1.get(i)));
        }

        String[] input2 = {""};
        List<List<String>> expectedOutput2 = Arrays.asList(Arrays.asList(""));
        List<List<String>> result2 = anagrams.groupAnagrams(input2);
        for (int i = 0; i < expectedOutput2.size(); i++) {
            assertTrue(result2.containsAll(expectedOutput2.get(i)));
        }

        String[] input3 = {"a"};
        List<List<String>> expectedOutput3 = Arrays.asList(Arrays.asList("a"));
        List<List<String>> result3 = anagrams.groupAnagrams(input3);
        for (int i = 0; i < expectedOutput3.size(); i++) {
            assertTrue(result3.containsAll(expectedOutput3.get(i)));
        }
    }
}