package anagrams.gpt4o.grey;

import anagrams.Anagrams;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AnagramsTest {

    @Test
    public void testGroupAnagramsExample1() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutput = List.of(
                List.of("bat"),
                List.of("nat", "tan"),
                List.of("ate", "eat", "tea")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);

        assertTrue(matchesExpectedOutput(result, expectedOutput));
    }

    @Test
    public void testGroupAnagramsExample2() {
        Anagrams anagrams = new Anagrams();
        String[] input = {""};
        List<List<String>> expectedOutput = List.of(
                List.of("")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);

        assertTrue(matchesExpectedOutput(result, expectedOutput));
    }

    @Test
    public void testGroupAnagramsExample3() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"a"};
        List<List<String>> expectedOutput = List.of(
                List.of("a")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);

        assertTrue(matchesExpectedOutput(result, expectedOutput));
    }

    @Test
    public void testGroupAnagramsEmptyInput() {
        Anagrams anagrams = new Anagrams();
        String[] input = {};
        List<List<String>> expectedOutput = List.of();
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertTrue(matchesExpectedOutput(result, expectedOutput));
    }

    @Test
    public void testGroupAnagramsSameCharacters() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc", "bca", "cab"};
        List<List<String>> expectedOutput = List.of(
                List.of("abc", "bca", "cab")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);

        assertTrue(matchesExpectedOutput(result, expectedOutput));
    }

    private boolean matchesExpectedOutput(List<List<String>> result, List<List<String>> expectedOutput) {
        if (result.size() != expectedOutput.size()) {
            return false;
        }
        
        for (List<String> expectedGroup : expectedOutput) {
            boolean found = false;
            for (List<String> resultGroup : result) {
                if (resultGroup.size() == expectedGroup.size() && resultGroup.containsAll(expectedGroup)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}