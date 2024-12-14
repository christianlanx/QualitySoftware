package anagrams.gpt4o.grey;

import anagrams.Anagrams;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

public class AnagramsTest {
    
    private Anagrams anagrams;

    @BeforeEach
    public void setUp() {
        anagrams = new Anagrams();
    }

    @Test
    public void testGroupAnagramsExample1() {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> actual = anagrams.groupAnagrams(input);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );

        assertEquals(expected.size(), actual.size());
        for (List<String> group : expected) {
            assertEquals(1, actual.stream().filter(g -> g.containsAll(group) && group.containsAll(g)).count());
        }
    }

    @Test
    public void testGroupAnagramsExample2() {
        String[] input = {""};
        List<List<String>> actual = anagrams.groupAnagrams(input);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("")
        );

        assertEquals(expected.size(), actual.size());
        for (List<String> group : expected) {
            assertEquals(1, actual.stream().filter(g -> g.containsAll(group) && group.containsAll(g)).count());
        }
    }

    @Test
    public void testGroupAnagramsExample3() {
        String[] input = {"a"};
        List<List<String>> actual = anagrams.groupAnagrams(input);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("a")
        );

        assertEquals(expected.size(), actual.size());
        for (List<String> group : expected) {
            assertEquals(1, actual.stream().filter(g -> g.containsAll(group) && group.containsAll(g)).count());
        }
    }

    @Test
    public void testGroupAnagramsWithDuplicates() {
        String[] input = {"aa", "aa", "aa"};
        List<List<String>> actual = anagrams.groupAnagrams(input);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("aa", "aa", "aa")
        );

        assertEquals(expected.size(), actual.size());
        for (List<String> group : expected) {
            assertEquals(1, actual.stream().filter(g -> g.containsAll(group) && group.containsAll(g)).count());
        }
    }

    @Test
    public void testGroupAnagramsWithEmptyString() {
        String[] input = {"", "b", "bb", ""};
        List<List<String>> actual = anagrams.groupAnagrams(input);

        List<List<String>> expected = Arrays.asList(
            Arrays.asList("", ""),
            Arrays.asList("b"),
            Arrays.asList("bb")
        );

        assertEquals(expected.size(), actual.size());
        for (List<String> group : expected) {
            assertEquals(1, actual.stream().filter(g -> g.containsAll(group) && group.containsAll(g)).count());
        }
    }
}