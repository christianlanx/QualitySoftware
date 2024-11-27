package anagrams.gpt4o.black;
import anagrams.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class AnagramsTest {

    @Test
    public void testGroupAnagramsExample1() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertTrue(compareListsOfLists(expectedOutput, result));
    }
    
    @Test
    public void testGroupAnagramsExample2() {
        Anagrams anagrams = new Anagrams();
        String[] input = {""};
        List<List<String>> expectedOutput = Arrays.asList(
            Collections.singletonList("")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertTrue(compareListsOfLists(expectedOutput, result));
    }
    
    @Test
    public void testGroupAnagramsExample3() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"a"};
        List<List<String>> expectedOutput = Arrays.asList(
            Collections.singletonList("a")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertTrue(compareListsOfLists(expectedOutput, result));
    }
    
    @Test
    public void testGroupAnagramsEmptyStringArray() {
        Anagrams anagrams = new Anagrams();
        String[] input = {};
        List<List<String>> expectedOutput = new ArrayList<>();
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertTrue(compareListsOfLists(expectedOutput, result));
    }

    @Test
    public void testGroupAnagramsSingleElement() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc"};
        List<List<String>> expectedOutput = Arrays.asList(
            Collections.singletonList("abc")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertTrue(compareListsOfLists(expectedOutput, result));
    }

    @Test
    public void testGroupAnagramsAllAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] input = {"abc", "bac", "cab"};
        List<List<String>> expectedOutput = Arrays.asList(
            Arrays.asList("abc", "bac", "cab")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        
        assertTrue(compareListsOfLists(expectedOutput, result));
    }

    private boolean compareListsOfLists(List<List<String>> expected, List<List<String>> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }
        for (List<String> list : expected) {
            list.sort(String::compareTo);
        }
        for (List<String> list : actual) {
            list.sort(String::compareTo);
        }
        expected.sort(Comparator.comparing(list -> list.get(0)));
        actual.sort(Comparator.comparing(list -> list.get(0)));
        return expected.equals(actual);
    }
}