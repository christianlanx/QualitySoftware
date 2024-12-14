package anagrams.gpt4o.black;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import anagrams.gpt4o.black.Anagrams;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    private boolean containsSameElements(List<List<String>> actual, List<List<String>> expected) {
        for (List<String> expectedGroup : expected) {
            boolean found = false;
            for (List<String> actualGroup : actual) {
                if (actualGroup.containsAll(expectedGroup) && expectedGroup.containsAll(actualGroup)) {
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

    @Test
    public void testGroupAnagramsExample1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(expected.size(), result.size());
        assertTrue(containsSameElements(result, expected));
    }

    @Test
    public void testGroupAnagramsExample2() {
        String[] input = {""};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(expected.size(), result.size());
        assertTrue(containsSameElements(result, expected));
    }

    @Test
    public void testGroupAnagramsExample3() {
        String[] input = {"a"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertEquals(expected.size(), result.size());
        assertTrue(containsSameElements(result, expected));
    }
    
    @Test
    public void testGroupAnagramsEmptyInput() {
        String[] input = {};
        List<List<String>> expected = new ArrayList<>();

        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(expected.size(), result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGroupAnagramsNoAnagrams() {
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("def"),
            Arrays.asList("ghi")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(expected.size(), result.size());
        assertTrue(containsSameElements(result, expected));
    }

    @Test
    public void testGroupAnagramsAllAnagrams() {
        String[] input = {"abcd", "bcda", "cdab", "dabc"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("abcd", "bcda", "cdab", "dabc")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);

        assertEquals(expected.size(), result.size());
        assertTrue(containsSameElements(result, expected));
    }
}