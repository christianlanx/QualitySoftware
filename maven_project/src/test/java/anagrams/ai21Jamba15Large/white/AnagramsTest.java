package anagrams.ai21Jamba15Large.white;
import anagrams.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsTest {

    private Anagrams anagrams = new Anagrams();

    @Test
    void testGroupAnagramsWithEmptyInput() {
        String[] input = new String[]{};
        List<List<String>> expected = new ArrayList<>();
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsWithSingleWord() {
        String[] input = new String[]{"apple"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of("apple")));
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsWithTwoAnagrams() {
        String[] input = new String[]{"listen", "silent"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of("listen", "silent")));
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsWithMultipleAnagrams() {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of("eat", "tea", "ate")));
        expected.add(new ArrayList<>(List.of("tan", "nat")));
        expected.add(new ArrayList<>(List.of("bat")));
        assertEquals(expected, anagrams.groupAnagrams(input));
    }

    @Test
    void testGroupAnagramsWithDuplicates() {
        String[] input = new String[]{"eat", "tea", "eat", "tan", "ate", "tan", "bat"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of("eat", "tea", "ate")));
        expected.add(new ArrayList<>(List.of("tan", "nat")));
        expected.add(new ArrayList<>(List.of("bat")));
        assertEquals(expected, anagrams.groupAnagrams(input));
    }
}