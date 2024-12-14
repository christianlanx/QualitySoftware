package anagrams.gpt4o.black;

import anagrams.Anagrams;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AnagramsTest {

    @Test
    public void testGroupAnagramsExample1() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );

        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsExample2() {
        Anagrams anagrams = new Anagrams();
        String[] input = {""};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("")
        );

        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsExample3() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"a"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("a")
        );

        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsEmptyStringArray() {
        Anagrams anagrams = new Anagrams();
        String[] input = {};
        List<List<String>> expectedOutput = Arrays.asList();

        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        assertEquals(expectedOutput.size(), actualOutput.size());
    }

    @Test
    public void testGroupAnagramsStringWithDifferentLengths() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc", "bca", "cab", "abcd", "dcba", "bacd", "ab"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("abc", "bca", "cab"),
            Arrays.asList("abcd", "dcba", "bacd"),
            Arrays.asList("ab")
        );

        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsSingleCharacterStrings() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"a", "b", "c", "a"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("a", "a"),
            Arrays.asList("b"),
            Arrays.asList("c")
        );

        List<List<String>> actualOutput = anagrams.groupAnagrams(input);

        assertEquals(expectedOutput.size(), actualOutput.size());
        assertAnagramsEqual(expectedOutput, actualOutput);
    }
    
    private void assertAnagramsEqual(List<List<String>> expected, List<List<String>> actual) {
        Set<Set<String>> expectedSet = new HashSet<>();
        for (List<String> group : expected) {
            expectedSet.add(new HashSet<>(group));
        }
        
        Set<Set<String>> actualSet = new HashSet<>();
        for (List<String> group : actual) {
            actualSet.add(new HashSet<>(group));
        }
        
        assertEquals(expectedSet, actualSet);
    }
}