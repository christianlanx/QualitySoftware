package anagrams.gpto1Mini.black;
import anagrams.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class AnagramsTest {

    private void assertAnagramGroups(List<List<String>> expected, List<List<String>> actual) {
        // Normalize the groups by sorting each inner list and then sorting the outer list
        List<List<String>> normalizedExpected = normalizeGroups(expected);
        List<List<String>> normalizedActual = normalizeGroups(actual);
        assertEquals(normalizedExpected, normalizedActual, "The anagram groups do not match the expected output.");
    }

    private List<List<String>> normalizeGroups(List<List<String>> groups) {
        List<List<String>> normalized = new ArrayList<>();
        for (List<String> group : groups) {
            List<String> sortedGroup = new ArrayList<>(group);
            Collections.sort(sortedGroup);
            normalized.add(sortedGroup);
        }
        normalized.sort((a, b) -> {
            if (a.size() != b.size()) {
                return Integer.compare(a.size(), b.size());
            }
            for (int i = 0; i < a.size(); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        return normalized;
    }

    @Test
    public void testExample1() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat","tan"),
                Arrays.asList("ate","eat","tea")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertAnagramGroups(expected, actual);
    }

    @Test
    public void testExample2() {
        Anagrams anagrams = new Anagrams();
        String[] input = {""};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertAnagramGroups(expected, actual);
    }

    @Test
    public void testExample3() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertAnagramGroups(expected, actual);
    }

    @Test
    public void testAllAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc", "bca", "cab", "cba", "bac", "acb"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("abc", "bca", "cab", "cba", "bac", "acb")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertAnagramGroups(expected, actual);
    }

    @Test
    public void testNoAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"one", "two", "three", "four"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("one"),
                Arrays.asList("two"),
                Arrays.asList("three"),
                Arrays.asList("four")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertAnagramGroups(expected, actual);
    }

    @Test
    public void testMixedAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"listen", "silent", "enlist", "google", "gooegl", "abc", "cab"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("listen", "silent", "enlist"),
                Arrays.asList("google", "gooegl"),
                Arrays.asList("abc", "cab")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertAnagramGroups(expected, actual);
    }

    @Test
    public void testEmptyInput() {
        Anagrams anagrams = new Anagrams();
        String[] input = {};
        List<List<String>> expected = new ArrayList<>();
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertAnagramGroups(expected, actual);
    }

    @Test
    public void testSingleCharacterStrings() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"a", "b", "a", "c", "b"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a", "a"),
                Arrays.asList("b", "b"),
                Arrays.asList("c")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertAnagramGroups(expected, actual);
    }

    @Test
    public void testLargeInput() {
        Anagrams anagrams = new Anagrams();
        int size = 10000;
        String[] input = new String[size];
        List<String> anagramGroup = Arrays.asList("test");
        for(int i = 0; i < size; i++) {
            input[i] = "test";
        }
        List<List<String>> expected = Arrays.asList(
                Collections.nCopies(size, "test")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(1, actual.size());
        assertEquals(size, actual.get(0).size());
        for(String s : actual.get(0)) {
            assertEquals("test", s);
        }
    }
}