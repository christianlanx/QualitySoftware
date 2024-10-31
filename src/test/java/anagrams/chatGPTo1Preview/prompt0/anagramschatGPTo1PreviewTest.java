package anagrams.chatGPTo1Preview.prompt0;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import anagrams.Anagrams;

public class anagramschatGPTo1PreviewTest {
  @Test
    public void testGroupAnagramsNormalInput() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("ate", "eat", "tea"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("bat")
        );

        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsEmptyInput() {
        Anagrams anagrams = new Anagrams();
        String[] input = {};
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        List<List<String>> expectedOutput = new ArrayList<>();

        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsEmptyStrings() {
        Anagrams anagrams = new Anagrams();
        String[] input = {""};
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("")
        );

        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsDuplicateWords() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"a", "a"};
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("a", "a")
        );

        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsSingleCharacterWords() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"a", "b", "c"};
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("a"),
            Arrays.asList("b"),
            Arrays.asList("c")
        );

        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsMultipleEmptyStrings() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"", ""};
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("", "")
        );

        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsMixedCase() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"Eat", "Tea", "Ate", "bat"};
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("Ate", "Eat", "Tea"),
            Arrays.asList("bat")
        );

        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    @Test
    public void testGroupAnagramsUnicodeCharacters() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"åäö", "äåö", "öäå", "abc"};
        List<List<String>> actualOutput = anagrams.groupAnagrams(input);
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("åäö", "äåö", "öäå")
        );

        assertAnagramsEqual(expectedOutput, actualOutput);
    }

    /**
     * Helper method to assert that two lists of anagram groups are equal,
     * regardless of the order of the groups and the order of the words within each group.
     */
    private void assertAnagramsEqual(List<List<String>> expected, List<List<String>> actual) {
        // Sort the words within each group
        for (List<String> group : expected) {
            Collections.sort(group);
        }
        for (List<String> group : actual) {
            Collections.sort(group);
        }

        // Sort the list of groups
        Comparator<List<String>> listComparator = new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int n = Math.min(o1.size(), o2.size());
                for (int i = 0; i < n; i++) {
                    int cmp = o1.get(i).compareTo(o2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return Integer.compare(o1.size(), o2.size());
            }
        };
        Collections.sort(expected, listComparator);
        Collections.sort(actual, listComparator);

        assertEquals(expected, actual);
    }
}
