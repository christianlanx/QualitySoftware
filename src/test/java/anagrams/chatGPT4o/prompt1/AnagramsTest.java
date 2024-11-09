package anagrams.chatGPT4o.prompt1;
import anagrams.Anagrams;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testExample1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutput1 = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );
        assertTrue(listsAreEqualIgnoringOrder(expectedOutput1, anagrams.groupAnagrams(input)));
    }

    @Test
    public void testExample2() {
        String[] input = {""};
        List<List<String>> expectedOutput = Collections.singletonList(Collections.singletonList(""));
        assertTrue(listsAreEqualIgnoringOrder(expectedOutput, anagrams.groupAnagrams(input)));
    }

    @Test
    public void testExample3() {
        String[] input = {"a"};
        List<List<String>> expectedOutput = Collections.singletonList(Collections.singletonList("a"));
        assertTrue(listsAreEqualIgnoringOrder(expectedOutput, anagrams.groupAnagrams(input)));
    }

    @Test
    public void testEmptyStringArray() {
        String[] input = {};
        List<List<String>> expectedOutput = Collections.emptyList();
        assertTrue(listsAreEqualIgnoringOrder(expectedOutput, anagrams.groupAnagrams(input)));
    }

    @Test
    public void testSingleCharacterAnagrams() {
        String[] input = {"a", "b", "c", "a"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("a", "a"),
            Arrays.asList("b"),
            Arrays.asList("c")
        );
        assertTrue(listsAreEqualIgnoringOrder(expectedOutput, anagrams.groupAnagrams(input)));
    }

    @Test
    public void testLongAnagram() {
        String[] input = {"abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba"};
        List<List<String>> expectedOutput = Collections.singletonList(
            Arrays.asList("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba")
        );
        assertTrue(listsAreEqualIgnoringOrder(expectedOutput, anagrams.groupAnagrams(input)));
    }

    // Utility method to compare two lists of lists ignoring order
    private boolean listsAreEqualIgnoringOrder(List<List<String>> expected, List<List<String>> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }
        for (List<String> list : expected) {
            boolean found = false;
            for (List<String> actualList : actual) {
                if (new HashSet<>(list).equals(new HashSet<>(actualList))) {
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