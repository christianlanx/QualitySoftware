package anagrams.gpt4o.white;

import anagrams.Anagrams;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class AnagramsTest {

    @Test
    void testGroupAnagrams_EmptyInput() {
        Anagrams anagrams = new Anagrams();
        String[] input = {};
        List<List<String>> expected = List.of();
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagrams_SingleWord() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"word"};
        List<List<String>> expected = List.of(
                List.of("word")
        );
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagrams_MultipleAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"bat", "tab", "eat", "tea", "tan", "nat"};
        List<List<String>> expected = List.of(
                List.of("bat", "tab"),
                List.of("eat", "tea"),
                List.of("tan", "nat")
        );
        assertTrue(areAnagramGroupsEqual(expected, anagrams.groupAnagrams(input)));
    }

    @Test
    void testGroupAnagrams_NoAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abcd", "efgh", "ijkl"};
        List<List<String>> expected = List.of(
                List.of("abcd"),
                List.of("efgh"),
                List.of("ijkl")
        );
        assertTrue(areAnagramGroupsEqual(expected, anagrams.groupAnagrams(input)));
    }

    @Test
    void testGroupAnagrams_MixedCaseSensitivity() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"bAt", "Tab", "tAb"};
        List<List<String>> expected = List.of(
                List.of("bAt"),
                List.of("Tab"),
                List.of("tAb")
        );
        assertTrue(areAnagramGroupsEqual(expected, anagrams.groupAnagrams(input)));
    }
    
    private boolean areAnagramGroupsEqual(List<List<String>> expected, List<List<String>> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }
        for (List<String> group : expected) {
            boolean matchFound = false;
            for (List<String> actualGroup : actual) {
                if (actualGroup.size() == group.size() && actualGroup.containsAll(group)) {
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                return false;
            }
        }
        return true;
    }
}