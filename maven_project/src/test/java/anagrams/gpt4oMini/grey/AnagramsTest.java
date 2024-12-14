package anagrams.gpt4oMini.grey;

import anagrams.Anagrams;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testGroupAnagramsWithMultipleGroups() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutput = List.of(
            List.of("bat"),
            List.of("nat", "tan"),
            List.of("ate", "eat", "tea")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        // Check that the size of the output matches expected groups
        assertEquals(expectedOutput.size(), actualOutput.size());
        // Validate that the groups exist in the output (order may vary)
        for (List<String> group : expectedOutput) {
            assertEquals(true, actualOutput.stream().anyMatch(g -> new List<>(g).containsAll(group) && group.containsAll(g)));
        }
    }

    @Test
    public void testGroupAnagramsWithEmptyString() {
        String[] input = {""};
        List<List<String>> expectedOutput = List.of(List.of(""));
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsWithSingleCharacter() {
        String[] input = {"a"};
        List<List<String>> expectedOutput = List.of(List.of("a"));
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsWithAllSameCharacters() {
        String[] input = {"abc", "bca", "cab", "cba"};
        List<List<String>> expectedOutput = List.of(
            List.of("abc", "bca", "cab", "cba")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        // Check that the size of the output matches expected groups
        assertEquals(expectedOutput.size(), actualOutput.size());
        // Validate that the groups exist in the output
        for (List<String> group : expectedOutput) {
            assertEquals(true, actualOutput.stream().anyMatch(g -> new List<>(g).containsAll(group) && group.containsAll(g)));
        }
    }

    @Test
    public void testGroupAnagramsWithNoAnagrams() {
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> expectedOutput = List.of(
            List.of("abc"),
            List.of("def"),
            List.of("ghi")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        assertEquals(expectedOutput.size(), actualOutput.size());
        // Validate that the groups exist in the output
        for (List<String> group : expectedOutput) {
            assertEquals(true, actualOutput.stream().anyMatch(g -> new List<>(g).containsAll(group) && group.containsAll(g)));
        }
    }
}