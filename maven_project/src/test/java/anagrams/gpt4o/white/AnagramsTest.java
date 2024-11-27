package anagrams.gpt4o.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class AnagramsTest {

    @Test
    public void testGroupAnagramsBasic() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = List.of(
                List.of("eat", "tea", "ate"),
                List.of("tan", "nat"),
                List.of("bat")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertListOfListsEqualsIgnoreOrder(expected, result);
    }

    @Test
    public void testGroupAnagramsEmptyArray() {
        Anagrams anagrams = new Anagrams();
        String[] input = {};
        List<List<String>> expected = List.of();
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertListOfListsEqualsIgnoreOrder(expected, result);
    }

    @Test
    public void testGroupAnagramsSingleWord() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc"};
        List<List<String>> expected = List.of(
                List.of("abc")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertListOfListsEqualsIgnoreOrder(expected, result);
    }

    @Test
    public void testGroupAnagramsNoAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc", "def", "ghi"};
        List<List<String>> expected = List.of(
                List.of("abc"),
                List.of("def"),
                List.of("ghi")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertListOfListsEqualsIgnoreOrder(expected, result);
    }

    @Test
    public void testGroupAnagramsAllAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"aabb", "bbaa", "abab", "baba"};
        List<List<String>> expected = List.of(
                List.of("aabb", "bbaa", "abab", "baba")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertListOfListsEqualsIgnoreOrder(expected, result);
    }

    private void assertListOfListsEqualsIgnoreOrder(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(expected.size(), actual.size());

        for (List<String> expectedList : expected) {
            boolean matchFound = false;

            for (List<String> actualList : actual) {
                if (equalListsIgnoreOrder(expectedList, actualList)) {
                    matchFound = true;
                    break;
                }
            }
            
            if (!matchFound) {
                throw new AssertionError("Expected: " + expected + ", but was: " + actual);
            }
        }
    }

    private boolean equalListsIgnoreOrder(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        
        return list1.containsAll(list2) && list2.containsAll(list1);
    }
}