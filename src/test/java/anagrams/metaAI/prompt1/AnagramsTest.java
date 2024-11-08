package anagrams.metaAI.prompt1;
import anagrams.Anagrams;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class AnagramsTest {

    Anagrams anagrams = new Anagrams();

    @Test
    public void testExample1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        assertGroupAnagrams(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testExample2() {
        String[] strs = {""};
        List<List<String>> expected = Arrays.asList(Arrays.asList(""));
        assertGroupAnagrams(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testExample3() {
        String[] strs = {"a"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("a"));
        assertGroupAnagrams(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testEmptyInput() {
        String[] strs = {};
        List<List<String>> expected = Arrays.asList();
        assertGroupAnagrams(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testSingleElement() {
        String[] strs = {"hello"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("hello"));
        assertGroupAnagrams(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testMultipleAnagrams() {
        String[] strs = {"listen", "silent", "enlist", "inlets", "cat", "act"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("listen", "silent", "enlist", "inlets"),
                Arrays.asList("cat", "act")
        );
        assertGroupAnagrams(expected, anagrams.groupAnagrams(strs));
    }

    private void assertGroupAnagrams(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            List<String> expectedGroup = expected.get(i);
            List<String> actualGroup = actual.get(i);
            assertEquals(expectedGroup.size(), actualGroup.size());
            for (String s : expectedGroup) {
                assertTrue(actualGroup.contains(s));
            }
        }
    }
}
