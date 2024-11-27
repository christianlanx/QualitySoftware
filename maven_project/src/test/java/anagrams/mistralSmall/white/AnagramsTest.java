package anagrams.mistralSmall.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

public class AnagramsTest {

    @Test
    public void testGroupAnagrams() {
        Anagrams anagrams = new Anagrams();

        String[] strs = {"cat", "dog", "tac", "good", "act", "god"};
        List<List<String>> result = anagrams.groupAnagrams(strs);

        List<String> expectedGroup1 = List.of("cat", "tac", "act");
        List<String> expectedGroup2 = List.of("dog", "god");

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(expectedGroup1));
        Assertions.assertTrue(result.contains(expectedGroup2));
    }

    @Test
    public void testGroupAnagramsEmptyInput() {
        Anagrams anagrams = new Anagrams();

        String[] strs = {};
        List<List<String>> result = anagrams.groupAnagrams(strs);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testGroupAnagramsSingleElement() {
        Anagrams anagrams = new Anagrams();

        String[] strs = {"cat"};
        List<List<String>> result = anagrams.groupAnagrams(strs);

        List<String> expectedGroup = List.of("cat");

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(expectedGroup));
    }

    @Test
    public void testGroupAnagramsAllSame() {
        Anagrams anagrams = new Anagrams();

        String[] strs = {"cat", "cat", "cat"};
        List<List<String>> result = anagrams.groupAnagrams(strs);

        List<String> expectedGroup = List.of("cat", "cat", "cat");

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(expectedGroup));
    }

    @Test
    public void testGroupAnagramsMixedCase() {
        Anagrams anagrams = new Anagrams();

        String[] strs = {"Cat", "cat", "tac", "Dog", "god", "God"};
        List<List<String>> result = anagrams.groupAnagrams(strs);

        List<String> expectedGroup1 = List.of("Cat", "cat", "tac", "act");
        List<String> expectedGroup2 = List.of("Dog", "god", "God");

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(expectedGroup1));
        Assertions.assertTrue(result.contains(expectedGroup2));
    }
}