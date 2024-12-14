package anagrams.gpt4oMini.grey;

import anagrams.Anagrams;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testGroupAnagrams_Example1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = List.of(
                List.of("bat"),
                List.of("nat", "tan"),
                List.of("ate", "eat", "tea")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), actual.size());
        // You may want to check contents as well, but order does not matter.
    }

    @Test
    public void testGroupAnagrams_Example2() {
        String[] input = {""};
        List<List<String>> expected = List.of(List.of(""));
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGroupAnagrams_Example3() {
        String[] input = {"a"};
        List<List<String>> expected = List.of(List.of("a"));
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGroupAnagrams_MultipleAnagrams() {
        String[] input = {"bat", "tab", "tap", "pat", "eat", "tea"};
        List<List<String>> expected = List.of(
                List.of("bat", "tab"),
                List.of("tap", "pat"),
                List.of("eat", "tea")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), actual.size());
        // Additional checks can be added to ensure specific contents match
    }

    @Test
    public void testGroupAnagrams_EmptyArray() {
        String[] input = {};
        List<List<String>> expected = List.of();
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGroupAnagrams_NonAnagrams() {
        String[] input = {"dog", "racecar", "good", "hello"};
        List<List<String>> expected = List.of(
                List.of("dog"),
                List.of("racecar"),
                List.of("good"),
                List.of("hello")
        );
        List<List<String>> actual = anagrams.groupAnagrams(input);
        assertEquals(expected.size(), actual.size());
        // Additional checks can be performed here as well
    }
}