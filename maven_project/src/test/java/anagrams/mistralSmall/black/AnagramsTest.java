package anagrams.mistralSmall.black;
import anagrams.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsTest {

    @Test
    public void testGroupAnagramsExample1() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testGroupAnagramsExample2() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {""};
        List<List<String>> expected = Arrays.asList(Arrays.asList(""));
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testGroupAnagramsExample3() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {"a"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("a"));
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testGroupAnagramsEmptyArray() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {};
        List<List<String>> expected = List.of();
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testGroupAnagramsSingleAnagram() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {"listen"};
        List<List<String>> expected = Arrays.asList(Arrays.asList("listen"));
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }

    @Test
    public void testGroupAnagramsMultipleAnagrams() {
        Anagrams anagrams = new Anagrams();
        String[] strs = {"silent", "enlist", "google", "gooegl", "abc", "bca", "a", "aa"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("silent", "enlist"),
                Arrays.asList("google", "gooegl"),
                Arrays.asList("abc", "bca"),
                Arrays.asList("a"),
                Arrays.asList("aa")
        );
        assertEquals(expected, anagrams.groupAnagrams(strs));
    }
}