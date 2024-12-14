package anagrams.gpt4o.black;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

public class AnagramsTest {

    private Anagrams anagrams = new Anagrams();

    @Test
    void testGroupAnagramsExample1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        verifyGroupAnagrams(expectedOutput, actualOutput);
    }

    @Test
    void testGroupAnagramsExample2() {
        String[] input = {""};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        verifyGroupAnagrams(expectedOutput, actualOutput);
    }

    @Test
    void testGroupAnagramsExample3() {
        String[] input = {"a"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("a")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        verifyGroupAnagrams(expectedOutput, actualOutput);
    }

    @Test
    void testGroupAnagramsEmptyStrings() {
        String[] input = {"", "", ""};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("", "", "")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        verifyGroupAnagrams(expectedOutput, actualOutput);
    }

    @Test
    void testGroupAnagramsSingleCharacterStrings() {
        String[] input = {"b", "a", "c", "b", "a"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("b", "b"),
            Arrays.asList("a", "a"),
            Arrays.asList("c")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        verifyGroupAnagrams(expectedOutput, actualOutput);
    }

    @Test
    void testGroupAnagramsNoAnagrams() {
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("def"),
            Arrays.asList("ghi")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        verifyGroupAnagrams(expectedOutput, actualOutput);
    }

    @Test
    void testGroupAnagramsMultipleGroups() {
        String[] input = {"abc", "bca", "def", "fed", "ghi", "ihg"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("abc", "bca"),
            Arrays.asList("def", "fed"),
            Arrays.asList("ghi", "ihg")
        );
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        verifyGroupAnagrams(expectedOutput, actualOutput);
    }

    private void verifyGroupAnagrams(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(expected.size(), actual.size(), "The number of groups should be the same");
        for (List<String> eGroup : expected) {
            boolean matchFound = false;
            for (List<String> aGroup : actual) {
                if (eGroup.containsAll(aGroup) && aGroup.containsAll(eGroup)) {
                    matchFound = true;
                    break;
                }
            }
            assertTrue(matchFound, "Expected group " + eGroup + " not found in actual output");
        }
    }
}