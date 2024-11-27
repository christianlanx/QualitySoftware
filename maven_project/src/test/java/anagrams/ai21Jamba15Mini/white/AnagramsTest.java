package anagrams.ai21Jamba15Mini.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

public class AnagramsTest {

    @Test
    void testGroupAnagrams_EmptyInput() {
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(new String[]{});
        assertTrue(result.isEmpty());
    }

    @Test
    void testGroupAnagrams_NoAnagrams() {
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(new String[]{"hello", "world", "foo"});
        assertEquals(3, result.size());
        assertEquals(Arrays.asList("hello"), result.get(0));
        assertEquals(Arrays.asList("world"), result.get(1));
        assertEquals(Arrays.asList("foo"), result.get(2));
    }

    @Test
    void testGroupAnagrams_SingleAnagram() {
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"), result.get(0));
    }

    @Test
    void testGroupAnagrams_MultipleAnagrams() {
        Anagrams anagrams = new Anagrams();
        List<List<String>> result = anagrams.groupAnagrams(new String[]{"listen", "silent", "enlist", "google", "googly", "egl"});
        assertEquals(3, result.size());
        assertEquals(Arrays.asList("listen", "silent", "enlist"), result.get(0));
        assertEquals(Arrays.asList("google", "googly"), result.get(1));
        assertEquals(Arrays.asList("egl"), result.get(2));
    }
}