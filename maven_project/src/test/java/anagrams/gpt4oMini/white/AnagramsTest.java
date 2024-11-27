package anagrams.gpt4oMini.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class AnagramsTest {
    
    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testEmptyInput() {
        String[] input = {};
        List<List<String>> expected = Arrays.asList();
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSingleWord() {
        String[] input = {"hello"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("hello"));
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected, result);
    }
    
    @Test
    public void testNoAnagrams() {
        String[] input = {"hello", "world", "java"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("hello"),
            Arrays.asList("world"),
            Arrays.asList("java")
        );
        List<List<String>> result = anagrams.groupAnagrams(input);
        assertEquals(expected, result);
    }
    
    @Test
    public void testMultipleAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("eat", "tea", "ate"),
            Arrays.asList("tan", "nat"),
            Arrays.asList("bat")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        // Sort both lists to ensure they are in a comparable order
        result.forEach(Collections::sort);
        expected.forEach(Collections::sort);
        
        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }
    
    @Test
    public void testAnagramsWithDifferentCases() {
        String[] input = {"eat", "Tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("eat", "ate", "Tea"),
            Arrays.asList("tan", "nat"),
            Arrays.asList("bat")
        );
        
        List<List<String>> result = anagrams.groupAnagrams(input);
        // Sort both lists to ensure they are in a comparable order
        result.forEach(Collections::sort);
        expected.forEach(Collections::sort);
        
        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void testAnagramsWithSpecialCharacters() {
        String[] input = {"a!bc", "bc!a", "c!ab", "abc!", "def!"};
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a!bc", "bc!a", "c!ab", "abc!"),
            Arrays.asList("def!")
        );

        List<List<String>> result = anagrams.groupAnagrams(input);
        // Sort both lists to ensure they are in a comparable order
        result.forEach(Collections::sort);
        expected.forEach(Collections::sort);

        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }
}