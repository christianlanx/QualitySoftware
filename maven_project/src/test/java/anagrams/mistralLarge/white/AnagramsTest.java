package anagrams.mistralLarge.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class AnagramsTest {

    @Test
    public void testGroupAnagrams_EmptyInput() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(0, result.size());
    }

    @Test
    public void testGroupAnagrams_SingleWord() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {"listen"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("listen"), result.get(0));
    }

    @Test
    public void testGroupAnagrams_MultipleWords() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {"listen", "silent", "enlist", "google", "googol"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList("listen", "silent", "enlist")));
        assertTrue(result.contains(Arrays.asList("google", "googol")));
    }

    @Test
    public void testGroupAnagrams_MixedCaseWords() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {"Listen", "Silent", "Enlist", "Google", "Googol"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList("Listen", "Silent", "Enlist")));
        assertTrue(result.contains(Arrays.asList("Google", "Googol")));
    }

    @Test
    public void testGroupAnagrams_AllAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {"listen", "silent", "enlist"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("listen", "silent", "enlist"), result.get(0));
    }

    @Test
    public void testGroupAnagrams_NoAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {"apple", "banana", "cherry"};
        List<List<String>> result = anagrams.groupAnagrams(strs);
        assertEquals(3, result.size());
        assertTrue(result.contains(Arrays.asList("apple")));
        assertTrue(result.contains(Arrays.asList("banana")));
        assertTrue(result.contains(Arrays.asList("cherry")));
    }
}